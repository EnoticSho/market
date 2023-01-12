package gb.ru.market.services;

import gb.ru.market.entity.Purchase;
import gb.ru.market.entity.PurchaseItem;
import gb.ru.market.entity.User;
import gb.ru.market.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PurchaseService {

    private final CartService cartService;
    private final ProductService productService;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(CartService cartService, ProductService productService, PurchaseRepository purchaseRepository) {
        this.cartService = cartService;
        this.productService = productService;
        this.purchaseRepository = purchaseRepository;
    }

    @Transactional
    public void createPurchase(User user) {
        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setDate(new Date());
        purchase.setTotalCost(cartService.getAmount());
        purchase.setItems(cartService.getProductList().stream().map(cartItem -> new PurchaseItem(
                productService.getProductById(cartItem.getId()).get(),
                purchase,
                cartItem.getQuantity(),
                cartItem.getPricePerCount()
        )).toList());
        purchaseRepository.save(purchase);
    }
}
