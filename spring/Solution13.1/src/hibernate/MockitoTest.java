package hibernate;

import java.util.List;


import org.mockito.Mockito;

public class MockitoTest {
	public void mockitotest() {
		
		List mockedList = Mockito.mock(List.class);
		mockedList.add("one");
		mockedList.clear();
		System.out.println( Mockito.verify(mockedList).add("one"));
		 Mockito.verify(mockedList).clear();
		 
	}
	public static void main(String[]args){
		MockitoTest test = new MockitoTest();
		test.mockitotest();
	}
}
