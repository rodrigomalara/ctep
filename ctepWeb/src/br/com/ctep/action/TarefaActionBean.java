package br.com.ctep.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.integration.spring.SpringBean;
import br.com.ctep.dao.exception.DadosDuplicadosException;
import br.com.ctep.dao.exception.ViolacaoIntegridadeDadosException;
import br.com.ctep.entidades.Tarefa;
import br.com.ctep.global.AppConstants;
import br.com.ctep.servicos.TarefaFacade;
import br.com.ctep.servicos.TransicaoEstadoInvalidaException;
import br.com.ctep.stripes.BaseActionBean;

public class TarefaActionBean extends BaseActionBean {

  @SpringBean("tarefaFacade")
  private TarefaFacade tarefaFacade;
  
  private List<Tarefa> tarefas;
  
  private Tarefa tarefa;
  
  private String comentarios;
  
  @DefaultHandler
  public Resolution lista() {
    tarefas = tarefaFacade.listaTodos();
    
    return new ForwardResolution("/WEB-INF/jsps/listaTarefas.jsp");
  }
  
  public Resolution criarTarefa() throws DadosDuplicadosException {
    if (tarefa != null) {
      tarefa.setEstado(AppConstants.TAREFA_ESTADO_PRONTA);
      tarefaFacade.insere(tarefa);
    }
    return new RedirectResolution(this.getClass());
  }
  
  public Resolution apagarTarefa() throws ViolacaoIntegridadeDadosException {
    if (tarefa != null) {
      tarefaFacade.remove(tarefa);
    }
    return new RedirectResolution(this.getClass());
  }
  
  public Resolution terminarTarefa() throws ViolacaoIntegridadeDadosException {
    if (tarefa != null) {
      tarefaFacade.remove(tarefa);
    }
    return new RedirectResolution(this.getClass());
  }

  
  public Resolution executarTarefa() throws TransicaoEstadoInvalidaException {
    tarefaFacade.colocaEmExecucao(tarefa, comentarios);
    return new RedirectResolution(this.getClass());
  }
  
  public Resolution esperarTarefa() throws TransicaoEstadoInvalidaException {
    tarefaFacade.colocaEmEspera(tarefa, comentarios);
    return new RedirectResolution(this.getClass());
  }
  
  public Resolution aprontarTarefa() throws TransicaoEstadoInvalidaException {
    tarefaFacade.estaPronta(tarefa, comentarios);
    return new RedirectResolution(this.getClass());
  }
  
  public Resolution fupTarefa() throws TransicaoEstadoInvalidaException {
    tarefaFacade.necessitaFup(tarefa, comentarios);
    return new RedirectResolution(this.getClass());
  }
  
  /* Getters and Setters */
  public List<Tarefa> getTarefas() throws TransicaoEstadoInvalidaException {
    return tarefas;
  }

  public void setTarefas(List<Tarefa> tarefas) {
    this.tarefas = tarefas;
  }

  public Tarefa getTarefa() {
    return tarefa;
  }

  public void setTarefa(Tarefa tarefa) {
    this.tarefa = tarefa;
  }

  public TarefaFacade getTarefaFacade() {
    return tarefaFacade;
  }

  public void setTarefaFacade(TarefaFacade tarefaFacade) {
    this.tarefaFacade = tarefaFacade;
  }

  public String getComentarios() {
    return comentarios;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }
}
