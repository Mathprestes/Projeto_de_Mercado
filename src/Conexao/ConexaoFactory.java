/*
*
*
 */
package Conexao;

//import com.mysql.jdbc.Connection; NAO SELECIONAR ESSE PARA O SOFTWARE
import java.sql.Connection;       ///SEMPRE USAR ESSE
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";   //<--sempre usar para a conexao
    private static final String URL = "jdbc:mysql://localhost:3306/dbmercado";      //conecando com o banco de dados espefico criado pro software
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);   
        }
        catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException (" ERRO NA CONEXAO COM O BANCO DE DADOS: ",ex);
        }
    }
    
    public static void closeConnection(Connection con) {   //criando metodos estaticos pra nao sobrecarregar o sistema
        try {
            
            if (con!=null) {
                con.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger (ConexaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {   //fazendo uma sobrecarga Connection con + PreparedStatement stmt
        closeConnection(con);
        try {
            
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException ex) {
                Logger.getLogger(ConexaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {   //fazendo mais uma sobrecarga Connection con, PreparedStatement stmt + ResultSet rs
        closeConnection(con, stmt);
        try {
            
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    public static PreparedStatement preparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   
    
    
   








































