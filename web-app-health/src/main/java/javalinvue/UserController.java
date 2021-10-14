package javalinvue;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.mindrot.jbcrypt.BCrypt;

import io.javalin.http.Context;

public class UserController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_858f587be77c71e";
	
	static final String USER = "b5bc0068b76307";
	static final String PASS = "6889d2a3";
	
	private UserController(){ }
	
	public static void radiologistOrderAuthentication(Context ctx) {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		if(username.equals("radOrderDoctor") && password.equals("20202021")) {
			ctx.cookie("username", "admin1");
			ctx.redirect("/radiologist-order-form");
		}
		else {
			ctx.redirect("/login-failure1");
		}
	 }
	
	public static void radiologistOrder(Context ctx) throws ParseException {
		
		String name = ctx.formParam("name");
		String surname = ctx.formParam("surname");
		String father = ctx.formParam("father");
		String mother = ctx.formParam("mother");
		String gender = ctx.formParam("gender");
		String birthdate = ctx.formParam("birthdate");
		String address = ctx.formParam("address");
		String homephone = ctx.formParam("homephone");
		String mobilephone = ctx.formParam("mobilephone");
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String orderDate = sdf.format(dt);
		String causes = ctx.formParam("causes");
		String radiologistOperation = ctx.formParam("radiologistOperation");
		String suggestedExecutionDate = ctx.formParam("suggestedExecutionDate");
		int priority = Integer.parseInt(ctx.formParam("priority"));
		
		Connection conn = null;
		try {
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			int i = 1;
			
			while(true) {
				PreparedStatement pst1 = conn.prepareStatement("SELECT * FROM radiologist_orders WHERE radiologist_order_id = '"+i+"'");
				ResultSet res1 = pst1.executeQuery();
				
				if(res1.next())	{
					i++;
					continue;
				}
				else {
					PreparedStatement ps1 = conn.prepareStatement("INSERT INTO radiologist_orders (radiologist_order_id, name, surname, father, mother, gender, birthdate, address, homephone, mobilephone, orderDate, causes, radiologistOperation, suggestedExecutionDate, priority) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					ps1.setInt(1, i);
					ps1.setString(2, name);
					ps1.setString(3, surname);
					ps1.setString(4, father);
					ps1.setString(5, mother);
					ps1.setString(6, gender);
					ps1.setString(7, birthdate);
					ps1.setString(8, address);
					ps1.setString(9, homephone);
					ps1.setString(10, mobilephone);
					ps1.setString(11, orderDate);
					ps1.setString(12, causes);
					ps1.setString(13, radiologistOperation);
					ps1.setString(14, suggestedExecutionDate);
					ps1.setInt(15, priority);
					
					ps1.executeUpdate();
					
					break;
				}
				
			}
			
			ctx.redirect("/radiologist-order-success");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	
	public static void radiologistOrderSchedulingAuthentication(Context ctx) {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		if(username.equals("radOrderScheduling") && password.equals("20202021")) {
			ctx.cookie("username", "admin2");
			ctx.redirect("/radiologist-order-scheduling-home");
		}
		else {
			ctx.redirect("/login-failure2");
		}
	 }
	
	public static void username(Context ctx) {
		String cookie = ctx.cookie("username");
		
		ArrayList<username> usernames = new ArrayList<username>();
		
		username username = new username(cookie);
		
		usernames.add(username);
		
		ctx.json(usernames);
	 }
	
	public static void getRadiologistOrders(Context ctx) {
		 
		 ArrayList<radiologistOrder> radiologistOrders = new ArrayList<radiologistOrder>();
		 
		 Connection conn = null;
			try {
				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM radiologist_orders");
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{	
					
					radiologistOrder radiologistOrder = new radiologistOrder(rs1.getInt("radiologist_order_id"), rs1.getString("name"), rs1.getString("surname"), rs1.getString("father"), rs1.getString("mother"), rs1.getString("gender"), rs1.getString("birthdate"), rs1.getString("address"), rs1.getString("homephone"), rs1.getString("mobilephone"), rs1.getString("orderDate"), rs1.getString("causes"), rs1.getString("radiologistOperation"), rs1.getString("suggestedExecutionDate"), rs1.getInt("priority"));
					
					radiologistOrders.add(radiologistOrder);
					
				}
				
				ctx.json(radiologistOrders);
				
			}catch (SQLException e) {
				e.printStackTrace();
	    } 
	 }
	
	public static void scheduleAppointment(Context ctx) {
		String radiologist_order_id = ctx.pathParam("radiologist_order_id");
		
		ctx.redirect("/schedule-appointment-details/"+radiologist_order_id);
	 }
	
	public static void getRadiologistOrder(Context ctx) {
		String radiologist_order_id = ctx.pathParam("radiologist_order_id");
		
		ArrayList<radiologistOrder> radiologistOrders = new ArrayList<radiologistOrder>();
		 
		 Connection conn = null;
			try {
				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM radiologist_orders WHERE radiologist_order_id = '"+radiologist_order_id+"'");
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{	
					
					radiologistOrder radiologistOrder = new radiologistOrder(rs1.getInt("radiologist_order_id"), rs1.getString("name"), rs1.getString("surname"), rs1.getString("father"), rs1.getString("mother"), rs1.getString("gender"), rs1.getString("birthdate"), rs1.getString("address"), rs1.getString("homephone"), rs1.getString("mobilephone"), rs1.getString("orderDate"), rs1.getString("causes"), rs1.getString("radiologistOperation"), rs1.getString("suggestedExecutionDate"), rs1.getInt("priority"));
					
					radiologistOrders.add(radiologistOrder);
					
				}
				
				ctx.json(radiologistOrders);
				
			}catch (SQLException e) {
				e.printStackTrace();
	    } 
	 }
	
	public static void getRadiologists(Context ctx) throws ParseException {
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String today = sdf.format(dt);
		
		ArrayList<radiologist> radiologists = new ArrayList<radiologist>();
		 
		 Connection conn = null;
			try {
				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM radiologists");
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{	
					
					PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM radiologist_order_scheduling WHERE radiologist = '"+rs1.getString("radiologist")+"'");
					ResultSet rs2 = ps2.executeQuery();
					
					int radiologistOrders = 0;
					
					while(rs2.next())
					{
						if(sdf.parse(today).before(sdf.parse(rs2.getString("executionDate")))) {
							radiologistOrders++;
						}
						
					}
					radiologist radiologist = new radiologist(rs1.getInt("radiologist_id"), rs1.getString("radiologist"),radiologistOrders);
					
					radiologists.add(radiologist);
					
				}
				
				ctx.json(radiologists);
				
			}catch (SQLException e) {
				e.printStackTrace();
	    } 
	 }
	
	public static void getRadiologistOrderScheduling(Context ctx) throws ParseException {
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String today = sdf.format(dt);
		
		ArrayList<radiologistOrderScheduling> radiologistOrderSchedulings = new ArrayList<radiologistOrderScheduling>();
		 
		 Connection conn = null;
			try {
				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM radiologist_order_scheduling");
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{	
					
					if(sdf.parse(today).before(sdf.parse(rs1.getString("executionDate")))) {
						
						radiologistOrderScheduling radiologistOrderScheduling = new radiologistOrderScheduling(rs1.getString("radiologist"), rs1.getString("executionDate"));
						
						radiologistOrderSchedulings.add(radiologistOrderScheduling);
					}
					
				}
				
				ctx.json(radiologistOrderSchedulings);
				
			}catch (SQLException e) {
				e.printStackTrace();
	    } 
	 }
	
	public static void radiologistOrderSchedulingComplete(Context ctx) {
		
		int radiologist_order_id = Integer.parseInt(ctx.pathParam("radiologist_order_id"));
		
		String radiologist = ctx.formParam("radiologist");
		String executionDate = ctx.formParam("executionDate");
		
		Connection conn = null;
		try {
			
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			PreparedStatement ps1 = conn.prepareStatement("INSERT INTO radiologist_order_scheduling (radiologist_order_id, radiologist, executionDate) VALUES (?, ?, ?)");
			ps1.setInt(1, radiologist_order_id);
			ps1.setString(2, radiologist);
			ps1.setString(3, executionDate);
			
			ps1.executeUpdate();
			
			
			PreparedStatement pst1 = conn.prepareStatement("SELECT * FROM radiologist_orders WHERE radiologist_order_id = '"+radiologist_order_id+"'");
			ResultSet res1 = pst1.executeQuery();
			
			if(res1.next())	{
				
				PreparedStatement pst2 = conn.prepareStatement("SELECT * FROM radiologist_order_scheduling WHERE radiologist_order_id = '"+radiologist_order_id+"'");
				ResultSet res2 = pst2.executeQuery();
				
				if(res2.next())	{
					
					int i = 1;
					
					while(true) {
						
						PreparedStatement pst3 = conn.prepareStatement("SELECT * FROM scheduled_appointments WHERE scheduled_appointment_id = '"+i+"'");
						ResultSet res3 = pst3.executeQuery();
						
						if(res3.next())	{
							i++;
							continue;
						}
						else {
							
							PreparedStatement pst4 = conn.prepareStatement("UPDATE radiologist_order_scheduling SET radiologist_order_id = '"+i+"' WHERE radiologist_order_id in ('"+radiologist_order_id+"')");
							pst4.executeUpdate();
							
							PreparedStatement ps2 = conn.prepareStatement("INSERT INTO scheduled_appointments (scheduled_appointment_id, name, surname, father, mother, gender, birthdate, address, homephone, mobilephone, causes, radiologistOperation, radiologist, executionDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
							ps2.setInt(1, i);
							ps2.setString(2, res1.getString("name"));
							ps2.setString(3, res1.getString("surname"));
							ps2.setString(4, res1.getString("father"));
							ps2.setString(5, res1.getString("mother"));
							ps2.setString(6, res1.getString("gender"));
							ps2.setString(7, res1.getString("birthdate"));
							ps2.setString(8, res1.getString("address"));
							ps2.setString(9, res1.getString("homephone"));
							ps2.setString(10, res1.getString("mobilephone"));
							ps2.setString(11, res1.getString("causes"));
							ps2.setString(12, res1.getString("radiologistOperation"));
							ps2.setString(13, radiologist);
							ps2.setString(14, executionDate);
							
							ps2.executeUpdate();
							
							break;
						}
						
					}
					
				}
				
			}
			
			PreparedStatement ps3 = conn.prepareStatement("DELETE FROM radiologist_orders WHERE radiologist_order_id = '"+radiologist_order_id+"'");
			ps3.executeUpdate();
			
			ctx.redirect("/radiologist-order-scheduling-success");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	
	public static void getScheduledAppointments(Context ctx) throws ParseException {
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String today = sdf.format(dt);
		
		ArrayList<scheduledAppointment> scheduledAppointments = new ArrayList<scheduledAppointment>();
		 
		 Connection conn = null;
			try {
				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM scheduled_appointments");
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{	
					
					if(sdf.parse(today).before(sdf.parse(rs1.getString("executionDate")))) {
						
						scheduledAppointment scheduledAppointment = new scheduledAppointment(rs1.getInt("scheduled_appointment_id"), rs1.getString("name"), rs1.getString("surname"), rs1.getString("father"), rs1.getString("mother"), rs1.getString("gender"), rs1.getString("birthdate"), rs1.getString("address"), rs1.getString("homephone"), rs1.getString("mobilephone"), rs1.getString("causes"), rs1.getString("radiologistOperation"), rs1.getString("radiologist"), rs1.getString("executionDate"));
						
						scheduledAppointments.add(scheduledAppointment);
					}
					
				}
				
				ctx.json(scheduledAppointments);
				
			}catch (SQLException e) {
				e.printStackTrace();
	    } 
	 }
	
	public static void getPastScheduledAppointments(Context ctx) throws ParseException {
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String today = sdf.format(dt);
		
		ArrayList<scheduledAppointment> scheduledAppointments = new ArrayList<scheduledAppointment>();
		 
		 Connection conn = null;
			try {
				
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);
				
				PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM scheduled_appointments");
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next())
				{	
					
					if(sdf.parse(today).after(sdf.parse(rs1.getString("executionDate")))) {
						
						scheduledAppointment scheduledAppointment = new scheduledAppointment(rs1.getInt("scheduled_appointment_id"), rs1.getString("name"), rs1.getString("surname"), rs1.getString("father"), rs1.getString("mother"), rs1.getString("gender"), rs1.getString("birthdate"), rs1.getString("address"), rs1.getString("homephone"), rs1.getString("mobilephone"), rs1.getString("causes"), rs1.getString("radiologistOperation"), rs1.getString("radiologist"), rs1.getString("executionDate"));
						
						scheduledAppointments.add(scheduledAppointment);
					}
					
				}
				
				ctx.json(scheduledAppointments);
				
			}catch (SQLException e) {
				e.printStackTrace();
	    } 
	 }

}
