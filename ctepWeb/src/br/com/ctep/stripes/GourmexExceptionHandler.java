package br.com.ctep.stripes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.ajax.JavaScriptResolution;
import net.sourceforge.stripes.exception.DefaultExceptionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GourmexExceptionHandler extends DefaultExceptionHandler {

  private static final String FAULT_VIEW = "/incl/fault.jsp";
  //private static final String CONTINGENCY_VIEW = "/incl/aviso.jsp";
  private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";
  private static final String AJAX_HEADER_NAME = "X-Requested-With";
  
  private static final Log log = LogFactory.getLog(
      GourmexExceptionHandler.class);

  public Resolution pegaTudo(Throwable exc, HttpServletRequest req,
      HttpServletResponse resp) {

    log.error(exc);
    return resolucao(exc, req, FAULT_VIEW);
  }
  
  private Resolution resolucao(Throwable exc,
      HttpServletRequest req, String jspView) {
    
    // Disponibiliza a excecao para ser exibida na JSP
    req.setAttribute("exception", exc);
    
    // Se a requisicao realizada e AJAX
    String reqWith = req.getHeader(AJAX_HEADER_NAME);
    if (AJAX_HEADER_VALUE.equalsIgnoreCase(reqWith)) {
      // Cria uma representacao JSON do erro.
      return new JavaScriptResolution(exc);
    } else {
      return new ForwardResolution(jspView);
    }
  }
}
