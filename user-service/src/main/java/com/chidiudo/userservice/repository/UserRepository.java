package com.chidiudo.userservice.repository;

import com.chidiudo.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //write JPQL query to search for users
   /* @Query("SELECT u FROM User u WHERE " + "u.firstname LIKE CONCAT('%':query,'%')" +
                                           "OR u.lastname LIKE CONCAT('%',:query,'%')" +
                                           "OR u.email LIKE CONCAT('%',:query,'%')" +
                                           "OR u.phonenumber LIKE CONCAT('%',:query,'%')")
    List<User> searchUsersjpql(String query); */


    //write SQL query to search for users
    @Query(value = "SELECT * FROM users u WHERE u.firstname LIKE %query%", nativeQuery = true)
    List<User> searchUsers(String query);

}
