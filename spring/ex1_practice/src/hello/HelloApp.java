package hello;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloApp {
	public static void  main(String []args){
		org.apache.log4j.Logger log= Logger.getLogger(HelloApp.class); 
		System.out.println( "before calling application context"+System.currentTimeMillis());
ApplicationContext context =  new FileSystemXmlApplicationContext("C:\\Users\\Ebssa\\Desktop\\springconfig.xml");
System.out.println("after calling context  everything above this happended by just when the the applicationcontext object loads" +
		"/n spring upon loading creates all the beans and tries to wire them based on the configuration. " +
		"/n if the bean doesnt have scope type to be prototype or it has init something as eager as false it will load the beans eagerly." +
		""+System.currentTimeMillis());
TestReferer test = context.getBean("testReferer",TestReferer.class);
		test.test();
//		IGreeting greetingBean = context.getBean("greetingService",GreetingImpl.class);
//		greetingBean.sayHello();
//		ShippingService shipperBean = context.getBean("shippingService",ShippingService.class);
//		shipperBean.getShippers();
	}
	

}
