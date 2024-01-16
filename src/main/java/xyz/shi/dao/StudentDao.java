package xyz.shi.dao;

import xyz.shi.domain.Course;
import xyz.shi.domain.Grade;
import xyz.shi.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student queryOne(int id);
    List<Student> findAll();
    int insert(Student student);
    int batchInsertStudentCourse(Map<String, Object> parameterMap);

    int updateStudent(Student student);
    int updateStudentCourse(Map<String, Object> parameterMap);
    int deleteStudentAndRelations(Integer id);


}
