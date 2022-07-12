package ngothanh.com.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="tbl_user")
public class Users{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String postion;
	private String role;
	
	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Booking> booking = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	@ToString.Exclude
	private List<Bill> bill = new ArrayList<>();
}
