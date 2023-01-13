package gb.ru.market.carts.converters;

import gb.ru.market.api.CartItemDto;
import gb.ru.market.carts.model.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {

    public CartItemDto modelToDto(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(cartItem.getId());
        cartItemDto.setName(cartItem.getName());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setPricePerCount(cartItem.getPricePerCount());
        cartItemDto.setTotalPrice(cartItem.getTotalPrice());
        return cartItemDto;
    }
}
