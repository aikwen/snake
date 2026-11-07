<template>
    <div ref="parent" class="gamemap">
        <canvas ref="canvas" tabindex="0"></canvas>
    </div>
</template>


<script>
import { GameMap } from '@/assets/scripts/GameMap';
import { ref, onMounted, onUnmounted } from 'vue';


export default {
  setup() {
    let parent = ref(null);
    let canvas = ref(null);
    let gameMap = null;
    
    onMounted(() => {
      gameMap = new GameMap(canvas.value.getContext('2d'), parent.value)
    })

    onUnmounted(() => {
      gameMap?.destroy();
      gameMap = null;
    })


    return {
      parent,
      canvas
    }
  }
}
</script>


<style scoped>

div.gamemap{
    width: 100%;
    height:100%;
    display:flex;
    justify-content: center;
    align-items: center;
}
</style>