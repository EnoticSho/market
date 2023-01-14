package gb.ru.market.carts.services;

import gb.ru.market.api.ProductDto;
import gb.ru.market.carts.integrations.ProductServiceIntegration;
import gb.ru.market.carts.model.Cart;
import gb.ru.market.carts.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final Cart cart;
    private final ProductServiceIntegration productService;

    @Autowired
    public CartService(Cart cart, ProductServiceIntegration productService) {
        this.cart = cart;
        this.productService = productService;
    }

    public List<CartItem> getProductList() {
        return cart.getItemList();
    }

    public Cart getCurrentCard() {
        return cart;
    }

    public void add(Long id) {
        ProductDto product = productService.getProductById(id);
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

    public int getAmount() {
        return cart.getAmount();
    }
}
