<template id="radiologist-order-scheduling-pending">
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
				<div class="radiologistOrderSchedulingPendingRow4">
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
				<div class="radiologistOrderSchedulingPendingRow1">
					<h1>All pending radiologist orders</h1>
				</div>
				<br>
				<br>
				<div v-if="radiologistOrders.length>0">
					<div class="radiologistOrderSchedulingPendingRow3">
						<div v-for="radiologistOrder in radiologistOrders">
							<div class="radiologistOrderSchedulingPendingRow2">
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
									<br>
									<br>
									<br>
									<form style="text-align:center;" :action="`/schedule-appointment/${radiologistOrder.radiologistOrderId}`" method="POST">
										<input type="submit" class="btn btn-primary" value="Schedule appointment">
									</form>
								</div>
							</div>
						</div>
						<br>
						<br>
					</div>
				</div>
				<div v-if="radiologistOrders.length==0">
					<div class="radiologistOrderSchedulingPendingRow5">
						<h1>There are no pending radiologist orders yet</h1>
					</div>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
				</div>
			</div>
		</div>
		<div class="radiologistOrderFormFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
    Vue.component("radiologist-order-scheduling-pending", {
    	template: "#radiologist-order-scheduling-pending",
    	data: () => ({
    		usernames: [],
    		radiologistOrders: [],
        }),
        created() {
    		fetch("/api/username")
	            .then(res => res.json())
	            .then(res => this.usernames = res)
    		fetch("/api/radiologist-orders")
            	.then(res => res.json())
            	.then(res => this.radiologistOrders = res);
        }
    });
</script>

<style>

	.radiologistOrderSchedulingPendingRow1{
		background-color: white;
		color: black;
		text-align: center;
		width:540px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderSchedulingPendingRow2{
		background-color: white;
		padding: 20px;
		margin: 15px;
		width:750px;
		text-align: left;
	}
	
	.radiologistOrderSchedulingPendingRow2 div{
		padding:8px;
		border-style: solid;
		flex:33%;
	}
	
	.radiologistOrderSchedulingPendingRow3{
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
	}
	
	.radiologistOrderSchedulingPendingRow4{
		background-color: white;
		color: black;
		text-align: center;
		width:610px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderSchedulingPendingRow5{
		background-color: white;
		color: black;
		text-align: center;
		width:800px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderSchedulingPendingFooter{
		position:relative;
		top:250px;
		background-color: black;
		padding: 30px;
		text-align: center;
		color:white;
	}
</style>