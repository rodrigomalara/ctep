package br.com.ctep.dao.exception;


public class DadosDuplicadosException extends Exception {
	private static final long serialVersionUID = -8140567617230997883L;

	public DadosDuplicadosException(Exception ex) {
    super(ex);
  }

	public DadosDuplicadosException(String mensagem) {
	  super(mensagem);
	}
}
