package ngothanh.com.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="tbl_booked_room")
public class BookedRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private Date checkin;
	private Date checkout;
	private float price;
	private boolean isCheckedIn;
	private float selloff;
	
	
	@ManyToOne
	@JoinColumn(name="room_id")
	@ToString.Exclude
	private Room room;
	
	@OneToMany(mappedBy = "bookedRoom")
	private List<UsedService> usedService = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;
}
