package ngothanh.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="tbl_bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private Date paymentDate;
	
	private float amount;
	
	private String paymentType;
	
	private String note;
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@ToString.Exclude
	private Users user;
}
