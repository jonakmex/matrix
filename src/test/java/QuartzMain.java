import org.springframework.context.support.ClassPathXmlApplicationContext;


public class QuartzMain {
	
	public static void main( String[] args ) throws Exception
    {
    	new ClassPathXmlApplicationContext("/healthreport-quartz.xml");
    }
}
