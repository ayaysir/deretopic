(function(e){function t(t){for(var a,c,s=t[0],i=t[1],l=t[2],p=0,f=[];p<s.length;p++)c=s[p],Object.prototype.hasOwnProperty.call(r,c)&&r[c]&&f.push(r[c][0]),r[c]=0;for(a in i)Object.prototype.hasOwnProperty.call(i,a)&&(e[a]=i[a]);u&&u(t);while(f.length)f.shift()();return o.push.apply(o,l||[]),n()}function n(){for(var e,t=0;t<o.length;t++){for(var n=o[t],a=!0,s=1;s<n.length;s++){var i=n[s];0!==r[i]&&(a=!1)}a&&(o.splice(t--,1),e=c(c.s=n[0]))}return e}var a={},r={app:0},o=[];function c(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.m=e,c.c=a,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)c.d(n,a,function(t){return e[t]}.bind(null,a));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],i=s.push.bind(s);s.push=t,s=s.slice();for(var l=0;l<s.length;l++)t(s[l]);var u=i;o.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"034f":function(e,t,n){"use strict";var a=n("85ec"),r=n.n(a);r.a},"1eff":function(e,t,n){},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("2b0e"),r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("img",{attrs:{alt:"Vue logo",src:n("cf05")}}),a("HelloWorld",{attrs:{msg:e.welcomeMessage}}),a("Topic",{attrs:{topicData:e.topicDataFromSuper}})],1)},o=[],c=(n("d3b7"),n("96cf"),n("1da1")),s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"hello"},[n("h1",[e._v(e._s(e.msg))])])},i=[],l={name:"HelloWorld",props:["msg"]},u=l,p=(n("c94c"),n("2877")),f=Object(p["a"])(u,s,i,!1,null,"7bf758b7",null),d=f.exports,h=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"topic"},e._l(e.getLineBreakedData,(function(t,a){return n("div",{key:a,staticClass:"each-row"},[n("div",{staticClass:"idol-name"},[n("a",{staticClass:"idol-link",attrs:{href:"/api/idol/redirect/"+t.idolNameJa,target:"_blank"}},[e._v(e._s(t.idolNameJa))])]),n("div",{staticClass:"topic-num"},[n("span",[e._v(e._s(t.topicNum))])]),n("div",{staticClass:"topic-content"},[n("p",{staticClass:"label-lang"},[e._v("Ja")]),n("p",{staticClass:"topic-ja"},[n("span",{domProps:{innerHTML:e._s(t.uwasaJa)}}),e._v(" "),n("a",{staticClass:"btn-speech",on:{click:function(n){e.speak(t.uwasaJa.replace(/<br>/g,""),{lang:"ja-JP"})}}},[e._v("🔊")])]),n("p",{staticClass:"label-lang"},[e._v("Ko")]),n("p",{staticClass:"topic-ko"},[n("span",{domProps:{innerHTML:e._s(t.uwasaKo)}})])])])})),0)},v=[],g=(n("d81d"),n("ac1f"),n("5319"),{name:"Topic",props:["topicData"],data:function(){return{propTopicData:this.topicData}},mounted:function(){},computed:{getLineBreakedData:function(){var e=JSON.parse(JSON.stringify(this.topicData));return e.map((function(e){return e.uwasaJa=e.uwasaJa.replace(/(?:\\r\\n|\\r|\\n)/g,"<br>"),e.uwasaKo=e.uwasaKo.replace(/(?:\\r\\n|\\r|\\n)/g,"<br>"),e}))}},methods:{speak:function(e,t){if("undefined"!==typeof SpeechSynthesisUtterance&&"undefined"!==typeof window.speechSynthesis){window.speechSynthesis.cancel();var n=t||{},a=new SpeechSynthesisUtterance;a.rate=n.rate||1,a.pitch=n.pitch||1,a.lang=n.lang||"ko-KR",a.text=e,window.speechSynthesis.speak(a)}else alert("이 브라우저는 음성 합성을 지원하지 않습니다.")}}}),m=g,b=(n("ae2d"),Object(p["a"])(m,h,v,!1,null,"594e3922",null)),w=b.exports,y={name:"App",data:function(){return{welcomeMessage:"default msg",topicDataFromSuper:[]}},components:{HelloWorld:d,Topic:w},created:function(){var e=this;function t(){return n.apply(this,arguments)}function n(){return n=Object(c["a"])(regeneratorRuntime.mark((function e(){var t,n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,fetch("/api/idol/uwasa",{method:"GET"});case 3:return t=e.sent,e.next=6,t.json();case 6:return n=e.sent,e.abrupt("return",n);case 10:e.prev=10,e.t0=e["catch"](0),console.error(e.t0);case 13:case"end":return e.stop()}}),e,null,[[0,10]])}))),n.apply(this,arguments)}fetch("/api/test/title",{method:"get"}).then((function(e){var t=e.text();return console.log(e),t})).then((function(t){console.log("fetch: "+t),e.welcomeMessage=t})).catch((function(t){console.log(t),e.welcomeMessage="Error"})),t().then((function(t){console.log("fromAPI",t),e.topicDataFromSuper=t}))}},_=y,O=(n("034f"),Object(p["a"])(_,r,o,!1,null,null,null)),S=O.exports;a["a"].config.productionTip=!1,new a["a"]({render:function(e){return e(S)}}).$mount("#app")},"85ec":function(e,t,n){},"87ed":function(e,t,n){},ae2d:function(e,t,n){"use strict";var a=n("87ed"),r=n.n(a);r.a},c94c:function(e,t,n){"use strict";var a=n("1eff"),r=n.n(a);r.a},cf05:function(e,t,n){e.exports=n.p+"img/logo.7c5310a9.png"}});
//# sourceMappingURL=app.c0af713b.js.map