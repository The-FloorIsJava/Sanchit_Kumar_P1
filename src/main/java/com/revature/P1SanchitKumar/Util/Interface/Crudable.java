package com.revature.P1SanchitKumar.Util.Interface;

import java.util.List;

public interface Crudable<T> {
    // Create
    T create(T newObject);

    // Read
    List<T> findAll();

    T findByUser(String employee_user);

    // Update
    boolean update(T updatedObject);

    // Delete
    boolean delete(String employee_user);
}
