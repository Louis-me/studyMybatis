package xyz.shi.dao.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.shi.dao.GradeDao;
import xyz.shi.domain.Grade;
import xyz.shi.domain.Student;
import xyz.shi.utils.MybatisUtils;

import java.util.List;

public class GradeDaoImpl implements GradeDao {
    @Override
    public List<Grade> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 命名空间+id，这就是命名空间的作用：便于区分
        List<Grade> gradesList = sqlSession.selectList("gradeMapper.findAll");
        sqlSession.commit();
        sqlSession.close();
        return gradesList;
    }

    @Override
    public Grade queryOne(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
       Grade grade = sqlSession.selectOne("gradeMapper.queryOne", id);
        sqlSession.close();
       return grade;
    }

    @Override
    public int insert(Grade grade) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.insert("gradeMapper.insertGrade", grade);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int insertBatchStudent(List<Student> students) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.insert("gradeMapper.insertBatchStudent",students);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int updateBatchStudent(List<Student> students) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.update("gradeMapper.updateBatchStudent",students);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int deleteBatchStudent(List<Integer> ids) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.delete("gradeMapper.deleteBatchStudent",ids);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

}
