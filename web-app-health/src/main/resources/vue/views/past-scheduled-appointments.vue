<template id="past-scheduled-appointments">
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
				<div class="pastScheduledAppointmentsRow5">
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
				<div class="pastScheduledAppointmentsRow1">
					<h1>Past scheduled appointments</h1>
				</div>
				<br>
				<br>
				<div v-if="scheduledAppointments.length>0">
					<div class="pastScheduledAppointmentsRow3">
						<div v-for="scheduledAppointment in scheduledAppointments">
							<div class="pastScheduledAppointmentsRow2">
								<div>
									<h2 style="text-align:center;"><b>Patient summary</b></h4>
									<hr>
									<h4><b>Name : </b>{{scheduledAppointment.name}}</h4>
									<br>
									<h4><b>Surname : </b>{{scheduledAppointment.surname}}</h4>
									<br>
									<h4><b>Father's name : </b>{{scheduledAppointment.father}}</h4>
									<br>
									<h4><b>Mother's name: : </b>{{scheduledAppointment.mother}}</h4>
									<br>
									<h4><b>Gender : </b>{{scheduledAppointment.gender}}</h4>
									<br>
									<h4><b>Birthdate : </b>{{scheduledAppointment.birthdate}}</h4>
									<br>
									<h4><b>Address : </b>{{scheduledAppointment.address}}</h4>
									<br>
									<h4><b>Home phone : </b>{{scheduledAppointment.homephone}}</h4>
									<br>
									<h4><b>Mobile phone: </b>{{scheduledAppointment.mobilephone}}</h4>
									<br>
									<br>
									<br>
									<h2 style="text-align:center;"><b>Radiologist's order details</b></h4>
									<hr>
									<h4><b>Execution date : </b>{{scheduledAppointment.executionDate}}</h4>
									<br>
									<h4><b>Radiologist : </b>{{scheduledAppointment.radiologist}}</h4>
									<br>
									<h4><b>Causes : </b>{{scheduledAppointment.causes}}</h4>
									<br>
									<h4><b>Radiologist operation : </b>{{scheduledAppointment.radiologistOperation}}</h4>
								</div>
							</div>
						</div>
						<br>
						<br>
					</div>
				</div>
				<div v-if="scheduledAppointments.length==0">
					<div class="pastScheduledAppointmentsRow4">
						<h1>There are no past scheduled appointments yet</h1>
					</div>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>
			</div>
		</div>
		<br>
		<br>
		<div class="pastScheduledAppointmentsFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
    Vue.component("past-scheduled-appointments", {
    	template: "#past-scheduled-appointments",
    	data: () => ({
    		usernames: [],
    		scheduledAppointments: [],
        }),
        created() {
    		fetch("/api/username")
	            .then(res => res.json())
	            .then(res => this.usernames = res)
    		fetch("/api/past-scheduled-appointments")
	            .then(res => res.json())
	            .then(res => this.scheduledAppointments = res);
        }
    });
</script>

<style>

	.pastScheduledAppointmentsRow1{
		background-color: white;
		color: black;
		text-align: center;
		width:550px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.pastScheduledAppointmentsRow2{
		background-color: white;
		padding: 20px;
		margin: 15px;
		width:750px;
		text-align: left;
	}
	
	.pastScheduledAppointmentsRow2 div{
		padding:8px;
		border-style: solid;
		flex:33%;
	}
	
	.pastScheduledAppointmentsRow3{
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
	}
	
	.pastScheduledAppointmentsRow4{
		background-color: white;
		color: black;
		text-align: center;
		width:850px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.pastScheduledAppointmentsRow5{
		background-color: white;
		color: black;
		text-align: center;
		width:610px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.pastScheduledAppointmentsFooter{
		position:relative;
		top:250px;
		background-color: black;
		padding: 30px;
		text-align: center;
		color:white;
	}
</style>