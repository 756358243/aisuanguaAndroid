package com.example.aisuangua.myUtils;
import android.util.Log;

import com.example.aisuangua.myInterceptor.LoggerInterceptor;

import okhttp3.*;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static android.content.ContentValues.TAG;

/**
 * 封装 OkHttp 工具类
 * @author yangqian
 * @date 2019-06-20
 */
public class OkHttpUtils {


    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private static final byte[] LOCKER = new byte[0];
    private static OkHttpUtils instance;
    private OkHttpClient okHttpClient;
    private static String baseurl = "http://192.168.43.37:8080";

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//10秒连接超时
                .writeTimeout(10, TimeUnit.SECONDS)//10m秒写入超时
                .readTimeout(10, TimeUnit.SECONDS)//10秒读取超时
                .addInterceptor(new LoggerInterceptor())
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (instance == null) {
            synchronized (LOCKER) {
                if (instance == null) {
                    instance = new OkHttpUtils();
                }
            }
        }
        return instance;
    }

    public String doGet(String url) {
        if (isBlankUrl(url)) {
            return null;
        }
        Request request = getRequestForGet(url);
        return commonRequest(request);
    }

    public String doGet(String url, HashMap<String, String> params) {
        if (isBlankUrl(url)) {
            return null;
        }
        Request request = getRequestForGet(url, params);
        return commonRequest(request);
    }

    public String doPostJson(String url, String json) {
        if (isBlankUrl(url)) {
            return null;
        }
        Request request = getRequestForPostJson(url, json);
        return commonRequest(request);
    }

    public String doPostForm(String url, Map<String, String> params) {
        if (isBlankUrl(url)) {
            return null;
        }
        Request request = getRequestForPostForm(url, params);
        return commonRequest(request);
    }

    private Boolean isBlankUrl(String url) {
        if (StringUtils.isStrEmpty(url)) {
            Log.i(TAG,"url is not blank");
            return true;
        } else {
            return false;
        }
    }

    private String commonRequest(Request request) {
        String re = "";
        try {
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                re = response.body().string();
                Log.i(TAG,"request url:{};response:{}"+request.url().toString());
            } else {
                Log.i(TAG,"request failure url:{};message:{}-----"+request.url().toString()+"----"+ response.message());
            }
        } catch (Exception e) {
            Log.e(TAG,"request execute failure---"+ e);
        }
        return re;
    }

    private Request getRequestForPostJson(String url, String json) {
        url = baseurl+url;
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return request;
    }


    private Request getRequestForPostForm(String url, Map<String, String> params) {
        url = baseurl+url;
        if (params == null) {
            params = new HashMap<>();
        }
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addEncoded(entry.getKey(), entry.getValue());
            }
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return request;
    }

    private Request getRequestForGet(String url, HashMap<String, String> params) {
        url = baseurl+url;
        Request request = new Request.Builder()
                .url(getUrlStringForGet(url, params))
                .build();
        return request;
    }

    private Request getRequestForGet(String url) {
        url = baseurl+url;
        Request request = new Request.Builder()
                .url(url)
                .build();
        return request;
    }

    private String getUrlStringForGet(String url, HashMap<String, String> params) {
        url = baseurl+url;
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(url);
        urlBuilder.append("?");
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                try {
                    urlBuilder.append("&").append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (Exception e) {
                    urlBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
                }
            }
        }
        return urlBuilder.toString();
    }
}