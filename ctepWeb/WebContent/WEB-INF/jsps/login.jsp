<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:bundle basename="StripesResources">
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
  <s:layout-component name="menu">
    <jsp:include page="/incl/empty.html"/>
  </s:layout-component>
  <s:layout-component name="body">
    <div class="grid_8">
      <h2 id="page-heading"><fmt:message key="label.auth.titulo"/></h2>
    </div>
    <div class="clear"></div>
    <div class="grid_8">
      <ol class="desc" style="width: 95%">
        <li><strong><fmt:message key="message.auth.howto1" /></strong></li>
        <li><fmt:message key="message.auth.howto2" /></li>
      </ol>
      <div class="box">
        <h2>
          <a href="#" id="toggle-login-forms"><fmt:message key="label.auth.titulo" /></a>
        </h2>
        <div class="block" id="login-forms">
            <form action="j_security_check" method="post">
              <fieldset class="login">
                <legend><fmt:message key="label.auth.titulo" /></legend>
                <p>
                  <label for="j_username"><fmt:message key="label.auth.username"/></label>
                  <input type="text" value="" size="40" name="j_username" title="User Name" id="username" />
                </p>
                <p>
                  <label for="j_password"><fmt:message key="label.auth.password"/></label>
                  <input type="password" value="" size="40" name="j_password" title="Password" id="password" />
                </p>
                <input class="login button" type="submit" value="Login" />
				<p>
		          <s:link beanclass="br.com.gourmex.lojistaweb.action.ForgotPasswordActionBean" > 
				    <fmt:message key="message.auth.forgotpassword" />
				  </s:link>
				</p>
              </fieldset>
            </form>
          </div>
        </div>
        <script language="Javascript1.2" type="text/javascript">
        <!--//
          document.forms[0].elements["j_username"].focus();
        //-->
        </script>
    </div>
  </s:layout-component>
</s:layout-render>
</fmt:bundle>