/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shreeka.coursemanagement.dao;

import com.shreeka.coursemanagement.entity.Course;

/**
 *
 * @author Decode
 */
public interface CourseDAO {
    
    boolean insert(Course c);
    boolean update(Course c);
    boolean delete(int id);
    Course getById(int id);
    Course[] getAll();
}
