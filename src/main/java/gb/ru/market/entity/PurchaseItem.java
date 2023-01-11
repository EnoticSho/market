package gb.ru.market.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "purchase_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_items_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Column(name = "product_count")
    private int quantity;

    @Column(name = "product_price")
    private int pricePerProduct;

    public PurchaseItem(Product product, Purchase purchase, int quantity, int pricePerCount) {
        this.product = product;
        this.purchase = purchase;
        this.quantity = quantity;
        this.pricePerProduct = pricePerCount;
    }
}
