<template>
    <div id="app">
        <Header :msg="welcomeMessage"></Header>
        <router-view :msg="welcomeMessage"/>
        <!-- <Topic /> -->
    </div>
</template>

<script>
    import Header from './components/Header.vue'
    // import Topic from './components/Topic.vue'


    export default {
        name: 'App',
        data() {
            return {
                welcomeMessage: "default msg",
                topicDataFromSuper: []
            }
        },
        components: {
            Header,
            // Topic
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
        /* margin-top: 60px; */
    }


</style>
