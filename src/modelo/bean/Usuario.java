package modelo.bean;

/**
 * <p> Classe de modelagem de usuarios. </p>
 *
 * @author Matheus
 * @version 1.1.0
 * @since 1.0.1
 */
public class Usuario {

    private int    id;
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    /**
     * <p> Cria um novo objeto inicializando todos os atributos com valores
     * vazios. </p>
     *
     * <p> O ID e definido com valor -1 para prevenir conflitos com o banco de
     * dados. O banco pode atribuir o valor 0 para um elemento salvo, o Java
     * inicializa valores numericos com 0, isso pode gerar conflito, por causa
     * disso usamos um valor que o banco nunca usaria. </p>
     */
    public Usuario() {
        this(-1, "", "", "", "");
    }

    /**
     * <p> Cria um novo objeto inicializando todos os atributos com excecao do
     * id. </p>
     *
     * <p> Esse construtor e ideao para quando ira salvar no banco de dados. </p>
     *
     * @param nome     Nome do usuario.
     * @param telefone Telefone do usuario.
     * @param email    Email do usuario.
     * @param senha    Senha do usuario. Precisa estar codificada.
     */
    public Usuario(String nome, String telefone, String email, String senha) {
        this(-1, nome, telefone, email, senha);
    }

    /**
     * <p> Cria um novo objeto inicializando todos os atributos. </p>
     *
     * <p> Esse construtor e ideal quando esta recebendo do banco de dados. </p>
     *
     * @param id       ID do usuario.
     * @param nome     Nome do usuario.
     * @param telefone Telefone do usuario.
     * @param email    Email do usuario.
     * @param senha    Senha do usuario. Precisa estar codificada.
     */
    public Usuario(int id, String nome, String telefone, String email, String senha) {
        this.id       = id;
        this.nome     = nome;
        this.telefone = telefone;
        this.email    = email;
        this.senha    = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return id == usuario.id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", telefone='" + telefone + '\'' +
               ", email='" + email + '\'' +
               ", senha='" + senha + '\'' +
               '}';
    }
}