<template id="radiologist-order-scheduling-home">
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
				<div class="radiologistOrderSchedulingHomeRow2">
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
				<div class="radiologistOrderSchedulingHomeRow2">
					<h1>Radiologist order scheduling overview</h1>
				</div>
				<br>
				<br>
				<br>
				<div class="radiologistOrderSchedulingHomeRow1">
					<div class="radiologistOrderSchedulingHomeRow">
						<a href="/radiologist-order-scheduling-pending">
							<h2>Pending radiologist orders</h2>
						</a>
					</div>
					<br>
					<br>
					<br>
					<div class="radiologistOrderSchedulingHomeRow">
						<a href="/scheduled-appointments">
							<h2>Scheduled appointments</h2>
						</a>
					</div>
					<br>
					<br>
					<br>
					<div class="radiologistOrderSchedulingHomeRow">
						<a href="/past-scheduled-appointments">
							<h2>Past scheduled appointments</h2>
						</a>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>
		<div class="radiologistOrderSchedulingHomeFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
    Vue.component("radiologist-order-scheduling-home", {
    	template: "#radiologist-order-scheduling-home",
    	data: () => ({
    		usernames: [],
        }),
        created() {
            fetch("/api/username")
                .then(res => res.json())
                .then(res => this.usernames = res);
        }
    });
</script>

<style>

	.radiologistOrderSchedulingHomeRow2{
		background-color: white;
		color: black;
		text-align: center;
		width:700px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderSchedulingHomeRow{
		background-color: white;
		color: black;
		text-align: center;
		width:270px;
		margin: 15px;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderSchedulingHomeRow a{
		color:black;	
	}
	
	.radiologistOrderSchedulingHomeRow1{
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
	}
	
	.radiologistOrderSchedulingHomeRow3{
		background-color: white;
		padding: 20px;
		margin: 15px;
		width:750px;
		text-align: left;
	}
	
	.radiologistOrderSchedulingHomeRow3 div{
		padding:8px;
		border-style: solid;
		flex:33%;
	}
	
	.radiologistOrderSchedulingHomeRow4{
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
	}
	
	.radiologistOrderSchedulingHomeFooter{
		position: fixed;
		left: 0;
		bottom: 0;
		width: 100%;
		background-color: black;
		padding: 30px;
		color: white;
		text-align: center;
	}
</style>