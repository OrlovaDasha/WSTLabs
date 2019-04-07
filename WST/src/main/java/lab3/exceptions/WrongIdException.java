package lab3.exceptions;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "lab3.exceptions.FilmServiceFault")
public class WrongIdException extends Exception {
    private FilmServiceFault filmServiceFault;

    private final static String TEMPLATE_OF_MESSAGE = "Error during %s operation. " +
            "Film with id %d is not found";

    public WrongIdException(Integer id, String command, FilmServiceFault fault) {
        super(String.format(TEMPLATE_OF_MESSAGE, command, id));
        this.filmServiceFault = fault;
    }

    public WrongIdException(Integer id, String command, FilmServiceFault fault, Throwable cause) {
        super(String.format(TEMPLATE_OF_MESSAGE, command, id), cause);
        this.filmServiceFault = fault;
    }

    public FilmServiceFault getFaultInfo() {
        return filmServiceFault;
    }
}
