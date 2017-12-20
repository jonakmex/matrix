
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walgreens.nice.dao.NiceDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/healthreport-beans.xml" })
public class NiceDaoTest {
	
	@Autowired
	private NiceDao niceDao;
	
	@Test
	public void retrieveQueriesTest(){
		niceDao.retrieveQueries();
	}
	
}
