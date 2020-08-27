<template>
    <div class="idol-name">
        <img class="puchi" src="https://dummyimage.com/128x172/d68bd6/000000.png&text=Loading+puchi">
        <p>
        <a class="idol-link" :href="'/api/idol/redirect/' + idol.name" target="_blank">
        {{idol.nameKo}}<br>({{idol.name}})</a>
        </p>
    </div>
</template>

<script>
export default {
    name: "ProfileMini",
    props: ["idol"]
}
</script>

<style scoped>
    .puchi {
        margin: 10px;
        height: 140px;
    }
</style>