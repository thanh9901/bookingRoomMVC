package ngothanh.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="tbl_room")
public class Room {
	@Id
	@Column(name="id")
	private String id;
	
	private String name;
	
	private String type;
	
	private float price;
	
	private String description;
	
	private String image;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	@ToString.Exclude
	@JsonIgnore
	private Hotel hotel;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "room")
	@ToString.Exclude
	@JsonIgnore
	private List<BookedRoom> bookedRoom=new ArrayList<BookedRoom>();
	
}
