package br.com.ctep.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import br.com.ctep.dao.GenericoDAO;
import br.com.ctep.dao.exception.DadosDuplicadosException;
import br.com.ctep.dao.exception.ViolacaoIntegridadeDadosException;

public class GenericoDAOIBatisImpl <T extends Serializable, 
	PK extends Number> extends SqlMapClientDaoSupport 
	implements GenericoDAO<T, PK> {
	
	protected Class<T> type;
	
	public GenericoDAOIBatisImpl(Class<T> type) {
		this.type = type;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public T busca(PK id) {
		return (T) getSqlMapClientTemplate().queryForObject(
				IBatisDAOUtils.pegaComandoSelectPK(type),
				id.longValue());
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public PK insere(T newInstance) throws DadosDuplicadosException {
		PK pk = null;
		try {
		    pk = (PK) getSqlMapClientTemplate().insert(
					IBatisDAOUtils.pegaComandoInsert(type), 
					newInstance);
		  } catch (DataIntegrityViolationException ex) {
		    throw new DadosDuplicadosException (ex);
		  }
		return pk;
	}

	@Transactional
	public int remove(T persistentObject) throws ViolacaoIntegridadeDadosException {
	  int qtdReg = 0;
	  try {
	    qtdReg = getSqlMapClientTemplate().delete(
	        IBatisDAOUtils.pegaComandoDelete(type), 
	        persistentObject);
	  } catch (DataIntegrityViolationException ex) {
	    throw new ViolacaoIntegridadeDadosException(ex);
	  }
		return qtdReg; 
	}

	@Transactional
	public void modifica(T transientObject) {
		getSqlMapClientTemplate().update(
				IBatisDAOUtils.pegaComandoUpdate(type), 
				transientObject);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> listaTodos(int... rowStartIdxAndCount) {
		List<T> result;
		if (rowStartIdxAndCount.length == 2) {
			result = getSqlMapClientTemplate().queryForList(
					IBatisDAOUtils.pegaComandoSelect(type), 
					rowStartIdxAndCount[0], rowStartIdxAndCount[1]);
		} else {
			result = getSqlMapClientTemplate().queryForList(
					IBatisDAOUtils.pegaComandoSelect(type));
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<T> listaPorExemplo(T exemplo, int... rowStartIdxAndCount) {
		List<T> result;
		if (rowStartIdxAndCount.length == 2) {
			result = getSqlMapClientTemplate().queryForList(
					IBatisDAOUtils.pegaComandoSelectPorExemplo(
							type), exemplo,
					rowStartIdxAndCount[0], rowStartIdxAndCount[1]);
		} else {
			result = getSqlMapClientTemplate().queryForList(
					IBatisDAOUtils.pegaComandoSelectPorExemplo(
							type), exemplo);
		}
		return result;
	}

	@Transactional(readOnly=true)
	public Integer contaTodos() {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				IBatisDAOUtils.pegaComandoContaTodos(type));
	}

	public Integer contaTodosPorExemplo(T exemplo) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				IBatisDAOUtils.pegaComandoContaTodosPorExemplo(type), exemplo);
	}
}
