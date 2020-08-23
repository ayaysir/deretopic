<template>
    <nav class="nav">
        <ul>
            <li class="logo-title"><img src="./../assets/logo.png" style="width: 50px;">{{msg}}</li>
            <li><router-link to="/">소문 목록</router-link></li>
            <li><router-link to="/v/simple-list">아이돌 리스트</router-link></li>
            <li><router-link to="/v/write-uwasa">소문 등록</router-link></li>
        </ul>
    </nav>
</template>

<script>
export default {
  name: 'Header',
  props: ["msg", "logoSrc"]
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

.nav .logo-title {
    float: left;
}

.nav li {
  font-family: 'Oswald', sans-serif;
  font-size: 1.2em;
  line-height: 40px;
  height: 40px;
  border-bottom: 1px solid #888;
}
 
.nav a {
  text-decoration: none;
  color: #fff;
  display: block;
  transition: .3s background-color;
}
 
.nav a:hover {
  background-color: #005f5f;
}
 
.nav a.active {
  background-color: #fff;
  color: #444;
  cursor: default;
}
 
@media screen and (min-width: 600px) {
  .nav li {
    width: 200px;
    border-bottom: none;
    height: 50px;
    line-height: 50px;
    font-size: 1.4em;
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