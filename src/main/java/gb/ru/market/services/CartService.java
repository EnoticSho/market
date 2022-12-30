package gb.ru.market.services;

import gb.ru.market.entity.Product;
import gb.ru.market.model.Cart;
import gb.ru.market.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final Cart cart;

    @Autowired
    public CartService(Cart cart, ProductService productService) {
        this.cart = cart;
    }

    public CartItem findById(Long id) {
        return cart.findProductById(id);
    }


    public List<CartItem> showProductsInCart() {
        return cart.getItemList();
    }

    public void add(CartItem cartItem) {
        cart.addProductToCart(cartItem);
    }

    public void clearCart() {
        cart.clearTheCart();
    }

    public void deleteFromCart(Long productId) {
        cart.removeProduct(productId);
    }

    public int getTotalPrice() {
        return cart.getAmount();
    }

    public void editCartItem(Long id, int inc) {
        cart.editCartItem(id, inc);
    }
}
