package ngothanh.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ngothanh.com.entity.Hotel;
import ngothanh.com.entity.Room;
import ngothanh.com.service.HotelService;
import ngothanh.com.service.RoomService;

@Controller
public class HomeController {
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<Hotel> listHotel= hotelService.getAll();
		model.addAttribute("list",listHotel);
		return "index";
	}
	
	@GetMapping(value="/getRoom/{id}")
	public String roomOfHotel(@PathVariable("id") int id,Model model) {
		
		List<Room> list = roomService.getRoomByIdHotel(id);
		
		Hotel hotel = list.get(0).getHotel();
		
		model.addAttribute("list", list);
		model.addAttribute("hotel",hotel);
		
		return "room";
		
	}
	
	@GetMapping("/updateHotel")
	public String updateHotel() {
		return "updateHotel";
	}
}
