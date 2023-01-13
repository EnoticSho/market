package gb.ru.market.carts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Long id;
    private String name;
    private int pricePerCount;
    private int quantity;
    private int totalPrice;

    public void resize(int inc) {
        quantity = quantity + inc;
        totalPrice = quantity * pricePerCount;
    }
}
