package br.com.ctep.entidades;

import java.io.Serializable;
import java.util.Date;

public class TarefaHist implements Serializable {
  private static final long serialVersionUID = 8094084513232584566L;

  private Integer idTarefaHist;
  
  private Integer idTarefa;
	
	private String estadoAnterior;
	
	private String estadoAtual;
	
	private String comentarios;
	
	private String userName;
	
	private Date tstamp;
	
	public TarefaHist(Integer idTarefa, String estadoAnterior, String estadoAtual) {
	  this.idTarefa = idTarefa;
	  this.estadoAnterior = estadoAnterior;
	  this.estadoAtual = estadoAtual;
	  this.tstamp = new Date();
	}
	
	public TarefaHist() {
    this.tstamp = new Date();
  }

  public Integer getIdTarefaHist() {
    return idTarefaHist;
  }

  public void setIdTarefaHist(Integer idTarefaHist) {
    this.idTarefaHist = idTarefaHist;
  }

  public Integer getIdTarefa() {
    return idTarefa;
  }

  public void setIdTarefa(Integer idTarefa) {
    this.idTarefa = idTarefa;
  }

  public String getEstadoAnterior() {
    return estadoAnterior;
  }

  public void setEstadoAnterior(String estadoAnterior) {
    this.estadoAnterior = estadoAnterior;
  }

  public String getEstadoAtual() {
    return estadoAtual;
  }

  public void setEstadoAtual(String estadoAtual) {
    this.estadoAtual = estadoAtual;
  }

  public Date getTstamp() {
    return tstamp;
  }

  public void setTstamp(Date tstamp) {
    this.tstamp = tstamp;
  }

  public String getComentarios() {
    return comentarios;
  }

  public void setComentarios(String comentarios) {
    this.comentarios = comentarios;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
