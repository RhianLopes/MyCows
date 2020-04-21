package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author rhian.costa
 */
public interface CowRepository extends JpaRepository<Cow, Long> {

    List<Cow> findAllByFarmAndIsActive(Farm farm, Boolean isActive);
}
