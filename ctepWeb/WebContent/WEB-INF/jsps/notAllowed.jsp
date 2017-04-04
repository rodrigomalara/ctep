<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:bundle basename="StripesResources">
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
	<s:layout-component name="body">
    <div class="grid_16">
      <h2 id="page-heading"><fmt:message key="global.error.message"/></h2>
    </div>
    <div class="clear"></div>
    <div class="grid_16" style="color: red;">
    <script language="Javascript1.2" type="text/javascript">
    <!--//
    function gohome() {
      history.go(-1);
    }
    setTimeout("gohome()", 5000);
    //-->
    </script>
    <fmt:message key="label.auth.notallowed"/>
    <p><a onclick="javascript:gohome()"><fmt:message key="label.back"/></a></p>
    </div>
  </s:layout-component>
</s:layout-render>
</fmt:bundle>