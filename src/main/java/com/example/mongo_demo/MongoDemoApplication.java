package com.example.mongo_demo;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@ComponentScan
@RestController
public class MongoDemoApplication {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/add")
	public User addUser() {
		User user = new User();
		user.setAge(18 + new Random(20).nextInt());
		user.setName("licheng" + new Random(20).nextInt());
		userRepository.save(user);
		return user;
	}


	@RequestMapping("/list")
	public List<User> list() {
		return userRepository.findAll();
	}

	@RequestMapping("/findByName/{name}")
	public List<User> findByName(@PathVariable("name") String name) {
		return null;
	}

	@RequestMapping("/page")
	public Page<User> findDsl(@QuerydslPredicate (root = User.class) Predicate predicate,
							  Pageable pageable,
							  @RequestParam MultiValueMap<String, String> params) {
		Page<User> page =  userRepository.findAll(predicate, pageable);
		return page;
	}

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}
}
