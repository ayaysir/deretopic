<template>
    <div>
        <h2>로그인 되었습니다.</h2>
    </div>
</template>

<script>

export default {
    created() {
        const url = window.location.href
        const token = this.getUrlParameter("token", url)
        const error = this.getUrlParameter("error", url)
        if(token) {
            localStorage.setItem("accessToken", token)
            this.$store.dispatch("LOGIN", token).then(() => {})
            this.$router.push("")
        } else if(error) {
            alert(error)
        }

    },
    props: ["accessToken"],
    data() {
        return {
        }
    },
    methods: {
        getUrlParameter(name, url) {
            name = name.replace(/[[]/, '\\[').replace(/[\]]/, '\\]');
            const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');

            const results = regex.exec(url);
            return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
        },
        redirect() {

        }
    }
}
</script>

<style scoped>

</style>