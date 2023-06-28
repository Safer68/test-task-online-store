package by.nenartovich.online_store.repository;

import by.nenartovich.online_store.repository.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
