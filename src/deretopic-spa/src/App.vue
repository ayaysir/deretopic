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

            async function getTopic() {
                try {
                    const init1 = await fetch("/api/test/data/1", {method: "GET"})
                    const data1 = await init1.text()

                    const init2 = await fetch("/api/test/data/2", {method: "GET"})
                    const data2 = await init2.text()

                    const init3 = await fetch("/api/test/data/3", {method: "GET"})
                    const data3 = await init3.text()

                    return [JSON.parse(data1), JSON.parse(data2), JSON.parse(data3)]
                } catch(exc) {
                    console.error(exc)
                }
            }

            getTopic().then(data => {
                this.topicDataFromSuper = {...data[0], ...data[1], ...data[2]}
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
