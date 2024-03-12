import com.zdx.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class EmployeeTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Before
    public void init(){
        String resources ="mybatis-config.xml";
        Reader reader=null;
        try {
            reader= Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
            sqlSession=sqlMapper.openSession();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findById(){
        int id=3;
        Employee employee=sqlSession.selectOne("com.zdx.mapper.EmployeeMapper.findById",id);
        System.out.println(employee);
    }
    @Test
    public void add(){
        Employee employee=new Employee(1,"张三",20,"manager");
        sqlSession.insert("com.zdx.mapper.EmployeeMapper.insert",employee);
        System.out.println("添加成功");
    }
    @Test
    public void UpdateById(){
        Employee employee=new Employee(1,"张三",20,"manager");
        sqlSession.update("com.zdx.mapper.EmployeeMapper.updateById",employee);
        System.out.println("更新成功");
    }
    @Test
    public void deleteById(){
        int id=1;
        sqlSession.delete("com.zdx.mapper.EmployeeMapper.deleteById",id);
        System.out.println("删除成功");
    }


    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }
}
