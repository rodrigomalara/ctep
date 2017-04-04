<%@ include file="/WEB-INF/jsps/commons/taglibs.jsp" %>
<%@ include file="/WEB-INF/jsps/commons/jspConstants.jsp" %>
<c:set var="ctx" scope="request">${pageContext.request.contextPath}</c:set>
<c:set var="prefix" scope="request">br.com.ctep.action.TarefaActionBean</c:set>
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
  <s:layout-component name="meta">
    <link rel="stylesheet" type="text/css" href="${ctx}/css/jquery-ui-1.7.2.custom.css" media="screen" />
    <script type="text/javascript" src="${ctx}/js/jquery-1.3.2.min.js" ></script>
    <script type="text/javascript" src="${ctx}/js/jquery-ui-1.7.2.custom.min.js" ></script>
    <script type="text/javascript" language="Javascript1.2" >
    jQuery(document).ready(function() {
        jQuery.datepicker.setDefaults(jQuery.extend({showMonthAfterYear: false}, 
                jQuery.datepicker.regional['']));
        jQuery("#criaTarefaForm input[name=tarefa.dataEntrega]").datepicker(
                jQuery.datepicker.regional['pt-BR']);
      });
    </script>
  </s:layout-component>
  <s:layout-component name="body">
    <div class="container_16">
      <h2 id="page-heading"><fmt:message key="${prefix}.titulo"/></h2>
    </div>
    <div class="clear"></div>
    <div class="container_16">
      <s:form beanclass="${prefix}" method="post" id="criaTarefaForm">
        <s:label for="tarefa.tarefa" /><s:text name="tarefa.tarefa" id="tarefa.tarefa" />&nbsp;
        <s:label for="tarefa.prioridade" />
        <s:select name="tarefa.prioridade" id="tarefa.prioridade">
          <s:option value="0"><fmt:message key="${prefix}.tarefa.prioridade.0" /></s:option>
          <s:option value="1"><fmt:message key="${prefix}.tarefa.prioridade.1" /></s:option>
          <s:option value="2"><fmt:message key="${prefix}.tarefa.prioridade.2" /></s:option>
          <s:option value="3"><fmt:message key="${prefix}.tarefa.prioridade.3" /></s:option>
        </s:select>&nbsp;
        <s:label for="tarefa.dataentrega" /><s:text name="tarefa.dataEntrega" maxlength="10" id="tarefa.dataEntrega" />&nbsp;
        <s:submit name="criarTarefa"><fmt:message key="${prefix}.novatarefa"/></s:submit>
      </s:form>
    </div>
    <div class="clear"></div>
    <p>&nbsp;</p>
    <div class="container_16">
    <div id="grid_16" >
      <display:table id="row" name="actionBean.tarefas" > 
        <display:column>
          <s:link beanclass="br.com.ctep.action.TarefaActionBean" 
            event="prepararEditar"  >
            <img src="${ctx}/img/icons/18/tool.png" />
            <s:param name="tarefa.idTarefa">${row.idTarefa}</s:param>
          </s:link>
        </display:column> 
        <display:column property="tarefa" titleKey="${prefix}.tarefa.tarefa"/>
        <display:column property="dataEntrega" titleKey="${prefix}.tarefa.dataentrega" />
        <display:column titleKey="${prefix}.acoes" >
          <s:link beanclass="${prefix}" event="apagarTarefa">
            <fmt:message key="${prefix}.acoes.apagar"/>
            <s:param name="tarefa.idTarefa">${row.idTarefa}</s:param>
          </s:link>
          <s:link beanclass="${prefix}" event="terminarTarefa">
            <fmt:message key="${prefix}.acoes.terminar"/>
            <s:param name="tarefa.idTarefa">${row.idTarefa}</s:param>
          </s:link>
          <c:if test="${row.estado eq tarefa_estado_pronta}" >
            <s:link beanclass="${prefix}" event="executarTarefa">
              <fmt:message key="${prefix}.acoes.executar"/>
              <s:param name="tarefa.idTarefa">${row.idTarefa}</s:param>
            </s:link>
          </c:if>
          <c:if test="${row.estado eq tarefa_estado_emexecucao}" >
            <s:link beanclass="${prefix}" event="esperarTarefa">
              <fmt:message key="${prefix}.acoes.esperar"/>
              <s:param name="tarefa.idTarefa">${row.idTarefa}</s:param>
            </s:link>
          </c:if>
          <c:if test="${row.estado eq tarefa_estado_emespera}" >
            <s:link beanclass="${prefix}" event="aprontarTarefa">
              <fmt:message key="${prefix}.acoes.pronta"/>
              <s:param name="tarefa.idTarefa">${row.idTarefa}</s:param>
            </s:link>
          </c:if>
          <c:if test="${row.estado eq tarefa_estado_necessitafup}" >
            <s:link beanclass="${prefix}" event="fupTarefa">
              <fmt:message key="${prefix}.acoes.necessitafup"/>
              <s:param name="tarefa.idTarefa">${row.idTarefa}</s:param>
            </s:link>
          </c:if>
        </display:column>
      </display:table>
      </div>
    </div>
  </s:layout-component>
</s:layout-render>
