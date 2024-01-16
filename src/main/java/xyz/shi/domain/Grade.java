package xyz.shi.domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grade {
    private Integer Id;
    private String name;
    //持有 Student 引用的集合，来维护一对多关联关系，一个班级可以创建多个学生
    private List<Student> students = new ArrayList<>();

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "Id=" + Id +
                ", name='" + name +
                '}';
    }
}