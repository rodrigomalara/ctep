<%@include file="/WEB-INF/jsps/commons/taglibs.jsp" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<c:set var="ctx" scope="request">${pageContext.request.contextPath}</c:set>
<fmt:setLocale value="${pageContext.request.locale}"/>
<s:layout-definition>
<fmt:bundle basename="StripesResources">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><fmt:message key="label.topbanner.title"/> | <fmt:message key="label.topbanner.subtitle"/></title>
<s:layout-component name="css">
	<jsp:include page="/incl/css.jsp"/>
</s:layout-component>
<meta name="date" content="2009-04-12" />
<meta name="keywords" content="" />
<meta name="description" content="<fmt:message key="label.topbanner.subtitle"/>" />
<script language="Javascript1.2" type="text/javascript">
<!--//
var ajaxError = '<fmt:message key="message.ajaxerror" />';
var msgConfirmRemove = "<fmt:message key='message.confirmdelete'/>";
var caminhoImagem = "${ctx}/img/loadingAnimation.gif";
//-->
</script>
<s:layout-component name="meta">
  <jsp:include page="/incl/empty.html"/>
</s:layout-component>
</head>
<body>
<div id="reusableHint" style="position:absolute;z-index:1;visibility:hidden;padding:10px;background-color:#e0e0e0;border:1px solid gray;"></div>
<div class="container_16">
  <s:layout-component name="top">
    <jsp:include page="/incl/topbanner.jsp"/>
  </s:layout-component>
  <div class="clear"></div>
  <s:layout-component name="menu">
    <jsp:include page="/incl/navigator.jsp"/>
  </s:layout-component>
  <div class="clear"></div>
  <div class="grid_16" style="color: red;">
    <strong><s:errors/></strong>
  </div>
  <div class="grid_16" style="color: navy;">
    <strong><s:messages/></strong>
  </div>
  <div class="clear"></div>
  <s:layout-component name="body">
    <jsp:include page="/incl/empty.html"/>
  </s:layout-component>
  <div class="clear"></div>
  <s:layout-component name="footer">
	  <jsp:include page="/WEB-INF/jsps/footer.jsp"/>
  </s:layout-component>
  </div>
</body>
</html>
</fmt:bundle>
</s:layout-definition>