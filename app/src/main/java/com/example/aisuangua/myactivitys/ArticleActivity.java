package com.example.aisuangua.myactivitys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.aisuangua.LoginActivity;
import com.example.aisuangua.R;
import com.example.aisuangua.myUtils.JsonResult;
import com.example.aisuangua.myUtils.OkHttpUtils;
import com.example.aisuangua.myUtils.StringUtils;
import com.example.aisuangua.myUtils.ToastUtils;
import com.example.aisuangua.pojo.Tiezianswer;
import com.example.aisuangua.pojo.User;

import java.util.HashMap;
import java.util.Map;

public class ArticleActivity extends Activity {

    private WebView webView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fabuarticle);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //获取id参数
        //Intent intent = getIntent();
        //final String user = intent.getStringExtra("user");
        //User u = JSON.parseObject(user, User.class);


        // 创建WebView
        webView = findViewById(R.id.fabuarticlewebview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.addJavascriptInterface(new Articlejs(webView), "articlejs");
        //webView.loadUrl("javascript:javacalljs()");
        //webView.loadUrl("javascript:javacalljswith(" + "'Android传过来的参数'" + ")");
        webView.loadUrl("file:///android_asset/www/fabuarticle.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:loadarticletype()");
            }
        });
        Button faarticle = findViewById(R.id.btn_fabuarticlesubmit);
        faarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先判断是否登录了，没有登录则需要登录
                SharedPreferences spf = getSharedPreferences("user", Context.MODE_PRIVATE);
                //获取是否登录
                String user = spf.getString("loginuser", "");
                if("".equals(user)){
                    //进行跳转到登录到页面
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    User u = JSON.parseObject(user, User.class);
                    //调用js中的方法
                    webView.loadUrl("javascript:tijiaoarticle('"+u.getId()+"')");

                }

            }
        });
    }

    public class Articlejs{
        public  View v;

        public Articlejs(View v){
            this.v = v;
        }



        @JavascriptInterface
        public void MyToast(final String parm) {
            ToastUtils.showToast(v.getContext(),parm);
        }

    }

}
