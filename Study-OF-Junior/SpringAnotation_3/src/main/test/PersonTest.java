/*

import com.lnsf.Config.PersonConfigOfAutowired;
import com.lnsf.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonTest {
    @Test
    public void AutowiredTest() {

      //1.创建IOC容器
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(PersonConfigOfAutowired.class);
        PersonService personService =  applicationContext.getBean(PersonService.class);
        System.out.println(personService);
    }
}
*/
