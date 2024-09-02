package com.ibrahim.userservice.dataAccess;

import com.ibrahim.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
