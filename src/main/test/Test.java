import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Test {
    public  void testJDBCTemplate(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext();
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
        String sql="select * from tb_stu" ;
        List<Map<String,Object>> userList=jdbcTemplate.queryForList(sql);
        System.out.println(JSON.toJSON(userList));
    }
}