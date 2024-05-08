package com.rayen.boisson.repos;

import com.rayen.boisson.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "type")
public interface TypeRepository extends JpaRepository<Type, Long>{
	
}
