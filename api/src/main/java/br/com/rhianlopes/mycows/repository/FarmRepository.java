package br.com.rhianlopes.mycows.repository;

import br.com.rhianlopes.mycows.domain.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
