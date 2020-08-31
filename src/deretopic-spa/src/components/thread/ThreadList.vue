<template>
    <div class="thread-wrapper">
        <div class="write-area" v-if="getLoggedIn">
            <label><strong>글쓰기</strong>  </label>
            <textarea rows="5" v-model="writtenContent"></textarea>
            <button @click="sendOneThread">등록</button>
        </div>
        <div v-if="threadList.length != 0">

            <div class="each-thread-wrapper" v-for="thread in lineCarriagedThreadList" :key="thread.id">
               <!--
                   { "id": 1, "threadName": "qna", "category": "e", "content": "ee", "authorId": null, 

                   "author": { "createdDate": "2020-08-31T14:11:33.751", "modifiedDate": "2020-08-31T14:11:33.751", 
                   d": 1, "name": "ddd", "email": "yoonbumtae@gmail.com", "imageUrl": null, "provider": "local", 
                   "providerId": null }, 
                   
                   "createdDate": "2020-08-31T14:12:01.687", "modifiedDate": "2020-08-31T14:12:01.687" }
                   -->
                   <table>
                       <tbody>
                           <tr>
                               <td><span>{{'No.' + thread.id}}</span></td>
                               <td><img :src="thread.author.imageUrl || ''" class="profile-img"> </td>
                               <td> <span>{{thread.author.name}}</span> </td>
                               <td v-if="thread.modifiedDate"> <span>{{ thread.modifiedDate.split('T')[0] + ' ' + thread.modifiedDate.split('T')[1].split('.')[0]}}</span> </td>
                               <td v-if="getLoggedIn && isCorrectWriter(thread.author.id)">
                                   <span style="cursor: pointer; color: lightcoral;" @click="deleteThread(thread.id)">[삭제]</span>
                               </td>
                           </tr>
                       </tbody>
                   </table>
                   <hr>
                   <div class="content" v-html="thread.content"></div>
            </div>
        </div>
        <infinite-loading :identifier="infiniteId" @infinite="infiniteHandler" spinner="waveDots" />
    </div>
</template>

<script>
import InfiniteLoading from 'vue-infinite-loading'

export default {
    data() {
        return {
            threadList: [],
            requestCount: 0,
            writtenContent: "",
            infiniteId: +new Date()
        }
    },
    components: {
        InfiniteLoading
    },
    created() {
        
    },
    computed: {
        getLoggedIn() {
            return this.isLoggedIn()
        },
        lineCarriagedThreadList() {
            const data = this.threadList
            return data.map(v => {
                v.content = v.content.replace(/(?:\\r\\n|\\r|\\n|\r\n|\r|\n)/g, "<br>")
                
                return v
            })
        }
    },
    methods: {
        isCorrectWriter(threadId) {
            return this.$store.state.accessUser.data.id == threadId
        },
        isLoggedIn() {
            return this.$store.state.accessUser && this.$store.state.accessUser.token != ""
        },
        async getThreads(threadName) {
            const init = await fetch(`/api/thread/${threadName}`)
            const data = await init.json()
            return data
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
            } else {
                alert("오류가 발생했습니다.\n" + JSON.stringify(result))
            }

            this.threadList = []
            this.requestCount = 0
            this.infiniteId += 1
            this.writtenContent = ""

        },

        async deleteThread(threadId) {
            if(!this.isLoggedIn) {
                alert("회원만 삭제할 수 있습니다.")
                return false
            }

            if(!confirm("정말 삭제하시겠습니까?")) {
                return false
            }

            const headers = {
                'Content-Type': 'application/json',
                "Authorization": `Bearer ${this.$store.state.accessUser.token}`
            }

            const initFetch = await fetch(`/api/thread/${threadId}`, {
                method: "DELETE",
                headers,
            })

            const result = await initFetch.json()
            if(result.status) {
                alert("오류가 발생했습니다.\n" + JSON.stringify(result))
            } else if(result == -99) {
                alert("게시물이 없습니다.")
            } else {
                alert("삭제되었습니다.")
            }

            this.threadList = []
            this.requestCount = 0
            this.infiniteId += 1
            
        },
        async infiniteHandler($state) {

            if(this.requestCount == 0) {
                $state.loaded()
                this.requestCount += 1
            } else {
                const data = await this.getThreads(this.$route.params.threadName)
                setTimeout(() => {
                    if(data.length) {
                        this.threadList = data
                    }
                    $state.complete()
                }, 500)
            }
            
        }
    }
}
</script>

<style scoped>
    .thread-wrapper {

        width: 100%;
        max-width: 500px;
        margin: 0px auto;
        
    }


    .write-area textarea {

        border: 1px solid lightsalmon;
        border-radius: 5px;
        width: 100%;
        margin-top: 10px;
    }

    .profile-img {
        width: 20px;
    }

    .each-thread-wrapper, .write-area {
        border: 1px solid lightgray;
        padding: 10px;
        border-radius: 10px;
        margin: 10px 0 auto;

        text-align: left;
    }

    .each-thread-wrapper table {
        text-align: left;
        margin-left: 0px;
        margin-right: auto;
        font-size: 0.7em;
        
    }

    .each-thread-wrapper table td {
        text-align: left;
        padding: 0px 10px;
        border-right: 5px dotted lightgray;
    }

    .each-thread-wrapper hr {
        color: lightgray
    }


    .write-area {
        margin-bottom: 20px;
    }

</style>