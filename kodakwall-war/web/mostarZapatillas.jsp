<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.inacap.entities.Usuario"%>
<%@page import="com.inacap.entities.Favorito"%>


<%
    Usuario u = (Usuario) request.getSession().getAttribute("usuario");
    if (u != null) {
%>

<c:forEach items="${avisos}" var="a">
    <div class="card mx-auto col-md-3 col-10 mt-5 pt-4">
        <div class="d-flex ">
        </div> <img style="border-radius: 0px;" class='mx-auto img-thumbnail' src="${a.imagen}" width="auto" height="auto" />
        <div class="card-body text-center mx-auto" style="text-align: center;">
            <h5 class="card-title">${a.marca} ${a.modelo}</h5>
            <p class="card-text">${a.fecha}  |  


                    <label for="${a.avisoIdaviso}" class="custom-checkbox">

                        <%
                            List<Favorito> favCol = (List<Favorito>)(request.getAttribute("favoritos"));
                            for (int i = 0; i < favCol.size(); i++) {
                                
                            if(favCol.get(i).getEstado() == 1){
                                out.println("<input type='checkbox' id='"+favCol.get(i).getAvisoIdaviso()+"' checked />");  
                            }
                            
                             if(favCol.get(i).getEstado() == 0){
                                out.println("<input type='checkbox' id='"+favCol.get(i).getAvisoIdaviso()+"'/>");  
                            }
                             
                             if(favCol.get(i).getEstado() == null){
                                out.println("<input type='checkbox' id='"+favCol.get(i).getAvisoIdaviso()+"'/>");  
                            }
                            }
                        %>
                     
                        <i class="glyphicon glyphicon-heart-empty"></i>
                        <i class="glyphicon glyphicon-heart"></i>
                    </label>
           

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
        </div> <img style="border-radius: 0px;" class='mx-auto img-thumbnail' src="${a.imagen}" width="auto" height="auto" />
        <div class="card-body text-center mx-auto" style="text-align: center;">
            <h5 class="card-title">${a.marca} ${a.modelo}</h5>
            <p class="card-text">${a.fecha}  |  

                <label for="${a.idaviso}" class="custom-checkbox">
                    <input type="checkbox" id="${a.idaviso}"/> <!--- *tiene que ser con id de avisos por si no tiene fav  *<         checked/> --->
                    <i class="glyphicon glyphicon-heart-empty"></i>
                    <i class="glyphicon glyphicon-heart"></i>
                </label>

            </p>
        </div>
    </div>
</c:forEach>
<%    }
%>





<%
    // for(int i=0; i<avisos.lenght; i++){
    //}
%>