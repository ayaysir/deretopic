<template>
    <div id="app">
        <h2>sound.yoonbumtae.com</h2>
    </div>
</template>

<script>

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
            
        },

        created() {

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
