package no.web.dto;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Email;

public class UserDTO {
	private Long id;
	private String email;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	
	private String typeOfUser;
	private String phone;
	private String misc1;
	private String misc2;
	private String misc3;
	private String teamMemberSince;
	private String currentWageHr;
	private String currentWageAnnual;
	private Long vacation;
	private Long sick;
	
	
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
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
