package httpInvoker;

import httpInvoker.IGreeting;
import httpInvoker.Person;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		IGreeting remoteService = context.getBean("greetingHttpInvokerProxy", IGreeting.class);

		Person person = new Person("John", "Doe");
		String result = remoteService.getMessage(person);
		System.out.println("Receiving result: " + result);

	}
}
