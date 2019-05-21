package withAuth;

import lab1.standalone.services.FilmWebService;
import lab2.FilmDao;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Date;
import java.util.Map;


@WebService(name = "FilmService")
public class FilmWebCrudService extends FilmWebService {

    private String user = "user";
    private String pswd = "12345";
    private final static FilmDao filmDao = new FilmDao();

    @Resource
    WebServiceContext ctx;

    private boolean login(String login, String password) {
        return user.equals(login) && pswd.equals(password);
    }

    @WebMethod
    public String insertFilm(
            @XmlElement(required = true)
            @WebParam(name = "login") String login,
            @XmlElement(required = true)
            @WebParam(name = "password") String password,
            @XmlElement(required = true)
            @WebParam(name = "filmName") String name,
            @WebParam(name = "director") String director,
            @WebParam(name = "country") String country,
            @WebParam(name = "dateOfStart") Date date,
            @WebParam(name = "duration") Double duration) {
        if (login(login, password)) {
            return filmDao.insertRow(name, director, country, date, duration).toString();
        } else {
            return "Problem with authentication";
        }
    }

    @WebMethod
    public String deleteFilm(@XmlElement(required = true)
                                 @WebParam(name = "login") String login,
                             @XmlElement(required = true)
                                 @WebParam(name = "password") String password,
                             @XmlElement(required = true)
                             @WebParam(name = "filmId") Integer id) {
        if (login(login, password)) {
            return filmDao.deleteRow(id).getStringValue();
        } else {
            return "Problem with authentication";
        }
    }

    @WebMethod
    public String updateFilm(@XmlElement(required = true)
                                 @WebParam(name = "login") String login,
                             @XmlElement(required = true)
                                 @WebParam(name = "password") String password,
                             @XmlElement(required = true)
                             @WebParam(name = "filmId") Integer id,
                             @WebParam(name = "filmName") String name,
                             @WebParam(name = "director") String director,
                             @WebParam(name = "country") String country,
                             @WebParam(name = "dateOfStart") Date date,
                             @WebParam(name = "duration") Double duration) {
        if (login(login, password)) {
            return filmDao.updateRow(id, name, director, country, date, duration).getStringValue();
        } else {
            return "Problem with authentication";
        }
    }
}

