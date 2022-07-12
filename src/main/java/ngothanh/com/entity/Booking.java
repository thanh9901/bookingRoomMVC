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
import javax.persistence.Transient;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="tbl_booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private Date bookingDate;
	
	private float selloff;
	
	private String note;
	
	@Transient
	private float totalAmount;
	
	@OneToMany(mappedBy = "booking")
	private List<BookedRoom> bookedRoom = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@ToString.Exclude
	private Users user;
	
	@OneToMany(mappedBy = "booking")
	private List<Bill> bill = new ArrayList<>();
}
