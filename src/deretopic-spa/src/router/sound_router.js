import Vue from 'vue'
import Router from 'vue-router'
import Meta from 'vue-meta'

import Topic from "@/components/topic/Topic.vue"
import HelloWorld from "@/components/HelloWorld.vue"
import IdolList from "@/components/idol/IdolList.vue"
import WriteUwasa from "@/components/topic/WriteUwasa.vue" 
import UpdateIdol from "@/components/idol/UpdateIdol.vue" 
import ViewIdol from "@/components/idol/ViewIdol.vue"
import LoginRedirectHandler from "@/components/auth/LoginRedirectHandler"
import ThreadList from "@/components/thread/ThreadList.vue"

Vue.use(Router)
Vue.use(Meta)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: "/v/search",
            name: "Topic",
            component: Topic,
            // alias: ["/v/search"]
        },
        {
            path: "/foo",
            name: "Foo",
            component: HelloWorld
        },
        {
            path: "/bar",
            name: "Bar",
            component: HelloWorld
        },
        {
            path: "/v/simple-list",
            name: "Idol Simple List",
            component: IdolList
        },
        {
            path: "/v/write-uwasa",
            name: "Write Uwasa",
            component: WriteUwasa
        },
        {
            path: "/v/idol/update/:id",
            name: "Update Idol",
            component: UpdateIdol
        },
        {
            path: "/v/idol/view/:id",
            name: "View Idol",
            component: ViewIdol
        },
        {
            path: "/v/auth-redirect",
            name: "Login Redirection Handler",
            component: LoginRedirectHandler
        },
        {
            path: "/v/thread/:threadName",
            name: "View Thread List",
            component: ThreadList
        },

    ]
})