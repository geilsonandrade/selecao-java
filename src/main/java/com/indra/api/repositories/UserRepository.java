package com.indra.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}