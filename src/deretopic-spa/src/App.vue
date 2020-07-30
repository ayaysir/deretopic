<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <HelloWorld v-bind:msg="welcomeMessage" />
        <Topic />
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'
    import Topic from './components/Topic.vue'

    export default {
        name: 'App',
        data() {
            return {
                welcomeMessage: "default msg",
                topicDataFromSuper: []
            }
        },
        components: {
            HelloWorld,
            Topic
        },

        created() {

            async function getTitle() {
                const init = await fetch("/api/test/title", {
                    method: "get"
                })
                return init.text()
            }
            getTitle().then(text => {
                this.welcomeMessage = text
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

    #app img {
        width: 200px;
        border-radius: 10px;
    }

</style>
