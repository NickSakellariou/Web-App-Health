<template id="login-failure2">
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
		<div class="loginFailure2Row">
			<h2>Wrong username or password, try again</h2>
		</div>
		<div class="loginFailure2Footer">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
	Vue.component("login-failure2", {
	    template: "#login-failure2",
	});
</script>

<style>
	hr {
	  border: 1px solid #f1f1f1;
	  margin-bottom: 25px;
	}
	
	.loginFailure2Row{
		background-color: white;
		color: black;
		text-align: center;
		width:600px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	.loginFailure2Footer{
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