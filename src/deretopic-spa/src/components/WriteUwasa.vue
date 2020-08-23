<template>
    <div>
        <fieldset>
            <legend>
                정보 입력
            </legend>

            <div class="form-group">
                <label>아이돌 선택: </label>
                <select v-model="selectedIdol">
                    <option v-for="(idol) in idols" :key="idol.id" :value="idol.id">
                        {{`${idol.nameKo} (${idol.name})`}}</option>
                </select>
            </div>

            <div class="form-group">
                <label>일본어 원문 입력: </label>
                <textarea v-model="textJa"></textarea>
            </div>

            <div>
                <button>파파고 한국어 번역 제안</button>
            </div>

            <div class="form-group">
                <label>한국어 번역 입력: </label>
                <textarea v-model="textKo"></textarea>
            </div>

            <div class="form-group">
                <label>일본어 원문 입력: </label>
                <textarea></textarea>
            </div>
            
            <div class="form-group">
                <label>소문 번호: </label>
                <input type="number" min="1">
            </div>

            <div class="form-group">
                <label>오디오 파일 업로드: </label>
                <input type="file">
            </div>

            <div class="form-group">
                <label>임시 비밀번호 입력: </label>
                <input type="password">
            </div>

            
        </fieldset>
    </div>
</template>

<script>
export default {
    data() {
        return {
            idols: [],
            selectedIdol: "",
            textJa: "",
            textKo: ""
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