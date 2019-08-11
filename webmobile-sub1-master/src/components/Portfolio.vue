<template>
  <v-hover>
	<v-card @click.native="detail"
		slot-scope="{ hover }"
      :class="`elevation-${hover ? 12 : 2}`"
      class="mx-auto"
      >
		<v-img :src="imgSrc" height="200px">
		</v-img>
		<v-card-title primary-title>
		<div>
			<div class="headline head">{{title}}</div>
			<span class="grey--text content">{{body}}</span>
		</div>
		</v-card-title>
	</v-card>
  </v-hover>
</template>

<script>
export default {
	name: 'Portfolio',
	props: {
		date: {type: String},
		title: {type: String},
		body: {type: String},
		imgSrc: {type: String},
	},
	data() {
		return {
			
		}
	},
	methods:{
		detail(){
			location.href="../portfolio"
		}
	}
}
</script>

<style>
.head{
   white-space: nowrap;
   overflow: hidden;
   text-overflow: ellipsis;
 }
 .content{
   display: -webkit-box;
   -webkit-line-clamp: 3;
   -webkit-box-orient: vertical;
   overflow: hidden;
 }
</style>