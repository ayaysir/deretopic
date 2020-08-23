package com.example.deretopic.util;

// 네이버 Papago NMT API 예제
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class PapagoAPITranslate {

    private static String clientId;
    private static String clientSecret;

    public static void setClientInfo(String clientId, String clientSecret) {
        PapagoAPITranslate.clientId = clientId;
        PapagoAPITranslate.clientSecret = clientSecret;
    }

    public static String translate(String originalText,
                                   String originalCountryCode, String destCountryCode) throws IOException {


            String text = URLEncoder.encode(originalText, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            // post request
            String postParams = "source=" + originalCountryCode + "&target=" + destCountryCode + "&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();

    }

    public static void main(String[] args) throws IOException {

        String result = translate("만나서 반갑습니다.", "ko", "ja");
        System.out.println(result);
    }
}