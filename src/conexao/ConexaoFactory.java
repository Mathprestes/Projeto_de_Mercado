/*
 *
 *
 */
package conexao;

//import com.mysql.jdbc.Connection; NAO SELECIONAR ESSE PARA O SOFTWARE

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

/**
 * <p> Gerencia as conexoes com o banco de dados. </p>
 */
public class ConexaoFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";   //<--sempre usar para a conexao
    private static final String URL    = "jdbc:mysql://localhost:3306/dbmercado";      //conecando com o banco de dados espefico criado pro software
    private static final String USER   = "root";
    private static final String PASS   = "";

    /**
     * <p> Tenta abrir uma nova conexao com banco de dados. </p>
     *
     * <p> Esse metodo retorna um {@link Optional} contendo a conexao que foi
     * aberta. Se a conexao falhou, entao esse optional estara vazio. </p>
     *
     * @return Um optional contento a conexao.
     */
    public static Optional<Connection> abrirConexao() {
        try {
            return Optional.ofNullable(DriverManager.getConnection(URL, USER, PASS));
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * <p> Fecha a conexao. </p>
     *
     * <p> Esse metodo implementa o uso de varargs, o que permite a passagem de
     * varios elementos em unica chamada. </p>
     *
     * <p> Essa abordagem previne a necessidade de sobrecarregar os metodos de
     * fechamento. </p>
     *
     * @param closeables Elementos que serao fechados.
     */
    public static void fecharConexao(AutoCloseable... closeables) {
        for (AutoCloseable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception ignored) {
                }
            }
        }
    }
}