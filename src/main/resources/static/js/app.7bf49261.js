(function(t){function e(e){for(var a,i,s=e[0],c=e[1],l=e[2],p=0,d=[];p<s.length;p++)i=s[p],Object.prototype.hasOwnProperty.call(r,i)&&r[i]&&d.push(r[i][0]),r[i]=0;for(a in c)Object.prototype.hasOwnProperty.call(c,a)&&(t[a]=c[a]);u&&u(e);while(d.length)d.shift()();return o.push.apply(o,l||[]),n()}function n(){for(var t,e=0;e<o.length;e++){for(var n=o[e],a=!0,s=1;s<n.length;s++){var c=n[s];0!==r[c]&&(a=!1)}a&&(o.splice(e--,1),t=i(i.s=n[0]))}return t}var a={},r={app:0},o=[];function i(e){if(a[e])return a[e].exports;var n=a[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,i),n.l=!0,n.exports}i.m=t,i.c=a,i.d=function(t,e,n){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(i.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var a in t)i.d(n,a,function(e){return t[e]}.bind(null,a));return n},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],c=s.push.bind(s);s.push=e,s=s.slice();for(var l=0;l<s.length;l++)e(s[l]);var u=c;o.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"034f":function(t,e,n){"use strict";var a=n("85ec"),r=n.n(a);r.a},"0922":function(t,e,n){},2274:function(t,e,n){"use strict";var a=n("0922"),r=n.n(a);r.a},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("2b0e"),r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("Header",{attrs:{msg:t.welcomeMessage}}),n("router-view",{attrs:{msg:t.welcomeMessage}})],1)},o=[],i=(n("d3b7"),n("96cf"),n("1da1")),s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("nav",{staticClass:"nav"},[a("div",{staticClass:"nav-header"},[a("img",{attrs:{src:n("cf05")}}),t._v(" "),a("h2",[t._v(t._s(t.msg))])]),a("ul",[a("li",[a("router-link",{attrs:{to:"/"}},[t._v("소문 목록")])],1),a("li",[a("router-link",{attrs:{to:"/v/simple-list"}},[t._v("아이돌 리스트")])],1),a("li",[a("router-link",{attrs:{to:"/v/write-uwasa"}},[t._v("소문 등록")])],1)])])},c=[],l={name:"Header",props:["msg","logoSrc"]},u=l,p=(n("74d5"),n("2877")),d=Object(p["a"])(u,s,c,!1,null,"16e013dd",null),f=d.exports,m={name:"App",data:function(){return{welcomeMessage:"default msg",topicDataFromSuper:[]}},components:{Header:f},created:function(){var t=this;function e(){return n.apply(this,arguments)}function n(){return n=Object(i["a"])(regeneratorRuntime.mark((function t(){var e;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,fetch("/api/test/title",{method:"get"});case 2:return e=t.sent,t.abrupt("return",e.text());case 4:case"end":return t.stop()}}),t)}))),n.apply(this,arguments)}e().then((function(e){t.welcomeMessage=e}))}},v=m,h=(n("034f"),Object(p["a"])(v,r,o,!1,null,null,null)),g=h.exports,_=n("8c4f"),b=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"topic"},[n("audio",{attrs:{id:"tts-audio-main"}}),t._l(t.lineCarriagedTopicData,(function(e,a){return n("div",{key:a,staticClass:"each-row"},[n("div",{staticClass:"idol-name"},[n("a",{staticClass:"idol-link",attrs:{href:"/api/idol/redirect/"+e.idolNameJa,target:"_blank"}},[t._v(t._s(e.idolNameJa))])]),n("div",{staticClass:"topic-num"},[n("span",[t._v(t._s(e.topicNum))])]),n("div",{staticClass:"topic-content"},[n("p",{staticClass:"label-lang"},[t._v("Ja")]),n("p",{staticClass:"topic-ja"},[n("span",{domProps:{innerHTML:t._s(e.uwasaJa)}}),n("a",{staticClass:"btn-speech",attrs:{"data-name":e.idolNameJa,"data-num":e.topicNum},on:{click:function(e){return t.playTTS(e)}}},[t._v("🔊")])]),n("p",{staticClass:"label-lang"},[t._v("Ko")]),n("p",{staticClass:"topic-ko"},[n("span",{domProps:{innerHTML:t._s(e.uwasaKo)}})])])])})),n("infinite-loading",{attrs:{spinner:"waveDots"},on:{infinite:t.infiniteHandler}},[n("div",{staticStyle:{color:"rgb(102, 102, 102)","font-size":"14px",padding:"10px 0px"},attrs:{slot:"no-more"},slot:"no-more"},[t._v("목록의 끝입니다 :)")])])],2)},w=[],x=(n("99af"),n("d81d"),n("b0c0"),n("ac1f"),n("5319"),n("e166")),y=n.n(x),j={name:"Topic",data:function(){return{topicData:[],limit:1}},created:function(){var t=this;function e(){return n.apply(this,arguments)}function n(){return n=Object(i["a"])(regeneratorRuntime.mark((function t(){var e,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,fetch("/api/idol/uwasa/pages/0",{method:"GET"});case 3:return e=t.sent,t.next=6,e.json();case 6:return n=t.sent,t.abrupt("return",n);case 10:t.prev=10,t.t0=t["catch"](0),console.error(t.t0);case 13:case"end":return t.stop()}}),t,null,[[0,10]])}))),n.apply(this,arguments)}e().then((function(e){console.log("fromAPI",e),t.topicData=e}))},mounted:function(){},components:{InfiniteLoading:y.a},computed:{lineCarriagedTopicData:function(){var t=JSON.parse(JSON.stringify(this.topicData));return t.map((function(t){return t.uwasaJa=t.uwasaJa.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g,"<br>"),t.uwasaKo=t.uwasaKo.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g,"<br>"),t}))}},methods:{speak:function(t,e){if("undefined"!==typeof SpeechSynthesisUtterance&&"undefined"!==typeof window.speechSynthesis){window.speechSynthesis.cancel();var n=e||{},a=new SpeechSynthesisUtterance;a.rate=n.rate||1,a.pitch=n.pitch||1,a.lang=n.lang||"ko-KR",a.text=t,window.speechSynthesis.speak(a)}else alert("이 브라우저는 음성 합성을 지원하지 않습니다.")},playTTS:function(t){var e=t.currentTarget||t.target,n=e.dataset.name,a=e.dataset.num;console.log(e,e.dataset.name,e.dataset.num);var r=document.getElementById("tts-audio-main");r.src="/api/idol/tts/"+n+"/"+a,r.play()},infiniteHandler:function(t){var e=this,n=30;fetch("/api/idol/uwasa/pages/"+this.limit,{method:"get"}).then((function(t){return t.json()})).then((function(a){setTimeout((function(){a.length?(e.topicData=e.topicData.concat(a),t.loaded(),e.limit+=1,console.log("after",e.topicData.length,e.limit),a.length/n<1&&t.complete()):t.complete()}),1e3)})).catch((function(t){console.error(t)}))}}},C=j,O=(n("f300"),Object(p["a"])(C,b,w,!1,null,"08790639",null)),k=O.exports,S=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"hello"},[n("h1",[t._v(t._s(t.msg))])])},J=[],T={name:"HelloWorld",props:["msg"]},E=T,K=(n("2274"),Object(p["a"])(E,S,J,!1,null,"2725e315",null)),P=K.exports,$=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("table",{staticClass:"idol-list"},[t._m(0),n("tbody",t._l(t.idols,(function(e){return n("tr",{key:e.name},[n("td",[t._v(t._s(e.id))]),n("td",[t._v(t._s(e.name))]),n("td",[t._v(t._s(e.nameKo))])])})),0)])])},I=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("thead",[n("th",[t._v("No.")]),n("th",[t._v("이름")]),n("th",[t._v("이름 (한글)")])])}],N={data:function(){return{idols:[]}},created:function(){this.getIdol()},methods:{getIdol:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){var n,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,fetch("/api/idol/simple");case 2:return n=e.sent,e.next=5,n.json();case 5:return a=e.sent,e.next=8,a;case 8:t.idols=e.sent,console.log(a);case 10:case"end":return e.stop()}}),e)})))()}}},R=N,D=(n("7930"),Object(p["a"])(R,$,I,!1,null,"8bcedb2a",null)),M=D.exports,H=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("fieldset",[n("legend",[t._v(" 정보 입력 ")]),n("div",{staticClass:"form-group"},[n("label",[t._v("아이돌 선택: ")]),n("select",{directives:[{name:"model",rawName:"v-model",value:t.selectedIdol,expression:"selectedIdol"}],on:{change:function(e){var n=Array.prototype.filter.call(e.target.options,(function(t){return t.selected})).map((function(t){var e="_value"in t?t._value:t.value;return e}));t.selectedIdol=e.target.multiple?n:n[0]}}},t._l(t.idols,(function(e){return n("option",{key:e.id,domProps:{value:e.id}},[t._v(" "+t._s(e.nameKo+" ("+e.name+")"))])})),0)]),n("div",{staticClass:"form-group"},[n("label",[t._v("일본어 원문 입력: ")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.textJa,expression:"textJa"}],domProps:{value:t.textJa},on:{input:function(e){e.target.composing||(t.textJa=e.target.value)}}})]),t._m(0),n("div",{staticClass:"form-group"},[n("label",[t._v("한국어 번역 입력: ")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.textKo,expression:"textKo"}],domProps:{value:t.textKo},on:{input:function(e){e.target.composing||(t.textKo=e.target.value)}}})]),t._m(1),t._m(2),t._m(3),t._m(4)])])},L=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("button",[t._v("파파고 한국어 번역 제안")])])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"form-group"},[n("label",[t._v("일본어 원문 입력: ")]),n("textarea")])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"form-group"},[n("label",[t._v("소문 번호: ")]),n("input",{attrs:{type:"number",min:"1"}})])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"form-group"},[n("label",[t._v("오디오 파일 업로드: ")]),n("input",{attrs:{type:"file"}})])},function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"form-group"},[n("label",[t._v("임시 비밀번호 입력: ")]),n("input",{attrs:{type:"password"}})])}],A={data:function(){return{idols:[],selectedIdol:"",textJa:"",textKo:""}},created:function(){this.getIdol()},methods:{getIdol:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){var n,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,fetch("/api/idol/simple");case 2:return n=e.sent,e.next=5,n.json();case 5:return a=e.sent,e.next=8,a;case 8:t.idols=e.sent;case 9:case"end":return e.stop()}}),e)})))()},translate:function(){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){var n,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:n=t.textJa,a=t.textKo,console.log(n,a);case 3:case"end":return e.stop()}}),e)})))()}}},U=A,B=(n("dfdd"),Object(p["a"])(U,H,L,!1,null,"1781ba3a",null)),F=B.exports;a["a"].use(_["a"]);var W=new _["a"]({mode:"history",routes:[{path:"/",name:"Topic",component:k},{path:"/foo",name:"Foo",component:P},{path:"/bar",name:"Bar",component:P},{path:"/v/simple-list",name:"Idol Simple List",component:M},{path:"/v/write-uwasa",name:"Write Uwasa",component:F}]});a["a"].config.productionTip=!1,new a["a"]({router:W,render:function(t){return t(g)}}).$mount("#app")},"74d5":function(t,e,n){"use strict";var a=n("ccd9"),r=n.n(a);r.a},7930:function(t,e,n){"use strict";var a=n("c985"),r=n.n(a);r.a},8029:function(t,e,n){},"85ec":function(t,e,n){},"9bb4":function(t,e,n){},c985:function(t,e,n){},ccd9:function(t,e,n){},cf05:function(t,e,n){t.exports=n.p+"img/logo.3ef3e78a.png"},dfdd:function(t,e,n){"use strict";var a=n("8029"),r=n.n(a);r.a},f300:function(t,e,n){"use strict";var a=n("9bb4"),r=n.n(a);r.a}});
//# sourceMappingURL=app.7bf49261.js.map