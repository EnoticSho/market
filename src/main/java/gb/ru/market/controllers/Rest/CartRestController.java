package gb.ru.market.controllers.Rest;

import gb.ru.market.model.Cart;
import gb.ru.market.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartRestController {

    private final CartService cartService;

    @Autowired
    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Cart showProductsInCart() {
        return cartService.getCurrentCard();
    }

    @PostMapping("/{id}")
    public void addProductToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @PutMapping("/increment")
    public void addQuantity(@RequestParam("productId") Long id, @RequestParam("delta") int delta) {
        cartService.editCartItem(id, delta);
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
