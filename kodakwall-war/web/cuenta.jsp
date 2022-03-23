<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <jsp:include page="head.jsp" />  
        <title>KODAK--WALL</title>
    </head>
    <body>
        <div class="container-fluid">
            <jsp:include page="menu.jsp" />  
            <div class="row">  
                <div class="col">
                    <p  style="margin-top: 50px;" class="wedontreformed">*ACCOUNT.</p>
                </div>
            </div>
            <div class="col-md-1" style="margin-top: 30px;" >
                <h2 class="card-title">OPCIONES:</h2>
                <a class="card-text" href="kwServlet?action=cuenta">Favoritos</a><br>
                <a class="card-text" href="kwServlet?action=editaracc">Editar cuenta</a><br>

            </div>
            <div class="row">  
                <div class="col">
                    <form method="post" action="kwServlet">
                        <div class="col-md-9" style="margin-left: 80px;margin-top: 40px">
                            <table class="table table-striped table-bordered">
                                <thead style="color: white;background-color:#1f1f1f">
                                    <tr>
                                        <th scope="col">
                                            Marca
                                        </th>
                                        <th scope="col">
                                            Modelo
                                        </th>
                                        <th scope="col">
                                            Fecha
                                        </th>
                                        <th scope="col">
                                            Imagen
                                        </th>
                                        <th scope="col">
                                            Acción
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${favoritos}" var="f">
                                        <tr>
                                            <td><a href="${f.avisoIdaviso.link}" >${f.avisoIdaviso.marca}</a></td>
                                            <td><a href="${f.avisoIdaviso.link}" >${f.avisoIdaviso.modelo}</a></td>
                                            <td><a href="${f.avisoIdaviso.link}" >${f.avisoIdaviso.fecha}</a></td>
                                            <td><a href="${f.avisoIdaviso.link}" ><img style="border-radius: 0px;max-height: 90px;max-width: 90px;" class='mx-auto img-thumbnail' src="${f.avisoIdaviso.imagen}" width="auto" height="auto" /></a></td>
                                            <td><a class="card-text" href="kwServlet?action=eliFav&id=${f.idfavorito}">Eliminar</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>

                            </table>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" /> 
    </body>
</html>