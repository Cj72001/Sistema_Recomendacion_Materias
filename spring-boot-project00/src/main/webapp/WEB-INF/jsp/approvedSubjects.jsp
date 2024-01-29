<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/WEB-INF/jsp/include-css.jsp" %>
    <title>Aproved Subjects</title>
</head>

<body>
    <!-- inluyendo header -->
    <%@include file="/WEB-INF/jsp/header.jsp" %>
    
    <di>
        <div>
            <h4 class="colordiv">
                Estas son tus materias aprobadas
            </h4>
            <img src="<c:url value='/resources/img/subjects.jpg'/>" width="25px"/>
        </div>
        
        <h1 class="colordiv">${errorMA0}</h1>
    
        <div>
            <table class="tablaNormal" border="1px">
                <tr>
                    <td bgcolor="#e5e5e5">Numero Correlativo</td>
                    <td bgcolor="#e5e5e5">Nombre de la materia</td>
                    <!-- <td bgcolor="#e5e5e5">Prerequisito</td> --> 
                    <td bgcolor="#e5e5e5">Nota</td>
                </tr>
                
                <c:forEach var="m" items="${materiasMA}">
                    <c:if test="${m.nombreMateria ne 'Bachillerato'}">
                        <tr>
                            <td>${m.idMateria}</td>
                            <td>${m.nombreMateria}</td>
                            <!-- <td>${m.preRequisito}</td>  -->
                            <td>${m.nota}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            
        </div>
                


</body>

</html>