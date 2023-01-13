package gb.ru.market.api;

import java.util.List;

public class CartDto {
    private List<CartItemDto> itemList;
    private int amount;

    public List<CartItemDto> getItemList() {
        return itemList;
    }

    public void setItemList(List<CartItemDto> itemList) {
        this.itemList = itemList;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
