<template>
    <div class="idol-name">
        <img class="puchi" ref="puchiImg" :src="getPuchiImage" @error="changeDefaultImage">
        <p>
        <a class="idol-link" :href="'/api/idol/redirect/' + idol.name" target="_blank">
        {{idol.nameKo}}<br>({{idol.name}})</a>
        </p>
    </div>
</template>

<script>
export default {
    name: "ProfilePuchi",
    props: ["idol", "customImage"],
    data() {
        return {
            defaultImgUrl: "https://dummyimage.com/128x172/ff7db5/fff.png&text=puchi",
            currentUrl: "/api/idol/puchi/" + this.idol.id
        }
    },
    methods: {
        changeDefaultImage() {
            this.currentUrl = this.defaultImgUrl
        }
    },

    computed: {
        getPuchiImage: {
            get() {
                return this.currentUrl
            },
            set: function(newValue) {
                this.currentUrl = newValue
            }
        }
    },

    watch: {
        customImage: function (file) {
            // console.log("changed", newVal, oldVal)
            const reader = new FileReader
            reader.onload = () => {
                this.getPuchiImage = reader.result
            }
            reader.readAsDataURL(file)
        }
    }
}
</script>

<style scoped>
    .puchi {
        margin: 10px;
        height: calc(172px * 0.8);
    }
</style>