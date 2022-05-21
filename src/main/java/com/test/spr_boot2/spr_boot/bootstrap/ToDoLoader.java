package com.test.spr_boot2.spr_boot.bootstrap;

import com.test.spr_boot2.spr_boot.model.ToDo;
import com.test.spr_boot2.spr_boot.model.ToDoStatus;
import com.test.spr_boot2.spr_boot.repositories.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ToDoLoader implements CommandLineRunner {
    public final ToDoRepository toDoRepository;

    public ToDoLoader(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadToDos();
    }

    private void loadToDos() {
        if (toDoRepository.count() == 0) {
            toDoRepository.save(
                    ToDo.builder()
                            .title("Go to market")
                            .description("Buy eggs from market")
                            .toDoStatus(ToDoStatus.COMPLETED)
                            .build()
            );
            toDoRepository.save(
                    ToDo.builder()
                            .title("Go to school")
                            .description("Complete assignments")
                            .toDoStatus(ToDoStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println("Sample Todos Loaded");
        }
    }
}
