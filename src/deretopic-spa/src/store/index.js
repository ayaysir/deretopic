import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

// const resourceHost = "http://localhost:8080"

export default new Vuex.Store({
    state: {
        accessUser: null
    },
    getters: {
        
    },
    mutations: {
        LOGIN(state, obj) {
            state.accessUser = obj

        },
        LOGOUT(state) {
            state.accessUser = null
        }
    },
    actions: {
        async LOGIN({commit}, accessToken) {
            const init = fetch("/api/user/me", {headers: {
                'Authorization': 'Bearer ' + accessToken
            }})
            const result = await init
            const data = await result.json()

            if(result.status == 200) {
                console.log("userData, data", await data)
                commit("LOGIN", {"token": accessToken, data})
            } 
        },
        LOGOUT({commit}) {
            commit("LOGOUT")
        }
    }
})