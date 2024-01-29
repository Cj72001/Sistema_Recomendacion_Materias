<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Registro</title>

    <style>
        form a, form label {
            text-decoration: none; 
            margin-top: 20px; /* Ajusta este margen según sea necesario */
            padding-top: 0; /* Asegúrate de que el padding se establezca en 0 */
            color: #9fafc1;
            line-height: 20pt;
        }
        .btn4 {
            margin-bottom: 20px; /* Añade un margen inferior al botón */
            color: white; /* Color del texto */
            border: none; /* Sin borde */
            padding: 10px 20px; /* Espaciado interno */
            cursor: pointer; /* Cambia el cursor al pasar por el botón */
            font-size: 16px; /* Tamaño de fuente */
            transition: background-color 0.3s, color 0.3s, border 0.3s; /* Transición suave para el cambio de color y borde */
        }
        .btn4:hover {
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

        <form method="post" action="registrarEstudiante">
        <img  src="<c:url value='/resources/img/login.jpg'/>" width="100px"/>
            <div class="box">
                <input type="text" name="nombreRe" placeholder="Nombre Completo" onFocus="field_focus(this, 'nombre');"
                    onblur="field_blur(this, 'nombre');" class="carnet" />
                <input type="carnet" name="carnetRe" placeholder="Carnet" onFocus="field_focus(this, 'carnet');"
                    onblur="field_blur(this, 'carnet');" class="carnet" />
                <input type="password" name="passwordRe" placeholder="Contraseña" onFocus="field_focus(this, 'password');"
                    onblur="field_blur(this, 'password');" class="carnet" /> 
                <input type="password" name="passwordRe2" placeholder="Repita Contraseña" onFocus="field_focus(this, 'password');"
                    onblur="field_blur(this, 'password');" class="carnet" /> 
            <h3>${errorRe}</h3>
            </div> <!-- End Box -->
            <br> <input class="btn4" type="submit" value="REGISTRARSE">
        </form>

        <div class="padding">
        <a href="${pageContext.request.contextPath}/login">Login</a>
      </div>

    </div>

</body>
</html>