package az.shopery.cart_ms.controller;

import az.shopery.cart_ms.model.dto.request.CartItemUpdateRequestDto;
import az.shopery.cart_ms.model.dto.response.CartResponseDto;
import az.shopery.cart_ms.model.dto.shared.SuccessResponse;
import az.shopery.cart_ms.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/me/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity<SuccessResponse<CartResponseDto>> getMyCart(@RequestParam String email) {
        return ResponseEntity.ok(cartService.getMyCart(email));
    }

    @PostMapping("/{productId}")
    public ResponseEntity<SuccessResponse<CartResponseDto>> addProductToCart(@RequestParam String email, @PathVariable String productId, @RequestBody @Valid CartItemUpdateRequestDto cartItemUpdateRequestDto) {
        return ResponseEntity.ok(cartService.addProductToCart(email, productId, cartItemUpdateRequestDto.getQuantity()));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<SuccessResponse<CartResponseDto>> updateProductInCart(@RequestParam String email, @PathVariable String productId, @RequestBody @Valid CartItemUpdateRequestDto cartItemUpdateRequestDto) {
        return ResponseEntity.ok(cartService.updateProductQuantity(email, productId, cartItemUpdateRequestDto.getQuantity()));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<SuccessResponse<CartResponseDto>> removeProductFromCart(@RequestParam String email,  @PathVariable String productId) {
        return ResponseEntity.ok(cartService.removeProductFromCart(email, productId));
    }

    @DeleteMapping
    public ResponseEntity<SuccessResponse<CartResponseDto>> removeAllProductsFromCart(@RequestParam String email) {
        return ResponseEntity.ok(cartService.removeAllProductsFromCart(email));
    }

    @PostMapping("/move-from-wishlist/{productId}")
    public ResponseEntity<SuccessResponse<CartResponseDto>> moveFromWishlist(@RequestParam String email, @PathVariable String productId) {
        return ResponseEntity.ok(cartService.moveProductFromWishlistToCart(email, productId));
    }
}
