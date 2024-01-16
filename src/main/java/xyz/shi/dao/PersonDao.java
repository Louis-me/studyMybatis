package xyz.shi.dao;

import xyz.shi.domain.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();
    Person queryOne(int id);
    int insert(Person person);
    int modify(Person person);
    int delete(int id);

}
