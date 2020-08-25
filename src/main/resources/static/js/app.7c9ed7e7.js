(function(e){function t(t){for(var a,o,s=t[0],c=t[1],l=t[2],p=0,d=[];p<s.length;p++)o=s[p],Object.prototype.hasOwnProperty.call(r,o)&&r[o]&&d.push(r[o][0]),r[o]=0;for(a in c)Object.prototype.hasOwnProperty.call(c,a)&&(e[a]=c[a]);u&&u(t);while(d.length)d.shift()();return i.push.apply(i,l||[]),n()}function n(){for(var e,t=0;t<i.length;t++){for(var n=i[t],a=!0,s=1;s<n.length;s++){var c=n[s];0!==r[c]&&(a=!1)}a&&(i.splice(t--,1),e=o(o.s=n[0]))}return e}var a={},r={app:0},i=[];function o(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,o),n.l=!0,n.exports}o.m=e,o.c=a,o.d=function(e,t,n){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(o.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)o.d(n,a,function(t){return e[t]}.bind(null,a));return n},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],c=s.push.bind(s);s.push=t,s=s.slice();for(var l=0;l<s.length;l++)t(s[l]);var u=c;i.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"034f":function(e,t,n){"use strict";var a=n("85ec"),r=n.n(a);r.a},"0546":function(e,t,n){"use strict";var a=n("df13"),r=n.n(a);r.a},"0922":function(e,t,n){},2274:function(e,t,n){"use strict";var a=n("0922"),r=n.n(a);r.a},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("2b0e"),r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("Header",{attrs:{msg:e.welcomeMessage}}),n("router-view",{attrs:{msg:e.welcomeMessage}})],1)},i=[],o=(n("d3b7"),n("96cf"),n("1da1")),s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("nav",{staticClass:"nav"},[a("div",{staticClass:"nav-header"},[a("img",{attrs:{src:n("cf05")}}),e._v(" "),a("h2",[e._v(e._s(e.msg))])]),a("ul",[a("li",[a("router-link",{attrs:{to:"/"}},[e._v("소문 목록")])],1),a("li",[a("router-link",{attrs:{to:"/v/simple-list"}},[e._v("아이돌 리스트")])],1),a("li",[a("router-link",{attrs:{to:"/v/write-uwasa"}},[e._v("소문 등록")])],1)])])},c=[],l={name:"Header",props:["msg","logoSrc"]},u=l,p=(n("74d5"),n("2877")),d=Object(p["a"])(u,s,c,!1,null,"16e013dd",null),f=d.exports,m={name:"App",data:function(){return{welcomeMessage:"default msg",topicDataFromSuper:[]}},components:{Header:f},created:function(){var e=this;function t(){return n.apply(this,arguments)}function n(){return n=Object(o["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,fetch("/api/test/title",{method:"get"});case 2:return t=e.sent,e.abrupt("return",t.text());case 4:case"end":return e.stop()}}),e)}))),n.apply(this,arguments)}t().then((function(t){e.welcomeMessage=t}))}},v=m,h=(n("034f"),Object(p["a"])(v,r,i,!1,null,null,null)),g=h.exports,w=n("8c4f"),_=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"topic"},[n("audio",{attrs:{id:"tts-audio-main"}}),n("TopicSearch",{on:{search:e.doSearch}}),e._l(e.lineCarriagedTopicData,(function(t,a){return n("div",{key:a,staticClass:"each-row"},[n("div",{staticClass:"idol-name"},[n("p",[e._v(e._s(t.idol.nameKo)),n("br"),n("a",{staticClass:"idol-link",attrs:{href:"/api/idol/redirect/"+t.idol.name,target:"_blank"}},[e._v(e._s(t.idol.name))])])]),n("div",{staticClass:"topic-num"},[n("span",[e._v(e._s(t.topicNum))])]),n("div",{staticClass:"topic-content"},[n("p",{staticClass:"label-lang"},[e._v("Ja")]),n("p",{staticClass:"topic-ja"},[n("span",{domProps:{innerHTML:e._s(t.uwasaJa)}}),n("a",{staticClass:"btn-speech",attrs:{"data-id":t.id,"data-name":t.idolNameJa,"data-num":t.topicNum},on:{click:function(t){return e.playTTS(t)}}},[e._v("🔊")])]),n("p",{staticClass:"label-lang"},[e._v("Ko")]),n("p",{staticClass:"topic-ko"},[n("span",{domProps:{innerHTML:e._s(t.uwasaKo)}})])])])})),n("infinite-loading",{attrs:{identifier:e.infiniteId,spinner:"waveDots"},on:{infinite:e.infiniteHandler}},[n("div",{staticStyle:{color:"rgb(102, 102, 102)","font-size":"14px",padding:"10px 0px"},attrs:{slot:"no-more"},slot:"no-more"},[e._v("목록의 끝입니다 :)")])])],2)},y=[],x=(n("99af"),n("d81d"),n("4d63"),n("ac1f"),n("25f0"),n("5319"),n("e166")),b=n.n(x),C=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"search-box"},[n("div",{staticClass:"form-group"},[n("select",{directives:[{name:"model",rawName:"v-model",value:e.searchCategory,expression:"searchCategory"}],on:{change:function(t){var n=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.searchCategory=t.target.multiple?n:n[0]}}},[n("option",{attrs:{selected:""}},[e._v("내용")])]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.searchKeyword,expression:"searchKeyword"}],attrs:{type:"text"},domProps:{value:e.searchKeyword},on:{keypress:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.search(t)},input:function(t){t.target.composing||(e.searchKeyword=t.target.value)}}}),n("button",{on:{click:e.search}},[e._v("검색")]),n("button",{on:{click:e.searchReset}},[e._v("초기화")])])])},k=[],K={data:function(){return{searchCategory:"내용",searchKeyword:""}},methods:{search:function(){this.$emit("search",this.searchCategory,this.searchKeyword)},searchReset:function(){this.$emit("search",this.searchCategory,"")}}},O=K,S=(n("0546"),Object(p["a"])(O,C,k,!1,null,"44d01773",null)),j=S.exports,N={name:"Topic",data:function(){return{topicData:[],limit:0,fetchUrl:"/api/idol/uwasa/pages/{limit}",searchKeyword:"",infiniteId:+new Date}},created:function(){},mounted:function(){},components:{InfiniteLoading:b.a,TopicSearch:j},computed:{lineCarriagedTopicData:function(){var e=JSON.parse(JSON.stringify(this.topicData)),t=this.searchKeyword,n=new RegExp(t,"ig");return console.log("현재 검색어  ",t),e.map((function(e){return e.uwasaJa=e.uwasaJa.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g,"<br>"),e.uwasaKo=e.uwasaKo.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g,"<br>"),t&&""!=t&&(e.uwasaJa=e.uwasaJa.replace(n,"<span class='search-highlight'>"+t+"</span>"),e.uwasaKo=e.uwasaKo.replace(n,"<span class='search-highlight'>"+t+"</span>")),e}))}},methods:{getTopicFromApi:function(e){return Object(o["a"])(regeneratorRuntime.mark((function t(){var n,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,fetch(e,{method:"GET"});case 3:return n=t.sent,t.next=6,n.json();case 6:return a=t.sent,t.abrupt("return",a);case 10:t.prev=10,t.t0=t["catch"](0),console.error(t.t0);case 13:case"end":return t.stop()}}),t,null,[[0,10]])})))()},speak:function(e,t){if("undefined"!==typeof SpeechSynthesisUtterance&&"undefined"!==typeof window.speechSynthesis){window.speechSynthesis.cancel();var n=t||{},a=new SpeechSynthesisUtterance;a.rate=n.rate||1,a.pitch=n.pitch||1,a.lang=n.lang||"ko-KR",a.text=e,window.speechSynthesis.speak(a)}else alert("이 브라우저는 음성 합성을 지원하지 않습니다.")},playTTS:function(e){var t=e.currentTarget||e.target,n=t.dataset.id;console.log(t,t.dataset);var a=document.getElementById("tts-audio-main");a.src="/api/idol/tts/"+n,a.play()},resetSearch:function(){this.limit=0,this.fetchUrl="/api/idol/uwasa/pages/{limit}",this.topicData=[],this.infiniteId+=1,this.searchKeyword=""},doSearch:function(e,t){console.log(e,t);var n=this,a={"내용":function(){t&&""!=t?(n.limit=0,n.searchKeyword=t,n.topicData=[],n.fetchUrl="/api/idol/uwasa/pages/{limit}?uwasaKeyword=".concat(t),n.infiniteId+=1):n.resetSearch()}};a[e]()},infiniteHandler:function(e){var t=this,n=30,a=this.fetchUrl.replace("{limit}",this.limit);this.getTopicFromApi(a).then((function(a){setTimeout((function(){a.length?(t.topicData=t.topicData.concat(a),e.loaded(),t.limit+=1,console.log("after",t.topicData.length,t.limit),a.length/n<1&&e.complete()):e.complete()}),1e3)})).catch((function(e){console.error(e)}))}}},J=N,T=(n("cd6a"),Object(p["a"])(J,_,y,!1,null,"4fe1e6f6",null)),I=T.exports,H=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"hello"},[n("h1",[e._v(e._s(e.msg))])])},R=[],P={name:"HelloWorld",props:["msg"]},D=P,E=(n("2274"),Object(p["a"])(D,H,R,!1,null,"2725e315",null)),F=E.exports,$=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("table",{staticClass:"idol-list"},[e._m(0),n("tbody",e._l(e.idols,(function(t){return n("tr",{key:t.name},[n("td",[e._v(e._s(t.id))]),n("td",[e._v(e._s(t.name))]),n("td",[e._v(e._s(t.nameKo))])])})),0)])])},M=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("thead",[n("th",[e._v("No.")]),n("th",[e._v("이름")]),n("th",[e._v("이름 (한글)")])])}],A={data:function(){return{idols:[]}},created:function(){this.getIdol()},methods:{getIdol:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var n,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("/api/idol/simple");case 2:return n=t.sent,t.next=5,n.json();case 5:return a=t.sent,t.next=8,a;case 8:e.idols=t.sent,console.log(a);case 10:case"end":return t.stop()}}),t)})))()}}},B=A,U=(n("7930"),Object(p["a"])(B,$,M,!1,null,"8bcedb2a",null)),L=U.exports,z=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("fieldset",[n("legend",[e._v(" 정보 입력 ")]),n("div",{staticClass:"form-group"},[n("label",[e._v("아이돌 선택: ")]),n("select",{directives:[{name:"model",rawName:"v-model",value:e.selectedIdol,expression:"selectedIdol"}],on:{change:function(t){var n=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.selectedIdol=t.target.multiple?n:n[0]}}},e._l(e.idols,(function(t){return n("option",{key:t.id,domProps:{value:t.id}},[e._v(" "+e._s(t.nameKo+" ("+t.name+")"))])})),0)]),n("div",{staticClass:"form-group"},[n("label",[e._v("일본어 원문 입력: ")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:e.textJa,expression:"textJa"}],domProps:{value:e.textJa},on:{input:function(t){t.target.composing||(e.textJa=t.target.value)}}})]),n("div",[n("button",{on:{click:e.translate}},[e._v("파파고 한국어 번역 제안")])]),n("div",{staticClass:"form-group"},[n("label",[e._v("한국어 번역 입력: ")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:e.textKo,expression:"textKo"}],domProps:{value:e.textKo},on:{input:function(t){t.target.composing||(e.textKo=t.target.value)}}})]),n("div",{staticClass:"form-group"},[n("label",[e._v("소문 번호: ")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.topicNum,expression:"topicNum"}],attrs:{type:"number",min:"1"},domProps:{value:e.topicNum},on:{input:function(t){t.target.composing||(e.topicNum=t.target.value)}}})]),n("div",{staticClass:"form-group"},[n("label",[e._v("오디오 파일 업로드: ")]),n("input",{attrs:{type:"file"},on:{change:e.handleFile}})]),n("div",{staticClass:"form-group"},[n("label",[e._v("임시 비밀번호 입력: ")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.tempHash,expression:"tempHash"}],attrs:{type:"password"},domProps:{value:e.tempHash},on:{input:function(t){t.target.composing||(e.tempHash=t.target.value)}}})]),n("div",{staticClass:"form-group"},[n("button",{on:{click:e.sendData}},[e._v("전송")])])]),e._m(0)])},W=[function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"convert-instruction"},[n("h4",[e._v("오디오 파일 변환방법")]),n("p",[e._v("1. Shell Script 작성")]),n("pre",[n("code",[e._v('#!/bin/bash\n        say -v Kyoko -o [파일이름].aiff "[일본어 원문]"')])]),n("p",[e._v("2. AIFF 파일을 mp3로 변환 (MediaHuman Converter)")])])}],G=(n("c975"),{data:function(){return{idols:[],selectedIdol:1,textJa:"",textKo:"",topicNum:0,tempHash:"",ttsFileBase64:null}},created:function(){this.getIdol()},methods:{getIdol:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var n,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("/api/idol/simple");case 2:return n=t.sent,t.next=5,n.json();case 5:return a=t.sent,t.next=8,a;case 8:e.idols=t.sent;case 9:case"end":return t.stop()}}),t)})))()},translate:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var n,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:n=e.textJa,a=e.textKo,console.log(n,a),alert("준비중");case 4:case"end":return t.stop()}}),t)})))()},handleFile:function(e){var t=this;console.log(e.target.files);var n=e.target.files;if(n.length>0){var a=e.target.files[0];if("audio/mpeg"!=a.type||a.size>3e5)return alert("파일이 mp3가 아니거나 사이즈가 너무 큽니다."),!1;var r=new FileReader;r.addEventListener("load",(function(){var e=r.result.indexOf(",")+1,n=r.result.substring(e,r.result.length);console.log(n.length),t.ttsFileBase64=n}),!1),r.readAsDataURL(a)}},sendData:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var n,a,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.selectedIdol||!e.textKo||!e.textJa||!e.tempHash||e.ttsFileBase64,e.topicNum){t.next=3;break}return alert("빈 칸이 있습니다."),t.abrupt("return",!1);case 3:return n={idolId:e.selectedIdol,uwasaJa:e.textJa,uwasaKo:e.textKo,ttsAudioBase64:e.ttsFileBase64,tempHash:e.tempHash,topicNum:e.topicNum},console.log(n),t.next=7,fetch("/api/idol/uwasa",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(n)});case 7:return a=t.sent,t.next=10,a.json();case 10:r=t.sent,-9999==r.uwasaId?alert("비밀번호가 틀립니다."):(alert("데이터가 입력되었습니다.\n"+JSON.stringify(r)),e.selectedIdol=1,e.textJa="",e.textKo="",e.topicNum=0,e.tempHash="",e.ttsFileBase64=null);case 12:case"end":return t.stop()}}),t)})))()}}}),q=G,Q=(n("5c74"),Object(p["a"])(q,z,W,!1,null,"0b3538e9",null)),V=Q.exports;a["a"].use(w["a"]);var X=new w["a"]({mode:"history",routes:[{path:"/",name:"Topic",component:I},{path:"/foo",name:"Foo",component:F},{path:"/bar",name:"Bar",component:F},{path:"/v/simple-list",name:"Idol Simple List",component:L},{path:"/v/write-uwasa",name:"Write Uwasa",component:V}]});a["a"].config.productionTip=!1,new a["a"]({router:X,render:function(e){return e(g)}}).$mount("#app")},"5c74":function(e,t,n){"use strict";var a=n("6352"),r=n.n(a);r.a},6352:function(e,t,n){},"6e83":function(e,t,n){},"74d5":function(e,t,n){"use strict";var a=n("ccd9"),r=n.n(a);r.a},7930:function(e,t,n){"use strict";var a=n("c985"),r=n.n(a);r.a},"85ec":function(e,t,n){},c985:function(e,t,n){},ccd9:function(e,t,n){},cd6a:function(e,t,n){"use strict";var a=n("6e83"),r=n.n(a);r.a},cf05:function(e,t,n){e.exports=n.p+"img/logo.3ef3e78a.png"},df13:function(e,t,n){}});
//# sourceMappingURL=app.7c9ed7e7.js.map