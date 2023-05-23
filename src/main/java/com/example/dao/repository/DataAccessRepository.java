package com.example.dao.repository;

import java.util.ArrayList;

public interface DataAccessRepository<T> {
    void connect();

    void disconnect();

    int save(T t);

    T getOne(int id);

    ArrayList<T> getAll();

    int update(T t);

    int delete(int id);

}
