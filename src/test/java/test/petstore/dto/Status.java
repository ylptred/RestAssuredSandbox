package test.petstore.dto;

public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold"),
    ;

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
