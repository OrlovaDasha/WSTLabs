package lab6.exceptions;

public class WrongFieldValueException extends Exception {

    private static final String MESSAGE_TEMPLATE = "The field %s value must be %s";

    public WrongFieldValueException(String fieldName, String possibleValues) {
        super(String.format(MESSAGE_TEMPLATE, fieldName, possibleValues));
    }
}