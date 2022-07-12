package ngothanh.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String fullname;
	private String idCard;
	private String address;
	private String tel;
	private String email;
	private String note;
	
	@OneToMany(mappedBy = "client")
	private List<Booking> booking = new ArrayList<>();
}
