(function(e){function t(t){for(var r,c,i=t[0],s=t[1],u=t[2],p=0,f=[];p<i.length;p++)c=i[p],Object.prototype.hasOwnProperty.call(a,c)&&a[c]&&f.push(a[c][0]),a[c]=0;for(r in s)Object.prototype.hasOwnProperty.call(s,r)&&(e[r]=s[r]);l&&l(t);while(f.length)f.shift()();return o.push.apply(o,u||[]),n()}function n(){for(var e,t=0;t<o.length;t++){for(var n=o[t],r=!0,i=1;i<n.length;i++){var s=n[i];0!==a[s]&&(r=!1)}r&&(o.splice(t--,1),e=c(c.s=n[0]))}return e}var r={},a={app:0},o=[];function c(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.m=e,c.c=r,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)c.d(n,r,function(t){return e[t]}.bind(null,r));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],s=i.push.bind(i);i.push=t,i=i.slice();for(var u=0;u<i.length;u++)t(i[u]);var l=s;o.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"034f":function(e,t,n){"use strict";var r=n("85ec"),a=n.n(r);a.a},"1eff":function(e,t,n){},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("img",{attrs:{alt:"Vue logo",src:n("cf05")}}),r("HelloWorld",{attrs:{msg:e.welcomeMessage}}),r("Topic",{attrs:{topicData:e.topicDataFromSuper}})],1)},o=[],c=(n("d3b7"),n("96cf"),n("1da1")),i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"hello"},[n("h1",[e._v(e._s(e.msg))])])},s=[],u={name:"HelloWorld",props:["msg"]},l=u,p=(n("c94c"),n("2877")),f=Object(p["a"])(l,i,s,!1,null,"7bf758b7",null),d=f.exports,h=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"topic"},e._l(e.getLineBreakedData,(function(t,r){return n("div",{key:r,staticClass:"each-row"},[n("div",{staticClass:"idol-name"},[n("a",{staticClass:"idol-link",attrs:{href:"/api/idol/redirect/"+t.idolNameJa,target:"_blank"}},[e._v(e._s(t.idolNameJa))])]),n("div",{staticClass:"topic-num"},[n("span",[e._v(e._s(t.topicNum))])]),n("div",{staticClass:"topic-content"},[n("p",{staticClass:"label-lang"},[e._v("Ja")]),n("p",{staticClass:"topic-ja"},[n("span",{domProps:{innerHTML:e._s(t.uwasaJa)}}),n("a",{staticClass:"btn-speech",on:{click:function(n){return e.getSpeechAudioFromServer(t.idolNameJa,t.topicNum)}}},[e._v("🔊")])]),n("p",{staticClass:"label-lang"},[e._v("Ko")]),n("p",{staticClass:"topic-ko"},[n("span",{domProps:{innerHTML:e._s(t.uwasaKo)}})])])])})),0)},m=[],g=(n("99af"),n("d81d"),n("ac1f"),n("3ca3"),n("5319"),n("ddb0"),n("2b3d"),{name:"Topic",props:["topicData"],data:function(){return{propTopicData:this.topicData}},mounted:function(){},computed:{getLineBreakedData:function(){var e=JSON.parse(JSON.stringify(this.topicData));return e.map((function(e){return e.uwasaJa=e.uwasaJa.replace(/(?:\\r\\n|\\r|\\n)/g,"<br>"),e.uwasaKo=e.uwasaKo.replace(/(?:\\r\\n|\\r|\\n)/g,"<br>"),e}))}},methods:{speak:function(e,t){if("undefined"!==typeof SpeechSynthesisUtterance&&"undefined"!==typeof window.speechSynthesis){window.speechSynthesis.cancel();var n=t||{},r=new SpeechSynthesisUtterance;r.rate=n.rate||1,r.pitch=n.pitch||1,r.lang=n.lang||"ko-KR",r.text=e,window.speechSynthesis.speak(r)}else alert("이 브라우저는 음성 합성을 지원하지 않습니다.")},getSpeechAudioFromServer:function(e,t){function n(){return r.apply(this,arguments)}function r(){return r=Object(c["a"])(regeneratorRuntime.mark((function n(){var r,a;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,fetch("/api/idol/tts/".concat(e,"/").concat(t),{method:"get"});case 2:return r=n.sent,n.next=5,r.blob();case 5:return a=n.sent,n.abrupt("return",a);case 7:case"end":return n.stop()}}),n)}))),r.apply(this,arguments)}n().then((function(e){console.log(e);var t=new Audio,n=URL.createObjectURL(e);t.src=n,console.log(t),t.play()}))}}}),v=g,b=(n("7695"),Object(p["a"])(v,h,m,!1,null,"7bdc4a54",null)),w=b.exports,y={name:"App",data:function(){return{welcomeMessage:"default msg",topicDataFromSuper:[]}},components:{HelloWorld:d,Topic:w},created:function(){var e=this;function t(){return n.apply(this,arguments)}function n(){return n=Object(c["a"])(regeneratorRuntime.mark((function e(){var t,n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,fetch("/api/idol/uwasa",{method:"GET"});case 3:return t=e.sent,e.next=6,t.json();case 6:return n=e.sent,e.abrupt("return",n);case 10:e.prev=10,e.t0=e["catch"](0),console.error(e.t0);case 13:case"end":return e.stop()}}),e,null,[[0,10]])}))),n.apply(this,arguments)}fetch("/api/test/title",{method:"get"}).then((function(e){var t=e.text();return console.log(e),t})).then((function(t){console.log("fetch: "+t),e.welcomeMessage=t})).catch((function(t){console.log(t),e.welcomeMessage="Error"})),t().then((function(t){console.log("fromAPI",t),e.topicDataFromSuper=t}))}},_=y,S=(n("034f"),Object(p["a"])(_,a,o,!1,null,null,null)),O=S.exports;r["a"].config.productionTip=!1,new r["a"]({render:function(e){return e(O)}}).$mount("#app")},"6ca9":function(e,t,n){},7695:function(e,t,n){"use strict";var r=n("6ca9"),a=n.n(r);a.a},"85ec":function(e,t,n){},c94c:function(e,t,n){"use strict";var r=n("1eff"),a=n.n(r);a.a},cf05:function(e,t,n){e.exports=n.p+"img/logo.7c5310a9.png"}});
//# sourceMappingURL=app.e751b1ec.js.map