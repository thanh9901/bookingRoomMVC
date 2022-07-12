package ngothanh.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_used_service")
public class UsedService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private int quantity;
	private float price;
	private float selloff;
	
	@Transient
	private float totalAmount;
	
	@ManyToOne
	@JoinColumn(name="service_idg")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name="booked_room_id")
	private BookedRoom bookedRoom;
}
