package gb.ru.market.model;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Scope("singleton")
@Getter
public class Cart {
    private List<CartItem> itemList;
    private int amount;

    public Cart() {
        itemList = new ArrayList<>();
    }

    public void addProductToCart(CartItem item) {
        amount += item.getTotalPrice();
        itemList.add(item);
    }

    public void clearTheCart() {
        itemList.clear();
        amount = 0;
    }

    public void removeProduct(Long id) {
        for (int i = 0; i < itemList.size(); i++) {
            if (Objects.equals(itemList.get(i).getId(), id)) {
                amount = amount - itemList.get(i).getTotalPrice();
                itemList.remove(itemList.get(i));
            }
        }
    }
}