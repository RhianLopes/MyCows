package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
