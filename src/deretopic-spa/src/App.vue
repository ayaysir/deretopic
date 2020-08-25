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
                // 제목 설정
                document.title = text
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

    .search-highlight {
        background-color: #fff34d;
        -moz-border-radius: 5px; /* FF1+ */
        -webkit-border-radius: 5px; /* Saf3-4 */
        border-radius: 5px; /* Opera 10.5, IE 9, Saf5, Chrome */
        -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.7); /* FF3.5+ */
        -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.7); /* Saf3.0+, Chrome */
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.7); /* Opera 10.5+, IE 9.0 */
    }


</style>
