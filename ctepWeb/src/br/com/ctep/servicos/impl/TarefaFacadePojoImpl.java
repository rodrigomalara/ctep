package br.com.ctep.servicos.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import br.com.ctep.dao.GenericoDAO;
import br.com.ctep.dao.exception.DadosDuplicadosException;
import br.com.ctep.dao.exception.ViolacaoIntegridadeDadosException;
import br.com.ctep.entidades.Tarefa;
import br.com.ctep.entidades.TarefaHist;
import br.com.ctep.global.AppConstants;
import br.com.ctep.servicos.TarefaFacade;
import br.com.ctep.servicos.TransicaoEstadoInvalidaException;

public class TarefaFacadePojoImpl extends SqlMapClientDaoSupport 
  implements TarefaFacade {
  
  private final String TAREFA_CRIADA = "Tarefa criada";
  
  private GenericoDAO<Tarefa, Integer> tarefaDAO;
  
  private GenericoDAO<TarefaHist, Integer> tarefaHistDAO;
  
  @Transactional(readOnly=true)
  public Tarefa busca(Integer id) {
    return tarefaDAO.busca(id);
  }

  @Transactional(readOnly=true)
  public Integer contaTodos() {
    return tarefaDAO.contaTodos();
  }
  
  @Transactional(readOnly=true)
  public List<Tarefa> listaPorExemplo(Tarefa exemplo,
      int... rowStartIdxAndCount) {
    return tarefaDAO.listaPorExemplo(exemplo, rowStartIdxAndCount);
  }

  @Transactional(readOnly=true)
  public List<Tarefa> listaTodos(int... rowStartIdxAndCount) {
    return tarefaDAO.listaTodos(rowStartIdxAndCount);
  }

  @Transactional(readOnly=true)
  public Integer contaTodosPorExemplo(Tarefa exemplo) {
    return tarefaDAO.contaTodosPorExemplo(exemplo);
  }

  @Transactional
  public Integer insere(Tarefa novaTarefa) throws DadosDuplicadosException {
    Integer idTarefa = tarefaDAO.insere(novaTarefa);
    novaTarefa.setIdTarefa(idTarefa);
    
    TarefaHist hist = new TarefaHist(idTarefa,
        novaTarefa.getEstado(), novaTarefa.getEstado());
    hist.setComentarios(TAREFA_CRIADA);
    try {
      tarefaHistDAO.insere(hist);
    } catch (DadosDuplicadosException e) {
      // Nao esperamos que essa exception seja jogada
      throw new RuntimeException(e);
    }
    return idTarefa;
  }

  public void modifica(Tarefa novaTarefa) {
    throw new UnsupportedOperationException("Use o metodo modifica " +
    		"que aceita o argumento comentarios");
  }
  
  @Transactional
  public void modifica(Tarefa novaTarefa, String comentarios) {
    Tarefa tarefaOriginal = tarefaDAO.busca(novaTarefa.getIdTarefa());
    
    TarefaHist hist = new TarefaHist(novaTarefa.getIdTarefa(),
        tarefaOriginal.getEstado(), novaTarefa.getEstado());
    hist.setComentarios(comentarios);
    try {
      tarefaHistDAO.insere(hist);
    } catch (DadosDuplicadosException e) {
      // Nao esperamos que essa exception seja jogada
      throw new RuntimeException(e);
    }
    
    tarefaDAO.modifica(novaTarefa);
  }

  @Transactional
  public int remove(Tarefa tarefa)
      throws ViolacaoIntegridadeDadosException {
    this.getSqlMapClientTemplate().delete(
        "TarefaHist.apagaTarefaHistPorTarefa", tarefa);
    return tarefaDAO.remove(tarefa);
  }

  @Transactional
  public void mudaStatusEspera(Tarefa tarefa, String comentarios) {
    tarefa.setEstado(AppConstants.TAREFA_ESTADO_EMESPERA);
    modifica(tarefa, comentarios);
  }

  @Transactional
  public void colocaEmEspera(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException {
    Tarefa tmpTarefa = busca(tarefa.getIdTarefa());
    if (!AppConstants.TAREFA_ESTADO_EMEXECUCAO.equals(tmpTarefa.getEstado())) {
      throw new TransicaoEstadoInvalidaException("Necessita estar no estado " +
          "'Em Execucao' para ir para o estado 'Em Espera'");
    }
    tmpTarefa.setEstado(AppConstants.TAREFA_ESTADO_EMESPERA);
    modifica(tmpTarefa, comentarios);
  }

  @Transactional
  public void colocaEmExecucao(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException {
    Tarefa tmpTarefa = busca(tarefa.getIdTarefa());
    if (!AppConstants.TAREFA_ESTADO_PRONTA.equals(tmpTarefa.getEstado())) {
      throw new TransicaoEstadoInvalidaException("Necessita estar no estado " +
          "'Pronta' para ir para o estado 'Em execucao'");
    }
    tmpTarefa.setEstado(AppConstants.TAREFA_ESTADO_EMEXECUCAO);
    modifica(tmpTarefa, comentarios);
  }

  @Transactional
  public void estaPronta(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException {
    Tarefa tmpTarefa = busca(tarefa.getIdTarefa());
    if (!AppConstants.TAREFA_ESTADO_EMESPERA.equals(tmpTarefa.getEstado())) {
      throw new TransicaoEstadoInvalidaException("Necessita estar no estado " +
          "'Em Espera' para ir para o estado 'Pronta'");
    }
    tmpTarefa.setEstado(AppConstants.TAREFA_ESTADO_PRONTA);
    modifica(tmpTarefa, comentarios);
  }

  @Transactional
  public void necessitaFup(Tarefa tarefa, String comentarios) 
  throws TransicaoEstadoInvalidaException {
    Tarefa tmpTarefa = busca(tarefa.getIdTarefa());
    if (!AppConstants.TAREFA_ESTADO_EMESPERA.equals(tmpTarefa.getEstado())) {
      throw new TransicaoEstadoInvalidaException("Necessita estar no estado " +
      		"'Em Espera' para ir para o estado 'Necessita Follow-Up'");
    }
    tmpTarefa.setEstado(AppConstants.TAREFA_ESTADO_TERMINADA);
    modifica(tmpTarefa, comentarios);
  }

  @Transactional
  public void termina(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException {
    Tarefa tmpTarefa = busca(tarefa.getIdTarefa());
    tarefa.setEstado(AppConstants.TAREFA_ESTADO_TERMINADA);
    modifica(tmpTarefa, comentarios);    
  }
  
  /* Getters and setters */
  
  public GenericoDAO<Tarefa, Integer> getTarefaDAO() {
    return tarefaDAO;
  }

  public void setTarefaDAO(GenericoDAO<Tarefa, Integer> tarefaDAO) {
    this.tarefaDAO = tarefaDAO;
  }

  public GenericoDAO<TarefaHist, Integer> getTarefaHistDAO() {
    return tarefaHistDAO;
  }

  public void setTarefaHistDAO(GenericoDAO<TarefaHist, Integer> tarefaHistDAO) {
    this.tarefaHistDAO = tarefaHistDAO;
  }
}
