package hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TraceAdvice {
	
	public TraceAdvice() {
		
	}

	@Before("execution(public * hello.*.*(..))")
	public void traceBefore(JoinPoint joinpoint) {
		System.out.println("TraceBefore advice in action on "+joinpoint.getSignature().getName()+"method");
	}

	@After("execution(public * *.*.*(..))")
	public void traceAfter(JoinPoint joinPoint) {
		System.out.println("TraceAfter advice in action on "+joinPoint.getSignature().getName()+"method");
	}

}
