package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author rhian.costa
 */
public interface FarmRepository extends JpaRepository<Farm, Long> {

    List<Farm> findAllByUser(User user);
}
