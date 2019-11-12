package no.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import no.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	List<CartItem> findByWorkOrderId(Long id);

}
