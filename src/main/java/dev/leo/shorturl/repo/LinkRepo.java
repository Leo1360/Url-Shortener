package dev.leo.shorturl.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.leo.shorturl.model.Link;

@Repository
public interface LinkRepo extends JpaRepository<Link,Long>{
    Optional<Link> findByShortVersion(String shortVersion);
    boolean existsByShortVersion(String shortVersion);
}
