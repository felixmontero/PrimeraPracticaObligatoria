<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
    <head>
        <link rel="stylesheet" href="/css/canvas.css">
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Figures</title>
    </head>

<body  style="background-image: url(https://wallpapers.com/images/hd/white-textured-paper-439vozmsl9bybc8a.jpg);">
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

    <h1>Figures</h1>
    <div id="clase" class="clase">
    <canvas id="canvas" class="canvas" width="1024" height="768" style="background-color: white; border: solid black 1px;" onclick="drawPreview()"></canvas>
    </div>
    <form action="/ventanaPrincipal" method="post">

        <label for="nombreFigura">Nombre de la figura:</label>
        <input type="text" name="nombreFigura" id="nombreFigura">

        <label for="figures" >Tipus de Figura:</label>
        <select name="tipoFigura" id="tipoFigura" width="100">
            <option value="circle" >Cercle</option>
            <option value="square">Quadrat</option>
            <option value="triangle">Triangle</option>
            <option value="pentagon">Pentagon</option>
            <option value="star">Estrella</option>
        </select>

        <label for="color">Color:</label>
        <select name="color" id="color">
            <option value="black">Negre</option>
            <option value="green">Verd</option>
            <option value="red">Vermell</option>
            <option value="blue">Blau</option>
            <option value="yellow">Groc</option>
            <option value="gray">Gris</option>
        </select>   

        <label for="xCord">Coordenada X:</label>
        <input type="number" name="xCord" id="xCord" required onchange="drawPreview()">

        <label for="yCord">Coordenada Y:</label>
        <input type="number" name="yCord" id="yCord" required onchange="drawPreview()">

        <br>
        <label for="size">Grandaria</label>
        <input type="range" name="size" id="size" onclick="drawPreview()">

        <br>

        <input type="submit" value="Crear firgura" class="btn btn-dark">
        <button onclick="drawPreview()" type="button" class="btn btn-dark">Previsualitza</button>
    </form>



<script>
let canvas = document.getElementById("canvas");
let ctx = canvas.getContext("2d");

function drawPreview() {
  let size = Number(document.getElementById("size").value);
  let xCord = Number(document.getElementById("xCord").value);
  let yCord = Number(document.getElementById("yCord").value);
  let figura = document.getElementById("tipoFigura").value;
  ctx.clearRect(0, 0, canvas.width, canvas.height);

  switch (figura) {
        case "circle":
            
            ctx.beginPath();
            ctx.arc(xCord, yCord, size, 0, 2 * Math.PI);
            ctx.fillStyle = document.getElementById("color").value;
            ctx.fill();
            break;

        case "square":
        ctx.beginPath();
        ctx.beginPath();
        ctx.rect(xCord, yCord, size, size);
        ctx.fillStyle = document.getElementById("color").value;
        ctx.fill();
        break;
        case "triangle":
            //configurar
        ctx.beginPath();
        ctx.moveTo(xCord, yCord);
        ctx.lineTo(xCord, yCord + size);
        ctx.lineTo(xCord + size, yCord);
        ctx.closePath();
        ctx.fillStyle = document.getElementById("color").value;
        ctx.fill();
            break;
        case "pentagon":
           
        let numberOfSides = 5;
        let radius=size;


        let angle = 2*Math.PI/numberOfSides;
        ctx.beginPath();
        ctx.translate(xCord, yCord);
        ctx.moveTo (radius*Math.cos(0), radius*Math.sin(0));
        for (var i = 1; i <= numberOfSides; i++) {
            ctx.lineTo (radius*Math.cos(i * angle), radius*Math.sin(i * angle));
        }
        ctx.setTransform(1, 0, 0, 1, 0, 0);

        ctx.closePath();
        ctx.fillStyle = document.getElementById("color").value;
        ctx.fill();
            break;

        case "star":
            //configurar
        let n = 7;
        let R = size;
        let r = size / 2;

        ctx.beginPath();
        ctx.translate(xCord, yCord);
        for (let i = 0; i < n; i++) {
            ctx.lineTo(Math.cos(((1 / 4 + i) * 2 * Math.PI / n)) * R, -Math.sin(((1 / 4 + i) * 2 * Math.PI / n)) * R);
            ctx.lineTo(Math.cos(((3 / 4 + i) * 2 * Math.PI / n)) * r, -Math.sin(((3 / 4 + i) * 2 * Math.PI / n)) * r);
        }
        ctx.setTransform(1, 0, 0, 1, 0, 0);

        ctx.closePath();
        ctx.fillStyle = document.getElementById("color").value;
        
        
        ctx.fill();;
                break;
            case "composed":

                chooseType(figura,xCord, yCord, size, ctx.fillStyle);
                chooseType(figura,xCord, yCord, size, ctx.fillStyle);
            default:
                break;

    }


    
    

}


</script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body></html>
