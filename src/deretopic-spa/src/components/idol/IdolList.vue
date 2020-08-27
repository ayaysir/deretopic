<template>
    <div>
        <table class="idol-list"> 
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
                    <td><router-link :to="'/v/idol/update/' + idol.id">[편집]</router-link></td>
                </tr>
            </tbody>
        </table>
    </div>
    
</template>

<script>
export default {
    data() {
        return {
            idols: []
        }
    },
    created() {
        this.getIdol()
    },
    methods: {
        async getIdol() {
            const init = await fetch("/api/idol/simple")
            const data = await init.json()
            this.idols = await data

            console.log(data)
        }
    }
}
</script>

<style scoped>
    
</style>