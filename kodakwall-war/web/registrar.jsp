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
                    <p class="wedontreformed">*REGISTRATION.</p>
                </div>
            </div>
            <div class="row">  
                <div class="col">
                    <form method="post" action="kwServlet">
                        <div class="cuadrologin">
                            <input class="login" type="text" name="email" id="email" value="${email}" size="23" maxlength="40" placeholder="E-mail"/>
                            <label class="errorLetras">${errorUsuario}</label>
                            <br>
                            <br>

                            <label class="errorLetras">${errorMail}</label>

                            <br>
                            <input class="login" type="password" name="contra" id="contraseña" value="${pass}" size="23" maxlength="40" placeholder="Password"/>
                            <label class="errorLetras">${errorContraseña1}</label>
                            <br>
                            <br>
                            <input class="login" type="password" name="recontra" id="contraseña" size="23" value="${pass2}" maxlength="40" placeholder="Re-Password"/>
                            <label class="errorLetras">${errorContraseña2}</label>
                            <br>
                            <label class="errorLetras">${errorClaveDif}</label>

                            <br>
                            <button class="col-md-5 botonsito" type="submit" value="crearcuenta" name="action">Crear</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" /> 
    </body>
</html>