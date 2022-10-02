package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface CrudService <T,ID>{
    T save(T obj);
   T findById(ID id); // find the user by username there is no id
    List<T> findAll(); // we will print all the users in the table on the user page
    void deleteById(ID id);

    void update(T object);
}
