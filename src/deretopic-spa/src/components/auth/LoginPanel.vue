<template>
    <div class="wrapper">
        <div v-show="!isLoggedIn">
            <a :href="getRedirectUrl"><img class="img-google" src="@/assets/btn_google_signin_dark_normal_web.png"></a>
        </div>
        <div v-show="isLoggedIn" class="profile-wrapper">
          <p><img v-if="getUserData" :src="getUserData.imageUrl" class="profile-img">
            <span v-if="getUserData">{{getUserData.name}}</span> <span>님, 로그인되었습니다.</span> <button @click="logout">로그아웃</button></p>
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
  .wrapper {
    margin: 0px auto;

  }
  .profile-wrapper{
    vertical-align: middle;
  }
  .profile-wrapper p {
    margin: 0px;
    padding: 0px;
  }
  .profile-wrapper span {
    vertical-align: middle;
  }
  .profile-img {
    border-radius: 100%;
    height: 30px;
    margin: 0px 5px;
    position: relative;
    top: 10px;
  }
  .img-google {
    height: 40px;
    margin-top: 10px;
  }
</style>