<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.inacap.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    Usuario u = (Usuario) request.getSession().getAttribute("usuario");

    if (u != null) {

%>
<div class="row menutop">
    <div class="marcaletras col-md-2"><p>*KODAK--WALL</p></div>

    <div class="col-md-1">                 
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="inicio" name="action">Main</button>
        </form> 
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="nosotros" name="action">About</button>
        </form>   
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="noticias" name="action">More</button>
        </form>   
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="shoes" name="action">Shoes</button>
        </form>   
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="Log-Out" name="action">Log-Out</button>
        </form>   
    </div>
     <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="cuenta" name="action">Account</button>
        </form>   
    </div>
</div>
<%} else {
%>
<div class="row menutop">
    <div class="marcaletras col-md-2"><p>*KODAK--WALL</p></div>

    <div class="col-md-1">                 
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="inicio" name="action">Main</button>
        </form> 
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="nosotros" name="action">About</button>
        </form>   
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="noticias" name="action">More</button>
        </form>   
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="shoes" name="action">Shoes</button>
        </form>   
    </div>
    <div class="col-md-1">
        <form action="kwServlet" method="post">
            <button class="camunflado" type="submit" value="Login" name="action">Login</button>
        </form>   
    </div>
</div>
<%
    }
%>
