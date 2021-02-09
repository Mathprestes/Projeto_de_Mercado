package modelo.dao;

import java.util.List;
import java.util.Optional;

/**
 * <p> Padroniza as operacoes envolvendo banco de dados. Possui apenas as
 * operacoes comuns de todos os DAOs. </p>
 *
 * <p> Metodos adicionais podem ser incluidos na classe concreta para extender
 * as funcionalidades especificas. </p>
 *
 * @param <T> Tipo de dado que a interface ira trabalhar.
 */
public interface DAO<T> {

    /**
     * <p> Adiciona um novo elemento na tabela. Caso o elemento seja nulo, a
     * operacao sera cancelada. </p>
     *
     * @param t Elemento que sera adicionado. Nao pode ser null.
     */
    void adicionar(T t);

    /**
     * <p> Atualiza os dados do elemento elemento que possua o ID fornecido. Os
     * dados sao provenientes do elemento fornecido. </p>
     *
     * <p> Se o ID nao for encontrado, a operacao sera cancelada. </p>
     *
     * @param id Indica qual elemento deve ser alterado.
     * @param t  Carrega os novos dados para atualizar o elemento.
     */
    void atualizar(int id, T t);

    /**
     * <p> Retorna uma lista com todos os elementos da tabela. </p>
     *
     * <p> A lista nunca sera nula. Se a tabela estiver vazia, entao a lista
     * sera vazia. </p>
     *
     * @return Lista de elementos.
     */
    List<T> listar();

    /**
     * <p> Pesquisa determinado elemento atraves de seu ID. </p>
     *
     * <p> Esse metodo retorna um {@link Optional} contendo o elemento
     * encontrado, se o ID nao for encontrado, entao esse optional estara
     * vazio. </p>
     *
     * @param id ID que sera pesquisado.
     *
     * @return Um optional contendo o elemento.
     */
    Optional<T> pesquisar(int id);

    /**
     * <p> Remove um determinado elemento da tabela por meio de seu ID. Se o ID
     * nao for encontrado, entao a operacao sera cancelada. </p>
     *
     * @param id ID que sera removido.
     */
    void remover(int id);
}