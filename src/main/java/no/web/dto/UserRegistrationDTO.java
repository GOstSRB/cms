package no.web.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class UserRegistrationDTO {
	
	private Long id;
	
	@NotEmpty
	@Size(min=3, max=30)
	private String firstName;
	
	@NotBlank
	@Size(min=3, max=30)
	private String lastName;
	
	@NotEmpty
	@Size(min=3, max=30)
	private String userName;
	
	@Size(min=8)
	@Pattern(regexp="(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
			message="Password is not strong enough.")
	private String password;
	private String passwordConfirm;
	
	private String typeOfUser;
	private String phone;
	@Email
	private String email;
	private String misc1;
	private String misc2;
	private String misc3;
	private String teamMemberSince;
	private String currentWageHr;
	private String currentWageAnnual;
	private Long vacation;
	private Long sick;
	
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMisc1() {
		return misc1;
	}
	public void setMisc1(String misc1) {
		this.misc1 = misc1;
	}
	public String getMisc2() {
		return misc2;
	}
	public void setMisc2(String misc2) {
		this.misc2 = misc2;
	}
	public String getMisc3() {
		return misc3;
	}
	public void setMisc3(String misc3) {
		this.misc3 = misc3;
	}
	public String getTeamMemberSince() {
		return teamMemberSince;
	}
	public void setTeamMemberSince(String teamMemberSince) {
		this.teamMemberSince = teamMemberSince;
	}
	public String getCurrentWageHr() {
		return currentWageHr;
	}
	public void setCurrentWageHr(String currentWageHr) {
		this.currentWageHr = currentWageHr;
	}
	public String getCurrentWageAnnual() {
		return currentWageAnnual;
	}
	public void setCurrentWageAnnual(String currentWageAnnual) {
		this.currentWageAnnual = currentWageAnnual;
	}
	public Long getVacation() {
		return vacation;
	}
	public void setVacation(Long vacation) {
		this.vacation = vacation;
	}
	public Long getSick() {
		return sick;
	}
	public void setSick(Long sick) {
		this.sick = sick;
	}
	
}
