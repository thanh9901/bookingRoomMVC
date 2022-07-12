package ngothanh.com.entityTest;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ngothanh.com.config.PersistenceJPAConfig;
import ngothanh.com.entity.Hotel;
import ngothanh.com.service.HotelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class HotelTest {
	
	@Autowired
	private HotelService hotelService;
	
	@Test
	public void getAll() throws UnsupportedEncodingException {
		List<Hotel> list = hotelService.getAll();
		
		PrintStream ps = new PrintStream(System.out,true,"UTF-8");
		
		ps.println(list);
	}
}
