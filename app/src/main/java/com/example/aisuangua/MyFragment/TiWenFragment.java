package com.example.aisuangua.MyFragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.aisuangua.R;
import com.example.aisuangua.andoridJs.ShouYeJs;
import com.example.aisuangua.andoridJs.TiWenJs;

public class TiWenFragment extends Fragment {
    @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_03, container, false);
        WebView webView = view.findViewById(R.id.webview_tiwen);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new TiWenJs(getContext(),this.getActivity(),view), "tiwen");
        webView.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.loadUrl("file:///android_asset/www/tiwen.html");
        return view;
     }
}
