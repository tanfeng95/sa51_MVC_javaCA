package team5.nonEntityModel;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import team5.model.RoleType;
import team5.model.User;

public class UserForm {

    private long id;
	
    @Column(unique=true)
    @Size(min=2,max=30)
    private String userName;
	@NotNull
	@Size(min=2,max=30)
	private String password;
	@NotNull
	private String confPassword;
	@NotNull
	private RoleType role;

	public UserForm() {
		super();
	}

	public UserForm(long id, String userName, String password, String confPassword, RoleType role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.confPassword = confPassword;
		this.role = role;
	}
	
	public UserForm(User user) {
		this.id=user.getId();
		this.userName=user.getUserName();
		this.password=user.getPassword();
		this.role=user.getRole();
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
	public String getConfPassword() {
		return confPassword;
	}
	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
}
