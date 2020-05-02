package org.f1.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @param <E>
 *            qualquer Objeto que anotado com Enitity
 * @author lourenco
 * 
 * @since v1.0.0
 */
public interface Dao<E> extends Serializable {

    int HIBERNATE_JDBC_BATCH_SIZE = 20;

    E persist(final E entity);

    E update(final E entity);

    E findById(final Class<E> clazz, final Object id);

    List<E> findAll(final Class<E> clazz);

    /**
     * Pesquisa objetos do tipo E por parametros <br/>
     * 
     * @param queryParameters
     *            {@link Map} onde achave � nome da propriedade e valor � um
     *            Object
     * @param clazz
     *            Class de E
     * @return {@link List} de objetos do tipo E
     */
    List<E> find(final Map<String, Object> queryParameters, final Class<E> clazz);

    /**
     * Pesquisa objetos do tipo E por parametros e com pagina��o <br/>
     * 
     * @param queryParameters
     * @param clazz
     * @param firstResult
     *            numero inicial onde a lista deve come�ar
     * @param maxResults
     *            mnumero maximo de resultados
     * @return {@link List} de objetos do tipo E
     */
    List<E> find(final Map<String, Object> queryParameters, final Class<E> clazz, Integer firstResult,
            Integer maxResults);

    /**
     * Pesquisa objetos do tipo E por parametros, no entanto os paremetros usam
     * a clausula OR <br/>
     * O SQL montado para consulta deve deve ser:
     * "... WHERE propriedade1 = valor1 OR propriedade2 =  valor2..."
     * 
     * @param queryParameters
     * @param clazz
     * @return {@link List} de objetos do tipo E
     */
    List<E> findWithOrPredicate(final Map<String, Object> queryParameters, final Class<E> clazz);

    /**
     * Pesquisa objetos do tipo E por parametros e com pagina��o,no entanto os
     * paremetros usam a clausula OR <br/>
     * O SQL montado para consulta deve deve ser:
     * "... WHERE propriedade1 = valor1 OR propriedade2 =  valor2..."
     * 
     * @param queryParameters
     * @param clazz
     * @param firstResult
     * @param maxResults
     * @return {@link List} de objetos do tipo E
     */
    List<E> findWithOrPredicate(final Map<String, Object> queryParameters, final Class<E> clazz, Integer firstResult,
            Integer maxResults);

    int removeAll(final String nomeEntidade);

    void remove(final E entity);

    void flushAndClear();

}
