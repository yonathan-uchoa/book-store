package com.yusk.bookstore.repository;

import com.yusk.bookstore.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    UserDetails findByUsername(String username);
}
