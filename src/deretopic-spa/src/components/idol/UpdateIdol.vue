<template>
    <div>
        <div class="form-group form-puchi">
            <ProfilePuchi v-if="idol.id" :idol="idol" :customImage="customImage"/>
            <label for="puchi">푸치 사진 변경</label>
            <input id="file-puchi" type="file" @change="handleFile">
            <button @click="sendData">전송</button>
            <p>
                <!-- <router-link :to="'/v/idol/update/' + ((idol.id - 1 != 0) ? idol.id - 1 : 1)">이전 아이돌 </router-link>
                <router-link :to="'/v/idol/update/' + (idol.id + 1)"> 다음 아이돌</router-link> -->
                <button @click="getIdolById(idol.id - 1)">이전 아이돌</button>
                <button @click="getIdolById(idol.id + 1)">다음 아이돌</button>
            </p>
        </div>

        <!-- {
"id": 1,
"name": "島村卯月",
"nameEn": null,
"nameKo": "시마무라 우즈키",
"age": null,
"birthday": null,
"birthPlace": null,
"bloodType": null,
"height": null,
"weight": null,
"threeSize": {
"bust": 0,
"waist": 0,
"hip": 0
},
"constellation": null,
"hobby": null,
"idolType": null,
"note": null,
"refKeyword": null,
"createdDate": null,
"modifiedDate": null,
"nameFurigana": null,
"imageColor": null,
"voiceActorKo": null,
"handedness": null
}-->
        <table id="vertical-table">
            <thead>
                
            </thead>
            <tbody>
                <tr>
                    <th scope=col rowspan="4">이름</th>
                    <td><input type="text" v-model="idol.nameKo" placeholder="한글 이름"></td>
                </tr>
                <tr>
                    <td><input type="text" v-model="idol.nameEn" placeholder="영문 이름"></td>
                </tr>
                <tr>
                    <td><input type="text" v-model="idol.name" placeholder="원문(한자) 이름"></td>
                </tr>
                <tr>
                    <td><input type="text" v-model="idol.nameFurigana" placeholder="후리가나"></td>
                </tr>
                <tr>
                    <th scope=col>나이</th>
                    <td><input type="number" v-model="idol.age"></td>
                </tr>
                <tr>
                    <th scope=col>출생지</th>
                    <td><input type="text" v-model="idol.birthPlace"></td>
                </tr>
                <tr>
                    <th scope=col>혈액형</th>
                    <td>
                        <select v-if="insertInfo" v-model="idol.bloodType">
                            <option disabled selected value="null">혈액형을 선택하세요.</option>
                            <option v-for="blood in insertInfo.BloodType" :key="blood" :value="blood">{{blood}}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th scope=col>키</th>
                    <td><input type="number" v-model="idol.height"></td>
                </tr>
                <tr>
                    <th scope=col>몸무게</th>
                    <td><input type="number" v-model="idol.weight"></td>
                </tr>
                <tr th-if="idol.birthday">
                    <th scope=col>생일</th>
                    <td>
                        <input type="number" min="1" max="12" data-from="month" :value="idol.birthday.split('-')[1]" @change="modifyBirthday">월 
                        <input type="number" min="1" max="31" data-from="day" :value="idol.birthday.split('-')[2]" @change="modifyBirthday"     >일
                        <!-- <input type="text" v-model="modifiedBirthday"> -->
                    </td>
                </tr>
                <tr>
                    <th scope=col rowspan="3">3사이즈</th>
                    <td>B <input type="number" v-if="idol.threeSize" v-model="idol.threeSize.bust"></td>
                </tr>
                <tr>
                    <td>W <input type="number" v-if="idol.threeSize" v-model="idol.threeSize.hip"></td>
                </tr>
                <tr>
                    <td>H <input type="number" v-if="idol.threeSize" v-model="idol.threeSize.waist"></td>
                </tr>
                <tr>
                    <th scope=col>별자리</th>
                    <select v-if="insertInfo" v-model="idol.constellation">
                        <option disabled value="null">별자리를 선택하세요.</option>
                        <option v-for="cst in insertInfo.Constellation" :key="cst" :value="cst">{{cst}}</option>
                    </select>
                </tr>
                <tr>
                    <th scope=col>취미</th>
                    <td><input type="text" v-model="idol.hobby"></td>
                </tr>
                <tr>
                    <th scope=col>아이돌 타입</th>
                    <td>
                        <select v-if="insertInfo" v-model="idol.idolType">
                        <option disabled value="null">아이돌 타입을 선택하세요.</option>
                          <option v-for="type in insertInfo.IdolType" :key="type" :value="type">{{type}}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th scope=col>자주 쓰는 손</th>
                    <td>
                        <select v-if="insertInfo" v-model="idol.handedness">
                            <option disabled value="null">자주 쓰는 손(handedness)을 선택하세요.</option>
                            <option v-for="hand in insertInfo.Handedness" :key="hand" :value="hand">{{hand}}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th scope=col>성우</th>
                    <td><input type="text" v-model="idol.voiceActorKo"></td>
                </tr>
                <tr>
                    <th scope=col>이미지 컬러</th>
                    <td><input type="color" v-model="idol.imageColor"></td>
                </tr>
                <tr>
                    <th scope=col>나무위키 키워드(선택)</th>
                    <td><input type="text" v-model="idol.refKeyword"></td>
                </tr>
                

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
        console.log("routed ", this.$route)
        this.getIdolById(this.$route.params.id)
        this.getEnumInfo()
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

        handleFile(e) {
            const files = e.target.files

            if(files.length > 0) {
                const file = e.target.files[0]
                this.customImage = file

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

            const dataObj = this.idol
            if(this.puchiBase64) {
                dataObj.puchiBase64 = this.puchiBase64
            } else {
                dataObj.puchiBase64 = ""
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
        },
        modifyBirthday($event) {
            console.log($event)
            const evTarget = $event.target
            if(this.idol.birthday) {
                const [y, m, d] = this.idol.birthday.split("-")
                if(evTarget.dataset.from == "month") {
                    const paddedMonth = this.paddingZero(evTarget.value)
                    this.idol.birthday = [y, paddedMonth, d].join("-")
                } else {
                    const paddedDay = this.paddingZero(evTarget.value)
                    this.idol.birthday = [y, m, paddedDay].join("-")
                }
            }
            
        },
        paddingZero(value) {
           return (value.length < 2) ? ("0" + value) : value;
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
    .form-puchi label {
        margin: 10px;
    }
    .form-puchi * {
        margin: 0px auto;
        padding: 2px;
    }

    
</style>