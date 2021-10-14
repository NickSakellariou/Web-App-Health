<template id="radiologist-order-form">
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
				<div class="radiologistOrderFormRow2">
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
				<br>
				<div class="radiologistOrderFormRow1">
					<h1>Enter the radiologist order</h1>
				</div>
				<div class="radiologistOrderFormRow">
					<h2>Enter patient's details:</h2>
					<form name="myform" method="POST" action="/radiologistOrder">
						<hr>
						<div class="form-group">
						  <label for="name">Name:</label>
						  <input type="text" class="form-control" pattern="[a-zA-Z]{1,}" title="Must contain only letters" id="name" name="name" required>
						</div>
						<div class="form-group">
						  <label for="surname">Surname:</label>
						  <input type="text" class="form-control" pattern="[a-zA-Z]{1,}" title="Must contain only letters" id="surname" name="surname"  required>
						</div>
						<div class="form-group">
						  <label for="father">Father's name:</label>
						  <input type="text" class="form-control" pattern="[a-zA-Z]{1,}" title="Must contain only letters" id="father" name="father" required>
						</div>
						<div class="form-group">
						  <label for="mother">Mother's name:</label>
						  <input type="text" class="form-control" pattern="[a-zA-Z]{1,}" title="Must contain only letters" id="mother" name="mother"  required>
						</div>
						<p>Gender:</p>
						<input type="radio" id="male" name="gender" checked value="Male">
						<label for="male">Male</label><br>
						<input type="radio" id="female" name="gender" value="Female">
						<label for="female">Female</label><br>
						<input type="radio" id="other" name="gender" value="Other">
						<label for="other">Other</label>
					    <br>
					    <br>
					    <label for="birthdate">Birthdate:</label>
					    <br>
		  				<input type="date" id="birthdate" name="birthdate" required>
		  				<br>
		  				<br>
		  				<div class="form-group">
						  <label for="address">Address:</label>
						  <input type="text" class="form-control" pattern=".{1,}" title="This field cannot be empty" id="address" name="address"  required>
						</div>
						<div class="form-group">
						  <label for="homephone">Home phone:</label>
						  <input type="text" class="form-control" pattern="[0-9]{10}" title="Must contain 10 numbers"  id="homephone" name="homephone"  required>
						</div>
						<div class="form-group">
						  <label for="mobilephone">Mobile phone:</label>
						  <input type="text" class="form-control" pattern="[0-9]{10}" title="Must contain 10 numbers"  id="mobilephone" name="mobilephone"  required>
						</div>
						<br>
						<h2>Enter radiologist's order details:</h2>
						<hr>
						<p>Causes:</p>
						<textarea maxlength="1000" rows="4" cols="92" name="causes" required></textarea>
						<br>
						<br>
						<div class="form-group">
						  <label for="radiologistOperation">Radiologist operation:</label>
						  <select class="form-control" id="radiologistOperation" name="radiologistOperation" required>
						    <option>MRI</option>
						    <option>X-ray</option>
						    <option>Ultrasound</option>
						    <option>Nuclear medicine</option>
						  </select>
						</div>
						<label for="suggestedExecutionDate">Suggested execution date:</label>
						<br>
		  				<input type="date" id="suggestedExecutionDate" name="suggestedExecutionDate" required>
		  				<br>
		  				<br>
		  				<div class="form-group">
						  <label for="priority">Priority (1:minimum, 5:maximum):</label>
						  <select class="form-control" id="priority" name="priority" required>
						    <option>1</option>
						    <option>2</option>
						    <option>3</option>
						    <option>4</option>
						    <option>5</option>
						  </select>
						</div>
						<button type="submit">Submit</button>
					</form>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="radiologistOrderFormFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
    Vue.component("radiologist-order-form", {
    	template: "#radiologist-order-form",
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

	.radiologistOrderFormRow1{
		background-color: white;
		color: black;
		text-align: center;
		width:500px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderFormRow{
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
	.radiologistOrderFormRow form{
		font-weight: bold;
	}
	
	.radiologistOrderFormRow button[type=submit] {
	  width: 100%;
	  background-color: #ff0000;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	.radiologistOrderFormRow button[type=submit]:hover {
	  background-color: #e60000;
	}
	
	.radiologistOrderFormRow2{
		background-color: white;
		color: black;
		text-align: center;
		width:610px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.radiologistOrderFormFooter{
		position:relative;
		top:250px;
		background-color: black;
		padding: 30px;
		text-align: center;
		color:white;
	}
</style>