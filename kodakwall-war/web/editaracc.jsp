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
                <h2 class="card-title">Opciones:</h2>
                <a class="card-text" href="kwServlet?action=cuenta">Favoritos</a><br>
                <a class="card-text" href="kwServlet?action=editaracc">Editar cuenta</a><br>
            </div>
            <div class="row">  
                <div class="col">
                    <form method="post" action="kwServlet">
                        <div style="margin-top: 100px;" class="cuadrologin">
                            <input class="login" type="text" name="email" id="email" value="${email}" size="23" maxlength="40" placeholder="E-mail"/>
                            <label class="errorLetras">${errorUsuario}</label>
                            <br>
                            <br>

                            <label class="errorLetras">${errorMail}</label>

                            <br>
                            <input class="login" type="text" name="pass" id="contraseña" size="23" maxlength="40" placeholder="Nueva password"/>
                            <label class="errorLetras">${errorContraseña1}</label>
                            <br>
                            <br>

                            <button class="col-md-5 botonsito" type="submit" value="editarCuentaOk" name="action">Editar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" /> 
    </body>
</html>