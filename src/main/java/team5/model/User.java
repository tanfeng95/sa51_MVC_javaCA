package team5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import team5.nonEntityModel.UserForm;



@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Column(unique=true)
    @Size(min=2,max=30)
    private String userName;
	@NotEmpty
	@Size(min=2,max=30)
	private String password;
	@NotNull
	private RoleType role;
	
	public User() {
		super();
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String password, RoleType role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	public User(UserForm userForm) {
		this.id=userForm.getId();
		this.userName=userForm.getUserName();
		this.password=userForm.getPassword();
		this.role=userForm.getRole();
	}
    
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
}

