package ngothanh.com.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ngothanh.com.entity.Hotel;

@Repository
public interface HotelResponsitory extends CrudRepository<Hotel,Integer>{

}
