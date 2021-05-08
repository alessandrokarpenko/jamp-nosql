package com.jamp.nosql.storage;

import com.jamp.nosql.models.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface UserCouchbaseRepository extends CouchbaseRepository<User, String> {

    Optional<User> findByEmail(String email);

    @Query("#{#n1ql.selectEntity} WHERE ANY sport IN sports SATISFIES lower(sport.name) = lower($1) END")
    Collection<User> findUsersBySportName(String sportName);

}
