package ngothanh.com.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="tbl_hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String name;
	
	private int starLevel;
	
	private String address;
	
	private String description;
	
	private String image;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy = "hotel")
	@ToString.Exclude
	@JsonIgnore
	private List<Room> listRoom = new ArrayList<Room>();
}
