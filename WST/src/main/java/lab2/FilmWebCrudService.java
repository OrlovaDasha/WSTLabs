package lab2;

import lab1.standalone.services.FilmWebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@WebService(name = "FilmService")
public class FilmWebCrudService extends FilmWebService {

    private final static FilmDao filmDao = new FilmDao();

    @WebMethod
    public Integer insertFilm(
            @XmlElement(required = true)
            @WebParam(name = "filmName") String name,
            @WebParam(name = "director") String director,
            @WebParam(name = "country") String country,
            @WebParam(name = "dateOfStart") Date date,
            @WebParam(name = "duration") Double duration) {
        return filmDao.insertRow(name, director, country, date, duration);
    }

    @WebMethod
    public String deleteFilm(@XmlElement(required = true)
                             @WebParam(name = "filmId") Integer id) {
        return filmDao.deleteRow(id).getStringValue();
    }

    @WebMethod
    public String updateFilm(@XmlElement(required = true)
                             @WebParam(name = "filmId") Integer id,
                             @WebParam(name = "filmName") String name,
                             @WebParam(name = "director") String director,
                             @WebParam(name = "country") String country,
                             @WebParam(name = "dateOfStart") Date date,
                             @WebParam(name = "duration") Double duration) {
        return filmDao.updateRow(id, name, director, country, date, duration).getStringValue();
    }
}

