package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.User;
import com.javatechie.crud.example.entity.UserDetails;
import com.javatechie.crud.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    // to save the object
    public void save(UserDetails userDetails) {
        userRepository.save(userDetails);
    }

    // to fetch results

    public List<UserDetails> getRecords(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) throws Exception {
        Page<UserDetails> records = userRepository.findAll(PageRequest.of(page, size));
        if(records==null|| records.isEmpty()){
            throw new Exception("there is no records");
        }
        return records.getContent();
    }

    public List<User> findAge(int age) throws Exception {
        List<UserDetails> userDetails=userRepository.findByAgeGreaterThan(age);
        if(userDetails==null||userDetails.isEmpty()){
            throw new Exception("there is no greater age than the current age");
        }
        List<User> users=new ArrayList<>();

        for(int i=0;i<userDetails.size();i++){
            User user=new User() ;
            user.setUserName(userDetails.get(i).getUserName());
            user.setAge(userDetails.get(i).getAge());
            users.add(user);
        }
        return users;
    }
}


