package gb.ru.market.api;

import java.util.List;

public class FieldsValidationError {
    private List<String> errorFieldMessages;

    public FieldsValidationError(List<String> errorFieldMessages) {
        this.errorFieldMessages = errorFieldMessages;
    }
}
