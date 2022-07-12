package ngothanh.com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ngothanh.com.entity.Hotel;
import ngothanh.com.entity.Room;
import ngothanh.com.service.HotelService;
import ngothanh.com.service.RoomService;

@RestController
public class HomeApi {
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomService roomService;
	
	
	@GetMapping("/api/hotel")
	public List<Hotel>getAllHotel(){
		return hotelService.getAll();
	}
	
	@GetMapping("/api/getRoom/{id}")
	public List<Room> getAllRoom(@PathVariable("id") int id){
		return roomService.getRoomByIdHotel(id);
	}
}
