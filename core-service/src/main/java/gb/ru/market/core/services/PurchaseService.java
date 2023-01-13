//package gb.ru.market.core.services;
//
//import gb.ru.market.core.repository.PurchaseRepository;
//import gb.ru.market.core.entity.Purchase;
//import gb.ru.market.core.entity.PurchaseItem;
//import gb.ru.market.auth.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//
//@Service
//public class PurchaseService {
//
//    private final CartService cartService;
//    private final ProductService productService;
//    private final PurchaseRepository purchaseRepository;
//
//    @Autowired
//    public PurchaseService(CartService cartService, ProductService productService, PurchaseRepository purchaseRepository) {
//        this.cartService = cartService;
//        this.productService = productService;
//        this.purchaseRepository = purchaseRepository;
//    }
//
//    @Transactional
//    public void createPurchase(User user) {
//        Purchase purchase = new Purchase();
//        purchase.setUser(user);
//        purchase.setDate(new Date());
//        purchase.setTotalCost(cartService.getAmount());
//        purchase.setItems(cartService.getProductList().stream().map(cartItem -> new PurchaseItem(
//                productService.getProductById(cartItem.getId()).get(),
//                purchase,
//                cartItem.getQuantity(),
//                cartItem.getPricePerCount()
//        )).toList());
//        purchaseRepository.save(purchase);
//    }
//}
