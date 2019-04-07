
package lab2.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FilmService", targetNamespace = "http://lab2/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FilmService {


    /**
     * 
     * @param filmId
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteFilm", targetNamespace = "http://lab2/", className = "lab2.DeleteFilm")
    @ResponseWrapper(localName = "deleteFilmResponse", targetNamespace = "http://lab2/", className = "lab2.DeleteFilmResponse")
    @Action(input = "http://lab2/FilmService/deleteFilmRequest", output = "http://lab2/FilmService/deleteFilmResponse")
    public String deleteFilm(
        @WebParam(name = "filmId", targetNamespace = "")
        int filmId);

    /**
     * 
     * @param duration
     * @param country
     * @param director
     * @param filmId
     * @param dateOfStart
     * @param filmName
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateFilm", targetNamespace = "http://lab2/", className = "lab2.UpdateFilm")
    @ResponseWrapper(localName = "updateFilmResponse", targetNamespace = "http://lab2/", className = "lab2.UpdateFilmResponse")
    @Action(input = "http://lab2/FilmService/updateFilmRequest", output = "http://lab2/FilmService/updateFilmResponse")
    public String updateFilm(
        @WebParam(name = "filmId", targetNamespace = "")
        int filmId,
        @WebParam(name = "filmName", targetNamespace = "")
        String filmName,
        @WebParam(name = "director", targetNamespace = "")
        String director,
        @WebParam(name = "country", targetNamespace = "")
        String country,
        @WebParam(name = "dateOfStart", targetNamespace = "")
        XMLGregorianCalendar dateOfStart,
        @WebParam(name = "duration", targetNamespace = "")
        Double duration);

    /**
     * 
     * @param duration
     * @param country
     * @param director
     * @param dateOfStart
     * @param filmName
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertFilm", targetNamespace = "http://lab2/", className = "lab2.InsertFilm")
    @ResponseWrapper(localName = "insertFilmResponse", targetNamespace = "http://lab2/", className = "lab2.InsertFilmResponse")
    @Action(input = "http://lab2/FilmService/insertFilmRequest", output = "http://lab2/FilmService/insertFilmResponse")
    public Integer insertFilm(
        @WebParam(name = "filmName", targetNamespace = "")
        String filmName,
        @WebParam(name = "director", targetNamespace = "")
        String director,
        @WebParam(name = "country", targetNamespace = "")
        String country,
        @WebParam(name = "dateOfStart", targetNamespace = "")
        XMLGregorianCalendar dateOfStart,
        @WebParam(name = "duration", targetNamespace = "")
        Double duration);

    /**
     * 
     * @param duration
     * @param country
     * @param director
     * @param dateOfStart
     * @param filmName
     * @return
     *     returns java.util.List<lab2.Film>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findFilms", targetNamespace = "http://lab2/", className = "lab2.FindFilms")
    @ResponseWrapper(localName = "findFilmsResponse", targetNamespace = "http://lab2/", className = "lab2.FindFilmsResponse")
    @Action(input = "http://lab2/FilmService/findFilmsRequest", output = "http://lab2/FilmService/findFilmsResponse")
    public List<Film> findFilms(
        @WebParam(name = "filmName", targetNamespace = "")
        String filmName,
        @WebParam(name = "director", targetNamespace = "")
        String director,
        @WebParam(name = "country", targetNamespace = "")
        String country,
        @WebParam(name = "dateOfStart", targetNamespace = "")
        XMLGregorianCalendar dateOfStart,
        @WebParam(name = "duration", targetNamespace = "")
        Double duration);

}
