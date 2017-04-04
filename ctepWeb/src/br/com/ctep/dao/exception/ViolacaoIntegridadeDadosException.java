package br.com.ctep.dao.exception;


public class ViolacaoIntegridadeDadosException extends Exception {
  private static final long serialVersionUID = 2197523295512483794L;
  
  public ViolacaoIntegridadeDadosException(Exception ex) {
    super(ex);
  }
}
