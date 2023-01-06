package gb.ru.market.model;

import gb.ru.market.entity.Product;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Getter
public class Cart {
    private List<CartItem> itemList;
    private int amount;

    @PostConstruct
    public void init() {
        itemList = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(itemList);
    }

    private void recalculate() {
        amount = 0;
        for (CartItem item : itemList) {
            amount += item.getTotalPrice();
        }
    }

    public void addProductToCart(Product product) {
        boolean isPresent = false;
        for (CartItem cartItem : itemList) {
            if (cartItem.getId().equals(product.getId())) {
                cartItem.resize(1);
                isPresent = true;
            }
        }
        if (!isPresent) {
            CartItem item = new CartItem(product.getId(),
                    product.getName(),
                    product.getPrice(),
                    1,
                    product.getPrice());
            itemList.add(item);
        }
        recalculate();
    }

    public void editCartItem(Long id, int inc) {
        for (CartItem next : itemList) {
            if (next.getId().equals(id)) {
                next.resize(inc);
                if (next.getQuantity() == 0) {
                    itemList.remove(next);
                    break;
                }
            }
        }
        recalculate();
    }

    public void clearTheCart() {
        itemList.clear();
        amount = 0;
    }

    public void removeProduct(Long id) {
        itemList.removeIf(cartItem -> cartItem.getId().equals(id));
        recalculate();
    }
}
