package no.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="userName",nullable=false)
	private String userName;
	
	@Column(name="password",nullable=false)
	private String password;
	
	// Field Technician, Service, HR, Admin, Inspections, Projects, Operations, Customer
	@Column(name="typeOfUser")
	private String typeOfUser;
	
	@Column(name="phone")
	private String phone;
		
	@Email
	private String email;
	
	@Column(name="misc1")
	private String misc1;
	
	@Column(name="misc2")
	private String misc2;
	
	@Column(name="misc3")
	private String misc3;
	
	// Need to be date field
	@Column(name="teamMemberSince")
	private String teamMemberSince;
	
	@Column(name="currentWageHr")
	private String currentWageHr;
	
	@Column(name="currentWageAnnual")
	private String currentWageAnnual;
	
	@Column(name="vacation")
	private Long vacation;
	
	@Column(name="sick")
	private Long sick;
	
	@Column(name="address")
	private Long address;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List <WorkOrder> workOrders = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<WorkOrder> getWorkOrders() {
		return workOrders;
	}

	public void setWorkOrders(List<WorkOrder> workOrders) {
		this.workOrders = workOrders;
	}
	
	public void addWorkOrder(WorkOrder workOrder) {
		if(workOrder.getUser() !=this) {
			workOrder.setUser(this);
		}
		workOrders.add(workOrder);
	}

		
}
