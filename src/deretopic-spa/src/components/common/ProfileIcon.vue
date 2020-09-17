<template>
    <div class="idol-icon-div">
        <img class="idol-icon" :src="getIconImage" @error="changeDefaultImage">
    </div>
</template>

<script>
export default {
    name: "ProfileIcon",
    props: ["idol", "customImage"],
    data() {
        return {
            defaultImgUrl: "https://dummyimage.com/90x90/ff7db5/fff.png&text=icon",
            currentUrl: "/api/idol/icon/" + this.idol.id
        }
    },
    methods: {
        changeDefaultImage() {
            this.currentUrl = this.defaultImgUrl
        },
        setIconImage(url) {
            this.currentUrl = url
        }
    },

    computed: {
        getIconImage: {
            get() {
                return this.currentUrl
            },
            set: function(newValue) {
                this.currentUrl = newValue
            }
        }
    },

    watch: {
        customImage: function(file) {
            const reader = new FileReader
            reader.onload = () => {
                this.getIconImage = reader.result
            }
            reader.readAsDataURL(file)
        },
        idol: function(idol) {
            this.currentUrl = "/api/idol/icon/" + idol.id
        }
    }
}
</script>

<style scoped>
    .idol-icon-div {
        width: 30px;
    }

    .idol-icon {
        width: 100%;
    }
</style>