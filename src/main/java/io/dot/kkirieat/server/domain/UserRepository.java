package io.dot.kkirieat.server.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFoodTags_Name(String name);

    User findByIdOrElseThrow(String userId);
    User findByEmailOrElseThrow(String email);
}
