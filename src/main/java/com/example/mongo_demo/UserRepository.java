package com.example.mongo_demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

/**
 * @Author Cheng Lee
 * @Version 1.0
 */
public interface UserRepository extends MongoRepository<User, String>,
                                        QueryDslPredicateExecutor<User> {

}
