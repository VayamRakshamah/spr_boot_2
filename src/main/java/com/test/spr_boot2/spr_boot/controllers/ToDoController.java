package com.test.spr_boot2.spr_boot.controllers;

import com.test.spr_boot2.spr_boot.model.ToDo;
import com.test.spr_boot2.spr_boot.services.ToDoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService=toDoService;
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTodos() {
        List<ToDo> todos = toDoService.getToDos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping({"/{todoId}"})
    public ResponseEntity<ToDo> getTodo(@PathVariable Long todoId) {
        return new ResponseEntity<>(toDoService.getToDoById(todoId), HttpStatus.OK);
    }

    public ResponseEntity<ToDo> saveTodo(@RequestBody ToDo todo) {
        ToDo todo1 = toDoService.insert(todo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("todo", "/api/v1/todo/" + todo1.getId().toString());
        return new ResponseEntity<>(todo1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{todoId}"})
    public ResponseEntity<ToDo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody ToDo todo) {
        toDoService.updateToDo(todoId, todo);
        return new ResponseEntity<>(toDoService.getToDoById(todoId), HttpStatus.OK);
    }

    @DeleteMapping({"/{todoId}"})
    public ResponseEntity<ToDo> deleteTodo(@PathVariable("todoId") Long todoId) {
        toDoService.deleteToDo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
