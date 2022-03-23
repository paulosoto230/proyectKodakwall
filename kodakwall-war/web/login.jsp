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
                    <p class="wedontreformed">*LOGIN.</p>
                </div>
            </div>
            <div class="row">  
                <div class="col">
                    <form method="post" action="kwServlet">
                        <div class="cuadrologin">
                            <div class="textError" id="alerta"></div>
                            <input class="login" type="text" name="usuario" id="usuario" size="23" maxlength="40" placeholder="E-mail"/>
                            <div class="textError" id="errorUsuario"></div>
                            <br>
                            <input class="login" type="password" name="contra" id="contra" size="23" maxlength="40" placeholder="Contraseña"/>
                            <div class="textError" id="errorContraseña"></div>
                            <br>
                            <a class="noregis" href="kwServlet?action=registrar">¿No estas registrado?.</a>
                            <br>
                            <button class="col-md-5 botonsito" type="submit" value="entrar" name="action">Aceptar</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" /> 

    </body>     
</html>
