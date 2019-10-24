package no;

import java.util.ArrayList;
import java.util.List;

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
		u1.setTypeOfUser("Field Technician");
		u1.setTeamMemberSince("01/01/2019");
		u1.setCurrentWageHr("10");
		u1.setCurrentWageAnnual("15");
		u1.setVacation(10L);
		u1.setSick(5L);
		userService.save(u1);
		
		
		User u2 = new User();
		u2.setFirstName("Marko");
		u2.setLastName("Markovic");
		u2.setUserName("marko");
		u2.setPassword("1111");
		u2.setTypeOfUser("Service");
		u2.setTeamMemberSince("01/01/2019");
		u2.setCurrentWageHr("15");
		u2.setCurrentWageAnnual("20");
		u2.setVacation(222L);
		u2.setSick(0L);
		userService.save(u2);
		
		
		User u3 = new User();
		u3.setFirstName("Tom");
		u3.setLastName("Daniels");
		u3.setUserName("tom");
		u3.setPassword("1111");
		u3.setTypeOfUser("HR");
		u3.setTeamMemberSince("01/01/2019");
		u3.setCurrentWageHr("20");
		u3.setCurrentWageAnnual("25");
		u3.setVacation(15L);
		u3.setSick(4L);
		userService.save(u3);
		
		User u4 = new User();
		u4.setFirstName("Jery");
		u4.setLastName("Dow");
		u4.setUserName("jery");
		u4.setPassword("1111");
		u4.setTypeOfUser("HR");
		u4.setTeamMemberSince("01/01/2019");
		u4.setCurrentWageHr("25");
		u4.setCurrentWageAnnual("30");
		u4.setVacation(15L);
		u4.setSick(44L);
		userService.save(u4);
		
		/////////////
		
		User u5 = new User();
		u5.setFirstName("Jon");
		u5.setLastName("Smith");
		u5.setUserName("jon");
		u5.setPassword("1111");
		u5.setTypeOfUser("Admin");
		u5.setTeamMemberSince("01/01/2019");
		u5.setCurrentWageHr("10");
		u5.setCurrentWageAnnual("15");
		u5.setVacation(1L);
		u5.setSick(1L);
		userService.save(u5);
		
		
		User u6 = new User();
		u6.setFirstName("Daniel");
		u6.setLastName("Guzman");
		u6.setUserName("daniel");
		u6.setPassword("1111");
		u6.setTypeOfUser("Inspections");
		u6.setTeamMemberSince("01/01/2019");
		u6.setCurrentWageHr("45");
		u6.setCurrentWageAnnual("50");
		u6.setVacation(10L);
		u6.setSick(6L);
		userService.save(u6);
		
		
		User u7 = new User();
		u7.setFirstName("James");
		u7.setLastName("Bond");
		u7.setUserName("james");
		u7.setPassword("1111");
		u7.setTypeOfUser("Projects");
		u7.setTeamMemberSince("01/01/2019");
		u7.setCurrentWageHr("60");
		u7.setCurrentWageAnnual("100");
		u7.setVacation(10L);
		u7.setSick(9L);
		userService.save(u7);
		
		User u8 = new User();
		u8.setFirstName("Tom");
		u8.setLastName("Henesi");
		u8.setUserName("tom");
		u8.setPassword("1111");
		u8.setTypeOfUser("Operations");
		u8.setTeamMemberSince("01/01/2019");
		u8.setCurrentWageHr("100");
		u8.setCurrentWageAnnual("30");
		u8.setVacation(1L);
		u8.setSick(1L);
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
		
		
		WorkOrder w1 = new WorkOrder();

		w1.setAdditionalComments("no comment");
		w1.setArrivalTime("01/01/2109");
		w1.setDate("01/02/2019");
		w1.setDepartueTime("05:00");

//		w1.addItem(i4);
		w1.setStatus("Open");
		w1.setUser(u1);
		w1.setWorkOrderName("Liman");
		w1.setWorkOrderPhone("000111222");
		workorderService.save(w1);
		
		
		
		
	}
		
		
		
	}
		
