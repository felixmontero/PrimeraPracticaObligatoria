<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Login</title>

  <style><%@include file="/WEB-INF/css/login.css"%></style>

</head>
<body>
<div id="login-form-wrap">
<div class="form-field">
 <h2>Login</h2>
</div>
   <c:if test="${not empty message}">
   ${message}
   </c:if>
   <form method="post" action="/login">
    <label for="username">Usuari:</label><br><br>
      <div class="form-field">
      <input type="text" placeholder="Poner Usuario" name="user"><br><br>
      </div>
      <div class="form-field">
      <input type="submit" value="envia" class="btn">
      </div>

   </form>
</div>
</body>
</html>