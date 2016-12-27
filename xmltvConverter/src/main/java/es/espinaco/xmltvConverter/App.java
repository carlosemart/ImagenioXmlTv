package es.espinaco.xmltvConverter;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       XmltvConverter converter = context.getBean(XmltvConverter.class);
       converter.process();
       System.out.println(converter);
       ((ClassPathXmlApplicationContext)context).close();
    }
}
