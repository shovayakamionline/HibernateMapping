package com.shova.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Teacher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String salary;
    private String teacherName;

    @ManyToOne
    @JoinColumn(name = "fk_dep")
    private Department department;

    public Teacher(int teacherId, String salary, String teacherName) {
        super();
        this.teacherId = teacherId;
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public Teacher() {
    }

    public Teacher(String salary, String teacherName) {
        this.salary = salary;
        this.teacherName = teacherName;
    }

    public Teacher(String salary, String teacherName, Department department) {
        super();
        this.salary = salary;
        this.teacherName = teacherName;
        this.department = department;
    }

    public Department getDep() {
        return department;
    }

    public void setDep(Department department) {
        this.department = department;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId && Objects.equals(salary, teacher.salary) && Objects.equals(teacherName, teacher.teacherName) && Objects.equals(department, teacher.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, salary, teacherName, department);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", salary='" + salary + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", department=" + department +
                '}';
    }
}
