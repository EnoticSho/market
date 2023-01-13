package gb.ru.market.api;

public class StringResponse {
    public StringResponse(String value) {
        this.value = value;
    }

    private String value;

    public StringResponse() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
