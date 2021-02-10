package modelo.bean;

/**
 * <p> Classe de modelagem de produtos. </p>
 *
 * @author Matheus
 * @version 1.1.0
 * @since 1.0.1
 */
public class Produto {

    private int    id;
    private String nome;
    private String tipo;
    private String descricao;
    private int    quantidade;
    private double preco;

    /**
     * <p> Cria um novo objeto inicializando todos os atributos com valores
     * vazios. </p>
     *
     * <p> O ID e definido com valor -1 para prevenir conflitos com o banco de
     * dados. O banco pode atribuir o valor 0 para um elemento salvo, o Java
     * inicializa valores numericos com 0, isso pode gerar conflito, por causa
     * disso usamos um valor que o banco nunca usaria. </p>
     */
    public Produto() {
        this(-1, "", "", "", 0, 0.0);
    }

    /**
     * <p> Cria um novo objeto inicializando todos os atributos com excecao do
     * id. </p>
     *
     * <p> Esse construtor e ideao para quando ira salvar no banco de dados. </p>
     *
     * @param nome       Nome do produto.
     * @param tipo       Tipo do produto.
     * @param descricao  Descricao do produto.
     * @param quantidade Quantidade do produto em estoque.
     * @param preco      Preco do produto.
     */
    public Produto(String nome, String tipo, String descricao, int quantidade, double preco) {
        this(-1, nome, tipo, descricao, quantidade, preco);
    }

    /**
     * <p> Cria um novo objeto inicializando todos os atributos. </p>
     *
     * <p> Esse construtor e ideal quando esta recebendo do banco de dados. </p>
     *
     * @param id         ID do produto.
     * @param nome       Nome do produto.
     * @param tipo       Tipo do produto.
     * @param descricao  Descricao do produto.
     * @param quantidade Quantidade do produto em estoque.
     * @param preco      Preco do produto.
     */
    public Produto(int id, String nome, String tipo, String descricao, int quantidade, double preco) {
        this.id         = id;
        this.nome       = nome;
        this.tipo       = tipo;
        this.descricao  = descricao;
        this.quantidade = quantidade;
        this.preco      = preco;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return id == produto.id;
    }

    @Override
    public String toString() {
        return "Produto{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", tipo='" + tipo + '\'' +
               ", descricao='" + descricao + '\'' +
               ", quantidade=" + quantidade +
               ", preco=" + preco +
               '}';
    }
}