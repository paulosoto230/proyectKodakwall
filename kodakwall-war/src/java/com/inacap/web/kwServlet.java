package com.inacap.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import clases.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.inacap.sessionbeans.AvisoFacadeLocal;
import com.inacap.sessionbeans.FavoritoFacadeLocal;
import com.inacap.sessionbeans.NoticiaFacadeLocal;
import com.inacap.sessionbeans.TipoDeUsuarioFacadeLocal;
import com.inacap.sessionbeans.UsuarioFacadeLocal;
import com.inacap.entities.Aviso;
import com.inacap.entities.Favorito;
import com.inacap.entities.Noticia;
import com.inacap.entities.TipoDeUsuario;
import com.inacap.entities.Usuario;
import com.inacap.entities.Zapatillascompletas;
import com.inacap.sessionbeans.ZapatillascompletasFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author ZALO
 */
@WebServlet(urlPatterns = {"/kwServlet"})
public class kwServlet extends HttpServlet {

    @EJB
    AvisoFacadeLocal AvisoEJB;
    @EJB
    FavoritoFacadeLocal FavoritoEJB;
    @EJB
    NoticiaFacadeLocal NoticiaEJB;
    @EJB
    TipoDeUsuarioFacadeLocal TipoUsuarioEJB;
    @EJB
    UsuarioFacadeLocal UsuarioEJB;
    @EJB
    ZapatillascompletasFacadeLocal CompletasEJB;
    Conexion c = new Conexion();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String boton = request.getParameter("action");

        switch (boton) {
            case "inicio":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "Login":
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "Log-Out":
                salir(request, response);
                break;
            case "LoginGoogle":
                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "registrar":
                request.getRequestDispatcher("registrar.jsp").forward(request, response);
                break;
            case "shoes":
                goTodasLasZapatillas(request, response);
                break;
            case "entrar":
                entrar(request, response);
                break;
            case "seguir":
                seguir(request, response);
                break;
            case "crearcuenta":
                crearUsuario(request, response);
                break;
            case "noticias":
                request.getRequestDispatcher("more.jsp").forward(request, response);
                break;
            case "nosotros":
                request.getRequestDispatcher("nosotros.jsp").forward(request, response);
                break;
            case "cuenta":
                cuenta(request, response);
                break;
            case "editaracc":
                editaracc(request, response);
                break;
            case "editarCuentaOk":
                editarCuentaOk(request, response);
                break;
            case "eliFav":
                eliFav(request, response);
                break;
            case "loginFollow":
                loginFollow(request, response);
                break;
            case "buscarA":
                buscarA(request, response);
                break;
            case "buscarN":
                buscarN(request, response);
                break;
            case "gobuscarmodelo":
                buscarLike(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void buscarA(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String marca = " ADIDAS ";
        List<Aviso> avisos = AvisoEJB.findMarca(marca);
        request.setAttribute("avisos", avisos);
        request.getRequestDispatcher("zapatillas.jsp").forward(request, response);

    }

    private void buscarN(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String marca = " NIKE ";
        List<Aviso> avisos = AvisoEJB.findMarca(marca);
        request.setAttribute("avisos", avisos);
        request.getRequestDispatcher("zapatillas.jsp").forward(request, response);

    }

    private void buscarLike(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String like = request.getParameter("buscarmodelo");
        List<Aviso> avisos = AvisoEJB.buscarLike(like);

        request.setAttribute("avisos", avisos);
        request.getRequestDispatcher("zapatillas.jsp").forward(request, response);

    }

    private void goTodasLasZapatillas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aviso s = new Aviso();
        ArrayList<Aviso> avisoNike = c.conexionNike("https://www.nike.com/cl/launch?s=upcoming", " NIKE ");
        for (int i = 0; i < avisoNike.size(); i++) {
            s.setMarca(avisoNike.get(i).getMarca());
            s.setFecha((avisoNike.get(i).getFecha()));
            s.setImagen(avisoNike.get(i).getImagen());
            s.setModelo(avisoNike.get(i).getModelo());
            s.setLink(avisoNike.get(i).getLink());
            Aviso ingresar = AvisoEJB.Encontrar(avisoNike.get(i).getModelo());

            if (ingresar == null) {

                AvisoEJB.create(s);
            }

        }

        ArrayList<Aviso> avisoAdi = c.ConexionAdi("https://www.adidas.cl/4d?grid=true", " ADIDAS ");
        for (int i = 0; i < avisoAdi.size(); i++) {
            s.setMarca(avisoAdi.get(i).getMarca());
            s.setFecha((avisoAdi.get(i).getFecha()));
            s.setImagen(avisoAdi.get(i).getImagen());
            s.setModelo(avisoAdi.get(i).getModelo());
            s.setLink(avisoAdi.get(i).getLink());

            Aviso ingresar = AvisoEJB.Encontrar(avisoAdi.get(i).getModelo());

            if (ingresar == null) {

                AvisoEJB.create(s);
            }

        }

        List<Aviso> avisos = AvisoEJB.findAll();
        request.setAttribute("avisos", avisos);
        request.getRequestDispatcher("zapatillas.jsp").forward(request, response);

    }

    private void buscarFavoritos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = (Usuario) request.getSession().getAttribute("cliente");
        int idusuario = u.getIdUsuario();
        List<Favorito> favoritos = FavoritoEJB.buscarFavPorUsuario(idusuario);
        request.setAttribute("favoritos", favoritos);
    }

    private void loginFollow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alerta = "Debes iniciar sesión para usar esta función.";

        request.setAttribute("alerta", alerta);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void entrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("usuario");
        String clave = request.getParameter("contra");

        String email = (String) request.getParameter("email");

        Usuario u = UsuarioEJB.Validar(correo);

        if (u != null) {
            String prueba = u.getContraseña();

            System.out.println(prueba);
            System.out.println(clave);
            if (prueba.equals(clave)) {

                request.getSession().setAttribute("usuario", u);

                List<Aviso> avisos = AvisoEJB.findAll();

                request.setAttribute("avisos", avisos);
                request.getRequestDispatcher("zapatillas.jsp").forward(request, response);

            }

        } else {
            /*
                la clave es incorrecta
             */
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

    }

    private void crearUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String pass = request.getParameter("contra");
        String passValidar = request.getParameter("recontra");

        String errorNull = "*Este campo es requerido.";
        String errorEmail = "*Este e-mail ya esta siendo utilizado.";
        String errorClaveDif = "*La contraseña debe ser la misma.";
        String sinError = "";

        request.setAttribute("errorEmail", errorEmail);
        request.setAttribute("email", email);
        request.setAttribute("pass", pass);
        request.setAttribute("pass2", passValidar);

        boolean sinNulls = true;
        boolean emailOk = true;

        if (email.equals("")) {
            sinNulls = false;
            request.setAttribute("errorUsuario", errorNull);
        } else {
            request.setAttribute("errorUsuario", sinError);
            sinNulls = true;
        }

        if (pass.equals("")) {
            sinNulls = false;
            request.setAttribute("errorContraseña1", errorNull);
        } else {
            request.setAttribute("errorContraseña1", sinError);
            sinNulls = true;
        }

        if (passValidar.equals("")) {
            sinNulls = false;
            request.setAttribute("errorContraseña2", errorNull);
        } else {
            request.setAttribute("errorContraseña2", sinError);
            sinNulls = true;
        }

        if (sinNulls == true) {
            if (pass.equals(passValidar)) {
                sinNulls = true;
                request.setAttribute("errorClaveDif", sinError);
            } else {
                request.setAttribute("errorClaveDif", errorClaveDif);
                sinNulls = false;
            }

        }

        if (sinNulls == true) {
            Usuario emailVerificacion = UsuarioEJB.Validar(email);

            if (emailVerificacion == null) {
                emailOk = true;
                request.setAttribute("errorMail", sinError);

            } else {
                request.setAttribute("errorMail", errorEmail);

                emailOk = false;
            }
        }

        if (sinNulls == true && emailOk == true) {
            Usuario usuario = new Usuario();

            usuario.setCorreo(email);
            usuario.setContraseña(pass);

            usuario.setTipoDeUsuarioIdtipoDeUsuario(null);
            UsuarioEJB.create(usuario);

            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("registrar.jsp").forward(request, response);
        }
    }

    private void seguir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String aviso = request.getParameter("idzafa");
        int avisojsp = Integer.parseInt(aviso);
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");

        Aviso avi = AvisoEJB.buscarId(avisojsp);

        Favorito fav = new Favorito();
        short bar = (short) 1;
        fav.setEstado(bar);
        fav.setUsuarioidUsuario(u);
        fav.setAvisoIdaviso(avi);
        FavoritoEJB.create(fav);

        List<Aviso> avisos = AvisoEJB.findAll();

        request.setAttribute("avisos", avisos);
        request.getRequestDispatcher("zapatillas.jsp").forward(request, response);

    }

    private void salir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");

    }

    private void cuenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");

        List<Favorito> favoritos = FavoritoEJB.buscarFavs(u);
        request.setAttribute("favoritos", favoritos);

        request.getRequestDispatcher("cuenta.jsp").forward(request, response);

    }

    private void eliFav(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        FavoritoEJB.remove(FavoritoEJB.find(id));

        cuenta(request, response);
    }

    private void editaracc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = (Usuario) request.getSession().getAttribute("usuario");

        request.setAttribute("email", u.getCorreo());

        request.getRequestDispatcher("editaracc.jsp").forward(request, response);

    }

    private void editarCuentaOk(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario u = (Usuario) request.getSession().getAttribute("usuario");

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        String errorNull = "*Este campo es requerido.";
        String errorEmail = "*Este e-mail ya esta siendo utilizado.";
        String sinError = "";

        request.setAttribute("errorEmail", errorEmail);
        request.setAttribute("email", email);
        request.setAttribute("pass", pass);

        boolean sinNulls = true;
        boolean emailOk = true;

        if (email.equals("")) {
            sinNulls = false;
            request.setAttribute("errorUsuario", errorNull);
        } else {
            request.setAttribute("errorUsuario", sinError);
            sinNulls = true;
        }

        if (pass.equals("")) {
            sinNulls = false;
            request.setAttribute("errorContraseña1", errorNull);
        } else {
            request.setAttribute("errorContraseña1", sinError);
            sinNulls = true;
        }

        if (sinNulls == true && emailOk == true) {
            int iduser = u.getIdUsuario();
            Usuario usuario = UsuarioEJB.find(iduser);
            usuario.setCorreo(email);
            usuario.setContraseña(pass);
            usuario.setTipoDeUsuarioIdtipoDeUsuario(null);
            UsuarioEJB.edit(usuario);

            request.getRequestDispatcher("login.jsp").forward(request, response);
            salir(request, response);

        } else {
            request.getRequestDispatcher("editaracc.jsp").forward(request, response);
        }

    }
}
