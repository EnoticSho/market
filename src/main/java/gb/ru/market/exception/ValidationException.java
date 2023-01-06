package gb.ru.market.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ValidationException extends RuntimeException {
    private List<String> errorFieldsMessage;
    public ValidationException(List<String> errorFieldsMessage) {
        super(String.join(",", errorFieldsMessage));
        this.errorFieldsMessage = errorFieldsMessage;
    }
}
