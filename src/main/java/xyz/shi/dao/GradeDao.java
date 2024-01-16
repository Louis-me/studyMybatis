package xyz.shi.dao;

import xyz.shi.domain.Grade;
import xyz.shi.domain.Student;

import java.util.List;

public interface GradeDao {
    List<Grade> findAll();
    Grade queryOne(int id);
    int insert(Grade grade);
    int insertBatchStudent(List<Student> students);

    int updateBatchStudent(List<Student> students);
    int deleteBatchStudent(List<Integer> ids);
}
