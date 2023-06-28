package by.nenartovich.online_store.repository;

public enum StatusOrder {
    IN_PROCESSING("in processing"),
    SENT("sent"),
    DELIVERED("delivered");

    private final String code;

    StatusOrder(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
