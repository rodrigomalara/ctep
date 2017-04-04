package br.com.ctep.dao;

import java.io.Serializable;
import java.util.List;

import br.com.ctep.dao.exception.DadosDuplicadosException;
import br.com.ctep.dao.exception.ViolacaoIntegridadeDadosException;

public interface GenericoDAO<T extends Serializable, PK extends Serializable> {

	/**
	 * Persiste nova instancia no BD
	 */
	PK insere(T newInstance) throws DadosDuplicadosException;

	/**
	 * Carrega objeto do banco de dados usando chave primaria
	 */
	T busca(PK id);

	/** 
	 * Salva mudancas no objeto persistente 
	 */
	void modifica(T transientObject);

	/**
	 * Remove um objeto existente na persistencia
	 * 
	 * @param persistentObject 
	 * 		objeto contendo chave primaria do registro a ser removido
	 * @return
	 * 		Quantidade de registros removidos
	 */
	int remove(T persistentObject) throws ViolacaoIntegridadeDadosException;
	
	/**
	 * Retorna todos as entidades no intervalo definido
	 * por rowStartIdxAndCount.
	 * 
	 * @param rowStartIdxAndCount 
	 * 		Parametro varargs opcional: rowStartIdxAndCount[0] especifica 
	 * 		o indice do primeiro resultado a ser retornado e 
	 * 		rowStartIdxAndCount[1] especifica a quantidade maxima de registros
	 * 		a ser retornada.
	 * 
	 * @return lista de entidades
	 */
	List<T> listaTodos(final int... rowStartIdxAndCount);

	Integer contaTodos();
	
	/**
	 * Retorna todos as entidades no intervalo definido
	 * por rowStartIdxAndCount.
	 * 
	 * @param exemplo 
	 * 		objeto populado com atributos a serem usados na 
	 * 		busca.
	 * @param rowStartIdxAndCount 
	 * 		Parametro varargs opcional: rowStartIdxAndCount[0] especifica 
	 * 		o indice do primeiro resultado a ser retornado e 
	 * 		rowStartIdxAndCount[1] especifica a quantidade maxima de registros
	 * 		a ser retornada.
	 * 
	 * @return lista de entidades
	 */
	List<T> listaPorExemplo(T exemplo, final int... rowStartIdxAndCount);
	
	/**
	 * Conta todos as entidades obtidas usando atributos do 
	 * parametro exemplo como filtros ao se fazer a busca.
	 * 
	 * @param exemplo 
	 * 		objeto populado com atributos a serem usados na 
	 * 		busca.
	 * @return
	 */
	Integer contaTodosPorExemplo(T exemplo);
	
}
