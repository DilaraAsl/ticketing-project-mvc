package com.cydeo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService  <T,ID>{
    // we are abstracting the implementation
    // where are we going to save the data? since we don't have database -we need a custom database
    public Map<ID,T> map=new HashMap<>(); // this is our custom database - we have findById() map is easier to retrieve the information
    T save(ID id,T object){
        map.put(id,object);
        return object;
    }
    List<T> findAll(){
        return new ArrayList<>(map.values()); //
    }

    T findById(ID id){
        return map.get(id);
    }
    void deleteById(ID id){
        map.remove(id);
    }
    void update(ID id,T object){
        map.put(id,object);
    }
}
