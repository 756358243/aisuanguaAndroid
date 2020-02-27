package com.example.aisuangua.MyFragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.aisuangua.R;
import com.example.aisuangua.andoridJs.ShouYeJs;

public class ShouYeFragment extends Fragment {
    @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page_01, container, false);
        WebView webView = view.findViewById(R.id.webview_shouye);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new ShouYeJs(getContext()), "zp");
        webView.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.loadUrl("file:///android_asset/www/shouye.html");
        return view;
     }



}
