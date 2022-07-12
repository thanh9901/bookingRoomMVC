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
import ngothanh.com.entity.Room;
import ngothanh.com.service.RoomService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class RoomTest {
	
	@Autowired
	private RoomService roomService;
	
	@Test
	public void testListRoom() throws UnsupportedEncodingException {
		List<Room> list = roomService.getRoomByIdHotel(1);
		Hotel hotel = list.get(0).getHotel();
		PrintStream ps = new PrintStream(System.out,true,"UTF-8");
		ps.println(hotel);
		ps.println(list);
		
	}
}
