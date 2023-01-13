package gb.ru.market.core.services;

import gb.ru.market.core.repository.PurchaseItemsRepository;
import gb.ru.market.core.entity.PurchaseItem;
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
