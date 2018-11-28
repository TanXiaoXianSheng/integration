import java.net.URL;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;
import org.apache.log4j.spi.Filter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import com.javen.model.User;
import com.javen.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {  
    private static Logger logger = Logger.getLogger(TestMyBatis.class);  
    @Resource  
    private UserService userService = null;  
    @Test  
    public void test1() {  
        User user = userService.getUserById(1);  
        System.out.println(user.toString());
        //logger.info(JSON.toJSONString(user));  
    }  
    
    /**
     * 测试哪些jar包冲突
     */
    @Test
    public void testJar() {
    	URL url = Filter.class.getProtectionDomain().getCodeSource().getLocation();
    	System.out.println("path:" + url.getPath() + ",name:" + url.getFile() + "\n");
    }
}  