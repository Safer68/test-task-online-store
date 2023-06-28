package by.nenartovich.online_store.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("by.nenartovich.online_store.repository.model")
@EnableJpaRepositories("by.nenartovich.online_store.repository")
public class RepositoryConfig {
}
