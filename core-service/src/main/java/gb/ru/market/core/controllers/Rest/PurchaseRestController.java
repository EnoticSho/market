package gb.ru.market.core.controllers.Rest;

import gb.ru.market.core.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseRestController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseRestController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPurchase(@RequestHeader String username) {
        purchaseService.createPurchase(username);
    }
}
