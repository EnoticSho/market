package gb.ru.market.api;

public class CartItemDto {
    private Long id;
    private String name;
    private int pricePerCount;
    private int quantity;
    private int totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerCount() {
        return pricePerCount;
    }

    public void setPricePerCount(int pricePerCount) {
        this.pricePerCount = pricePerCount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
