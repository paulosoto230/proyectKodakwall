/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.inacap.entities.Aviso;
import com.inacap.sessionbeans.AvisoFacadeLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author paulo soto
 */
public class Conexion {
    
   

public ArrayList<Aviso> conexionNike(String url, String marca) {

        ArrayList<Aviso> avisos = new ArrayList<Aviso>();
        ArrayList<String> todosAr = new ArrayList<String>();
        ArrayList<String> fechaAr = new ArrayList<String>();
        ArrayList<String> linkImagen = new ArrayList<String>();
        ArrayList<String> todoUrls = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();

            Elements articulos = doc.select("div[class=copy-container ta-sm-c bg-white pt6-sm pb7-sm pb5-lg]");

            for (Element todoArticulo : articulos) {

                String nombre = todoArticulo.getElementsByClass("ncss-brand u-uppercase fs20-sm fs24-md fs28-lg").text();

                todosAr.add(nombre);
            }
            Elements fechas = doc.select("div[class=launch-caption ta-sm-c]");
            for (Element fech : fechas) {

                String fecha = (fech.getElementsByClass("mod-h2 ncss-brand u-uppercase fs19-sm fs28-md fs34-lg ").text() + " / "
                        + fech.getElementsByClass("mod-h1 ncss-brand test-day fs30-sm fs40-md").text() + " / " + "2020");
                fechaAr.add(fecha);

            }
            Elements linkImg = doc.select("a[class=card-link d-sm-b]");
            Elements nuevo;

            for (Element img : linkImg) {

                nuevo = img.getElementsByTag("img");

                for (Element todos : nuevo) {

                    String linkimagenes = todos.absUrl("src");

                    linkImagen.add(linkimagenes);

                }
            }
            Elements todo = doc.select("div[class=product-card ncss-row mr0-sm ml0-sm]");
            for (Element urls : todo) {

                String urlss = urls.getElementsByClass("card-link d-sm-b").attr("abs:href");

                todoUrls.add(urlss);
            }

            for (int i = 0; i < todoUrls.size(); i++) {

                Aviso sc = new Aviso();

                sc.setModelo(todosAr.get(i));
                sc.setFecha(fechaAr.get(i));
                sc.setImagen(linkImagen.get(i));
                sc.setMarca(marca);
                sc.setLink(todoUrls.get(i));

                avisos.add(sc);

            }

        } catch (IOException ex) {
            System.out.println("ouchhhh");
        }

        return avisos;

    }
 
    public ArrayList<Aviso> ConexionAdi(String url, String marca) {
  
  
            ArrayList<Aviso> avisos = new ArrayList<Aviso>(); 
        try {
          
            ArrayList<String> todoNombre = new ArrayList<String>();
            ArrayList<String> linkImagen = new ArrayList<String>();
            ArrayList<String> todoUrls = new ArrayList<String>();
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
           
            
               
         Elements modelos = doc.select("div[class=gl-product-card__details-main]");   
         for (Element todoArticulo : modelos) {

                String nombre = todoArticulo.text();
                todoNombre.add(nombre);
            }   
       
            Elements linkImg = doc.select("a[class=gl-product-card__media-link]");
            Elements nuevo;
            Elements imagenes2;
            for (Element img : linkImg) {

                nuevo = img.getElementsByClass("img_with_fallback___2aHBu gl-product-card__image performance-item");
                imagenes2 = img.getElementsByClass("img_with_fallback___2aHBu gl-product-card__image");
                for (Element todos : nuevo) {

                    String linkimagenes = todos.absUrl("src");

                    linkImagen.add(linkimagenes);

                }            
                  for (Element todos : imagenes2) {

                    String linkimagenes = todos.absUrl("src");
                     linkImagen.add(linkimagenes);

                }   
            }
         
           Elements todo = doc.select("div[class=gl-product-card glass-product-card___17N3p]");
      
                   
             for (Element urls : todo) {

                String urlss = urls.getElementsByClass("gl-product-card__media-link").attr("abs:href");

               todoUrls.add(urlss);
            }
           
          
            for (int i = 0; i < todoUrls.size(); i++) {

                Aviso sc = new Aviso();

                sc.setModelo(todoNombre.get(i));
                sc.setFecha("Jul/01/2020");
                sc.setImagen(linkImagen.get(i));
                sc.setMarca(marca);
                sc.setLink(todoUrls.get(i));
               
                avisos.add(sc);

            }
                          
                       
            
        } catch (IOException ex) {
           
            System.out.println(" ouchhhhhh error");
        }
        
        
        return avisos;
      }
}

