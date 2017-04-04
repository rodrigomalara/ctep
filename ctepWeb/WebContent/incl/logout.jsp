<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
HttpSession sess = request.getSession(false);
if (sess != null) {
  sess.invalidate();
}
%>
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
  <s:layout-component name="body">
    <div class="grid_8">
      <h2><fmt:message key="label.auth.logout"/></h2>
      <h5><fmt:message key="label.auth.loggedout"/></h5>
      <p/>
      <script language="Javascript1.2" type="text/javascript">
      <!--//
      function gohome() {
    	  location.href="<%=request.getContextPath()%>/";
		  }
	    setTimeout("gohome()", 3000);
	    //-->
      </script>
      <p><a onclick="javascript:gohome()" href="#">
        <fmt:message key="label.auth.nowait"/>
      </a></p>
    </div>
  </s:layout-component>
</s:layout-render>