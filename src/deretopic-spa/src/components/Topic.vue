<template>
  <div class="topic">
      <div class="each-idol" v-for="(idol, idolName) in topicData" v-bind:key="idolName">
        <div class="each-row" v-for="(row, i) in idol" v-bind:key="i">
          <div class="idol-name"><a class="idol-link" :href="'/api/idol/redirect/' + idolName" target="_blank">{{idolName}}</a></div>
          <div class="topic-num"><span>{{row[0]}}</span></div>
          <div class="topic-content">
            <p class="label-lang">Ja</p>
            <p class="topic-ja">{{row[1]}} <a class="btn-speech" @click="speak(row[1], {lang:'ja-JP'})">🔊</a></p>
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
  },
  mounted() {
    
  },
  methods: {
    speak(text, opt_prop) {
      if (typeof SpeechSynthesisUtterance === "undefined" || typeof window.speechSynthesis === "undefined") {
        alert("이 브라우저는 음성 합성을 지원하지 않습니다.")
        return
      }
      
      window.speechSynthesis.cancel() // 현재 읽고있다면 초기화

      const prop = opt_prop || {}

      const speechMsg = new SpeechSynthesisUtterance()
      speechMsg.rate = prop.rate || 1 // 속도: 0.1 ~ 10      
      speechMsg.pitch = prop.pitch || 1 // 음높이: 0 ~ 2
      speechMsg.lang = prop.lang || "ko-KR"
      speechMsg.text = text
      
      // SpeechSynthesisUtterance에 저장된 내용을 바탕으로 음성합성 실행
      window.speechSynthesis.speak(speechMsg)
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


  a.idol-link {
    color: cornflowerblue;
    text-decoration: none;
    font-weight: 600;
  }

  a.idol-link:hover {
    text-decoration: underline;
  }

  .btn-speech {
    cursor: pointer;

  }
  @media screen and (max-width: 768px) {
    /* 모바일에 사용될 스트일 시트를 여기에 작성합니다. */
    .topic {
      width: 98%;
      margin: 0px auto;
      display: table;
    }

    .idol-name {
      min-width: 80px;
      padding-left: 3px;
    }

    .topic-num {
      min-width: 30px;
    }

  }
</style>