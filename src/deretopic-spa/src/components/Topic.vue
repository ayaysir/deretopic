<template>
  <div class="topic">
        <audio id="tts-audio-main"></audio>
        <div class="each-row" v-for="(uwasa, rowIndex) in lineCarriagedTopicData" v-bind:key="rowIndex">
          <div class="idol-name"><a class="idol-link" :href="'/api/idol/redirect/' + uwasa.idolNameJa" target="_blank">{{uwasa.idolNameJa}}</a></div>
          <div class="topic-num"><span>{{uwasa.topicNum}}</span></div>
          <div class="topic-content">
            <p class="label-lang">Ja</p>
            <p class="topic-ja">
              <span v-html="uwasa.uwasaJa"></span> 
              <a class="btn-speech" @click="playTTS($event)" v-bind:data-name="uwasa.idolNameJa" v-bind:data-num="uwasa.topicNum">🔊</a>
            </p>
            <p class="label-lang">Ko</p>
            <p class="topic-ko"><span v-html="uwasa.uwasaKo"></span></p>
          </div>
        </div>
        <infinite-loading @infinite="infiniteHandler" spinner="waveDots">
          <div slot="no-more" style="color: rgb(102, 102, 102); font-size: 14px; padding: 10px 0px;">목록의 끝입니다 :)</div>
        </infinite-loading>
  </div>
</template>

<script>

import InfiniteLoading from 'vue-infinite-loading';

export default {

  name: 'Topic',
  data() {
      return {
          topicData: [],
          limit: 1
      }
  },
  created() {

      async function getTopicFromApi() {
          try {
              const init = await fetch(`/api/idol/uwasa/pages/0`, {method: "GET"})
              const data = await init.json()

              return data
          } catch(exc) {
              console.error(exc)
          }
      }

      getTopicFromApi().then(data => {
          console.log("fromAPI", data)
          this.topicData = data
      })
      
  },
  mounted() {
    // async function get() {
    //   const init = await fetch(`/api/idol/tts/島村卯月/1`, {method: "get"})
    //   const blob = await init.blob()

    //   // use blob ...

    //   // *** 예제: 함수가 실행되면 파일 다운로드 바로 되게 ***

    //   // 파일이름 가져오기
    //   const disposition = init.headers.get("content-disposition")

    //   let fileName = "file"
    //   if(disposition && disposition.indexOf('attachment') !== -1) {
    //     const filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/;
    //     const matches = filenameRegex.exec(disposition)

    //     if (matches != null && matches[1]) {
    //       fileName = matches[1].replace(/['"]/g, '')
    //     } 
    //   }

    //   // console.log(fileName, await blob)
        
    //   // 가상 링크 DOM 만들어서 다운로드 실행
    //   const url = URL.createObjectURL(await blob)
    //   const a = document.createElement("a")
    //   a.href = url
    //   a.download = fileName
    //   document.body.appendChild(a)
    //   a.click()
    //   window.URL.revokeObjectURL(url)
    // }

    // get()
  },
  components: {
    InfiniteLoading
  },
  computed: {
    lineCarriagedTopicData() {
      const data = JSON.parse(JSON.stringify(this.topicData))
      return data.map(v => {
        v.uwasaJa = v.uwasaJa.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g, "<br>")
        v.uwasaKo = v.uwasaKo.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g, "<br>")
        return v
      })
    }
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
    },
    playTTS(event) {

      const evTarget = event.currentTarget || event.target
      const name = evTarget.dataset.name
      const num = evTarget.dataset.num
      console.log(evTarget, evTarget.dataset.name, evTarget.dataset.num)

      const mainAudio = document.getElementById("tts-audio-main")
      mainAudio.src = '/api/idol/tts/' + name + '/' + num
      mainAudio.play()
      
    },
    infiniteHandler($state) {
      const EACH_LEN = 30

      fetch("/api/idol/uwasa/pages/" + (this.limit), {method: "get"}).then(resp => {
        return resp.json()
      }).then(data => {
        setTimeout(() => {
          if(data.length) {
            this.topicData = this.topicData.concat(data)
            $state.loaded()
            this.limit += 1
            console.log("after", this.topicData.length, this.limit)

            // 끝 지정(No more data) - 데이터가 EACH_LEN개 미만이면 
            if(data.length / EACH_LEN < 1) {
              $state.complete()
            }
          } else {
            // 끝 지정(No more data)
            $state.complete()
          }
        }, 1000)
      }).catch(err => {
        console.error(err);
      })
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