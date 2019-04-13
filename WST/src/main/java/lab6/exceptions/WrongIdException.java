package lab6.exceptions;

public class WrongIdException extends Exception {

    private final static String TEMPLATE_OF_MESSAGE = "Error during %s operation. " +
            "FilmRequest with id %d is not found";

    public WrongIdException(Integer id, String command) {
        super(String.format(TEMPLATE_OF_MESSAGE, command, id));
    }
}
