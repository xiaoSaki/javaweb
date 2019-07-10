
import com.lnsf_Aop.Config.ConfigAop_Tx;
import com.lnsf_Aop.entiities.Person;
import com.lnsf_Aop.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Person_Tx {
    @Test
    public void personTx_Test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAop_Tx.class);
        PersonService personService = applicationContext.getBean(PersonService.class);
        Person person = new Person();
        person.setId(19);
        person.setName("xiaoming");
        personService.addPerson(person);
    }

}
