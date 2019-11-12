package no;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.model.Item;
import no.model.User;
import no.model.WorkOrder;
import no.service.ItemService;
import no.service.UserService;
import no.service.WorkOrderService;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private WorkOrderService workorderService;
		
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		
		User u1 = new User();
		u1.setFirstName("Petar");
		u1.setLastName("Petrovic");
		u1.setUserName("petko");
		u1.setPassword("1111");
		u1.setPhone("+3816546654654");
		u1.setEmail("mil@co.com");
		u1.setTypeOfUser("Field Technician");
		u1.setTeamMemberSince("01/01/2019");
		u1.setCurrentWageHr("10");
		u1.setCurrentWageAnnual("15");
		u1.setVacation(10L);
		u1.setSick(5L);
		u1.setMisc1("accType");
		u1.setMisc2("panelType");
		u1.setMisc3("access code");
		userService.save(u1);
		
		
		User u2 = new User();
		u2.setFirstName("Marko");
		u2.setLastName("Markovic");
		u2.setUserName("marko");
		u2.setPassword("1111");
		u2.setPhone("+3816546654654");
		u2.setEmail("mil1@co.com");
		u2.setTypeOfUser("Service");
		u2.setTeamMemberSince("01/01/2019");
		u2.setCurrentWageHr("15");
		u2.setCurrentWageAnnual("20");
		u2.setVacation(222L);
		u2.setSick(0L);
		u2.setMisc1("accType");
		u2.setMisc2("panelType");
		u2.setMisc3("access code");
		userService.save(u2);
		
		
		User u3 = new User();
		u3.setFirstName("Tom");
		u3.setLastName("Daniels");
		u3.setUserName("tom");
		u3.setPassword("1111");
		u3.setPhone("+3816546654654");
		u3.setEmail("mil2@co.com");
		u3.setTypeOfUser("HR");
		u3.setTeamMemberSince("01/01/2019");
		u3.setCurrentWageHr("20");
		u3.setCurrentWageAnnual("25");
		u3.setVacation(15L);
		u3.setSick(4L);
		u3.setMisc1("accType");
		u3.setMisc2("panelType");
		u3.setMisc3("access code");
		userService.save(u3);
		
		User u4 = new User();
		u4.setFirstName("Jery");
		u4.setLastName("Dow");
		u4.setUserName("jery");
		u4.setPassword("1111");
		u4.setPhone("+3816546654654");
		u4.setEmail("mil3@co.com");
		u4.setTypeOfUser("HR");
		u4.setTeamMemberSince("01/01/2019");
		u4.setCurrentWageHr("25");
		u4.setCurrentWageAnnual("30");
		u4.setVacation(15L);
		u4.setSick(44L);
		u4.setMisc1("accType");
		u4.setMisc2("panelType");
		u4.setMisc3("access code");
		userService.save(u4);
		
		/////////////
		
		User u5 = new User();
		u5.setFirstName("Jon");
		u5.setLastName("Smith");
		u5.setUserName("jon");
		u5.setPassword("1111");
		u5.setPhone("+3816546654654");
		u5.setEmail("mil4@co.com");
		u5.setTypeOfUser("Admin");
		u5.setTeamMemberSince("01/01/2019");
		u5.setCurrentWageHr("10");
		u5.setCurrentWageAnnual("15");
		u5.setVacation(1L);
		u5.setSick(1L);
		u5.setMisc1("accType");
		u5.setMisc2("panelType");
		u5.setMisc3("access code");
		userService.save(u5);
		
		
		User u6 = new User();
		u6.setFirstName("Daniel");
		u6.setLastName("Guzman");
		u6.setUserName("daniel");
		u6.setPassword("1111");
		u6.setPhone("+3816546654654");
		u6.setEmail("mil5@co.com");
		u6.setTypeOfUser("Inspections");
		u6.setTeamMemberSince("01/01/2019");
		u6.setCurrentWageHr("45");
		u6.setCurrentWageAnnual("50");
		u6.setVacation(10L);
		u6.setSick(6L);
		u6.setMisc1("accType");
		u6.setMisc2("panelType");
		u6.setMisc3("access code");
		userService.save(u6);
		
		
		User u7 = new User();
		u7.setFirstName("James");
		u7.setLastName("Bond");
		u7.setUserName("james");
		u7.setPassword("1111");
		u7.setPhone("+3816546654654");
		u7.setEmail("mil6@co.com");
		u7.setTypeOfUser("Projects");
		u7.setTeamMemberSince("01/01/2019");
		u7.setCurrentWageHr("60");
		u7.setCurrentWageAnnual("100");
		u7.setVacation(10L);
		u7.setSick(9L);
		u7.setMisc1("accType");
		u7.setMisc2("panelType");
		u7.setMisc3("access code");
		userService.save(u7);
		
		User u8 = new User();
		u8.setFirstName("Tom");
		u8.setLastName("Henesi");
		u8.setUserName("tom");
		u8.setPassword("1111");
		u8.setPhone("+3816546654654");
		u8.setEmail("mil7@co.com");
		u8.setTypeOfUser("Operations");
		u8.setTeamMemberSince("01/01/2019");
		u8.setCurrentWageHr("100");
		u8.setCurrentWageAnnual("30");
		u8.setVacation(1L);
		u8.setSick(1L);
		u8.setMisc1("accType");
		u8.setMisc2("panelType");
		u8.setMisc3("access code");
		userService.save(u8);
		
		Item i1 = new Item();
		i1.setPartName("5 AH 12v Batteries");
		i1.setPartNumber("FAS1055");
		i1.setPartPrice(30.00);
		i1.setPartType("Batteries");
		i1.setQuantity(2L);
		itemService.save(i1);
		
		Item i2 = new Item();
		i2.setPartName("5816 Transmitters");
		i2.setPartNumber("5816WMWH");
		i2.setPartPrice(50.88);
		i2.setPartType("Honeywell");
		i2.setQuantity(1L);
		itemService.save(i2);
		
		Item i3 = new Item();
		i3.setPartName("IP Dome Cams");
		i3.setPartNumber("ICIP-D2000-IR");
		i3.setPartPrice(436.00);
		i3.setPartType("Cameras");
		i3.setQuantity(1L);
		itemService.save(i3);
		
		Item i4 = new Item();
		i4.setPartName("Cat 6");
		i4.setPartNumber("556609");
		i4.setPartPrice(470.00);
		i4.setPartType("Wire");
		i4.setQuantity(1L);
		itemService.save(i4);
		
		Item i5 = new Item();
		i5.setPartName("1.0 Hr Labor to diagnose issue ");
		i5.setPartNumber("0000001");
		i5.setPartPrice(90.00);
		i5.setPartType("WO");
		i5.setQuantity(1L);
		itemService.save(i5);
		
		// we dont need this!!!!
		Set<Item> wo1 = new HashSet<Item>();
		wo1.add(i1);
		wo1.add(i5);
		
		
		
		
		WorkOrder w1 = new WorkOrder();

		w1.setAdditionalComments("no comment");
		w1.setArrivalTime("01/01/2109");
		w1.setDate("01/02/2019");
		w1.setDepartueTime("05:00");
//		w1.getItemss().add(i5);
//		w1.getItemss().add(i4);
//		w1.setItemss(wo1);
		w1.setStatus("Open");
		w1.setUser(u1);
		w1.setWorkOrderName("Liman");
		w1.setWorkOrderPhone("000111222");

	
		workorderService.save(w1);
		

		WorkOrder w2 = new WorkOrder();

		w2.setAdditionalComments("no comment");
		w2.setArrivalTime("01/01/2109");
		w2.setDate("01/03/2019");
		w2.setDepartueTime("05:00");
//		w2.addItem(i4);
		w2.setStatus("Completed");
		w2.setUser(u2);
		w2.setWorkOrderName("Grbavica");
		w2.setWorkOrderPhone("000111222");
		workorderService.save(w2);
		
		
		WorkOrder w3 = new WorkOrder();

		w3.setAdditionalComments("no comment");
		w3.setArrivalTime("01/04/2109");
		w3.setDate("01/04/2019");
		w3.setDepartueTime("06:00");
//		w3.addItem(i4);
		w3.setStatus("Accepted");
		w3.setUser(u1);
		w3.setWorkOrderName("Novo Naselje");
		w3.setWorkOrderPhone("000111222");
		workorderService.save(w3);
		

		WorkOrder w4 = new WorkOrder();

		w4.setAdditionalComments("no comment");
		w4.setArrivalTime("01/05/2109");
		w4.setDate("01/05/2019");
		w4.setDepartueTime("05:00");
//		w4.addItem(i4);
		w4.setStatus("Accepted");
		w4.setUser(u2);
		w4.setWorkOrderName("Centar");
		w4.setWorkOrderPhone("000111222");
		workorderService.save(w4);
		
		WorkOrder w5 = new WorkOrder();

		w5.setAdditionalComments("no comment");
		w5.setArrivalTime("01/06/2109");
		w5.setDate("01/06/2019");
		w5.setDepartueTime("05:00");
		w5.setStatus("Completed");
		w5.setUser(u1);
		w5.setWorkOrderName("Rumenka");
		w5.setWorkOrderPhone("000111222");
		workorderService.save(w5);
		

		WorkOrder w6 = new WorkOrder();

		w6.setAdditionalComments("no comment");
		w6.setArrivalTime("01/07/2109");
		w6.setDate("01/07/2019");
		w6.setDepartueTime("05:00");
		w6.setStatus("Completed");
		w6.setUser(u2);
		w6.setWorkOrderName("Novi Sad");
		w6.setWorkOrderPhone("000111222");
		workorderService.save(w6);
		
		WorkOrder w7 = new WorkOrder();

		w7.setAdditionalComments("no comment");
		w7.setArrivalTime("01/08/2109");
		w7.setDate("01/07/2000");
		w7.setDepartueTime("05:00");

//		w7.addItem(i5);
		w7.setStatus("Completed");
		w7.setUser(u1);
		w7.setWorkOrderName("Rumenka");
		w7.setWorkOrderPhone("000111222");
		workorderService.save(w7);
		

		WorkOrder w8 = new WorkOrder();

		w8.setAdditionalComments("no comment");
		w8.setArrivalTime("01/01/2109");
		w8.setDate("01/05/2015");
		w8.setDepartueTime("05:00");

//		w8.addItem(i6);
		w8.setStatus("Open");
		w8.setUser(u2);
		w8.setWorkOrderName("Novi Sad");
		w8.setWorkOrderPhone("000111222");
		workorderService.save(w8);
		
		
		
	
		
		
		
		
	}
		
		
		
	}
		
