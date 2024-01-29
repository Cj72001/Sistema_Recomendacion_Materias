<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Document</title>

    <style>
        form a, form label {
            text-decoration: none; 
            margin-top: 20px; /* Ajusta este margen según sea necesario */
            padding-top: 0; /* Asegúrate de que el padding se establezca en 0 */
            color: #9fafc1;
            line-height: 20pt;
        }
        .btn2 {
            margin-bottom: 20px; /* Añade un margen inferior al botón */
            color: white; /* Color del texto */
            border: none; /* Sin borde */
            padding: 10px 20px; /* Espaciado interno */
            cursor: pointer; /* Cambia el cursor al pasar por el botón */
            font-size: 16px; /* Tamaño de fuente */
            transition: background-color 0.3s, color 0.3s, border 0.3s; /* Transición suave para el cambio de color y borde */
        }
        .btn2:hover {
            background-color: #f2f2f2; /* Color de fondo al pasar el mouse */
            color: black; /* Color del texto al pasar el mouse */
            border: 1px solid #333; /* Borde gris-negro al pasar el mouse */
        }
        .links div {
            margin-top: 10px; /* Añade un margen superior a los enlaces */
        }
    </style>
    
</head>

<body>
    <div class="main">

        <form method="post" action="userUpdateSuccess">
        <img src="<c:url value='/resources/img/login.jpg'/>" width="10%"/>
            <div class="box">
                <input type="name" name="name" placeholder="Nuevo Nombre" onFocus="field_focus(this, 'nombre');"
                    onblur="field_blur(this, 'name');" class="carnet" />
                <input type="carnet" name="carnet" placeholder="Carnet" onFocus="field_focus(this, 'carnet');"
                    onblur="field_blur(this, 'carnet');" class="carnet" />
            </div> <!-- End Box -->
            
            <div> 
            <h3>${errorUU}</h3>
            <br> <input class="btn2" type="submit" value="Actualizar">
              
            </div>
            
        </form>

        <div>
            
            <div> 
                <a href="${pageContext.request.contextPath}/mainPage">Regresar a Mi Proceso</a>
            </div>

        </div>

    </div>

</body>

</html>