package com.example.aisuangua.MyFragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.aisuangua.LoginActivity;
import com.example.aisuangua.R;
import com.example.aisuangua.andoridJs.ShouYeJs;

public class WoDeFragment extends Fragment {
    @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_05, container, false);
        WebView webView = view.findViewById(R.id.webview_wode);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new Wodejs(), "wodejs");
        webView.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.loadUrl("file:///android_asset/www/shezhi.html");
        return view;

    }



    public class Wodejs{
        @JavascriptInterface
        public String myuser(){
          //获取对于的存储的数据
            SharedPreferences spf = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
            String user = spf.getString("loginuser", "");
            //判断是否已经登录了
            if("".equals(user)){
              return "";
            }else{
                return user;
            }

        }

        //logout
        @JavascriptInterface
        public void logout() {
            SharedPreferences spf = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
            spf.edit().clear();
            spf.edit().commit();
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
