package xyz.shi.dao.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.shi.dao.PersonDao;
import xyz.shi.domain.Person;
import xyz.shi.utils.MybatisUtils;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public List<Person> findAll() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 命名空间+id，这就是命名空间的作用：便于区分
        List<Person> personList = sqlSession.selectList("personMapper.findAll");
        sqlSession.close();
        return personList;
    }

    @Override
    public Person queryOne(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Person person = sqlSession.selectOne("personMapper.queryOne", id);
        sqlSession.close();
        return person;

    }

    @Override
    public int insert(Person person) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.insert("personMapper.insertPerson", person);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int modify(Person person) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.update("personMapper.modifyPerson", person);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int delete(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.delete("personMapper.deletePerson", id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

}
