package xyz.shi.domain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private Integer id;
    private String name;
    //持有实体类 Grade 的一个引用，维护多对一关系
    private Grade grade;
    //将 Course 对象的集合作为其属性，以维护它们之间的多对多关联关系
    private List<Course> courses = new ArrayList<>();
    public Student() {
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
public Student(Integer id, String name, Grade grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
}
    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}