<template>
    <div class="write-area" v-if="getLoggedIn">
        <label><strong>글쓰기</strong>  </label>
        <textarea rows="5" v-model="writtenContent"></textarea>
        <button @click="sendOneThread">등록</button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            writtenContent: "",
        }
    },
    props: ["threadName"],
    computed: {
        getLoggedIn() {
            return this.isLoggedIn()
        },
    },
    methods: {
        isLoggedIn() {
            return this.$store.state.accessUser && this.$store.state.accessUser.token != ""
        },
        async sendOneThread() {
            if(!this.isLoggedIn) {
                alert("회원만 작성할 수 있습니다.")
                return false
            }

            const dataObj = {
                "authorId": this.$store.state.accessUser.data.id,
                "category": "",
                "content": this.writtenContent,
                "threadName": this.$route.params.threadName
            }

            const headers = {
                'Content-Type': 'application/json',
                "Authorization": `Bearer ${this.$store.state.accessUser.token}`
            }

            const initFetch = await fetch("/api/thread", {
                method: "POST",
                headers,
                body: JSON.stringify(dataObj)
            })

            const result = await initFetch.json()
            if(result.status == 201) {
                alert("글이 정상적으로 등록되었습니다.");
                this.$emit("refreshThread")
                this.writtenContent = ""
            } else {
                alert("오류가 발생했습니다.\n" + JSON.stringify(result))
            }

        },
    }
}
</script>

<style scoped>
    .write-area {
        border: 1px solid lightgray;
        padding: 10px;
        border-radius: 10px;
        margin: 10px 0 auto;
        text-align: left;
        margin-bottom: 20px;
    }


    .write-area textarea {

        border: 1px solid lightsalmon;
        border-radius: 5px;
        width: 100%;
        margin-top: 10px;
    }
</style>