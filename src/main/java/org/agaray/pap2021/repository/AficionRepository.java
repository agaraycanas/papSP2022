package org.agaray.pap2021.repository;

import org.agaray.pap2021.entities.Aficion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AficionRepository extends JpaRepository<Aficion, Long>{
}
