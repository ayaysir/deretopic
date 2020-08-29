<template>
    <div>
        <div v-show="!isLoggedIn">
            <a :href="getRedirectUrl">로그인</a>
        </div>
        <div v-show="isLoggedIn">
            <img v-if="getUserData" :src="getUserData.imageUrl" class="profile-img">
            <span v-if="getUserData">{{getUserData.name}}</span> <span>님, 로그인되었습니다.</span> <button @click="logout">로그아웃</button>
        </div>
    </div>

    
</template>

<script>

export default {


  created() {
      
  },
  props: ["accessToken"],
  computed: {
      isLoggedIn() {
        return this.$store.state.accessUser && this.$store.state.accessUser.token != ""
      },
      getUserData() {
        return this.$store.state.accessUser && this.$store.state.accessUser.data
      },
      getRedirectUrl() {
        const url = window.location.href
        const isHttp = url.indexOf("http://") != -1
        const coreUrl = url.replace(/http:\/\/|https:\/\//, "").split("/")[0]
        const finalUrl = (isHttp ? "http://" : "https://") + coreUrl
        return finalUrl + "/oauth2/authorize/google?redirect_uri=" + finalUrl + "/v/auth-redirect"
      }
  },
  methods: {
    logout() {
      localStorage.removeItem("accessToken")
      this.$store.dispatch("LOGOUT")
    }
  },
  data() {
      return {
          
      }
  }
}
</script>

<style scoped>
    .profile-img {
        border-radius: 100%;
        width: 20px;
        margin: 2px;
    }
</style>