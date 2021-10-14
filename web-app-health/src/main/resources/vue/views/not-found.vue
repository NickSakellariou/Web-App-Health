<template id="not-found">
	<div>
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
		<div class="notFoundRow">
			<h1>NOT FOUND</h1>
		</div>
		<div class="notFoundFooter">
			&copy;
			<a href="http://www.ds.unipi.gr/" target="_blank">2021 DS_UNIPI
			</a>.
			All rights reserved.
		</div>
	</div>
</template>

<script>
	Vue.component("not-found", {
	    template: "#not-found",
	    data: () => ({
        }),
        created() {
        }
	});
</script>

<style>
	hr {
	  border: 1px solid #f1f1f1;
	  margin-bottom: 25px;
	}
	
	.notFoundRow{
		background-color: white;
		color: black;
		text-align: center;
		width:270px;
		margin: auto;
		border-radius:25px;
		box-shadow:1px 1px 1px white;
	}
	.notFoundFooter{
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