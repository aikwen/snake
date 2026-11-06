<template>
  <div>
      <div>BOT昵称：{{bot_name}}</div>
      <div>BOT战力：{{bot_rating}}</div>
  </div>
  <router-view/>
</template>

<script>
import $ from "jquery"
import { ref } from 'vue';
import config from "./config";


export default {
  name: "App",
  setup: () => {
    let bot_name = ref("")
    let bot_rating = ref("")

    $.ajax({
      url: config.BASE_URL + "/pk/getbotinfo/",
      type: "get",
      success: resp =>{
        bot_name.value = resp.name
        bot_rating.value = resp.rating
      }
    })

    
    return {
      bot_name,
      bot_rating
    }
  }
}

</script>

<style>

body {
    background-image: url("@/assets/background.png");
    background-size:cover;
}

</style>
