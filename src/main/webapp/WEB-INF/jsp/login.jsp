<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Login</title>
</head>
<body>
 <h1> login </h1>
   <c:if test="${not empty message}">
   ${message}
   </c:if>
   <form method="post" action="/login">
                Usuari: <input type="text" name="user">
                <br>

                <input type="submit" value="envia">
   </form>

</body>
</html>