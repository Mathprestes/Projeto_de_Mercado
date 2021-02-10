package modelo.dao;

import conexao.ConexaoFactory;
import modelo.bean.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p> Gerencia todas as operacoes no banco de dados que envolvam a tabela de
 * produtos. </p>
 *
 * @author Matheus
 * @version 2.0.0
 * @since 1.0.0
 */
public class ProdutoDAO implements DAO<Produto> {

    @Override
    public void adicionar(Produto produto) {
        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            System.err.println("Nao foi possivel abrir a conexao.");
            return;
        }

        final String sql = "INSERT INTO tb_produto (nome, tipo, descricao, quantidade, preco) " +
                           "VALUES (?, ?, ?, ?, ?)";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getTipo());
            statement.setString(3, produto.getDescricao());
            statement.setInt(4, produto.getQuantidade());
            statement.setDouble(5, produto.getPreco());

            statement.executeUpdate();
            System.out.println("Sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement);
        }
    }

    @Override
    public void atualizar(int id, Produto produto) {
        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            System.err.println("Nao foi possivel abrir a conexao.");
            return;
        }

        final String sql = "UPDATE tb_produto " +
                           "SET nome = ?, tipo = ?, descricao = ?, quantidade = ?, preco = ? " +
                           "WHERE id = ?";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getTipo());
            statement.setString(3, produto.getDescricao());
            statement.setInt(4, produto.getQuantidade());
            statement.setDouble(5, produto.getPreco());
            statement.setInt(6, produto.getId());

            statement.executeUpdate();
            System.out.println("Sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement);
        }
    }

    @Override
    public List<Produto> listar() {
        List<Produto> produtoList = new ArrayList<>();

        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            System.err.println("Nao foi possivel abrir a conexao.");
            return produtoList;
        }

        // Retorna apenas os items que nao foram excluidos
        final String sql = "SELECT * " +
                           "FROM tb_produto " +
                           "WHERE ativo = ?";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;
        ResultSet         resultSet  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, true);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setTipo(resultSet.getString("tipo"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setPreco(resultSet.getDouble("preco"));

                produtoList.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement, resultSet);
        }

        return produtoList;
    }

    @Override
    public Optional<Produto> pesquisar(int id) {
        List<Produto> produtoList = this.listar();
        produtoList.removeIf(produto -> produto.getId() != id);

        return produtoList.isEmpty()
               ? Optional.empty()
               : Optional.of(produtoList.get(0));
    }

    @Override
    public void remover(int id) {
        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            System.err.println("Nao foi possivel abrir a conexao.");
            return;
        }

        String sql = "UPDATE tb_produto " +
                     "SET ativo = false " +
                     "WHERE id = ?";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement);
        }
    }
}