<template id="radiologist-order-success">
	<div>
		<div v-for="username in usernames">
			<div v-if="username.value == null || username.value == 'admin2' ">
				<div class="header">
		    		<br>
					<a href="/radiologist-order">
						<h1>
							Radiologist order
						</h1>
					</a>
					<br>
					<br>
				</div>
				<br>
				<br>
				<br>
				<br>
				<div class="radiologistOrderSuccessRow1">
					<h1>You have no access to this page</h1>
				</div>
				<br>
				<br>
				<br>
				<br>
			</div>
			<div v-if="username.value == 'admin1'">
				<div class="header">
		    		<br>
					<a href="/radiologist-order-form">
						<h1>
							Radiologist order
						</h1>
					</a>
					<br>
					<br>
				</div>
				<br>
				<br>
				<br>
				<div class="radiologistOrderSuccessRow">
					<h2>Radiologist order was submitted successfully!</h2>
				</div>
			</div>
		</div>
		<div class="radiologistOrderSuccessFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
	Vue.component("radiologist-order-success", {
		template: "#radiologist-order-success",
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
	.radiologistOrderSuccessRow{
		background-color: white;
		color: black;
		text-align: center;
		width:680px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	.radiologistOrderSuccessRow1{
		background-color: white;
		color: black;
		text-align: center;
		width:610px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	.radiologistOrderSuccessFooter{
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