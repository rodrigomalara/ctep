<%@include file="/WEB-INF/jsps/commons/taglibs.jsp" %>
<fmt:bundle basename="StripesResources">
<c:set var="ctx" scope="request">${pageContext.request.contextPath}</c:set>
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
  <s:layout-component name="body">
    <script language="Javascript" src="${ctx}/js/jquery-1.3.2.min.js"></script>
    <script language="Javascript">
    <!--//
      function toggleDiv(divId) {
        if (jQuery('#' + divId).is(':visible')) {
          jQuery('#' + divId).hide(200);
        } else {
          jQuery('#' + divId).show(200);
        }
      }
      jQuery(document).ready(function() {
    	  jQuery('#diagnostico').hide();
      });
    //-->
    </script>
    <div class="grid_16">
      <h2 id="page-heading" ><fmt:message key="label.aviso.descricao"/></h2>
      <p><fmt:message key="label.aviso.detalhes"/></p>
      <br/><s:link href="#" ><fmt:message key="label.aviso.faq"/></s:link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:link href="#" ><fmt:message key="label.aviso.videos"/></s:link>
    </div>
    <div class="clear"></div>
    <div class="grid_16">
      <fmt:message key="label.contact.body"/>
      <s:form partial="true" action="null">        
        <p class="buttons">
          <s:button name="submit" style="submit" onclick="javascript:history.go(-1);"><fmt:message key="label.back"/></s:button>
        </p>
      </s:form>
      <br/><a href="#" onclick="javascript:toggleDiv('diagnostico');"><fmt:message key="label.aviso.exibediagnostico"/></a>
      <div id="diagnostico" style="position:relative; margin-left:auto; margin-right:auto; overflow:auto;">
      <pre>${exception.message}</pre>
      </div>
    </div>
  </s:layout-component>
</s:layout-render>
</fmt:bundle>