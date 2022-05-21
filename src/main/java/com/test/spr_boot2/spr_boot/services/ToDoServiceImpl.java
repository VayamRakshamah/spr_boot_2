package com.test.spr_boot2.spr_boot.services;

import com.test.spr_boot2.spr_boot.model.ToDo;
import com.test.spr_boot2.spr_boot.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    private ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDo> getToDos() {
        List<ToDo> toDos = new ArrayList<>();
        toDoRepository.findAll().forEach(toDos::add);
        return toDos;
    }

    @Override
    public ToDo getToDoById(Long id) {
        return toDoRepository.findById(id).get();
    }

    @Override
    public ToDo insert(ToDo todo) {
        return toDoRepository.save(todo);
    }

    @Override
    public void updateToDo(Long id, ToDo todo) {
        ToDo todoFromDb = toDoRepository.findById(id).get();
        System.out.println(todoFromDb.toString());
        todoFromDb.setTitle(todo.getTitle());
        todoFromDb.setDescription(todo.getDescription());
        todoFromDb.setToDoStatus(todo.getToDoStatus());
        toDoRepository.save(todoFromDb);

    }

    @Override
    public void deleteToDo(Long todoId) {
        toDoRepository.deleteById(todoId);
    }
}
