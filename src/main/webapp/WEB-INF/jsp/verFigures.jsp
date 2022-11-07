<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
 <title>Ver Figuras</title>
</head>
<body onload= "drawPreview('${figura.size}' , '${figura.xCord}', '${figura.yCord}', '${figura.tipo}', '${figura.color}')">
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

 <h1> Veure Figura </h1>

 <canvas id="canvas" width="1024" height="768" style="border: solid black 1px;"></canvas>


 <script>
    let canvas = document.getElementById("canvas");
    let ctx = canvas.getContext("2d");
    
    function drawPreview(size,xCord,yCord,figura,color) {

      ctx.clearRect(0, 0, canvas.width, canvas.height);
    
      switch (figura) {
            case "circle":
                
                ctx.beginPath();
                ctx.arc(xCord, yCord, size, 0, 2 * Math.PI);
                ctx.fillStyle = color.value;
                ctx.fill();
                break;
    
            case "square":
            ctx.beginPath();
            ctx.beginPath();
            ctx.rect(xCord, yCord, size, size);
            ctx.fillStyle = color.value;
            ctx.fill();
            break;
            case "triangle":
                //configurar
            ctx.beginPath();
            ctx.moveTo(xCord, yCord);
            ctx.lineTo(xCord, yCord + size);
            ctx.lineTo(xCord + size, yCord);
            ctx.closePath();
            ctx.fillStyle = color.value;
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
            ctx.fillStyle = color.value;
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
            ctx.fillStyle = color.value;
            
            
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

</body>
</html>