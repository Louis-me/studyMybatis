import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import xyz.shi.dao.GradeDao;
import xyz.shi.dao.PersonDao;
import xyz.shi.dao.StudentDao;
import xyz.shi.dao.impl.StudentDaoImpl;
import xyz.shi.domain.Course;
import xyz.shi.domain.Grade;
import xyz.shi.domain.Person;
import xyz.shi.domain.Student;

import java.util.*;

public class StudentDaoTest {
    private StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void  findAllStuCourse() {
        //在查询之前，设置分页条件 显示第一页，展示10条数据
        Page<Object> page = PageHelper.startPage(1, 3);

        List<Student> students = studentDao.findAll();

        PageInfo<Student> pageInfo = new PageInfo<>(students, 5);

        for (Student student:students) {
            System.out.println("------每个用户的信息-------");
            System.out.println(student);
            System.out.println(student.getCourses());
            List<Course> courses = student.getCourses();
            for(Course course: courses) {
                System.out.println(course.getName());
                System.out.println(course.getId());
            }
        }
        System.out.println();
        ///xxx
        System.out.println("---------全面配置信息：--------");
        System.out.println("总数据量 :"+pageInfo.getTotal());
        System.out.println("每页的数量:"+pageInfo.getPageSize());
        System.out.println("当前页码:"+pageInfo.getPageNum());
        System.out.println("是否有上一页:"+pageInfo.isHasPreviousPage());
        System.out.println("上一页是:"+pageInfo.getPrePage());
        System.out.println("是否有下一页:"+pageInfo.isHasNextPage());
        System.out.println("下一页是:"+pageInfo.getNextPage());
        System.out.println("是否是第一页:"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页:"+pageInfo.isIsLastPage());
        System.out.println("导航页的第一个页码是："+pageInfo.getNavigateFirstPage());
        System.out.println("导航页的最后一个页码是："+pageInfo.getNavigateLastPage());
        System.out.println("每页显示的页码个数："+pageInfo.getNavigatePages());
        System.out.println("页码数："+ Arrays.toString(pageInfo.getNavigatepageNums()));
    }

    @Test
    public void insertBatchStudent() {
        // 设置年纪
        Grade grade = new Grade();
        grade.setId(2);

        Student student1 = new Student();
        student1.setName("刘小龙1");
        // 关联当前学生的年级
        student1.setGrade(grade);
        studentDao.insert(student1);

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("studentId", student1.getId());
        // 手动设置多个科目信息，也可以做批量新增科目
        List<Integer> courseIds = Arrays.asList(17, 18);
        parameterMap.put("courseIds", courseIds);

        studentDao.batchInsertStudentCourse(parameterMap);
    }
    @Test
    public void updateStudentCourse() {
        // 要更新的学生信息
        Student student = new Student();
        student.setId(41);
        // 学生新的名字
        student.setName("张三");

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("student", student);
        // 手动设置多个科目信息，也可以做批量新增科目
        List<Integer> courseIds = Arrays.asList(29, 30);
        parameterMap.put("courseIds", courseIds);
        // 更新学生的关联的课程
        studentDao.updateStudentCourse(parameterMap);
    }
    @Test
    public void deleteStudentAndRelations() {
        studentDao.deleteStudentAndRelations(42);
    }
}
