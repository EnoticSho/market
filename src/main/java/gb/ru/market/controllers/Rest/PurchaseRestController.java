package gb.ru.market.controllers.Rest;

import gb.ru.market.entity.User;
import gb.ru.market.services.PurchaseService;
import gb.ru.market.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseRestController {
    private final UserDetailsServiceImpl userService;
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseRestController(UserDetailsServiceImpl userService, PurchaseService purchaseService) {
        this.userService = userService;
        this.purchaseService = purchaseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPurchase(Principal principal) {
        User user = userService.findByName(principal.getName()).orElseThrow(() -> new RuntimeException(""));
        System.out.println(user.getName());
        purchaseService.createPurchase(user);
    }
}
