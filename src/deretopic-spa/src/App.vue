<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <HelloWorld v-bind:msg="welcomeMessage" />
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'

    export default {
        name: 'App',
        data() {
            return {
                welcomeMessage: "default msg"
            }
        },
        components: {
            HelloWorld
        },
        created() {
            fetch("/api/test", {
                method: "get"
            }).then(resp => {
                const text = resp.text()
                console.log(resp)
                return text // [[PromiseValue]]를 꺼내 다음 then으로 전송
            }).then(text => {
                console.log("fetch: " + text)
                this.welcomeMessage = text
            }).catch(excResp => {
                console.log(excResp)
                this.welcomeMessage = "Error"
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
