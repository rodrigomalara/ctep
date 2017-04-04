package br.com.ctep.servicos;

import br.com.ctep.dao.GenericoDAO;
import br.com.ctep.entidades.Tarefa;

public interface TarefaFacade extends GenericoDAO<Tarefa, Integer> {
  
  void colocaEmExecucao(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException;
  
  void colocaEmEspera(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException;
  
  void estaPronta(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException;
  
  void necessitaFup(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException;
  
  void termina(Tarefa tarefa, String comentarios)
  throws TransicaoEstadoInvalidaException;
}
