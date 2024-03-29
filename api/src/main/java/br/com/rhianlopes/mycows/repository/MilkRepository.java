package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.Milk;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rhian.costa
 */
public interface MilkRepository extends JpaRepository<Milk, Long> {
}
