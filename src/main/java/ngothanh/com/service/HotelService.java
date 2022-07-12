package ngothanh.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ngothanh.com.entity.Hotel;
import ngothanh.com.responsitory.HotelResponsitory;

@Service
public class HotelService {
	@Autowired
	private HotelResponsitory hotelResponsitory;
	
	public List<Hotel> getAll(){
		return (List<Hotel>) hotelResponsitory.findAll();
	}
}
