<template>
    <div>
        <table>
            <thead>
            </thead>
            <tbody>
                <tr v-for="idol in idols" :key="idol.name">
                    <td>{{idol.name}}</td>
                    <td>{{idol.nameKo}}</td>
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