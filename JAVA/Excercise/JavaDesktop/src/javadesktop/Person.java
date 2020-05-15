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
public class Person {
    private String name;
    private String birthDay;
    private String address;
    
    public Person(){
        
    }

    public Person(String name, String birthDay, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
    }
    
    public Person(Person p){
        this.name = p.getName();
        this.birthDay = p.getBirthDay();
        this.address = p.getAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", birthDay=" + birthDay + ", address=" + address + '}';
    }
    
}
