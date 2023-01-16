package com.javatechie.crud.example.repository;


import com.javatechie.crud.example.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer> {

    List<UserDetails> findByAgeGreaterThan(int age);

}
