<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Figures</title>
  </head>

  <body  style="background-image: url(https://img.freepik.com/vector-gratis/fondo-geometrico_23-2148573776.jpg?w=2000);">
  <header>
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="ventanaPrincipal">Crear</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-item nav-link active" href="totalFigures">Llista de Figures <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="meFigures">Les meves Figures</a>

          </div>
        </div>
      </nav>
     </header>



    <h1>Les meves figures</h1>

    <table class="table">
    <thead class="thead-dark">
      <tr>
        <th scope="col">Id</th>
            <th scope="col">Nombre</th>
            <th scope="col">Tipus</th>
            <th scope="col">Coordenada X</th>
            <th scope="col">Coordenada Y</th>
            <th scope="col">IdUsuari</th>
            <th scope="col">Data</th>
            <th scope="col">Veure</th>
            <th scope="col">Eliminar</th>
      </tr>
      </thead>
      <c:forEach var="figura" items="${figures}">
        <tr>
          <td scope="row" class="table-light">${figura.idFigura}</td>
          <td scope="row" class="table-light">${figura.nombreFigura}</td>
          <td scope="row" class="table-light">${figura.tipo}</td>
          <td scope="row" class="table-light">${figura.xCord}</td>
          <td scope="row" class="table-light">${figura.yCord}</td>
          <td scope="row" class="table-light">${figura.idUsuario}</td>
          <td scope="row" class="table-light">${figura.fecha}</td>
          <td scope="row" class="table-light">
              <form action="/verFigures" method="get">
                  <input type="hidden" name="idFigura" id="idFigura" value=${figura.idFigura}>
                  <input type="submit" value="ver" class="btn btn-dark">
              </form>
          </td>
          <td scope="row" class="table-light">
              <form action="/eliminarFigura" method="post" onsubmit=" return popup()">
                  <input type="hidden" name="idFigura" id="idFigura" value="${figura.idFigura}">
                  <input type="submit" value="Borrar" class="btn btn-dark">
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
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>
