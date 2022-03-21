package org.agaray.pap2021.repository.rest;

import org.agaray.pap2021.entities.Pais;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RepositoryRestResource(collectionResourceRel = "paises", path = "paises")
public interface PaisRestRepository extends PagingAndSortingRepository<Pais,Long> {
    
}
