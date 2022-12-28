package gb.ru.market.model;

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

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerCount=" + pricePerCount +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
