package com.jamp.nosql.storage;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.search.SearchQuery;
import com.couchbase.client.java.search.result.SearchRow;
import com.jamp.nosql.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class UserCouchbaseSearchRepository implements UserSearchRepository {

    @Autowired
    private Cluster cluster;

    @Autowired
    private UserCouchbaseRepository repository;

    @Value("${search.index.name}")
    private String searchIndexName;

    @Override
    public Collection<User> search(String query) {
        return repository.findAllById(
                cluster.searchQuery(searchIndexName, SearchQuery.queryString(query))
                        .rows().stream().map(SearchRow::id).collect(Collectors.toList()));
    }
}














