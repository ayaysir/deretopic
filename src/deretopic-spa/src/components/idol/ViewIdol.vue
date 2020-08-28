<template>
    <div>
        <div class="form-group form-puchi">
            <ProfilePuchi v-if="idol.id" :idol="idol" :customImage="customImage"/>
            <p>
                <button @click="getIdolById(idol.id - 1)">이전 아이돌</button>
                <button @click="getIdolById(idol.id + 1)">다음 아이돌</button>
            </p>
        </div>

        <table id="vertical-table">
            <thead>
                
            </thead>
            <tbody>
                <tr>
                    <th scope=col rowspan="4">이름</th>
                    <td>{{idol.nameKo}}</td>
                </tr>
                <tr>
                    <td>{{idol.nameEn}}</td>
                </tr>
                <tr>
                    <td>{{idol.name}}</td>
                </tr>
                <tr>
                    <td>{{idol.nameFurigana}}</td>
                </tr>
                <tr>
                    <th scope=col>나이</th>
                    <td>{{idol.age ? (idol.age + '세') : ''}}</td>
                </tr>
                <tr>
                    <th scope=col>출생지</th>
                    <td>{{idol.birthPlace}}</td>
                </tr>
                <tr>
                    <th scope=col>혈액형</th>
                    <td>
                        {{idol.bloodType}}
                    </td>
                </tr>
                <tr>
                    <th scope=col>키</th>
                    <td>{{idol.height}}</td>
                </tr>
                <tr>
                    <th scope=col>몸무게</th>
                    <td>{{idol.weight}}</td>
                </tr>
                <tr>
                    <th scope=col>생일</th>
                    <td>{{getFormattedDate}}</td>
                </tr>
                <tr>
                    <th scope=col>3사이즈</th>
                    <td>{{getThreeSize}}</td>
                </tr>
                <tr>
                    <th scope=col>별자리</th>
                    <td>{{idol.constellation}}</td>
                </tr>
                <tr>
                    <th scope=col>취미</th>
                    <td>{{idol.hobby}}</td>
                </tr>
                <tr>
                    <th scope=col>아이돌 타입</th>
                    <td>{{idol.idolType}}</td>
                </tr>
                <tr>
                    <th scope=col>자주 쓰는 손</th>
                    <td>{{idol.handedness}}</td>
                </tr>
                <tr>
                    <th scope=col>성우</th>
                    <td>{{idol.voiceActorKo}}</td>
                </tr>
                <tr>
                    <th scope=col>이미지 컬러</th>
                    <td class="image-color" :style="{'background': getImageColor, 'color': getTextColorOfImageColor}">{{idol.imageColor}}</td>
                </tr>
                <!-- <tr>
                    <th scope=col>나무위키 키워드(선택)</th>
                    <td><input type="text" v-model="idol.refKeyword"></td>
                </tr> -->
                

            </tbody>
        </table>
    </div>
    
</template>

<script>
import ProfilePuchi from "@/components/common/ProfilePuchi.vue";
export default {
    data() {
        return {
            idol: {},
            puchiBase64: null,
            customImage: null,
            insertInfo: null,
        }
    },
    components: {
        ProfilePuchi
    },
    created() {
        this.getIdolById(this.$route.params.id)
        this.getEnumInfo()
    },
    computed: {
        getFormattedDate() {
            if(this.idol.birthday) {
                const arr = this.idol.birthday.split("-")
                const month = arr[1].startsWith(0) ? arr[1].substr(1, 1) : arr[1]
                const day = arr[2].startsWith(0) ? arr[2].substr(1, 1) : arr[2]
                return `${month}월 ${day}일`
            } else {
                return ""
            }
        },
        getThreeSize() {
            if(this.idol.threeSize && this.idol.threeSize.bust != 0) {
                return this.idol.threeSize.bust + '-' + this.idol.threeSize.hip + '-' + this.idol.threeSize.waist
            } else {
                return "-"
            }
        },
        getImageColor() {
            return this.idol.imageColor || ""
        },
        getTextColorOfImageColor() {
            if(!this.idol.imageColor)   return ""

            const c = this.idol.imageColor.substring(1);      // strip #
            const rgb = parseInt(c, 16);   // convert rrggbb to decimal
            const r = (rgb >> 16) & 0xff;  // extract red
            const g = (rgb >>  8) & 0xff;  // extract green
            const b = (rgb >>  0) & 0xff;  // extract blue

            const luma = 0.2126 * r + 0.7152 * g + 0.0722 * b; // per ITU-R BT.709

            // pick a different colour
            return luma < 40 ? "black" : "white"
        }
    },

    methods: {
        async getEnumInfo() {
            const init = await fetch("/api/idol/insert-info")
            const data = await init.json()
            this.insertInfo = await data;
        },
        async getIdolById(id) {
            try{
                const init = await fetch("/api/idol/profile/" + id)
                const data = await init.json()
                if(init.status == 200) {
                    this.idol = await data
                    const currentUrl = window.location.href

                    history.pushState(
                        {},
                        null,
                        currentUrl.substr(0, currentUrl.lastIndexOf("/") + 1) + (this.idol.id)
                    )
                } else {
                    alert("해당 아이디의 아이돌이 없습니다.")
                    this.idol.id = 0
                }

                
            } catch(exc) {
                console.log(exc)
            }
            
        },

        
    }
}
</script>

<style scoped>
    .form-puchi {
        margin: 0px auto;
        border: 1px solid gray;
        margin-top: 10px;
    }
    .form-puchi label {
        margin: 10px;
    }
    .form-puchi * {
        margin: 0px auto;
        padding: 2px;
    }

    .image-color {
        border-radius: 5px;
    }


    
</style>