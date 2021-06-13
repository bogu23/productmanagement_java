package com.sdaacademy.productmanagement.repository;

import com.sdaacademy.productmanagement.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
