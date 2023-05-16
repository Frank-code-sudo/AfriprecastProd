package com.production.AfriprecastProd.repository;

import com.production.AfriprecastProd.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByLoginAndPassword(String login, String password);
}
