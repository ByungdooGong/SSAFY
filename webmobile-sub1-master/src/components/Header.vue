<template>
  <v-toolbar fixed>
    <v-toolbar-title @click="next" style="font-size: 20px;">SSAFY</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-icon class="bookmark" @click="add">star</v-icon>

    <div class="hidden-md-and-up">
    <v-menu offset-y>
      <template v-slot:activator="{ on }">
        <v-btn color="primary" dark v-on="on">Dropdown</v-btn>
      </template>
      <v-list>
        <v-list-tile v-for="item in items" :key="item" @click="link(item)">
          <v-list-tile-title v-text="item"></v-list-tile-title>
        </v-list-tile>
      </v-list>
    </v-menu>
  </div>

    <v-toolbar-items class="hidden-sm-and-down">
      <v-btn flat to = 'post'>post</v-btn>
      <v-btn flat to = 'portfolio'>portfolio</v-btn>
      <v-btn flat to = 'login'>login</v-btn>
    </v-toolbar-items>
  </v-toolbar>
</template>

<script>
export default {
    name: 'Header',
    props: {

    },
     data:()=>{
      return{
         items:["Home","Post","Portfolio"]
      }
    },
    /*data(){return{items:[]}}
    data:()=>({items:[]})*/

    methods: {
      next: function() {
        location.href="/"
      },
      link(str){
         if (str == "Home") {
        location.href = "/";
       } else if (str == "Post") {
        location.href = "/post";
       } else {
        location.href = "/portfolio";
        }
      },
      add:()=>{
        alert("즐겨찾기는 Ctrl-D를 누르세요.")
      }
      /*next () {} 랑 같음*/
    },
}
</script>
