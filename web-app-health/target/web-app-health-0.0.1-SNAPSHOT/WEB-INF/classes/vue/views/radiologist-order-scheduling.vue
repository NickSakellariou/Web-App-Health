<template id="radiologist-order-scheduling">
	<div>
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
		<div class="radiologistOrderSchedulingRow">
			<h2>Enter username and password to proceed</h2>
			<form name="myform" method="POST" action="/radiologistOrderSchedulingAuthentication">
				<hr>
				<div class="form-group">
				  <label for="username">Username:</label>
				  <input type="text" class="form-control" pattern=".{5,}" title="Must contain 5 or more characters" id="username" name="username"  required>
				</div>
				<div class="form-group">
				  <label for="password">Password:</label>
				  <input type="password" class="form-control" pattern=".{8,}" title="Must contain 8 or more characters" id="password" name="password"  required>
				</div>
				<button type="submit">Submit</button>
			</form>
		</div>
		<br>
		<br>
		<div class="radiologistOrderSchedulingFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
    Vue.component("radiologist-order-scheduling", {
    	template: "#radiologist-order-scheduling",
    	data: () => ({
        }),
        created() {
        }
    });
</script>

<style>
	
	.radiologistOrderSchedulingRow{
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
	.radiologistOrderSchedulingRow form{
		font-weight: bold;
	}
	
	.radiologistOrderSchedulingRow button[type=submit] {
	  width: 100%;
	  background-color: #ff0000;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	.radiologistOrderSchedulingRow button[type=submit]:hover {
	  background-color: #e60000;
	}
	
	.radiologistOrderSchedulingFooter{
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