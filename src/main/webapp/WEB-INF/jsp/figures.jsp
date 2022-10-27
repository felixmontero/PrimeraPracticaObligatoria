<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
    <head>
        <link rel="stylesheet" href="style.css">
    </head>

<body>

<h1> Ventana Principal </h1>

<canvas id="myCanvas" width="640" height="480" style="border:1px solid #000000;">
</canvas><br>

Tipo de figura:
<select name="figuras" id="figuras">
  <option value="circulo"> Circulo</option>
  <option value="Cuadrado">Cuadrado</option>
  <option value="Triangulo">Triangulo</option> 
  <option value="Estrella">Estrella</option>
</select>

colores:
<select name="colores" id="colores">
  <option value="Black"> BLACK</option>
  <option value="Green">GREEN</option>
  <option value="Red">RED</option>
  <option value="Blue">BLUE</option>
  <option value="Estrella">YELLOW</option>
  <option value="Estrella">GRAY</option>
</select>
<input type="range"> <input type="number" name="coordenada1"> <input type="number" name="coordenada2">

<input type="submit" value="envia">
<input type="submit" value="preview">

<script>
  let tipo = $Black

</script>








<!-- Circulo -->

<script>

var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.beginPath();
ctx.arc(95, 50, 40, 0, 2 * Math.PI);
ctx.stroke();





</script>
</body></html>