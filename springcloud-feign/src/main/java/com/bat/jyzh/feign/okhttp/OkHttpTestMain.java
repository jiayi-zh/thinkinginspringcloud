package com.bat.jyzh.feign.okhttp;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * OKHttp 使用
 *
 * @author ZhengYu
 * @version 1.0 2021/3/7 10:06
 **/
public class OkHttpTestMain {
    public static void main(String[] args) {
        String url = "http://wwww.baidu.com";

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);

        try (Response response = call.execute()) {
            System.out.println("response status code: " + response.code());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
