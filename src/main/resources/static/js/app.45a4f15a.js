(function(e){function t(t){for(var n,o,s=t[0],c=t[1],l=t[2],p=0,d=[];p<s.length;p++)o=s[p],Object.prototype.hasOwnProperty.call(r,o)&&r[o]&&d.push(r[o][0]),r[o]=0;for(n in c)Object.prototype.hasOwnProperty.call(c,n)&&(e[n]=c[n]);u&&u(t);while(d.length)d.shift()();return i.push.apply(i,l||[]),a()}function a(){for(var e,t=0;t<i.length;t++){for(var a=i[t],n=!0,s=1;s<a.length;s++){var c=a[s];0!==r[c]&&(n=!1)}n&&(i.splice(t--,1),e=o(o.s=a[0]))}return e}var n={},r={app:0},i=[];function o(t){if(n[t])return n[t].exports;var a=n[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,o),a.l=!0,a.exports}o.m=e,o.c=n,o.d=function(e,t,a){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(o.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)o.d(a,n,function(t){return e[t]}.bind(null,n));return a},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],c=s.push.bind(s);s.push=t,s=s.slice();for(var l=0;l<s.length;l++)t(s[l]);var u=c;i.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"034f":function(e,t,a){"use strict";var n=a("85ec"),r=a.n(n);r.a},"0922":function(e,t,a){},2274:function(e,t,a){"use strict";var n=a("0922"),r=a.n(n);r.a},"3e43":function(e,t,a){"use strict";var n=a("82c1"),r=a.n(n);r.a},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var n=a("2b0e"),r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("Header",{attrs:{msg:e.welcomeMessage}}),a("router-view",{attrs:{msg:e.welcomeMessage}})],1)},i=[],o=(a("d3b7"),a("96cf"),a("1da1")),s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("nav",{staticClass:"nav"},[n("div",{staticClass:"nav-header"},[n("img",{attrs:{src:a("cf05")}}),e._v(" "),n("h2",[e._v(e._s(e.msg))])]),n("ul",[n("li",[n("router-link",{attrs:{to:"/"}},[e._v("소문 목록")])],1),n("li",[n("router-link",{attrs:{to:"/v/simple-list"}},[e._v("아이돌 리스트")])],1),n("li",[n("router-link",{attrs:{to:"/v/write-uwasa"}},[e._v("소문 등록")])],1)])])},c=[],l={name:"Header",props:["msg","logoSrc"]},u=l,p=(a("74d5"),a("2877")),d=Object(p["a"])(u,s,c,!1,null,"16e013dd",null),m=d.exports,f={name:"App",data:function(){return{welcomeMessage:"default msg",topicDataFromSuper:[]}},components:{Header:m},created:function(){var e=this;function t(){return a.apply(this,arguments)}function a(){return a=Object(o["a"])(regeneratorRuntime.mark((function e(){var t;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,fetch("/api/test/title",{method:"get"});case 2:return t=e.sent,e.abrupt("return",t.text());case 4:case"end":return e.stop()}}),e)}))),a.apply(this,arguments)}t().then((function(t){e.welcomeMessage=t,document.title=t}))}},v=f,h=(a("034f"),Object(p["a"])(v,r,i,!1,null,null,null)),g=h.exports,w=a("8c4f"),_=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"topic"},[a("audio",{attrs:{id:"tts-audio-main"}}),a("TopicSearch",{on:{search:e.doSearch,allOrder:e.doAllOrder}}),e._l(e.lineCarriagedTopicData,(function(t,n){return a("div",{key:n,staticClass:"each-row"},[a("div",{staticClass:"idol-name"},[a("p",[e._v(e._s(t.idol.nameKo)),a("br"),a("a",{staticClass:"idol-link",attrs:{href:"/api/idol/redirect/"+t.idol.name,target:"_blank"}},[e._v(e._s(t.idol.name))])])]),a("div",{staticClass:"topic-num"},[a("span",[e._v(e._s(t.topicNum))])]),a("div",{staticClass:"topic-content"},[a("p",{staticClass:"label-lang"},[e._v("Ja")]),a("p",{staticClass:"topic-ja"},[a("span",{domProps:{innerHTML:e._s(t.uwasaJa)}}),a("a",{staticClass:"btn-speech",attrs:{"data-id":t.id,"data-name":t.idolNameJa,"data-num":t.topicNum},on:{click:function(t){return e.playTTS(t)}}},[e._v("🔊")])]),a("p",{staticClass:"label-lang"},[e._v("Ko")]),a("p",{staticClass:"topic-ko"},[a("span",{domProps:{innerHTML:e._s(t.uwasaKo)}})])])])})),a("infinite-loading",{attrs:{identifier:e.infiniteId,spinner:"waveDots"},on:{infinite:e.infiniteHandler}},[a("div",{staticStyle:{color:"rgb(102, 102, 102)","font-size":"14px",padding:"10px 0px"},attrs:{slot:"no-more"},slot:"no-more"},[e._v("목록의 끝입니다 :)")])])],2)},y=[],b=(a("99af"),a("d81d"),a("4d63"),a("ac1f"),a("25f0"),a("5319"),a("e166")),x=a.n(b),O=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"search-box"},[a("div",{staticClass:"form-group order"},[a("label",[e._v("전체 정렬")]),a("select",{directives:[{name:"model",rawName:"v-model",value:e.allOrderStatus,expression:"allOrderStatus"}],on:{change:[function(t){var a=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.allOrderStatus=t.target.multiple?a:a[0]},e.allOrder]}},[a("option",{attrs:{disabled:"",value:"no"}},[e._v("-- 전체 목록 정렬 --")]),a("option",{attrs:{selected:"",value:"asc"}},[e._v("오름차순")]),a("option",{attrs:{value:"desc"}},[e._v("내림차순")])])]),a("div",{staticClass:"form-group search"},[a("label",[e._v("소문 검색")]),a("select",{directives:[{name:"model",rawName:"v-model",value:e.searchCategory,expression:"searchCategory"}],on:{change:function(t){var a=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.searchCategory=t.target.multiple?a:a[0]}}},[a("option",{attrs:{selected:"",value:"내용"}},[e._v("소문 내용")]),a("option",{attrs:{value:"이름"}},[e._v("아이돌 이름")])]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.searchKeyword,expression:"searchKeyword"}],attrs:{type:"text"},domProps:{value:e.searchKeyword},on:{keypress:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.search(t)},input:function(t){t.target.composing||(e.searchKeyword=t.target.value)}}}),a("button",{on:{click:e.search}},[e._v("검색")]),a("button",{on:{click:e.searchReset}},[e._v("초기화")])])])},C=[],S={data:function(){return{searchCategory:"내용",searchKeyword:"",allOrderStatus:"asc"}},methods:{search:function(){this.$emit("search",this.searchCategory,this.searchKeyword)},searchReset:function(){this.$emit("search",this.searchCategory,"")},allOrder:function(){this.$emit("allOrder",this.allOrderStatus)}}},k=S,K=(a("3e43"),Object(p["a"])(k,O,C,!1,null,"7103871d",null)),j=K.exports,N={name:"Topic",data:function(){return{topicData:[],limit:0,fetchUrl:"/api/idol/uwasa/pages/{limit}",searchKeyword:"",infiniteId:+new Date}},created:function(){},mounted:function(){},components:{InfiniteLoading:x.a,TopicSearch:j},computed:{lineCarriagedTopicData:function(){var e=JSON.parse(JSON.stringify(this.topicData)),t=this.searchKeyword,a=new RegExp(t,"ig");return console.log("현재 검색어  ",t),e.map((function(e){return e.uwasaJa=e.uwasaJa.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g,"<br>"),e.uwasaKo=e.uwasaKo.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g,"<br>"),t&&""!=t&&(e.uwasaJa=e.uwasaJa.replace(a,"<span class='search-highlight'>"+t+"</span>"),e.uwasaKo=e.uwasaKo.replace(a,"<span class='search-highlight'>"+t+"</span>")),e}))}},methods:{getTopicFromApi:function(e){return Object(o["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,fetch(e,{method:"GET"});case 3:return a=t.sent,t.next=6,a.json();case 6:return n=t.sent,t.abrupt("return",n);case 10:t.prev=10,t.t0=t["catch"](0),console.error(t.t0);case 13:case"end":return t.stop()}}),t,null,[[0,10]])})))()},speak:function(e,t){if("undefined"!==typeof SpeechSynthesisUtterance&&"undefined"!==typeof window.speechSynthesis){window.speechSynthesis.cancel();var a=t||{},n=new SpeechSynthesisUtterance;n.rate=a.rate||1,n.pitch=a.pitch||1,n.lang=a.lang||"ko-KR",n.text=e,window.speechSynthesis.speak(n)}else alert("이 브라우저는 음성 합성을 지원하지 않습니다.")},playTTS:function(e){var t=e.currentTarget||e.target,a=t.dataset.id;console.log(t,t.dataset);var n=document.getElementById("tts-audio-main");n.src="/api/idol/tts/"+a,n.play()},resetSearch:function(e){this.limit=0,this.fetchUrl="/api/idol/uwasa/pages/{limit}"+(e?"?reverseAll=true":""),this.topicData=[],this.infiniteId+=1,this.searchKeyword=""},doSearch:function(e,t){if(console.log(e,t),t&&""!=t){this.limit=0,this.searchKeyword=t,this.topicData=[];var a="내용"==e?"uwasaKeyword":"이름"==e?"idolKeyword":"";this.fetchUrl="/api/idol/uwasa/pages/{limit}?".concat(a,"=").concat(t),this.infiniteId+=1}else this.resetSearch()},doAllOrder:function(e){this.resetSearch("desc"==e)},infiniteHandler:function(e){var t=this,a=30,n=this.fetchUrl.replace("{limit}",this.limit);this.getTopicFromApi(n).then((function(n){setTimeout((function(){n.length?(t.topicData=t.topicData.concat(n),e.loaded(),t.limit+=1,console.log("after",t.topicData.length,t.limit),n.length/a<1&&e.complete()):e.complete()}),1e3)})).catch((function(e){console.error(e)}))}}},J=N,T=(a("9cd7"),Object(p["a"])(J,_,y,!1,null,"28c85753",null)),I=T.exports,H=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"hello"},[a("h1",[e._v(e._s(e.msg))])])},R=[],P={name:"HelloWorld",props:["msg"]},D=P,E=(a("2274"),Object(p["a"])(D,H,R,!1,null,"2725e315",null)),F=E.exports,$=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("table",{staticClass:"idol-list"},[e._m(0),a("tbody",e._l(e.idols,(function(t){return a("tr",{key:t.name},[a("td",[e._v(e._s(t.id))]),a("td",[e._v(e._s(t.name))]),a("td",[e._v(e._s(t.nameKo))])])})),0)])])},A=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("thead",[a("th",[e._v("No.")]),a("th",[e._v("이름")]),a("th",[e._v("이름 (한글)")])])}],M={data:function(){return{idols:[]}},created:function(){this.getIdol()},methods:{getIdol:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("/api/idol/simple");case 2:return a=t.sent,t.next=5,a.json();case 5:return n=t.sent,t.next=8,n;case 8:e.idols=t.sent,console.log(n);case 10:case"end":return t.stop()}}),t)})))()}}},B=M,U=(a("7930"),Object(p["a"])(B,$,A,!1,null,"8bcedb2a",null)),L=U.exports,z=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("fieldset",[a("legend",[e._v(" 정보 입력 ")]),a("div",{staticClass:"form-group"},[a("label",[e._v("아이돌 선택: ")]),a("select",{directives:[{name:"model",rawName:"v-model",value:e.selectedIdol,expression:"selectedIdol"}],on:{change:function(t){var a=Array.prototype.filter.call(t.target.options,(function(e){return e.selected})).map((function(e){var t="_value"in e?e._value:e.value;return t}));e.selectedIdol=t.target.multiple?a:a[0]}}},e._l(e.idols,(function(t){return a("option",{key:t.id,domProps:{value:t.id}},[e._v(" "+e._s(t.nameKo+" ("+t.name+")"))])})),0)]),a("div",{staticClass:"form-group"},[a("label",[e._v("일본어 원문 입력: ")]),a("textarea",{directives:[{name:"model",rawName:"v-model",value:e.textJa,expression:"textJa"}],domProps:{value:e.textJa},on:{input:function(t){t.target.composing||(e.textJa=t.target.value)}}})]),a("div",[a("button",{on:{click:e.translate}},[e._v("파파고 한국어 번역 제안")])]),a("div",{staticClass:"form-group"},[a("label",[e._v("한국어 번역 입력: ")]),a("textarea",{directives:[{name:"model",rawName:"v-model",value:e.textKo,expression:"textKo"}],domProps:{value:e.textKo},on:{input:function(t){t.target.composing||(e.textKo=t.target.value)}}})]),a("div",{staticClass:"form-group"},[a("label",[e._v("소문 번호: ")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.topicNum,expression:"topicNum"}],attrs:{type:"number",min:"1"},domProps:{value:e.topicNum},on:{input:function(t){t.target.composing||(e.topicNum=t.target.value)}}})]),a("div",{staticClass:"form-group"},[a("label",[e._v("오디오 파일 업로드: ")]),a("input",{attrs:{type:"file"},on:{change:e.handleFile}})]),a("div",{staticClass:"form-group"},[a("label",[e._v("임시 비밀번호 입력: ")]),a("input",{directives:[{name:"model",rawName:"v-model",value:e.tempHash,expression:"tempHash"}],attrs:{type:"password"},domProps:{value:e.tempHash},on:{input:function(t){t.target.composing||(e.tempHash=t.target.value)}}})]),a("div",{staticClass:"form-group"},[a("button",{on:{click:e.sendData}},[e._v("전송")])])]),e._m(0)])},W=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"convert-instruction"},[a("h4",[e._v("오디오 파일 변환방법")]),a("p",[e._v("1. Shell Script 작성")]),a("pre",[a("code",[e._v('#!/bin/bash\n        say -v Kyoko -o [파일이름].aiff "[일본어 원문]"')])]),a("p",[e._v("2. AIFF 파일을 mp3로 변환 (MediaHuman Converter)")])])}],G=(a("c975"),{data:function(){return{idols:[],selectedIdol:1,textJa:"",textKo:"",topicNum:0,tempHash:"",ttsFileBase64:null}},created:function(){this.getIdol()},methods:{getIdol:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("/api/idol/simple");case 2:return a=t.sent,t.next=5,a.json();case 5:return n=t.sent,t.next=8,n;case 8:e.idols=t.sent;case 9:case"end":return t.stop()}}),t)})))()},translate:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:a=e.textJa,n=e.textKo,console.log(a,n),alert("준비중");case 4:case"end":return t.stop()}}),t)})))()},handleFile:function(e){var t=this;console.log(e.target.files);var a=e.target.files;if(a.length>0){var n=e.target.files[0];if("audio/mpeg"!=n.type||n.size>3e5)return alert("파일이 mp3가 아니거나 사이즈가 너무 큽니다."),!1;var r=new FileReader;r.addEventListener("load",(function(){var e=r.result.indexOf(",")+1,a=r.result.substring(e,r.result.length);console.log(a.length),t.ttsFileBase64=a}),!1),r.readAsDataURL(n)}},sendData:function(){var e=this;return Object(o["a"])(regeneratorRuntime.mark((function t(){var a,n,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.selectedIdol||!e.textKo||!e.textJa||!e.tempHash||e.ttsFileBase64,e.topicNum){t.next=3;break}return alert("빈 칸이 있습니다."),t.abrupt("return",!1);case 3:return a={idolId:e.selectedIdol,uwasaJa:e.textJa,uwasaKo:e.textKo,ttsAudioBase64:e.ttsFileBase64,tempHash:e.tempHash,topicNum:e.topicNum},console.log(a),t.next=7,fetch("/api/idol/uwasa",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(a)});case 7:return n=t.sent,t.next=10,n.json();case 10:r=t.sent,-9999==r.uwasaId?alert("비밀번호가 틀립니다."):(alert("데이터가 입력되었습니다.\n"+JSON.stringify(r)),e.selectedIdol=1,e.textJa="",e.textKo="",e.topicNum=0,e.tempHash="",e.ttsFileBase64=null);case 12:case"end":return t.stop()}}),t)})))()}}}),q=G,Q=(a("5c74"),Object(p["a"])(q,z,W,!1,null,"0b3538e9",null)),V=Q.exports;n["a"].use(w["a"]);var X=new w["a"]({mode:"history",routes:[{path:"/",name:"Topic",component:I},{path:"/foo",name:"Foo",component:F},{path:"/bar",name:"Bar",component:F},{path:"/v/simple-list",name:"Idol Simple List",component:L},{path:"/v/write-uwasa",name:"Write Uwasa",component:V}]});n["a"].config.productionTip=!1,new n["a"]({router:X,render:function(e){return e(g)}}).$mount("#app")},"5c74":function(e,t,a){"use strict";var n=a("6352"),r=a.n(n);r.a},6352:function(e,t,a){},"74d5":function(e,t,a){"use strict";var n=a("ccd9"),r=a.n(n);r.a},7930:function(e,t,a){"use strict";var n=a("c985"),r=a.n(n);r.a},"82c1":function(e,t,a){},"85ec":function(e,t,a){},"8e07":function(e,t,a){},"9cd7":function(e,t,a){"use strict";var n=a("8e07"),r=a.n(n);r.a},c985:function(e,t,a){},ccd9:function(e,t,a){},cf05:function(e,t,a){e.exports=a.p+"img/logo.3ef3e78a.png"}});
//# sourceMappingURL=app.45a4f15a.js.map