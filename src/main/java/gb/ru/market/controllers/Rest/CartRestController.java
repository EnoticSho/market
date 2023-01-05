package gb.ru.market.controllers.Rest;

import gb.ru.market.entity.Product;
import gb.ru.market.model.CartItem;
import gb.ru.market.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartRestController {

    private final CartService cartService;

    @Autowired
    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> showProductsInCart() {
        return cartService.showProductsInCart();
    }

    @PostMapping("/{id}")
    public void addProductToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductToCart(@PathVariable Long id) {
        cartService.deleteFromCart(id);
    }

    @DeleteMapping
    public void clearTheCart() {
        cartService.clearCart();
    }
}
