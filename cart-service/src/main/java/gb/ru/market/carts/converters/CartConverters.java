package gb.ru.market.carts.converters;

import gb.ru.market.api.CartDto;
import gb.ru.market.carts.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartConverters {

    private final CartItemConverter cartItemConverter;
    public CartDto modelToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setAmount(cart.getAmount());
        cartDto.setItemList(cart.getItemList().stream().map(cartItemConverter::modelToDto).toList());
        return cartDto;
    }
}
