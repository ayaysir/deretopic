<template>
    <div>
        <div class="form-group form-puchi">
            <img src="https://dummyimage.com/128x172/d68bd6/000000.png&text=puchi">
            <label for="puchi">푸치 사진 변경</label>
            <input id="file-puchi" type="file" @change="handleFile">
            <button @click="sendData">전송</button>
        </div>
        <table>
            <thead>
            </thead>
            <tbody>
                <tr v-for="(value, name) in idol" :key="name">
                    <td>{{name}}</td>
                    <td>{{value || '--입력되지 않았습니다.--'}}</td>
                </tr>
            </tbody>
        </table>
    </div>
    
</template>

<script>
export default {
    data() {
        return {
            idol: {},
            puchiBase64: null
        }
    },
    created() {
        console.log("routed ", this.$route)
        this.getIdolById(this.$route.params.id)
    },

    methods: {
        async getIdolById(id) {
            const init = await fetch("/api/idol/profile/" + id)
            const data = await init.json()
            this.idol = await data

            console.log(data)
        },

        handleFile(e) {
            const files = e.target.files

            if(files.length > 0) {
                const file = e.target.files[0]

                if(file.type != "image/png" || file.size > 300000) {
                    alert("파일이 png가 아니거나 사이즈가 너무 큽니다.")
                    e.target.value = ""
                    return false
                }

                const reader = new FileReader()

                reader.addEventListener("load", () => {
                    const dataIndex = reader.result.indexOf(',') + 1
                    const base64 = reader.result.substring(
                                    dataIndex,
                                    reader.result.length
                    )

                    console.log(base64.length)
                    this.puchiBase64 = base64
                }, false)
                reader.readAsDataURL(file)

            }
        },

        async sendData() {
            // private String idolNameJa, uwasaJa, uwasaKo;
            // private String ttsAudioBase64, tempHash;
            // private Integer topicNum;

            if(!this.puchiBase64) {
                alert("빈 칸이 있습니다.")
                return false
            }

            const dataObj = {
                puchiBase64: this.puchiBase64
            }

            const initFetch = await fetch(`/api/idol/profile/${this.idol.id}`, {
                method: "PUT",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataObj)
            })

            const data = await initFetch.json()
            alert(JSON.stringify(data))
            
            
        }
    }
}
</script>

<style scoped>
    .form-puchi {
        margin: 0px auto;
        border: 1px solid gray;
        width: 500px;
        margin-top: 10px;
    }
    .form-puchi * {
        margin: 0px auto;
        display: block;
    }

    
</style>