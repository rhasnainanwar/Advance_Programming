package spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawinApp {

	@SuppressWarnings("resource")
	public static void main( String[] args )
    {    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("springcomb.xml");
    	
    	Triangle triangle = (Triangle) context.getBean("triangle");
    	triangle.draw();
    	
    	Triangle1 triangle1 = (Triangle1) context.getBean("triangle1");
    	triangle1.draw();
    	
    }
}
