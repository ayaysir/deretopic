<template>
    <div>
        <div class="form-group form-puchi">
            <ProfilePuchi v-if="idol.id" :idol="idol" :customImage="customPuchi" />
            <label for="file-puchi">푸치 사진 변경</label>
            <input id="file-puchi" type="file" @change="handlePuchi">
            <hr>
            <ProfileIcon v-if="idol.id" :idol="idol" :customImage="customIcon" />
            <label for="file-icon">아이콘 변경</label>
            <input id="file-icon" type="file" @change="handleIcon">
            <hr>
            <p>
                <button v-if="idol.id > 1" @click="moveIdol(idol.id - 1)">이전 아이돌</button>
                <button @click="moveIdol(idol.id + 1)">다음 아이돌</button>
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
                <tr>
                    <th scope=col>생일</th>
                    <td>
                        <input type="date" v-model="idol.birthday"> 
                        <!-- <input type="number" min="1" max="12" data-from="month" 
                            v-model="tempDate.m" @change="modifyBirthday">월 
                        <input type="number" min="1" max="31" data-from="day" 
                            v-model="tempDate.d" @change="modifyBirthday">일 -->
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
            <tfoot>
                <tr>
                    <td colspan="2"><button class="btn-send" @click="sendData">전송</button></td>
                </tr>
            </tfoot>
        </table>
    </div>
    
</template>

<script>
import ProfilePuchi from "@/components/common/ProfilePuchi.vue"
import ProfileIcon from "@/components/common/ProfileIcon.vue"

export default {
    data() {
        return {
            idol: {},
            puchiBase64: null,
            iconBase64: null,
            customPuchi: null,
            customIcon: null,
            insertInfo: null,
            tempDate: {
                m: 0,
                d: 0
            }
        }
    },
    components: {
        ProfilePuchi,
        ProfileIcon
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
        async moveIdol(targetId) {
            const result = await this.getIdolById(targetId)
            result != 0 && this.changeUrl(result)
        },
        changeUrl(targetId) {
            const currentUrl = window.location.href
            history.pushState(
                {},
                null,
                currentUrl.substr(0, currentUrl.lastIndexOf("/") + 1) + targetId
            )
        },
        async getIdolById(id) {
            try{
                const init = await fetch("/api/idol/profile/" + id)
                const data = await init.json()
                if(init.status == 200) {
                    this.idol = await data
                    return this.idol.id
                } else {
                    alert("해당 아이디의 아이돌이 없습니다.")
                    this.getIdolById(1)
                    return 0
                }
                
            } catch(exc) {
                console.log(exc)
            }
            
        },

        handlePuchi(e) {
            
            const fileType = "image/png"
            
            const files = e.target.files

            if(files.length > 0) {
                const file = e.target.files[0]
                this.customPuchi = file

                if(file.type != fileType || file.size > 300000) {
                    alert(`파일이 png가 아니거나 사이즈가 너무 큽니다.`)
                    e.target.value = ""
                    this.customPuchi = ""
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

        handleIcon(e) {
            
            const fileType = "image/jpeg"
            
            const files = e.target.files

            if(files.length > 0) {
                const file = e.target.files[0]
                this.customIcon = file

                if(file.type != fileType || file.size > 300000) {
                    alert(`파일이 png가 아니거나 사이즈가 너무 큽니다.`)
                    e.target.value = ""
                    this.customIcon = ""
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
                    this.iconBase64 = base64
                }, false)
                reader.readAsDataURL(file)

            }
        }, 

        async sendData() {
            // private String idolNameJa, uwasaJa, uwasaKo;
            // private String ttsAudioBase64, tempHash;
            // private Integer topicNum;

            const dataObj = this.idol
            dataObj.puchiBase64 = this.puchiBase64 || ""
            dataObj.iconBase64 = this.iconBase64 || ""

            const headers = {
                'Content-Type': 'application/json'
            }
            if(this.$store.state.accessUser != null && this.$store.state.accessUser.token) {
                headers['Authorization'] = `Bearer ${this.$store.state.accessUser.token}`
            }
            const initFetch = await fetch(`/api/idol/profile/${this.idol.id}`, {
                method: "PUT",
                headers: headers,
                body: JSON.stringify(dataObj)
            })

            const data = await initFetch.json()
            if(data.result == "OK") {
                alert("정보 수정이 완료되었습니다.")
            } else {
                if(data.status == 401) {
                    alert("접근권한이 없습니다. 로그인하세요.")
                } else {
                    alert("오류가 발생했습니다. \n" + JSON.stringify(data))
                }
            }
        },
        paddingZero(value) {
           return (value.length < 2) ? ("0" + value) : value;
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
    .btn-send {
        font-size: 17px;
        width: 100%;
        margin: 10px auto;
    }
    
</style>