package net.javaguides.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="full_name")
    private String fullName;
    @Column(name = "point_number_one")
    private float pointNumberOne;

    @Column(name = "point_number_two")
    private float pointNumberTwo;
    @Column(name = "point_number_three")
    private float pointNumberThree;

    @Column(name="gpa")
    private float gpa;

    public Employee( String fullName, float pointNumberOne, float pointNumberTwo, float pointNumberThree, float gpa) {
        this.fullName = fullName;
        this.pointNumberOne = pointNumberOne;
        this.pointNumberTwo = pointNumberTwo;
        this.pointNumberThree = pointNumberThree;
        this.gpa = gpa;
    }
    public Employee() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getPointNumberOne() {
        return pointNumberOne;
    }

    public void setPointNumberOne(float pointNumberOne) {
        this.pointNumberOne = pointNumberOne;
    }

    public float getPointNumberTwo() {
        return pointNumberTwo;
    }

    public void setPointNumberTwo(float pointNumberTwo) {
        this.pointNumberTwo = pointNumberTwo;
    }

    public float getPointNumberThree() {
        return pointNumberThree;
    }

    public void setPointNumberThree(float pointNumberThree) {
        this.pointNumberThree = pointNumberThree;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
