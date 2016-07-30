/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shreeka.coursemanagement;

import com.shreeka.coursemanagement.dao.CourseDAO;
import com.shreeka.coursemanagement.dao.impl.CourseDAOImpl;
import com.shreeka.coursemanagement.entity.Course;
import java.util.Scanner;

/**
 *
 * @author Decode
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        CourseDAO courseDAO=new CourseDAOImpl();
        while(true)
        {
            System.out.println("");
        System.out.println("1.Add Course");
        System.out.println("2.Delete Course");
        System.out.println("3.Show All");
        System.out.println("4.Search by ID");
            System.out.println("5. Update a course");
        System.out.println("6.Exit");
        System.out.print("Enter your choice [1-5]: ");
        
        switch(input.nextInt())
        {
            case 1:
                Course c=new Course();
                System.out.println("Add new course");
                System.out.print("Enter course Id: ");
                c.setId(input.nextInt());
                System.out.print("Enter course name: ");
                c.setName(input.next());
                System.out.print("Enter course cost: ");
                c.setCost(input.nextDouble());
                
                if(courseDAO.insert(c))
                {
                    System.out.println("Inserted successfully");
                }else
                    System.out.println("Data full");
                
                break;
                
            case 2:
                System.out.print("Enter course id to be deleted: ");
                if(courseDAO.delete(input.nextInt()))
                {
                    System.out.println("Course deleted.");   
                }else
                    System.out.println("Null course id. Cannot be deleted. ");
                break;
                
            case 3:
                System.out.println("Display all courses");
                Course[] courseList= courseDAO.getAll();
                for(int i=0;i<courseList.length;i++)
                {   if(courseList[i]!=null)
                {
                    System.out.println("Course id: "+courseList[i].getId());
                    System.out.println("Course name: "+courseList[i].getName());
                    System.out.println("Course cost: "+courseList[i].getCost());
                    System.out.println("");
                }
                }
                break;
                
            case 4:
                System.out.print("Enter course id to be searched: ");
                Course course= courseDAO.getById(input.nextInt());
                if(course!=null){
                System.out.println("Course id: "+course.getId());
                System.out.println("Course name: "+course.getName());
                System.out.println("Course cost: "+course.getCost());
                }else
                    System.out.println("Course could not be found.");
                break;
                
            case 5:
                System.out.print("Enter course id to be updated: ");
                int id=input.nextInt();
                Course cupdate=courseDAO.getById(id);
                if(cupdate!=null){

                System.out.println("1. Update course id");
                System.out.println("2. Update course name");
                System.out.println("3. Update course cost");
                System.out.print("Enter your choice: ");
                switch(input.nextInt())
                {
                    case 1:
                        System.out.print("Enter new course id: ");
                        cupdate.setId(input.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter new course name: ");
                        cupdate.setName(input.next());
                        break;
                    case 3:
                        System.out.print("Enter new course cost: ");
                        cupdate.setCost(input.nextDouble());
                        break;
                }
                    System.out.println("Updated successfully");
                }else
                System.out.println("Course could not be found.");
                break;
                
            case 6:
                System.out.print("Do you really want to exit?(y/n)");
                if((input.next()).equalsIgnoreCase("y")){
                System.exit(0);
                }
                break;
                    
        }
        }
    }
    
}
