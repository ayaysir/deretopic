import Vue from 'vue'
import App from './App.vue'
import DereApp from './DereApp.vue'

import dereRouter from "./router/dere_router";
import soundRouter from "./router/sound_router";

import store from "./store"

Vue.config.productionTip = false

// 현재 URL이 뭔가요?
console.log("url", window.location.hostname)

if(window.location.hostname == "dere.yoonbumtae.com") {
  new Vue({
    router: dereRouter,
    store,
    render: h => h(DereApp),
  }).$mount('#app')
} else {
  new Vue({
    router: soundRouter,
    store,
    render: h => h(App),
  }).$mount('#app')
}


