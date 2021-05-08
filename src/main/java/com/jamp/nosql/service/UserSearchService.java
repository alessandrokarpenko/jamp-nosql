package com.jamp.nosql.service;

import com.jamp.nosql.models.User;
import com.jamp.nosql.storage.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserSearchService {

    @Autowired
    private UserSearchRepository userSearchRepository;

    public Collection<User> search(String query) {
        return userSearchRepository.search(query);
    }

}
