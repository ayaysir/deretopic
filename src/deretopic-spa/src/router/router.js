import Vue from 'vue'
import Router from 'vue-router'

import Topic from "@/components/topic/Topic.vue"
import HelloWorld from "@/components/HelloWorld.vue"
import IdolList from "@/components/idol/IdolList.vue"
import WriteUwasa from "@/components/topic/WriteUwasa.vue" 
import UpdateIdol from "@/components/idol/UpdateIdol.vue" 

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: "/",
            name: "Topic",
            component: Topic
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

    ]
})