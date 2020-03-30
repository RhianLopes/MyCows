package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
