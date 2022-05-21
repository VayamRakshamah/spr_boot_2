package com.test.spr_boot2.spr_boot.services;

import com.test.spr_boot2.spr_boot.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getToDos();

    ToDo getToDoById(Long id);

    ToDo insert(ToDo todo);

    void updateToDo(Long id, ToDo todo);

    void deleteToDo(Long todoId);
}
