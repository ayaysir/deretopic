<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <HelloWorld msg="Welcome to Your Vue.js App" />
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'

    export default {
        name: 'App',
        components: {
            HelloWorld
        },
        mounted() {
            fetch("/api/test", {
                method: "get"
            }).then(resp => {
                const text = resp.text()
                console.log(resp)
                return text // [[PromiseValue]]를 꺼내 다음 then으로 전송
            }).then(text => {
                console.log("fetch: " + text)
            }).catch(excResp => {
                console.log(excResp)
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
