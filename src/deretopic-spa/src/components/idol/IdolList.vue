<template>
    <div>
        <table class="idol-list" v-if="idols.length != 0"> 
            <thead>
                <th>No.</th>
                <th>이름</th>
                <th>이름 (한글)</th>
            </thead>
            <tbody>
                <tr v-for="idol in idols" :key="idol.name">
                    <td>{{idol.id}}</td>
                    <td>{{idol.name}}</td>
                    <td>{{idol.nameKo}}</td>
                    <td><router-link :to="'/v/idol/view/' + idol.id">[보기]</router-link></td>
                    <td><router-link :to="'/v/idol/update/' + idol.id" v-if="getLoggedIn" class="danger">[편집]</router-link></td>
                </tr>
            </tbody>
        </table>
        <infinite-loading @infinite="infiniteHandler" spinner="waveDots">
        </infinite-loading>
    </div>
    
</template>

<script>
import InfiniteLoading from 'vue-infinite-loading';

export default {
    data() {
        return {
            idols: [],
            requestCount: 0
        }
    },
    created() {
        // this.getIdol()
    },
    components: {
        InfiniteLoading
    },
    computed: {
        getLoggedIn() {
            return this.$store.state.accessUser && this.$store.state.accessUser.token != ""
        }
    },
    methods: {
        async getIdol() {
            const init = await fetch("/api/idol/simple")
            return await init.json()
        }, 
        async infiniteHandler($state) {

            if(this.requestCount == 0) {
                $state.loaded()
                this.requestCount += 1
            } else {
                const data = await this.getIdol()
                setTimeout(() => {
                    if(data.length) {
                        this.idols = data
                    }
                    $state.complete()
                }, 500)
            }
            
        }
        
    }
}
</script>

<style scoped>
    
</style>