package az.shopery.cart_ms.repository;

import az.shopery.cart_ms.model.entity.UserEntity;
import az.shopery.cart_ms.utils.enums.UserStatus;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus status);
}
