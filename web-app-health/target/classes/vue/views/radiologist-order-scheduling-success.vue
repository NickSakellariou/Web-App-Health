<template id="radiologist-order-scheduling-success">
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
				<div class="radiologistOrderSchedulingSuccessRow1">
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
				<div class="radiologistOrderSchedulingSuccessRow">
					<h2>Radiologist order appointment was submitted successfully!</h2>
				</div>
			</div>
		</div>
		<div class="radiologistOrderSchedulingSuccessFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
	Vue.component("radiologist-order-scheduling-success", {
    	template: "#radiologist-order-scheduling-success",
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
	.radiologistOrderSchedulingSuccessRow{
		background-color: white;
		color: black;
		text-align: center;
		width:860px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderSchedulingSuccessRow1{
		background-color: white;
		color: black;
		text-align: center;
		width:610px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderSchedulingSuccessFooter{
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