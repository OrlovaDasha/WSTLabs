package lab3.exceptions;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "lab3.exceptions.FilmServiceFault")
public class WrongFieldValueException extends Exception {
    private FilmServiceFault filmServiceFault;

    private static final String MESSAGE_TEMPLATE = "The field % value must be %s";

    public WrongFieldValueException(String fieldName, String possibleValues, FilmServiceFault fault) {
        super(String.format(MESSAGE_TEMPLATE, fieldName, possibleValues));
        this.filmServiceFault = fault;
    }

    public WrongFieldValueException(String fieldName, String possibleValues, FilmServiceFault fault, Throwable cause) {
        super(String.format(MESSAGE_TEMPLATE, fieldName, possibleValues), cause);
        this.filmServiceFault = fault;
    }

    public FilmServiceFault getFaultInfo() {
        return filmServiceFault;
    }
}