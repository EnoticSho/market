package gb.ru.market.controllers;

import gb.ru.market.entity.Product;
import gb.ru.market.model.CartItem;
import gb.ru.market.services.CartService;
import gb.ru.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public String showCart(Model model) {
        List<CartItem> allProducts = cartService.showProductsInCart();
        model.addAttribute("Cart", allProducts);
        return "cart/showCart";
    }

    @PostMapping
    public String addProductToCart(@ModelAttribute("cartItem") CartItem cartItem) {
        System.out.println(cartItem);
        cartService.add(cartItem);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteProductFromCart(@PathVariable Long id) {
        cartService.deleteFromCart(id);
        return "redirect:/cart";
    }
}
