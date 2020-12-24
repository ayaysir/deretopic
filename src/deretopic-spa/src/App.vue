<template>
    <div id="app">

        <Header :msg="welcomeMessage" :accessToken="accessToken"></Header>
        <router-view :msg="welcomeMessage" :key="$route.fullPath" :accessToken="accessToken"/>
        <!-- <Topic /> -->
    </div>
</template>

<script>
    import Header from '@/components/common/Header.vue'

    export default {
        name: 'App',
        data() {
            return {
                welcomeMessage: "default msg",
                topicDataFromSuper: [],
                accessToken: localStorage.getItem("accessToken")
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

            // localStorage에서 accessToken 가져옴
            const token = localStorage.getItem("accessToken")
            if(token && token != "") {
                this.$store.dispatch("LOGIN", token).then(() => {})
            }

            // 현재 URL이 뭔가요?
            console.log("url", window.location.hostname)
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
    
    @media screen and (-webkit-min-device-pixel-ratio:0) { 
        select,
        textarea,
        input, button {
            font-size: 16px;
            /* background: #eee; */
        }
    }

    table {
        margin: 0px auto;
    }

    a, a:visited {
        color: cornflowerblue;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }

    a.danger, a.danger:visited {
        color: lightcoral;
    }

</style>
