/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadesktop;

/**
 *
 * @author Tik
 */
public class Student extends Person {

    private String id;
    private String classroom;
    private double math;
    private double physics;
    private double chemistry;

    public Student() {
    }

    public Student(String name, String birthDay, String address) {
        super(name, birthDay, address);
    }

    public Student(Person p) {
        super(p);
    }

    public Student(String id, String classroom, double math, double physics, double chemistry) {
        this.id = id;
        this.classroom = classroom;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public Student(String id, String classroom, double math, double physics, double chemistry, String name, String birthDay, String address) {
        super(name, birthDay, address);
        this.id = id;
        this.classroom = classroom;
        this.math = math;

        this.physics = physics;

        this.chemistry = chemistry;
    }

    public Student(String id, String classroom, double math, double literature, double physics, double biology, double chemistry, Person p) {
        super(p);
        this.id = id;
        this.classroom = classroom;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public double goalAVG() {
        return (math + physics + chemistry) / 5;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }


    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + super.getName() + ", address=" + super.getAddress() + ", classroom=" + classroom + ", birthday=" + super.getBirthDay() + ", math=" + math + ", physics=" + physics + ", chemistry=" + chemistry + '}';
    }

}
