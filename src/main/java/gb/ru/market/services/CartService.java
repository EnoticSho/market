package gb.ru.market.services;

import gb.ru.market.entity.Product;
import gb.ru.market.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final Cart cart;
    private final ProductService productService;

    @Autowired
    public CartService(Cart cart, ProductService productService1) {
        this.cart = cart;
        this.productService = productService1;
    }

    public Cart getCurrentCard() {
        return cart;
    }

    public void add(Long id) {
        Product product = productService.getProductById(id).orElseThrow();
        cart.addProductToCart(product);
    }

    public void clearCart() {
        cart.clearTheCart();
    }

    public void deleteFromCart(Long productId) {
        cart.removeProduct(productId);
    }

    public void editCartItem(Long id, int inc) {
        cart.editCartItem(id, inc);
    }
}
