package br.com.ctep.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Tarefa implements Serializable {
  private static final long serialVersionUID = 1218655282922474038L;

  private Integer idTarefa;
	
	private String tarefa;
	
	private Date dataEntrega;
	
	private Integer prioridade;
	
	private String estado;
	
	private Date timeout;
	
	private String evento;
	
	private String descricao;
	
	private Collection<TarefaHist> historico;

  public Integer getIdTarefa() {
    return idTarefa;
  }

  public void setIdTarefa(Integer idTarefa) {
    this.idTarefa = idTarefa;
  }

  public String getTarefa() {
    return tarefa;
  }

  public void setTarefa(String tarefa) {
    this.tarefa = tarefa;
  }

  public Date getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega(Date dataEntrega) {
    this.dataEntrega = dataEntrega;
  }

  public Integer getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(Integer prioridade) {
    this.prioridade = prioridade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Date getTimeout() {
    return timeout;
  }

  public void setTimeout(Date timeout) {
    this.timeout = timeout;
  }

  public String getEvento() {
    return evento;
  }

  public void setEvento(String evento) {
    this.evento = evento;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Collection<TarefaHist> getHistorico() {
    return historico;
  }

  public void setHistorico(Collection<TarefaHist> historico) {
    this.historico = historico;
  }
}
