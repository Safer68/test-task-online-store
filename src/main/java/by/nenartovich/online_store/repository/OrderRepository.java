package by.nenartovich.online_store.repository;

import by.nenartovich.online_store.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM  Order o WHERE o.client.id= :client_id")
    List<Order> findAllOrdersByClientId(@Param("client_id") Long clientId);

    @Query("SELECT o FROM Order o WHERE o.id = :id AND o.client.id = :client_id")
    Optional<Order> findByIdAndClientId(@Param("id") Long id, @Param("client_id") Long clientId);
}
