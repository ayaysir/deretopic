<template>
  <div class="topic">
      <div class="each-idol" v-for="(idol, idolName) in topicData" v-bind:key="idolName">
        <div class="each-row" v-for="row in idol" v-bind:key="row">
          <div class="idol-name">{{idolName}}</div>
          <div class="topic-num"><span>{{row[0]}}</span></div>
          <div class="topic-content">
            <p class="label-lang">Ja</p>
            <p class="topic-ja">{{row[1]}}</p>
            <p class="label-lang">Ko</p>
            <p class="topic-ko">{{row[2]}}</p>
          </div>
        </div>
      </div>
    
  </div>
</template>

<script>
export default {
  name: 'Topic',
  props: ["topicData"],
  data() {
      return {
          propTopicData: []
      }
  }
}
</script>


<style scoped>
  .topic {
    width: 70%;
    margin: 0px auto;
    display: table;
  }
  .each-idol {
    padding: 5px;
    display: table-row;
  }

  .each-row {
    margin-bottom: 10px;

    border: 1px solid gray;
    border-radius: 10px;
    padding-top: 5px;
  }
  .idol-name, .topic-num {
    display: table-cell;
    vertical-align: middle;
  }

  .idol-name {
    min-width: 100px;
    padding-left: 3px;
  }

  .topic-num {
    min-width: 50px;
  }

  .topic-num span {
    font-size: .8em;
    width: 1em;
    border-radius: 3em;
    padding: .1em  .2em;
    line-height: 1.25em;
    border: 1px solid #333;
    display: inline-block;
    text-align: center;
  }

  .topic-content {
    display: table-cell;
    vertical-align: middle;
  }

  .topic-content .topic-ja, .topic-content .topic-ko {
    text-align: left;
    vertical-align: middle;
    margin-top: 7px;
    margin-bottom: 7px;
  }

  .label-lang {
    text-align: left;
    font-weight: bold;
    font-size: .5em;
    height: 1px;
    margin-bottom: 10px;
    color: gray;
  }
</style>