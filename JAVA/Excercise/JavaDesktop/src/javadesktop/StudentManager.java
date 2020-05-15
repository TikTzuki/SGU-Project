/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadesktop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Path;

/**
 *
 * @author Tik
 */
public class StudentManager {

    public List<Student> list_student;

    public StudentManager() {
        list_student = new ArrayList<Student>();
    }

    public StudentManager(List<Student> list_student) {
        this.list_student = list_student;
    }

    public boolean addStudent(Student s) {
        if (!list_student.contains(s.getId())) {
            list_student.add(s);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStudent(String id) {
        for (Iterator<Student> it = list_student.iterator(); it.hasNext();) {
            Student s = it.next();
            if (s.getId().compareToIgnoreCase(id) == 0) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    public void deleteStudent(int index) {
        list_student.remove(index);
    }
    public void edit(int index, Student s){
        list_student.set(index, s);
    }
    public boolean findStudent(String name) {
        for (Iterator<Student> it = list_student.iterator(); it.hasNext();) {
            Student s = it.next();
            if (s.getName().compareToIgnoreCase(name) == 0) {
                return true;
            }
        }
        return false;
    }

}
