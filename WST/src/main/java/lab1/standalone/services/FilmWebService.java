package lab1.standalone.services;

import lab1.common.beans.Film;
import lab1.common.dao.FilmDAO;
import lab1.standalone.dao.StandaloneFilmDAO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(name = "FilmService")
public class FilmWebService {

    private final static FilmDAO filmDao = new StandaloneFilmDAO();

    @WebMethod
    public List<Film> getFilmsByFields(@WebParam(name = "filmName") String name,
                                       @WebParam(name = "director") String director,
                                       @WebParam(name = "country") String country,
                                       @WebParam(name = "dateOfStart") Date date,
                                       @WebParam(name = "duration") Double duration) {
        return filmDao.getDataByFields(name, director, country, date, duration);
    }
}
