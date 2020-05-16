package com.example.aisuangua.andoridJs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.example.aisuangua.LoginActivity;
import com.example.aisuangua.MainActivity;
import com.example.aisuangua.XuanShangActivity;
import com.example.aisuangua.myUtils.JsonResult;
import com.example.aisuangua.myUtils.OkHttpUtils;
import com.example.aisuangua.myUtils.ToastUtils;
import com.example.aisuangua.pojo.Tiezi;
import com.example.aisuangua.pojo.User;

import java.util.HashMap;
import java.util.Map;


public class TiWenJs {

    public Context context;

    public Activity activity;

    public View v;

    public TiWenJs(Context ct, Activity ac,View v){
        this.context = ct;
        this.activity = ac;
        this.v = v;
    }


    //Toast
    @JavascriptInterface
    public void MyToast(final String parm) {
        ToastUtils.showToast(context,parm);
    }

    //Xuanshang
    @JavascriptInterface
    public void fabuwenti(String biaoti,String quecontent,String tiezitypeid,String queasgbi) {
        //判断用户是非登录了
        System.out.println(biaoti);
        //先判断是否登录了，没有登录则需要登录
        SharedPreferences spf = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        //获取是否登录
        String user = spf.getString("loginuser", "");
        if("".equals(user)){
            //进行跳转到登录到页面
            Intent intent = new Intent(v.getContext(), LoginActivity.class);
            context.startActivity(intent);
        }else {
            //进行问题发布
            Tiezi tiezi = new Tiezi();
            User u = JSON.parseObject(user, User.class);
            tiezi.setUserid(u.getId());
            tiezi.setQueasgbi(queasgbi);
            tiezi.setTiezitypeid(tiezitypeid);
            tiezi.setQuecontent(quecontent);
            tiezi.setQuetitle(biaoti);
            //faTieziSubmit
            String tiezistr = JSON.toJSONString(tiezi);
            String rs = OkHttpUtils.getInstance().doPostJson("/smbaikeAPP/faTieziSubmit", tiezistr);
            JsonResult obj = JSON.parseObject(rs, JsonResult.class);
            //发送成功
            if ("0".equals(obj.getCode())) {
                //信息发送成功，则重新加载页面
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                context.startActivity(intent);
            }else{
                MyToast(obj.getMsg());
            }
        }




    }
}
