<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp" %>
<%@page import="br.com.ctep.global.AppConstants"%>
<c:set var="tarefa_estado_concluida" scope="request"><%=AppConstants.TAREFA_ESTADO_CONCLUIDA%></c:set>
<c:set var="tarefa_estado_emespera" scope="request"><%=AppConstants.TAREFA_ESTADO_EMESPERA%></c:set>
<c:set var="tarefa_estado_emexecucao" scope="request"><%=AppConstants.TAREFA_ESTADO_EMEXECUCAO%></c:set>
<c:set var="tarefa_estado_necessitafup" scope="request"><%=AppConstants.TAREFA_ESTADO_NECESSITAFUP%></c:set>
<c:set var="tarefa_estado_pronta" scope="request"><%=AppConstants.TAREFA_ESTADO_PRONTA%></c:set>
<c:set var="tarefa_estado_terminada" scope="request"><%=AppConstants.TAREFA_ESTADO_TERMINADA%></c:set>