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
                    <p class="wedont">*WE DON'T PAY RESALE.</p>
                </div>
            </div>

            <div class="row" style="position: fixed; top: 0; width: 1600px; height: 900px; z-index: -999;">
                <video class="videofondo" autoplay="" muted="" loop="" playsinline="" width="1600" height="900" id="video" style="width:100%; height:100%">
                    <source src="img/kodakwall.mp4" type="video/mp4">
                </video>
            </div>
        </div>
        <jsp:include page="footer.jsp" /> 
    </body>
</html>