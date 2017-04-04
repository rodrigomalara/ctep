<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="StripesResources">
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
  <s:layout-component name="body">
    <div class="grid_16">
      <h2 id="page-heading"><fmt:message key="global.error.message"/></h2>
    </div>
    <div id="clear"></div>
    <div class="grid_16" style="color: red;">
      <p class="buttons">
 	      <s:submit name="submit" class="submit" onclick="javascript:history.go(-1);">
 		      <fmt:message key="label.back"/>
 	      </s:submit>
      </p>
  </div>
  </s:layout-component>
</s:layout-render>
</fmt:bundle>
