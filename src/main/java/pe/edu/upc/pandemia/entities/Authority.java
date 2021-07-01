package pe.edu.upc.pandemia.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="authorities",uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","authority"})})
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	@Column(length=30,nullable=false)
	private String authority;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User User;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		this.User = user;
	}





	

	


	
}
