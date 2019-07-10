/*
import com.lnsf_Aop.Config.ConfigOfAOP;
import com.lnsf_Aop.util.Calculate;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AopTest {
    @Test
    public  void test_Aop(){
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigOfAOP.class);
    //1.不要自己创建对象
    //MathCalculator mathCalculator = new MathCalculator();
    //mathCalculator.div(1, 1);
    //我们要中容器中获取组件
     Calculate calculate = applicationContext.getBean(Calculate.class);
     calculate.div(10,1);
    }
}
*/
