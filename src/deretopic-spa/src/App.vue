<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <HelloWorld msg="Welcome to Your Vue.js App" />
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'
    import request from "request"

    export default {
        name: 'App',
        components: {
            HelloWorld
        },
        mounted() {
            request(`${location.protocol}//${location.host}` + "/api/test", (error, response, body) => {
                console.log(">>>>>>>>>>", location.protocol, location.host, location.hostname, `${location.protocol}//${location.host}` + "/api/test")
                console.log(">>>>>>>>>>", error, response && response.statusCode)
                console.log(">>>>>>>>>>", body)
            })
        }
    }

</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }

</style>
