package pe.edu.upc.pandemia.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="usuario")
public class User {
	@Id 
	@NotNull
	@Range(min=10000000,max=99999999)

	@Column(name = "id", length = 8, nullable = false)
	private Integer id;

	@NotEmpty
	
	@Column(name = "Username", length = 120)
	private String username;
	
	@NotEmpty
	@Column(name = "Password", length = 120)
	private String password;
	@NotEmpty
	 @Column(name="nombre", length=30)
	    private String nombre;
	@NotEmpty
	    @Column(name="apellido", length=30)
	    private String apellido;
	@NotEmpty
	@Email
	    @Column(name="email", length=60)
	    private String email;
		
	    @Column(name = "habilitado", length = 1, nullable = false)
		private int habilitado;
	
	    @Column(name = "tipoUsuario", length = 1, nullable = false)
			private int tipoUsuario;
		

	private boolean enable;

	@OneToMany(mappedBy = "User",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Authority>authorities;
	
	@Column(name="dateRegistro")
	@Temporal(TemporalType.DATE)
	private Date dateRegistro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Date getDateRegistro() {
		return dateRegistro;
	}

	public void setDateRegistro(Date dateRegistro) {
		this.dateRegistro = dateRegistro;
	}

	public User(@NotNull @Range(min = 10000000, max = 99999999) Integer id, @NotEmpty String username,
			@NotEmpty String password, String nombre, String apellido, String email, int habilitado, int tipoUsuario,
			boolean enable, List<Authority> authorities, Date dateRegistro) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.habilitado = habilitado;
		this.tipoUsuario = tipoUsuario;
		
		this.dateRegistro = dateRegistro;
		this.enable=true;
		this.authorities= new ArrayList<>();
	}

	public User() {
		super();
		this.enable=true;
		this.authorities= new ArrayList<>();
		// TODO Auto-generated constructor stub
	}





	


	
	
}
