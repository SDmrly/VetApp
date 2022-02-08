package com.App.Vet.core.dataAccess;

import com.App.Vet.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    boolean existsByUserName(String userName);
    User findByUserName(String userName);
    User findById(int id);

    @Query("select u from User u where u.userName like %:keyword% or u.firstName like %:keyword% or u.lastName Like %:keyword%")
    List<User> findByKeyword(@Param("keyword") String keyword);

}
