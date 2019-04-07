package lab3;

import lab1.standalone.services.FilmWebService;
import lab3.exceptions.FilmServiceFault;
import lab3.exceptions.WrongFieldValueException;
import lab3.exceptions.WrongIdException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@WebService(name = "FilmService")
public class FilmWebCrudServiceWithExceptions extends FilmWebService {

    private final static FilmDao filmDao = new FilmDao();

    @WebMethod
    public Integer insertFilm(
            @XmlElement(required = true)
            @WebParam(name = "filmName") String name,
            @WebParam(name = "director") String director,
            @WebParam(name = "country") String country,
            @WebParam(name = "dateOfStart") Date date,
            @WebParam(name = "duration") Double duration) throws WrongFieldValueException {
        if (duration != null && (duration < 10 || duration > 400)) {
            FilmServiceFault fault = new FilmServiceFault("insert", "Duration must have a normal value ");
            throw new WrongFieldValueException("insert", "Duration must be between 10 minutes and 400 minutes", fault);
        } else {
            return filmDao.insertRow(name, director, country, date, duration);
        }
    }

    @WebMethod
    public String deleteFilm(@XmlElement(required = true)
                             @WebParam(name = "filmId") Integer id) throws WrongIdException {
        if (filmDao.findId(id)) {
            return filmDao.deleteRow(id).getStringValue();
        } else {
            FilmServiceFault fault = new FilmServiceFault("delete", "Row for delete must exist");
            throw new WrongIdException(id, "delete", fault);
        }
    }

    @WebMethod
    public String updateFilm(@XmlElement(required = true)
                             @WebParam(name = "filmId") Integer id,
                             @WebParam(name = "filmName") String name,
                             @WebParam(name = "director") String director,
                             @WebParam(name = "country") String country,
                             @WebParam(name = "dateOfStart") Date date,
                             @WebParam(name = "duration") Double duration) throws WrongIdException, WrongFieldValueException {
        if (filmDao.findId(id)) {
            if (duration != null && (duration < 10 || duration > 400)) {
                FilmServiceFault fault = new FilmServiceFault("insert", "Duration must have a normal value ");
                throw new WrongFieldValueException("insert", "Duration must be between 10 minutes and 400 minutes", fault);
            } else {
                return filmDao.updateRow(id, name, director, country, date, duration).getStringValue();
            }
        } else {
            FilmServiceFault fault = new FilmServiceFault("update", "Row for update must exist");
            throw new WrongIdException(id, "update", fault);
        }

    }
}

