/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Conexao.ConexaoFactory;
import Modelo.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    
    public void create(Produto p) {      //CRUD=CREATE,UPDATE E DELETE
         
        Connection con = ConexaoFactory.getConnection();        //abrindo a conexao
        PreparedStatement stmt = null;                            //preparando e executando
        
        try {
            stmt = con.prepareStatement("INSERT INTO mercado (nome,tipo,descricao,quantidade,preco) VALUES(?,?,?,?,?)");
            stmt.setString   (1, p.getNome       () );
            stmt.setString   (2, p.getTipo       () );
            stmt.setString   (3, p.getDescricao  () );
            stmt.setInt      (4, p.getQuantidade () );
            stmt.setDouble   (5, p.getPreco      () );
            
            stmt.executeUpdate();                             //executando a sql
            
            JOptionPane.showMessageDialog (null, "Salvo com Sucesso!");     //exibindo mensagem se deu certo a inserçao
            
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog (null, "Erro ao salvar!" +ex);
                } 
        
        finally {
            ConexaoFactory.closeConnection (con, stmt);
        }
    }

    public List<Produto> read() {                              //retornar os dados do banco e inserir no jTable usando uma lista
        
        Connection con = ConexaoFactory.getConnection();        //abrindo a conexao
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();   //colocando dentro de uma lista
        
        try {
            stmt = con.prepareStatement("SELECT * FROM mercado");   //selecionando todos os campos da tabela mercado
            rs = stmt.executeQuery();                                 //colocando os valores dentro do "rs" que é o ResultSet
            
            while (rs.next()) {           //quando existir um valor ele passara para o proximo e vai colocar o objeto, e vai indo ate retornar false
                
                Produto produto = new Produto();            //chamando o objeto
                
                produto.setId          (rs.getInt("id") );
                produto.setNome        (rs.getString("nome") );
                produto.setTipo        (rs.getString("tipo") );
                produto.setDescricao   (rs.getString("descricao") );
                produto.setQuantidade  (rs.getInt ("quantidade") );     //colocando os valores dentro do objeto
                produto.setPreco       (rs.getDouble ("preco") );  
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally {   //chamar a classe conection e pegar a ultima sobrecarga
            ConexaoFactory.closeConnection (con, stmt, rs);
        }
        
        return produtos;
    }
    
    public void update(Produto p) {      
         
        Connection con = ConexaoFactory.getConnection();        
        PreparedStatement stmt = null;                          
        
        try {
            stmt = con.prepareStatement("UPDATE mercado SET nome = ?, tipo = ?, descricao = ?, quantidade = ?, preco = ? WHERE id = ?");
            stmt.setString   (1, p.getNome       () );
            stmt.setString   (2, p.getTipo       () );
            stmt.setString   (3, p.getDescricao  () );
            stmt.setInt      (4, p.getQuantidade () );
            stmt.setDouble   (5, p.getPreco      () );
            stmt.setInt      (6, p.getId         () );
            
            stmt.executeUpdate();                             //executando a sql
            
            JOptionPane.showMessageDialog (null, "Atualizado com sucesso!");     //exibindo mensagem se deu certo a inserçao
            
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog (null, "Erro ao atualizar!" +ex);
                } 
        
        finally {
            ConexaoFactory.closeConnection (con, stmt);
        }
    }
   
    public void Delete(Produto p) {      
         
        Connection con = ConexaoFactory.getConnection();        
        PreparedStatement stmt = null;                          
        
        try {
            stmt = con.prepareStatement("DELETE FROM mercado WHERE id = ?");
            stmt.setInt (1, p.getId() );
            
            stmt.executeUpdate();                             //executando a sql
            
            JOptionPane.showMessageDialog (null, "Deletado com Sucesso!");     //exibindo mensagem se deu certo a inserçao
            
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog (null, "Erro ao deletar!" +ex);
                } 
        
        finally {
            ConexaoFactory.closeConnection (con, stmt);
        }  
    }
}













