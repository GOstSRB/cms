package no.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import no.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	List<Item> findBypartNameLike(String name);

	

}
