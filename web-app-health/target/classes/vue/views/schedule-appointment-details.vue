<template id="schedule-appointment-details">
	<div>
		<div v-for="username in usernames">
			<div v-if="username.value == null || username.value == 'admin1' ">
				<div class="header">
		    		<br>
					<a href="/radiologist-order-scheduling">
						<h1>
							Radiologist order scheduling
						</h1>
					</a>
					<br>
					<br>
				</div>
				<br>
				<br>
				<br>
				<br>
				<div class="scheduleAppointmentDetailsRow9">
					<h1>You have no access to this page</h1>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
			</div>
			<div v-if="username.value == 'admin2'">
				<div class="header">
		    		<br>
					<a href="/radiologist-order-scheduling-home">
						<h1>
							Radiologist order scheduling
						</h1>
					</a>
					<br>
					<br>
				</div>
				<br>
				<br>
				<br>
				<br>
				<div class="scheduleAppointmentDetailsRow1">
					<h1>Radiologist order's details</h1>
				</div>
				<br>
				<br>
				<div class="scheduleAppointmentDetailsRow3">
					<div v-for="radiologistOrder in radiologistOrders">
						<div class="scheduleAppointmentDetailsRow2">
							<div>
								<h2 style="text-align:center;"><b>Patient summary</b></h4>
								<hr>
								<h4><b>Name : </b>{{radiologistOrder.name}}</h4>
								<br>
								<h4><b>Surname : </b>{{radiologistOrder.surname}}</h4>
								<br>
								<h4><b>Father's name : </b>{{radiologistOrder.father}}</h4>
								<br>
								<h4><b>Mother's name: : </b>{{radiologistOrder.mother}}</h4>
								<br>
								<h4><b>Gender : </b>{{radiologistOrder.gender}}</h4>
								<br>
								<h4><b>Birthdate : </b>{{radiologistOrder.birthdate}}</h4>
								<br>
								<h4><b>Address : </b>{{radiologistOrder.address}}</h4>
								<br>
								<h4><b>Home phone : </b>{{radiologistOrder.homephone}}</h4>
								<br>
								<h4><b>Mobile phone: </b>{{radiologistOrder.mobilephone}}</h4>
								<br>
								<br>
								<br>
								<h2 style="text-align:center;"><b>Radiologist's order details</b></h4>
								<hr>
								<h4><b>Order date : </b>{{radiologistOrder.orderDate}}</h4>
								<br>
								<h4><b>Causes : </b>{{radiologistOrder.causes}}</h4>
								<br>
								<h4><b>Radiologist operation : </b>{{radiologistOrder.radiologistOperation}}</h4>
								<br>
								<h4><b>Suggested execution date : </b>{{radiologistOrder.suggestedExecutionDate}}</h4>
								<br>
								<h4><b>Priority (1:minimum, 5:maximum) : </b>{{radiologistOrder.priority}}</h4>
							</div>
						</div>
					</div>
					<br>
					<br>
				</div>
				<br>
				<br>
				<div class="scheduleAppointmentDetailsRow4">
					<h1>All radiologists</h1>
				</div>
				<br>
				<br>
				<div v-for="(radiologist, key) in radiologists">
					<div class="scheduleAppointmentDetailsRow6">
						<div>
							<h3>{{ key + 1}})</h4>
							<h4>
								<b>Name : </b> {{radiologist.name}}
								<br>
								<b>Upcoming radiologist orders to do : </b> {{radiologist.radiologistOrders}}
							</h4>
						</div>
					</div>
					<br>
				</div>
				<div v-if="radiologistOrderSchedulings.length>0">
					<br>
					<br>
					<br>
					<br>
					<div class="scheduleAppointmentDetailsRow7">
						<h1>Upcoming radiologist orders</h1>
					</div>
					<br>
					<br>
					<div v-for="radiologistOrderScheduling in radiologistOrderSchedulings">
						<div class="scheduleAppointmentDetailsRow8">
							<div>
								<h4>
									<b>Radiologist : </b> {{radiologistOrderScheduling.radiologist}}
									<br>
									<b>Date : </b> {{radiologistOrderScheduling.executionDate}}
								</h4>
							</div>
						</div>
						<br>
					</div>
				</div>
				<br>
				<br>
				<div v-for="radiologistOrder in radiologistOrders" class="scheduleAppointmentDetailsRow5">
					<h2>Choose radiologist and date:</h2>
					<form name="myform" method="POST" :action="`/radiologist-order-scheduling-complete/${radiologistOrder.radiologistOrderId}`">
						<hr>
						<label for="executionDate">Execution date:</label>
						<br>
		  				<input type="datetime-local" id="executionDate" name="executionDate" required>
		  				<br>
		  				<br>
		  				<div class="form-group">
						  <label for="radiologist">Radiologist:</label>
						  <select class="form-control" id="radiologist" name="radiologist" required>
						    <option>Wilhelm Rontgen</option>
						    <option>Ian Donsald</option>
						    <option>Raymond Damadian</option>
						  </select>
						</div>
						<button type="submit">Submit</button>
					</form>
				</div>
			</div>
		</div>
		<div class="scheduleAppointmentDetailsFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
    Vue.component("schedule-appointment-details", {
    	template: "#schedule-appointment-details",
    	data: () => ({
    		usernames: [],
    		radiologists: [],
    		radiologistOrders: [],
    		radiologistOrderSchedulings: [],
        }),
        created() {
    		const radiologist_order_id = this.$javalin.pathParams["radiologist_order_id"];
    		fetch("/api/username")
	            .then(res => res.json())
	            .then(res => this.usernames = res)
    		fetch("/api/radiologists")
	            .then(res => res.json())
	            .then(res => this.radiologists = res)
	        fetch("/api/radiologist-order-scheduling")
	            .then(res => res.json())
	            .then(res => this.radiologistOrderSchedulings = res)
    		fetch(`/api/radiologist-order/${radiologist_order_id}`)
	            .then(res => res.json())
	            .then(res => this.radiologistOrders = res);
        }
    });
</script>

<style>

	.scheduleAppointmentDetailsRow1{
		background-color: white;
		color: black;
		text-align: center;
		width:480px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.scheduleAppointmentDetailsRow2{
		background-color: white;
		padding: 20px;
		margin: 15px;
		width:750px;
		text-align: left;
	}
	
	.scheduleAppointmentDetailsRow2 div{
		padding:8px;
		border-style: solid;
		flex:33%;
	}
	
	.scheduleAppointmentDetailsRow3{
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
	}
	
	.scheduleAppointmentDetailsRow4{
		background-color: white;
		color: black;
		text-align: center;
		width:285px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.scheduleAppointmentDetailsRow5{
		padding: 16px;
		color:black;
		margin: auto;
		width:800px;
		background-color: #006699;
		border-radius:25px;
		box-shadow:0px 3px 12px white;
		position:relative;
		top:25px;
	}
	.scheduleAppointmentDetailsRow5 form{
		font-weight: bold;
	}
	
	.scheduleAppointmentDetailsRow5 button[type=submit] {
	  width: 100%;
	  background-color: #ff0000;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	.scheduleAppointmentDetailsRow5 button[type=submit]:hover {
	  background-color: #e60000;
	}
	
	.scheduleAppointmentDetailsRow6{
		background-color: white;
		padding: 20px;
		margin: auto;
		width:750px;
		text-align: left;
	}
	
	.scheduleAppointmentDetailsRow6 div{
		padding:8px;
		border-style: solid;
		flex:33%;
	}
	
	.scheduleAppointmentDetailsRow7{
		background-color: white;
		color: black;
		text-align: center;
		width: 520px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.scheduleAppointmentDetailsRow8{
		background-color: white;
		padding: 20px;
		margin: auto;
		width:750px;
		text-align: left;
	}
	
	.scheduleAppointmentDetailsRow8 div{
		padding:8px;
		border-style: solid;
		flex:33%;
	}
	
	.scheduleAppointmentDetailsRow9{
		background-color: white;
		color: black;
		text-align: center;
		width:610px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.scheduleAppointmentDetailsFooter{
		position:relative;
		top:250px;
		background-color: black;
		padding: 30px;
		text-align: center;
		color:white;
	}
</style>