package com.test.spr_boot2.spr_boot.repositories;

import com.test.spr_boot2.spr_boot.model.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo,Long> {
}
