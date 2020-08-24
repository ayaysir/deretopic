<template>
    <div>
        <fieldset>
            <legend>
                정보 입력
            </legend>

            <div class="form-group">
                <label>아이돌 선택: </label>
                <select v-model="selectedIdol">
                    <option v-for="(idol) in idols" :key="idol.id" :value="idol.name" >
                        {{`${idol.nameKo} (${idol.name})`}}</option>
                </select>
            </div>

            <div class="form-group">
                <label>일본어 원문 입력: </label>
                <textarea v-model="textJa"></textarea>
            </div>

            <div>
                <button @click="translate">파파고 한국어 번역 제안</button>
            </div>

            <div class="form-group">
                <label>한국어 번역 입력: </label>
                <textarea v-model="textKo"></textarea>
            </div>
            
            <div class="form-group">
                <label>소문 번호: </label>
                <input type="number" min="1" v-model="topicNum">
            </div>

            <div class="form-group">
                <label>오디오 파일 업로드: </label>
                <input type="file" @change="handleFile">
            </div>

            <div class="form-group">
                <label>임시 비밀번호 입력: </label>
                <input type="password" v-model="tempHash">
            </div>

            <div class="form-group">
                <button @click="sendData">전송</button>
            </div>

            
        </fieldset>
    </div>
</template>

<script>
export default {
    data() {
        return {
            idols: [],
            selectedIdol: "島村卯月",
            textJa: "",
            textKo: "",
            topicNum: 0,
            tempHash: "",
            ttsFileBase64: null

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

        },
        async translate() {
            const textJa = this.textJa
            const textKo = this.textKo

            console.log(textJa, textKo)

            alert("준비중")
        },
        handleFile(e) {
            console.log(e.target.files)
            const files = e.target.files

            if(files.length > 0) {
                const file = e.target.files[0]


                if(file.type != "audio/mpeg" || file.size > 300000) {
                    alert("파일이 mp3가 아니거나 사이즈가 너무 큽니다.")
                    return false
                }

                const reader = new FileReader()

                reader.addEventListener("load", () => {
                    const dataIndex = reader.result.indexOf(',') + 1
                    const base64 = reader.result.substring(
                                    dataIndex,
                                    reader.result.length
                    )

                    console.log(reader.result)
                    this.ttsFileBase64 = base64
                }, false)
                reader.readAsDataURL(file)
                

            }
        },

        async sendData() {
            // private String idolNameJa, uwasaJa, uwasaKo;
            // private String ttsAudioBase64, tempHash;
            // private Integer topicNum;

            if(!this.selectedIdol || !this.textKo || !this.textJa || !this.tempHash
            || !this.ttsFileBase64, !this.topicNum) {
                alert("빈 칸이 있습니다.")
                return false
            }

            const dataObj = {
                idolNameJa: this.selectedIdol,
                uwasaJa: this.textJa,
                uwasaKo: this.textKo,
                ttsAudioBase64: this.ttsFileBase64,
                tempHash: this.tempHash,
                topicNum: this.topicNum
            }

            console.log(dataObj)

            const initFetch = await fetch("/api/idol/uwasa", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dataObj)
            })

            const data = await initFetch.json()
            if(data.uwasaId == -9999) {
                alert("비밀번호가 틀립니다.")
            } else {
                alert("데이터가 입력되었습니다.\n" + JSON.stringify(data))
                // 데이터를 모두 비운다
                this.selectedIdol = "島村卯月"
                this.textJa = ""
                this.textKo = ""
                this.topicNum = 0
                this.tempHash = ""
                this.ttsFileBase64 = null
                // file 비우기
                
            }
            
        }
     }
}
</script>

<style scoped>
    .form-group {
        margin-bottom: 10px;
    }

    .form-group label {
        display: block;
    }
</style>