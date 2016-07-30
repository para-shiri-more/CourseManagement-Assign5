/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shreeka.coursemanagement.dao.impl;

import com.shreeka.coursemanagement.dao.CourseDAO;
import com.shreeka.coursemanagement.entity.Course;

/**
 *
 * @author Decode
 */
public class CourseDAOImpl implements CourseDAO {
    
    private int counter=0;
    private Course[] courseList=new Course[10];

    @Override
    public boolean insert(Course c) {
        if(counter<courseList.length)
        {
            courseList[counter]=c;
            counter++;
            return true;
        }else
            return false;    
        
    }

   

   

    @Override
    public Course getById(int id) {
        for(int i=0;i<courseList.length;i++)
        {
            Course c= courseList[i];
            if(c!=null && c.getId()==id){
            return c;
            }
        }
        return null;        
    }

    @Override
    public Course[] getAll() {
        return courseList;
    }

    @Override
    public boolean delete(int id) {
        for(int i=0;i<courseList.length;i++)
        {
            Course c= courseList[i];
            if(c!=null && c.getId()==id){
            courseList[i]=null;
            return true;
            }
                         
        }    
          return false;
    }

    @Override
    public boolean update(Course c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
