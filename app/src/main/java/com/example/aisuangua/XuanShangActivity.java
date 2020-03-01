package com.example.aisuangua;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.aisuangua.andoridJs.ShouYeJs;
import com.example.aisuangua.myUtils.JsonResult;
import com.example.aisuangua.myUtils.OkHttpUtils;
import com.example.aisuangua.myUtils.ToastUtils;
import com.example.aisuangua.pojo.Tiezianswer;
import com.example.aisuangua.pojo.User;

import java.util.HashMap;
import java.util.Map;

public class XuanShangActivity extends Activity {

    private WebView webView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xsdeails);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //获取id参数
        Intent intent=getIntent();
        final String id=intent.getStringExtra("id");

        // 创建WebView
        webView = findViewById(R.id.xuanshang_content);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        //webView.loadUrl("javascript:javacalljs()");
        //webView.loadUrl("javascript:javacalljswith(" + "'Android传过来的参数'" + ")");
        webView.loadUrl("file:///android_asset/www/xsDeails.html");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                view.loadUrl("javascript:loadXSDeails('"+id+"')");
            }
        });

        Button fasong = findViewById(R.id.btn_confirm);

        //发送的点击事件
        fasong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //先判断是否登录了，没有登录则需要登录
                SharedPreferences spf = getSharedPreferences("user", Context.MODE_PRIVATE);
                //获取是否登录
                String islogin = spf.getString("islogin","");
                if("".equals(islogin)){
                    //进行跳转到登录到页面
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    EditText fsxiaoxi = findViewById(R.id.et_discuss);
                    String pl = fsxiaoxi.getText().toString();
                    ToastUtils.showToast(XuanShangActivity.this, pl);
                    String user = spf.getString("loginuser", "");
                    User u = JSON.parseObject(user, User.class);
                    //进行发送信息
                    Tiezianswer answer = new Tiezianswer();
                    //发送信息的数据拼接
                    answer.setTieziid(id);
                    answer.setAnswerfuserid(u.getId());
                    answer.setAnswersendcont(pl);
                    Map<String, String> params = new HashMap<>();
                    String answerString = JSON.toJSONString(answer);
                    params.put("tiezianwer", answerString);
                    String rs = OkHttpUtils.getInstance().doPostForm("http://192.168.43.37:8080/smbaikeAPP/Tiezianswer", params);
                    JsonResult obj = JSON.parseObject(rs, JsonResult.class);
                    //发送成功
                    if ("0".equals(obj.getCode())) {
                        //信息发送成功，则重新加载页面
                        onResume();
                    }
                }

            }
        });


    }



    @Override
    protected void onResume() {
        super.onResume();
        onCreate(null);
    }

}
