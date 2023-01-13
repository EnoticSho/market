package gb.ru.market.carts.controllers;

import gb.ru.market.api.CartDto;
import gb.ru.market.carts.converters.CartConverters;
import gb.ru.market.carts.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin("*")
public class CartRestController {

    private final CartService cartService;
    private final CartConverters cartConverters;

    @Autowired
    public CartRestController(CartService cartService, CartConverters cartConverters) {
        this.cartService = cartService;
        this.cartConverters = cartConverters;
    }

    @GetMapping
    public CartDto showProductsInCart() {
        return cartConverters.modelToDto(cartService.getCurrentCard());
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
