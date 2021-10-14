package javalinvue;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;

public class Main {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_858f587be77c71e";
	
	static final String USER = "b5bc0068b76307";
	static final String PASS = "6889d2a3";

	public static void main(String[] args) {
		
		Javalin app = Javalin.create(config -> {
			config.enableWebjars();
            config.addStaticFiles("/vue");
        }).start(getHerokuAssignedPort());
		
		app.error(404, "html", new VueComponent("<not-found></not-found>"));
		
		app.get("/", ctx -> ctx.result("Hello Heroku"));
        
		app.get("/radiologist-order", new VueComponent("<radiologist-order></radiologist-order>"));
		
		app.post("/radiologistOrderAuthentication", UserController::radiologistOrderAuthentication);
		
		app.get("/login-failure1", new VueComponent("<login-failure1></login-failure1>"));
		
		app.get("/api/username", UserController::username);
		
		app.get("/radiologist-order-form", new VueComponent("<radiologist-order-form></radiologist-order-form>"));
		
		app.post("/radiologistOrder", UserController::radiologistOrder);
		
		app.get("/radiologist-order-success", new VueComponent("<radiologist-order-success></radiologist-order-success>"));
		
		app.get("/radiologist-order-scheduling", new VueComponent("<radiologist-order-scheduling></radiologist-order-scheduling>"));
		
		app.post("/radiologistOrderSchedulingAuthentication", UserController::radiologistOrderSchedulingAuthentication);
		
		app.get("/login-failure2", new VueComponent("<login-failure2></login-failure2>"));
		
		app.get("/radiologist-order-scheduling-home", new VueComponent("<radiologist-order-scheduling-home></radiologist-order-scheduling-home>"));
		
		app.get("/radiologist-order-scheduling-pending", new VueComponent("<radiologist-order-scheduling-pending></radiologist-order-scheduling-pending>"));

		app.get("/api/radiologist-orders", UserController::getRadiologistOrders);
		
		app.post("/schedule-appointment/:radiologist_order_id", UserController::scheduleAppointment);
		
		app.get("/schedule-appointment-details/:radiologist_order_id", new VueComponent("<schedule-appointment-details></schedule-appointment-details>"));
		
		app.get("/api/radiologist-order/:radiologist_order_id", UserController::getRadiologistOrder);
		
		app.get("/api/radiologists", UserController::getRadiologists);
		
		app.get("/api/radiologist-order-scheduling", UserController::getRadiologistOrderScheduling);
		
		app.post("/radiologist-order-scheduling-complete/:radiologist_order_id", UserController::radiologistOrderSchedulingComplete);
		
		app.get("/radiologist-order-scheduling-success", new VueComponent("<radiologist-order-scheduling-success></radiologist-order-scheduling-success>"));
		
		app.get("/scheduled-appointments", new VueComponent("<scheduled-appointments></scheduled-appointments>"));
		
		app.get("/api/scheduled-appointments", UserController::getScheduledAppointments);
		
		app.get("/past-scheduled-appointments", new VueComponent("<past-scheduled-appointments></past-scheduled-appointments>"));
		
		app.get("/api/past-scheduled-appointments", UserController::getPastScheduledAppointments);
	}
	
	private static int getHerokuAssignedPort() {
	    String herokuPort = System.getenv("PORT");
	    if (herokuPort != null) {
	      return Integer.parseInt(herokuPort);
	    }
	    return 7777;
	  }

}
