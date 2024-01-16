package xyz.shi.dao.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.shi.dao.StudentDao;
import xyz.shi.domain.Student;
import xyz.shi.utils.MybatisUtils;

import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student queryOne(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Student student = sqlSession.selectOne("studentMapper.queryOne", id);
        sqlSession.close();
        return student;
    }

    @Override
    public List<Student> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Student> students = sqlSession.selectList("studentMapper.findAllStuCourse");
        sqlSession.commit();
        sqlSession.close();
        return students;

    }

    @Override
    public int insert(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
       int num = sqlSession.insert("studentMapper.insertStudent", student);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int batchInsertStudentCourse(Map<String, Object> parameterMap) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.insert("studentMapper.batchInsertStudentCourse", parameterMap);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int updateStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.update("studentMapper.updateStudent", student);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int updateStudentCourse(Map<String, Object> parameterMap) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.update("studentMapper.updateStudentCourse", parameterMap);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int deleteStudentAndRelations(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.update("studentMapper.deleteStudentAndRelations", id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
