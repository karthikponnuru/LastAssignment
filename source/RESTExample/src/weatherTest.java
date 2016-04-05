import org.junit.Test;

public class weatherTest {
	weather weatherobj=new weather();
	Restaurant restobj=new Restaurant();
	@Test
	public void test1() throws Exception{
		String jsonstr=weatherobj.Getweather();
		if(jsonstr!=null)
		{
			System.out.println("*******Weather Web service successfully called and executed**********");
		
		}
	}
	
	@Test
	public void test2() throws Exception{
		String jsonstr=restobj.GetRestaurant();
		if(jsonstr!=null)
		{
			System.out.println("*******Foursquare Web service successfully called and executed********");
		
		}
	}

}
