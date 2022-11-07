<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <!--  <link rel="
    stylesheet" href="style.css"> -->
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Figures</title>
  </head>

  <body>
    <h1>Les meves figures</h1>

    <table>
      <tr>
        <th>id</th>
        <th>nombre</th>
        <th>tipus</th>
        <th>coordenada X</th>
        <th>coordenada Y</th>
        <th>userID</th>
        <th>Fecha</th>
        <th>Accions</th>
      </tr>
      <c:forEach var="figura" items="${figures}">
        <tr>
          <td>${figura.idFigura}</td>
          <td>${figura.nombreFigura}</td>
          <td>${figura.tipo}</td>
          <td>${figura.xCord}</td>
          <td>${figura.yCord}</td>
          <td>${figura.idUsuario}</td>
          <td>${figura.fecha}</td>
          <td>
                      <form action="/verFigures" method="get">
                          <input type="hidden" name="idFigura" id="idFigura" value=${figura.idFigura}>
                          <input type="submit" value="ver">
                      </form>
                  </td>
                  <td>
                      <form action="/eliminarFigura" method="post" onsubmit=" return popup()">
                          <input type="hidden" name="idFigura" id="idFigura" value="${figura.idFigura}">
                          <input type="submit" value="Borrar">
                      </form>
          </td>
        </tr>
      </c:forEach>
    </table>
    <script>
          function popup() {
            var txt;
            if (confirm("Vols eliminar aquesta figura?")) {
              return true;
            } else {
              return false;
            }
            document.getElementById("idFigura").innerHTML = txt;
          }
          </script>
  </body>
</html>
