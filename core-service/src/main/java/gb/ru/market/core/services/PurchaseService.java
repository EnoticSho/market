package gb.ru.market.core.services;

import gb.ru.market.api.CartDto;
import gb.ru.market.core.entity.Purchase;
import gb.ru.market.core.entity.PurchaseItem;
import gb.ru.market.core.integrations.CartServiceIntegration;
import gb.ru.market.core.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PurchaseService {

    private final CartServiceIntegration cartServiceIntegration;
    private final ProductService productService;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(CartServiceIntegration cartServiceIntegration, ProductService productService, PurchaseRepository purchaseRepository) {
        this.cartServiceIntegration = cartServiceIntegration;
        this.productService = productService;
        this.purchaseRepository = purchaseRepository;
    }

    @Transactional
    public void createPurchase(String username) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart();
        Purchase purchase = new Purchase();
        purchase.setUsername(username);
        purchase.setDate(new Date());
        purchase.setTotalCost(cartDto.getAmount());
        purchase.setItems(cartDto.getItemList().stream().map(cartItem -> new PurchaseItem(
                productService.getProductById(cartItem.getId()).get(),
                purchase,
                cartItem.getQuantity(),
                cartItem.getPricePerCount()
        )).toList());
        purchaseRepository.save(purchase);
    }
}
