package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rhian.costa
 */
public interface CowRepository extends JpaRepository<Cow, Long> {
}
