<template>
    <div class="search-box">
        <div class="form-group">
            <label>전체 정렬</label>
            <select v-model="allOrderStatus" @change="allOrder">
                <option disabled value="no">-- 전체 목록 정렬 --</option>
                <option selected value="asc">오름차순</option>
                <option value="desc">내림차순</option>
            </select>

            <label>소문 검색</label>
            <select v-model="searchCategory">
                <option selected value="내용">소문 내용</option>
                <option value="이름">아이돌 이름</option>
            </select>
            <input type="text" v-model="searchKeyword" @keypress.enter="search">
            <button @click="search">검색</button>
            <button @click="searchReset">초기화</button>
        </div>
        
    </div>
</template>

<script>
export default {
    data() {
        return {
            searchCategory: "내용",
            searchKeyword: "",
            allOrderStatus: "asc"

        }
    },

    methods: {
        search() {
            this.$emit("search", this.searchCategory, this.searchKeyword)
        },
        searchReset() {
            this.$emit("search", this.searchCategory, "")
        },
        allOrder() {
            this.$emit("allOrder", this.allOrderStatus)
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