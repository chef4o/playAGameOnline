package com.example.pago.repositories;

import com.example.pago.domains.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    @Query(
        value = "select * from users u where u.role < :roleId",
        nativeQuery = true)
    List<User> findByRoleLowerThan(Integer roleId);
}

