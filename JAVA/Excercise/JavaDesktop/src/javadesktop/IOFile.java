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
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tik
 */
public class IOFile {

    public void write(String path, StudentManager studentList) {
        try {
            FileWriter fw = new FileWriter("database.txt", false);
            PrintWriter pw = new PrintWriter(fw);
            for (Student s : studentList.list_student) {
                pw.println(s.getId());
                pw.println(s.getName());
                pw.println(s.getAddress());
                pw.println(s.getClass());
                pw.println(s.getBirthDay());
                pw.println(s.getMath());
                pw.println(s.getPhysics());
                pw.println(s.getChemistry());
                s.toString();
            }
        } catch (IOException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void read(String path) {
        try {
            Scanner scan = new Scanner(Paths.get("database.txt"), "UTF-8");
            while (scan.hasNext()) {
                Student s = new Student();
                s.setId(scan.nextLine());
                s.setName(scan.nextLine());
                s.setAddress(scan.nextLine());
                s.setClassroom(scan.nextLine());
                s.setBirthDay(scan.nextLine());
                s.setMath(Double.parseDouble(scan.nextLine()));
                s.setPhysics(Double.parseDouble(scan.nextLine()));
                s.setChemistry(Double.parseDouble(scan.nextLine()));
            }
        } catch (IOException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFile(String path, StudentManager studentList) {
        try {
            FileWriter fw = new FileWriter(path, false);
            PrintWriter pw = new PrintWriter(fw);
            for (Iterator<Student> obj = studentList.list_student.iterator(); obj.hasNext();) {
                Student s = obj.next();
                pw.printf(s.getId() + ";" + s.getName() + ";" + s.getAddress() + ";" + s.getClassroom() + ";" + s.getBirthDay() + ";" + s.getMath() + ";" + s.getPhysics() + ";" + s.getChemistry() + ";");
                s.toString();
            }
            fw.close();
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StudentManager readFile(String path) {
        StudentManager studentList = new StudentManager();
        try {
            Scanner scan = new Scanner(Paths.get(path), "UTF-8");
            if (!scan.hasNext()) {
                return studentList;
            }
            String row = scan.nextLine();
            
            String[] oneRow = row.split(";");
            int i = 0;
            while (i < oneRow.length) {
                Student s = new Student();
                s.setId(oneRow[i]);
                i++;
                s.setName(oneRow[i]);
                i++;
                s.setAddress(oneRow[i]);
                i++;
                s.setClassroom(oneRow[i]);
                i++;
                s.setBirthDay(oneRow[i]);
                i++;
                s.setMath(Double.parseDouble(oneRow[i]));
                i++;
                s.setPhysics(Double.parseDouble(oneRow[i]));
                i++;
                s.setChemistry(Double.parseDouble(oneRow[i]));
                i++;
                studentList.addStudent(s);
            }
        } catch (IOException ex) {
            System.out.println("got an exception!");
        }
        return studentList;
    }
}
