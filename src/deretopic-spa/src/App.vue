<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <HelloWorld v-bind:msg="welcomeMessage" />
        <Topic v-bind:topicData="topicDataFromSuper" />
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
            fetch("/api/test/title", {
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

            async function getTopicFromApi() {
                try {
                    const init = await fetch("/api/idol/uwasa", {method: "GET"})
                    const data = await init.json()

                    return data
                } catch(exc) {
                    console.error(exc)
                }
            }

            getTopicFromApi().then(data => {
                console.log("fromAPI", data)
                this.topicDataFromSuper = data
            })

            
        },
        
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
