package com.jamp.nosql.controller;

import com.jamp.nosql.models.User;
import com.jamp.nosql.service.UserSearchService;
import com.jamp.nosql.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/search")
@Tag(name = "Full text search service", description = "API for search by full-text-search index")
public class SearchController {

    @Autowired()
    private UserSearchService userSearchService;

    @GetMapping("/{query}")
    @Operation(summary = "Find users by text")
    public ResponseEntity<Collection<User>> findUsersBySportName(@PathVariable String query) {
        return ResponseEntity.ok(userSearchService.search(query));
    }
}
