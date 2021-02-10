package modelo.dao;

import conexao.ConexaoFactory;
import modelo.bean.Produto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p> Gerencia todas as operacoes no banco de dados que envolvam a tabela de
 * produtos. </p>
 *
 * @author Matheus
 * @version 1.1.0
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
                           "WHERE ativo = true";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;
        ResultSet         resultSet  = null;

        try {
            statement = connection.prepareStatement(sql);
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


    // --- Sera removido logo
    @Deprecated
    public void create(Produto p) {      //CRUD=CREATE,UPDATE E DELETE

        Connection        con  = ConexaoFactory.getConnection();        //abrindo a conexao
        PreparedStatement stmt = null;                            //preparando e executando

        try {
            stmt = con.prepareStatement("INSERT INTO tb_produto (nome,tipo,descricao,quantidade,preco) VALUES(?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTipo());
            stmt.setString(3, p.getDescricao());
            stmt.setInt(4, p.getQuantidade());
            stmt.setDouble(5, p.getPreco());

            stmt.executeUpdate();                             //executando a sql

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");     //exibindo mensagem se deu certo a inserçao

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        } finally {
            ConexaoFactory.closeConnection(con, stmt);
        }
    }

    @Deprecated
    public List<Produto> read() {                              //retornar os dados do banco e inserir no jTable usando uma lista

        Connection        con  = ConexaoFactory.getConnection();        //abrindo a conexao
        PreparedStatement stmt = null;
        ResultSet         rs   = null;

        List<Produto> produtos = new ArrayList<>();   //colocando dentro de uma lista

        try {
            stmt = con.prepareStatement("SELECT * FROM tb_produto");   //selecionando todos os campos da tabela mercado
            rs   = stmt.executeQuery();                                 //colocando os valores dentro do "rs" que é o ResultSet

            while (rs.next()) {           //quando existir um valor ele passara para o proximo e vai colocar o objeto, e vai indo ate retornar false

                Produto produto = new Produto();            //chamando o objeto

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTipo(rs.getString("tipo"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));     //colocando os valores dentro do objeto
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {   //chamar a classe conection e pegar a ultima sobrecarga
            ConexaoFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    @Deprecated
    public void update(Produto p) {

        Connection        con  = ConexaoFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tb_produto SET nome = ?, tipo = ?, descricao = ?, quantidade = ?, preco = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTipo());
            stmt.setString(3, p.getDescricao());
            stmt.setInt(4, p.getQuantidade());
            stmt.setDouble(5, p.getPreco());
            stmt.setInt(6, p.getId());

            stmt.executeUpdate();                             //executando a sql

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");     //exibindo mensagem se deu certo a inserçao

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
        } finally {
            ConexaoFactory.closeConnection(con, stmt);
        }
    }

    @Deprecated
    public void Delete(Produto p) {

        Connection        con  = ConexaoFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tb_produto WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();                             //executando a sql

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");     //exibindo mensagem se deu certo a inserçao

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar!" + ex);
        } finally {
            ConexaoFactory.closeConnection(con, stmt);
        }
    }
    // --- Sera removido logo
}