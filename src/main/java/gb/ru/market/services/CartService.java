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
    private final ProductService productService;

    @Autowired
    public CartService(Cart cart, ProductService productService, ProductService productService1) {
        this.cart = cart;
        this.productService = productService1;
    }

    public CartItem findById(Long id) {
        return cart.findProductById(id);
    }


    public List<CartItem> showProductsInCart() {
        return cart.getItemList();
    }

    public void add(Long id) {
        Product product = productService.getProductById(id);
        CartItem cartItem = new CartItem(product.getId(),
                product.getName(),
                product.getPrice(),
                1,
                product.getPrice());
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
