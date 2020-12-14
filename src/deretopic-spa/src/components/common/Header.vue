<template>
    <nav class="nav">
        <div class="nav-header">
            <img src="@/assets/logo.png"> <h2><router-link to="/">{{msg}}</router-link></h2>
        </div>
        
        <ul class="nav-body">
            <li><router-link to="/">소문 목록</router-link></li>
            <li><router-link to="/v/simple-list">아이돌 리스트</router-link></li>
            <li v-if="getLoggedIn"><router-link to="/v/write-uwasa">소문 등록</router-link></li>
            <li><router-link to="/v/thread/qna">잡답/질문게시판</router-link></li>
            <li><a href="https://github.com/ayaysir/deretopic" target="_blank">About</a></li>
        </ul>

        <div class="notification">
          이 사이트는 운영을 중단하며 2020년 12월 14일 이후 다음으로 이동되었습니다. 
          <br><a href="http://yoonbumtae.com/dere">http://yoonbumtae.com/dere</a>
          <br>앞으로 올라오는 최신 소문들은 위 링크에서 업데이트됩니다.
        </div>
        <LoginPanel :accessToken="accessToken" />
    </nav>

</template>

<script>
import LoginPanel from "@/components/auth/LoginPanel.vue"

export default {
  name: 'Header',
  props: ["msg", "logoSrc", "accessToken"],
  components: {
    LoginPanel
  },
  computed: {
    getLoggedIn() {
      return this.$store.state.accessUser &&  this.$store.state.accessUser.token != ""
    }
  }
  
}
</script>

<style scoped>
.nav ul {
  list-style: none;
  background-color: #444;
  color: whitesmoke;
  text-align: center;
  padding: 0;
  margin: 0;
}

.nav .nav-header {
    display: table;
    margin: 0px auto;
}

.nav img {
    width: 50px;
    margin-right: 10px;
    border-radius: 10px;
}

.nav .nav-header h2 {
    display: table-cell;
    vertical-align: middle;
}

.nav li {
  font-family: 'Oswald', sans-serif;
  font-size: 1em;
  line-height: 40px;
  height: 40px;
  border-bottom: 1px solid #888;
}
 
.nav-body a {
  text-decoration: none;
  color: #fff;
  display: block;
  transition: .3s background-color;
}
 
.nav-body a:hover {
  background-color: #005f5f;
}
 
.nav-body a.active {
  background-color: #fff;
  color: #444;
  cursor: default;
}

.nav-header a, .nav-header a:visited {
  color: black;
  text-decoration: none;
}

.nav-header a:hover {
  text-decoration: underline;
}

.notification {
  padding: 10px 10px;
  background-color: crimson; 
  color: white;
}

.notification a{
  color:cornsilk;
  font-weight: bold;
}
 
@media screen and (min-width: 600px) {
  .nav li {
    width: 200px;
    border-bottom: none;
    height: 50px;
    line-height: 50px;
    font-size: 1em;
  }
 
  /* Option 1 - Display Inline */
  .nav li {
    display: inline-block;
    margin-right: -4px;
  }
 
  /* Options 2 - Float
  .nav li {
    float: left;
  }
  .nav ul {
    overflow: auto;
    width: 600px;
    margin: 0 auto;
  }
  .nav {
    background-color: #444;
  }
  */
}

</style>