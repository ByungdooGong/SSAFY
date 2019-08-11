<template>
 <div class="markdown">
   <v-flex>
     <v-text-field label="title"></v-text-field>
   </v-flex>
   <markdown-editor></markdown-editor>
   <center>
    <v-btn @click="back">back</v-btn>
    <v-btn>save</v-btn>
   </center>
 </div>
</template>

<script>

export default{
  name:'MarkDown',
  methods:{
    back(){
      location.href="../portfolio"
    }
  }

}
</script>