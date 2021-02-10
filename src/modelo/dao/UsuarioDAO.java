package modelo.dao;

import conexao.ConexaoFactory;
import modelo.bean.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * <p> Gerencia todas as operacoes no banco de dados que envolvam a tabela de
 * usuarios. </p>
 *
 * @author Matheus
 * @version 1.1.1
 * @since 1.0.0
 */
public class UsuarioDAO implements DAO<Usuario> {

    /**
     * <p> Lida com as operacoes de log. </p>
     */
    private final Logger logger = Logger.getGlobal();

    @Override
    public void adicionar(Usuario usuario) {
        if (usuario == null) {
            logger.warning("O usuario nao pode ser null.");
            return;
        }

        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            logger.severe("A conexao nao pode ser aberta.");
            return;
        }

        String sql = "INSERT INTO tb_usuario (nome, senha, telefone, email, ativo) " +
                     "VALUES (?, ?, ?, ?, ?)";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            statement.setString(3, usuario.getTelefone());
            statement.setString(4, usuario.getEmail());
            statement.setBoolean(5, true);

            statement.executeUpdate();
            logger.info("Usuario adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement);
        }
    }

    @Override
    public void atualizar(int id, Usuario usuario) {
        if (usuario == null) {
            logger.warning("O usuario nao pode ser null.");
            return;
        }

        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            logger.severe("A conexao nao pode ser aberta.");
            return;
        }

        String sql = "UPDATE tb_usuario " +
                     "SET nome = ?, senha = ?, telefone = ?, email = ? " +
                     "WHERE id = ?";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(1, usuario.getSenha());
            statement.setString(1, usuario.getTelefone());
            statement.setString(1, usuario.getEmail());

            statement.executeUpdate();
            logger.info("Atualizacao realizada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement);
        }
    }

    @Override
    public List<Usuario> listar() {
        ArrayList<Usuario> usuarioList = new ArrayList<>();

        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            logger.severe("A conexao nao pode ser aberta.");
            return usuarioList;
        }

        String sql = "SELECT * " +
                     "FROM tb_usuario " +
                     "WHERE ativo = ?";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;
        ResultSet         resultSet  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, true);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setTelefone(resultSet.getString("telefone"));
                usuario.setEmail(resultSet.getString("email"));

                usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement, resultSet);
        }

        return usuarioList;
    }

    @Override
    public Optional<Usuario> pesquisar(int id) {
        List<Usuario> usuarioList = this.listar();
        usuarioList.removeIf(usuario -> usuario.getId() != id);

        return usuarioList.isEmpty()
               ? Optional.empty()
               : Optional.of(usuarioList.get(0));
    }

    @Override
    public void remover(int id) {
        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            logger.severe("A conexao nao pode ser aberta.");
            return;
        }

        String sql = "UPDATE tb_usuario " +
                     "SET ativo = false " +
                     "WHERE id = ?";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            logger.info("Remocao finalizada.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement);
        }
    }

    public boolean checkLogin(String email, String senha) {
        Optional<Connection> optional = ConexaoFactory.abrirConexao();

        if (!optional.isPresent()) {
            logger.severe("A conexao nao pode ser aberta.");
            return false;
        }

        String sql = "SELECT * " +
                     "FROM tb_usuario " +
                     "WHERE email = ? and senha = ?";

        Connection        connection = optional.get();
        PreparedStatement statement  = null;
        ResultSet         resultSet  = null;
        boolean           check      = false;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, senha);

            resultSet = statement.executeQuery();
            check     = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao(connection, statement, resultSet);
        }

        return check;
    }
}