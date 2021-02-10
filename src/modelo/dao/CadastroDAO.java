/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexao.ConexaoFactory;
import modelo.bean.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Matheus
 * @deprecated Usar {@link UsuarioDAO} ao inves dessa classe.
 */
@Deprecated
public class CadastroDAO {

    /**
     * @deprecated Usar {@link UsuarioDAO#adicionar(Usuario)} ao inves desse
     * metodo.
     */
    @Deprecated
    public void create(Usuario p) {      //CRUD=CREATE,UPDATE E DELETE

        Connection        con  = ConexaoFactory.getConnection();        //abrindo a conexao
        PreparedStatement stmt = null;                            //preparando e executando

        try {
            stmt = con.prepareStatement("INSERT INTO tb_usuario (nome,telefone,email,senha) VALUES(?,?,?,?)");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getSenha());

            stmt.executeUpdate();                             //executando a sql

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");     //exibindo mensagem se deu certo a inserçao

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
        } finally {
            ConexaoFactory.closeConnection(con, stmt);
        }
    }
}