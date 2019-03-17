package lab2;

public enum OperationStatus {

    SUCCESS_UPDATE("Row was successfully updated"),
    SUCCESS_DELETE("Row eas successfully deleted"),
    FAIL("Something went wrong");

    String value;

    OperationStatus(String value) {
        this.value = value;
    }

    public String getStringValue() {
        return value;
    }
}
