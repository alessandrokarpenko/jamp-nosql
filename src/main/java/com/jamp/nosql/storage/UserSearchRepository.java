package com.jamp.nosql.storage;

import com.jamp.nosql.models.User;

import java.util.Collection;

public interface UserSearchRepository {

    Collection<User> search(String query);
}
