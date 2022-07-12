package ngothanh.com.responsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ngothanh.com.entity.Room;

@Repository
public interface RoomResponsitory extends CrudRepository<Room,String>{

}
