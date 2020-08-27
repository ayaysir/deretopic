<template>
  <div class="topic">
        <audio id="tts-audio-main"></audio>
        <TopicSearch v-on:search="doSearch" v-on:allOrder="doAllOrder"/>
        <div class="each-row" v-for="(uwasa, rowIndex) in lineCarriagedTopicData" v-bind:key="rowIndex">
          <ProfileMini :idol="uwasa.idol"/>
          <div class="topic-num"><span>{{uwasa.topicNum}}</span></div>
          <div class="topic-content">
            <p class="label-lang">Ja</p>
            <p class="topic-ja">
              <span v-html="uwasa.uwasaJa"></span> 
              <a class="btn-speech" @click="playTTS($event)" v-bind:data-id="uwasa.id" v-bind:data-name="uwasa.idolNameJa" v-bind:data-num="uwasa.topicNum">🔊</a>
            </p>
            <p class="label-lang">Ko</p>
            <p class="topic-ko"><span v-html="uwasa.uwasaKo"></span></p>
          </div>
        </div>
        <infinite-loading :identifier="infiniteId" @infinite="infiniteHandler" spinner="waveDots">
          <div slot="no-more" style="color: rgb(102, 102, 102); font-size: 14px; padding: 10px 0px;">목록의 끝입니다 :)</div>
        </infinite-loading>
  </div>
</template>

<script>

import InfiniteLoading from 'vue-infinite-loading';

import TopicSearch from "@/components/TopicSearch.vue";
import ProfileMini from "@/components/ProfileMini.vue";

export default {

  name: 'Topic',
  data() {
      return {
          topicData: [],
          limit: 0,
          fetchUrl: `/api/idol/uwasa/pages/{limit}`,
          searchKeyword: "",
          infiniteId: +new Date()
      }
  },
  created() {
      
      
  },
  mounted() {
  },
  components: {
    InfiniteLoading,
    TopicSearch,
    ProfileMini
  },
  computed: {
    lineCarriagedTopicData() {
      const data = JSON.parse(JSON.stringify(this.topicData))
      const keyword = this.searchKeyword
      const regex = new RegExp(keyword, "ig")
      console.log("현재 검색어  ", keyword)
      return data.map(v => {
        v.uwasaJa = v.uwasaJa.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g, "<br>")
        v.uwasaKo = v.uwasaKo.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g, "<br>")

        // 검색어가 있는 겅우 하이라이트
        if(keyword && keyword != "") {
          v.uwasaJa = v.uwasaJa.replace(regex, "<span class='search-highlight'>" + keyword + "</span>")
          v.uwasaKo = v.uwasaKo.replace(regex, "<span class='search-highlight'>" + keyword + "</span>")
        }
        
        return v
      })
    }
  },

  methods: {
    async getTopicFromApi(fetchUrl) {
      try {
          const init = await fetch(fetchUrl, {method: "GET"})
          const data = await init.json()

          return data
      } catch(exc) {
          console.error(exc)
      }
    },
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
      const id = evTarget.dataset.id
      console.log(evTarget, evTarget.dataset)

      const mainAudio = document.getElementById("tts-audio-main")
      mainAudio.src = '/api/idol/tts/' + id
      mainAudio.play()
      
    },
    resetSearch(isReverseAll) {
      this.limit = 0
      this.fetchUrl = `/api/idol/uwasa/pages/{limit}` + (isReverseAll ? "?reverseAll=true" : "")
      this.topicData = []
      this.infiniteId += 1
      this.searchKeyword = ""
    },
    doSearch(category, keyword) {
      console.log(category, keyword)

      if(!keyword || keyword == "") {
        this.resetSearch()
      } else {
        this.limit = 0
        this.searchKeyword = keyword
        this.topicData = []

        const target = category == "내용" ? "uwasaKeyword" : category == "이름" ? "idolKeyword" : ""
        this.fetchUrl = `/api/idol/uwasa/pages/{limit}?${target}=${keyword}`
        this.infiniteId += 1
        
      }

    },
    doAllOrder(order) {

      this.resetSearch(order == "desc" ? true : order == "asc" ? false : false)

    },
    infiniteHandler($state) {
      const EACH_LEN = 30
      const fetchUrl = this.fetchUrl.replace("{limit}", this.limit)

      this.getTopicFromApi(fetchUrl).then(data => {
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