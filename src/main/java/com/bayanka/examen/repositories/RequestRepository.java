package com.bayanka.examen.repositories;

import com.bayanka.examen.repositories.domains.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
