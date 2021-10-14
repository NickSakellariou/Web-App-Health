<template id="home-page">
	<div>
		<div class="header">
    		<br>
			<a href="/">
				<h1>
					Home page
				</h1>
			</a>
			<br>
			<br>
		</div>
		<br>
		<br>
		<br>
		<div class="homePageRow1">
			<div class="homePageRow">
				<a href="/radiologist-order">
					<h2>Make radiologist order</h2>
				</a>
			</div>
			<br>
			<br>
			<br>
			<div class="homePageRow">
				<a href="/radiologist-order-scheduling">
					<h2>Schedule radiologist order</h2>
				</a>
			</div>
		</div>
		<br>
		<br>
		<div class="homePageFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
    Vue.component("home-page", {
    	template: "#home-page",
    });
</script>

<style>
	
	.homePageRow{
		background-color: white;
		color: black;
		text-align: center;
		width:270px;
		margin: 15px;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	
	.homePageRow a{
		color:black;	
	}
	
	.homePageRow1{
		display: flex;
		flex-wrap: wrap;
		justify-content: center;
	}
	
	.homePageFooter{
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