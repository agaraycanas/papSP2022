package org.agaray.pap2021.repository;

import org.agaray.pap2021.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
}
