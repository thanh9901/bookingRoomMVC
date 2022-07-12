package ngothanh.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ngothanh.com.entity.Hotel;
import ngothanh.com.entity.Room;
import ngothanh.com.responsitory.HotelResponsitory;
import ngothanh.com.responsitory.RoomResponsitory;

@Service
public class RoomService {
	
	@Autowired
	private RoomResponsitory roomResponsitory;
	
	@Autowired
	private HotelResponsitory hotelResponsitory;
	
	public List<Room> getRoomByIdHotel(int id){
		Hotel hotel = hotelResponsitory.findById(id).get();
		return hotel.getListRoom();
	}
}
