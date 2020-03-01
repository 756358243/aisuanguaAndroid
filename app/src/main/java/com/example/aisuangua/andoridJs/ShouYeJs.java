package com.example.aisuangua.andoridJs;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.aisuangua.MainActivity;
import com.example.aisuangua.XuanShangActivity;
import com.example.aisuangua.myUtils.OkHttpUtils;
import com.example.aisuangua.myUtils.ToastUtils;

import java.util.HashMap;
import java.util.Map;


public class ShouYeJs{

    public Context context;

    public Activity activity;

    public ShouYeJs(Context ct,Activity ac){
        this.context = ct;
        this.activity = ac;
    }
    //JavaScript调用此方法
    @JavascriptInterface
    public String ShouYeInit(String starttime) {
        Map<String, String> params = new HashMap<>();
        //Integer start = Integer.valueOf(page);
        if(starttime == null){
            starttime = "start";
        }
        params.put("starttime",starttime);
        String rs =OkHttpUtils.getInstance().doPostForm("http://192.168.43.37:8080/smbaikeAPP/smbaikeappInfo",params);
        //String rs = OkHttpUtils.getInstance().doGet("http://192.168.43.37:8080/smbaikeAPP/smbaikeappInfo?start="+start);
        System.out.println(rs);
        return rs;
    }

    //Toast
    @JavascriptInterface
    public void MyToast(final String parm) {
        ToastUtils.showToast(context,parm);
    }

    //Xuanshang
    @JavascriptInterface
    public void Xuanshang(final String id) {

        Intent intent = new Intent(activity, XuanShangActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
