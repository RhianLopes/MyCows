package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rhian.costa
 */
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
