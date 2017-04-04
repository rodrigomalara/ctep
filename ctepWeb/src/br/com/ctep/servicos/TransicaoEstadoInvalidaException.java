package br.com.ctep.servicos;

public class TransicaoEstadoInvalidaException extends Exception {
  private static final long serialVersionUID = 5131885017877883848L;
  
  public TransicaoEstadoInvalidaException() {
    super();
  }
  
  public TransicaoEstadoInvalidaException(String message) {
    super(message);
  }
  
  public TransicaoEstadoInvalidaException(Exception e) {
    super(e);
  }
}
