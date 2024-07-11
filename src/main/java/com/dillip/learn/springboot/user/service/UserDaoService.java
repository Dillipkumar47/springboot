package com.dillip.learn.springboot.user.service;

import com.dillip.learn.springboot.user.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users=new ArrayList<>();

    private static int userCount=0;
    static{
        users.add(new User(++userCount,"Dillip", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Rajesh", LocalDate.now().minusYears(29)));
        users.add(new User(++userCount,"Siddi", LocalDate.now().minusYears(31)));

    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;

    }
}
