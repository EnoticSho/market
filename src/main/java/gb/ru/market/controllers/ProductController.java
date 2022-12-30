package gb.ru.market.controllers;

import gb.ru.market.entity.Product;
import gb.ru.market.model.CartItem;
import gb.ru.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@PreAuthorize("hasAuthority('view')")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showAllBuyers(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("allProducts", allProducts);
        model.addAttribute("cartItem", new CartItem());
        return "products/allProducts";
    }

    @GetMapping("/{id}")
    public String showProductInfo(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("ProductInfo", product);
        return "products/ProductInfo";
    }


    @GetMapping("/newProduct")
    @PreAuthorize("hasAuthority('editing')")
    public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("newProduct", product);
        return "products/NewProduct";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('editing')")
    public String addNewProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('editing')")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
