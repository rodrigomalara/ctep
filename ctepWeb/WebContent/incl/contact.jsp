<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:bundle basename="StripesResources">
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
  <s:layout-component name="body">
    <div class="grid_16">
    <h2 id="page-heading"><fmt:message key="label.contact.heading"/></h2>
    </div>
    <div class="clear"></div>
    <div class="grid_16">
   	  <fmt:message key="label.contact.body"/>
      <s:form partial="true" action="null">        
      <p class="buttons">
       	<s:button name="submit" style="submit" onclick="javascript:history.go(-1);"><fmt:message key="label.back"/></s:button>
      </p>
      </s:form>
    </div>
  </s:layout-component>
</s:layout-render>
</fmt:bundle>