<template>
    <div class="search-box">
        <div class="form-group">
            <select v-model="searchCategory">
                <option selected>내용</option>
            </select>
            <input type="text" v-model="searchKeyword" @keypress.enter="search">
            <button @click="search">검색</button>
        </div>
        
    </div>
</template>

<script>
export default {
    data() {
        return {
            searchCategory: "내용",
            searchKeyword: ""
        }
    },

    methods: {
        search() {
            this.$emit("search", this.searchCategory, this.searchKeyword)
        }
    }
}
</script>

<style scoped>
    .search-box{
        padding: 10px;
    }

    .search-box .form-group * {
        margin: 0px 5px;
    }
</style>