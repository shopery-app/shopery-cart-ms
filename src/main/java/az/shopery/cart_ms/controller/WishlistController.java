package az.shopery.cart_ms.controller;

import az.shopery.cart_ms.model.dto.shared.SuccessResponse;
import az.shopery.cart_ms.model.dto.response.WishlistResponseDto;
import az.shopery.cart_ms.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/me/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @GetMapping
    public ResponseEntity<SuccessResponse<WishlistResponseDto>> getMyWishlist(@RequestParam String email) {
        return ResponseEntity.ok(wishlistService.getMyWishlist(email));
    }

    @PostMapping("/{productId}")
    public ResponseEntity<SuccessResponse<WishlistResponseDto>> addProductToWishlist(@RequestParam String email, @PathVariable String productId) {
        return ResponseEntity.ok(wishlistService.addProductToWishlist(email, productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<SuccessResponse<WishlistResponseDto>> removeProductFromWishlist(@RequestParam String email, @PathVariable String productId) {
        return ResponseEntity.ok(wishlistService.removeProductFromWishlist(email, productId));
    }

    @DeleteMapping
    public ResponseEntity<SuccessResponse<WishlistResponseDto>> removeAllProductsFromWishlist(@RequestParam String email) {
        return ResponseEntity.ok(wishlistService.removeAllProductsFromWishlist(email));
    }
}
