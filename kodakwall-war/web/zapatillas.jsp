<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.inacap.entities.Usuario"%>
<%@page import="com.inacap.entities.Favorito"%>
<%@page import="com.inacap.entities.Zapatillascompletas"%>

<html lang="en">
    <head>
        <jsp:include page="head.jsp" />  

        <title>KODAK--WALL</title>
    </head>
    <body>
        <div class="container-fluid">
            <jsp:include page="menu.jsp" />  
            <div style="padding-top: 50px;" class="row">
                <div class="col-md-1">
                    <form method="post" action="kwServlet">
                        <h2 class="card-title">MARCAS:</h2>
                        <a class="card-text" href="kwServlet?action=buscarN">Nike</a><br>
                        <a class="card-text" href="kwServlet?action=buscarA">Adidas</a><br>
                        <input class="login" type="text" name="buscarmodelo" size="20" maxlength="999" placeholder="Buscar modelo"/>
                        <br>
                        <button class="botonsito" style="width: 50px;" type="submit" value="gobuscarmodelo" name="action">Buscar</button>
                    </form>
                </div>

                <div class="col-md-11">

                    <%

                        Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                        if (u != null) {
                    %>
         


                    <c:forEach items="${avisos}" var="a">
                        <div class="card mx-auto col-md-3 col-10 mt-5 pt-4">
                            <div class="d-flex ">
                            </div> <a href="${a.link}" ><img style="border-radius: 0px;" class='mx-auto img-thumbnail' src="${a.imagen}" width="auto" height="auto" /></a>
                            <div class="card-body text-center mx-auto" style="text-align: center;">
                                <h5 class="card-title">${a.marca} ${a.modelo}</h5>
                                <p class="card-text">${a.fecha}  |

                                    <a style="text-decoration:none" href="kwServlet?action=seguir&idzafa=${a.idaviso}">Seguir</a>
                                </p>
                            </div>
                        </div>
                    </c:forEach>


                    <%
                    } else {
                    %>
                    <c:forEach items="${avisos}" var="a">
                        <div class="card mx-auto col-md-3 col-10 mt-5 pt-4">
                            <div class="d-flex ">
                            </div><a href="${a.link}" ><img style="border-radius: 0px;" class='mx-auto img-thumbnail' src="${a.imagen}" width="auto" height="auto" /></a>
                            <div class="card-body text-center mx-auto" style="text-align: center;">
                                <h5 class="card-title">${a.marca} ${a.modelo}</h5>
                                <p class="card-text">${a.fecha}  |

                                    <a style="text-decoration:none" href="kwServlet?action=loginFollow">Seguir</a>
                                </p>
                            </div>
                        </div>
                    </c:forEach>
                    <%    }
                    %>
                </div>
            </div>

        </div>
        <jsp:include page="footer.jsp" /> 
    </body>
</html>