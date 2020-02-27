package com.example.aisuangua.andoridJs;

import android.app.Application;
import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.aisuangua.MainActivity;
import com.example.aisuangua.myUtils.OkHttpUtils;
import com.example.aisuangua.myUtils.ToastUtils;

import java.util.HashMap;
import java.util.Map;


public class ShouYeJs{

    public Context context;

    public ShouYeJs(Context ct){
        this.context = ct;
    }
    //JavaScript调用此方法
    @JavascriptInterface
    public String ShouYeInit(String page) {
        Map<String, String> params = new HashMap<>();
        String rs = OkHttpUtils.getInstance().doGet("http://192.168.43.37:8080/smbaikeAPP/smbaikeappInfo?page="+page);
        System.out.println(rs);
        return rs;
    }

    //Toast
    @JavascriptInterface
    public void MyToast(final String parm) {
        ToastUtils.showToast(context,parm);
    }

}
