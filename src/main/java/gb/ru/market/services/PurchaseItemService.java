package gb.ru.market.services;

import gb.ru.market.entity.PurchaseItem;
import gb.ru.market.repository.PurchaseItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseItemService {

    private final PurchaseItemsRepository purchaseItemsRepository;

    @Autowired
    public PurchaseItemService(PurchaseItemsRepository purchaseItemsRepository) {
        this.purchaseItemsRepository = purchaseItemsRepository;
    }

    public void save(PurchaseItem purchaseItem) {
        purchaseItemsRepository.save(purchaseItem);
    }
}
