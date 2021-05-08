package com.jamp.nosql.service;

import com.jamp.nosql.models.Sport;
import com.jamp.nosql.models.User;
import com.jamp.nosql.storage.UserCouchbaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    @Autowired()
    private UserCouchbaseRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Optional<User> addSport(String id, Sport sport) {
        return repository.findById(id)
                .map(u->{
                    u.addSport(sport);
                    return repository.save(u);
                });
    }

    public Collection<User> findUsersBySportName(String sportName) {
        return repository.findUsersBySportName(sportName);
    }


}




