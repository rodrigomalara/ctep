<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<div class="grid_16">
  <ul class="nav main">
	<!-- Manutencao -->
	<li>
	  <a href="#"><fmt:message key="label.navigator.tarefas"/></a>
	  <ul>
  		  <li>
		    <s:link beanclass="br.com.ctep.action.TarefaActionBean" >
	          <fmt:message key="label.navigator.minhastarefas"/>
		    </s:link>
		  </li>
	  </ul>
	</li>
	<!-- Logout -->
	  <%if (request.getUserPrincipal() != null) {%>
		<li class="secondary">
	      <s:link href="/incl/logout.jsp" >
	        <fmt:message key="button.logout"/>
	      </s:link>
	    </li>
	  <%}%>
  </ul>

</div>