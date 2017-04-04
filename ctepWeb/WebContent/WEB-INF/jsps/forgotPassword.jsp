<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<fmt:bundle basename="StripesResources">
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
  <s:layout-component name="menu">
    <jsp:include page="/incl/empty.html"/>
  </s:layout-component>
  <s:layout-component name="body">

  <c:if test="${actionBean.enviado == true}">
  <script language="Javascript1.2" type="text/javascript">
      <!--//
      function gohome() {
        location.href="<%=request.getContextPath()%>/";
      }
      setTimeout("gohome()", 5000);
      //-->
      </script>
      <div class="grid_8">
      <br/><fmt:message key="label.auth.loggedout"/>
      <br/><a onclick="javascript:gohome()" href="#">
       <fmt:message key="label.auth.nowait"/>
      </a>
      </div>
   </c:if>
   
  <c:if test="${actionBean.enviado == false}">
    <div class="grid_8">
      <h2 id="page-heading"><fmt:message key="label.forgotpassword.titulo"/></h2>
    </div>
    <div class="clear"></div>
    <div class="grid_8">
      <div class="box">
        <h2>
          <a href="#" id="toggle-login-forms"><fmt:message key="label.forgotpassword.titulo" /></a>
        </h2>
        <div class="block" id="login-forms">
	        <s:form beanclass="br.com.gourmex.lojistaweb.action.ForgotPasswordActionBean" method="post" focus="email">

              <fieldset class="forgotpassword">
                <p class="notice"><fmt:message key="label.forgotpassword.observacao"/></p>
                <p>
                  <label for="email"><fmt:message key="label.forgotpassword.email"/></label>
				  <s:text name="email" class="required" />
                </p>
				<s:submit name="enviar" class="send button" ><fmt:message key="label.enviar"/></s:submit>&nbsp;
	            <s:submit name="cancel" class="register-button" ><fmt:message key="label.voltar"/></s:submit>
              </fieldset>
            </s:form>
          </div>
        </div>
    </div>
    </c:if>
  </s:layout-component>
</s:layout-render>
</fmt:bundle>