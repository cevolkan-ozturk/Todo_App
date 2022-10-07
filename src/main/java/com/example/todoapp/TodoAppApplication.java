package com.example.todoapp;

import com.example.todoapp.models.TodoItem;
import com.example.todoapp.models.User;
import com.example.todoapp.repository.TodoItemRepository;
import com.example.todoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@RequiredArgsConstructor
@EnableWebMvc
@EnableSwagger2
public class TodoAppApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final TodoItemRepository todoItemRepository;


	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1L);
		user.setFirstname("Volkan");
		user.setLastname("ÖZTÜRK");
		user.setEmail("volkan.erzurum@gmail.com");
		user.setPassword("password");

		TodoItem todoItem = new TodoItem();
		todoItem.setId(1l);
		todoItem.setDescription("Start the Todo app");
		todoItem.getCompleted();

		user.getTodoItems().add(todoItem);

		todoItemRepository.save(todoItem);
		userRepository.save(user);

	}
}
