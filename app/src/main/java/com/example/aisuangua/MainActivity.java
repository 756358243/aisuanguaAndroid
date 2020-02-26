package com.example.aisuangua;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener,OnPageChangeListener{

    // 底部菜单4个Linearlayout
    private LinearLayout ll_home;
    private LinearLayout ll_address;
    private LinearLayout ll_friend;
    private LinearLayout ll_setting;
    private LinearLayout ll_tiwen;

    // 底部菜单4个ImageView
    private ImageView iv_home;
    private ImageView iv_address;
    private ImageView iv_friend;
    private ImageView iv_setting;
    private ImageView iv_tiwen;

    // 底部菜单4个菜单标题
    private TextView tv_home;
    private TextView tv_address;
    private TextView tv_friend;
    private TextView tv_setting;
    private TextView tv_tiwen;

    // 中间内容区域
    private ViewPager viewPager;

    // ViewPager适配器ContentAdapter
    private ContentAdapter adapter;

    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();

    }

    private void initEvent() {
        // 设置按钮监听
        ll_home.setOnClickListener(this);
        ll_address.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        ll_setting.setOnClickListener(this);
        ll_tiwen.setOnClickListener(this);
        //设置ViewPager滑动监听
        viewPager.setOnPageChangeListener(this);
    }

    private void initView() {

        // 底部菜单4个Linearlayout
        this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
        this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
        this.ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
        this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);
        this.ll_tiwen = (LinearLayout) findViewById(R.id.ll_tiwen);
        // 底部菜单4个ImageView
        this.iv_home = (ImageView) findViewById(R.id.iv_home);
        this.iv_address = (ImageView) findViewById(R.id.iv_address);
        this.iv_friend = (ImageView) findViewById(R.id.iv_friend);
        this.iv_setting = (ImageView) findViewById(R.id.iv_setting);
        this.iv_tiwen = (ImageView) findViewById(R.id.iv_tiwen);
        // 底部菜单4个菜单标题
        this.tv_home = (TextView) findViewById(R.id.tv_home);
        this.tv_address = (TextView) findViewById(R.id.tv_address);
        this.tv_friend = (TextView) findViewById(R.id.tv_friend);
        this.tv_setting = (TextView) findViewById(R.id.tv_setting);
        this.tv_tiwen = (TextView) findViewById(R.id.tv_tiwen);
        // 中间内容区域ViewPager
        this.viewPager = (ViewPager) findViewById(R.id.vp_content);

        // 适配器
        View page_01 = View.inflate(MainActivity.this, R.layout.page_01, null);

        WebView webView= page_01.findViewById(R.id.webview_shouye);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.loadUrl("https://www.aisuangua.com");
        try {
            Thread.currentThread().sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });
        View page_02 = View.inflate(MainActivity.this, R.layout.page_02, null);
        WebView webView02= page_02.findViewById(R.id.webview_xuanshang);
        webView02.getSettings().setJavaScriptEnabled(true);
        webView02.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView02.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView02.loadUrl("https://www.aisuangua.com/smbaike/smbaikeInfo");
        try {
            Thread.currentThread().sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webView02.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

        View page_03 = View.inflate(MainActivity.this, R.layout.page_03, null);
        WebView webView03= page_03.findViewById(R.id.webview_tiwen);
        webView03.getSettings().setJavaScriptEnabled(true);
        webView03.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView03.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView03.loadUrl("https://www.aisuangua.com/smbaike/smbaikeTiwen");
        try {
            Thread.currentThread().sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webView03.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

        View page_04 = View.inflate(MainActivity.this, R.layout.page_04, null);
        WebView webView04= page_04.findViewById(R.id.webview_suanming);
        webView04.getSettings().setJavaScriptEnabled(true);
        webView04.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView04.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView04.loadUrl("https://www.aisuangua.com/sgj/suanguajie?pagenum=1");
        try {
            Thread.currentThread().sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webView04.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

        View page_05 = View.inflate(MainActivity.this, R.layout.page_05, null);

        WebView webView05= page_05.findViewById(R.id.webview_wode);
        webView05.getSettings().setJavaScriptEnabled(true);
        webView05.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView05.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView05.loadUrl("https://www.aisuangua.com");
        try {
            Thread.currentThread().sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webView05.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });

        views = new ArrayList<View>();
        views.add(page_01);
        views.add(page_02);
        views.add(page_03);
        views.add(page_04);
        views.add(page_05);

        this.adapter = new ContentAdapter(views);
        viewPager.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_home:
                iv_home.setImageResource(R.drawable.shouye_on);
                tv_home.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_address:
                iv_address.setImageResource(R.drawable.xuanshang_on);
                tv_address.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(1);
                break;

            case R.id.ll_tiwen:
                iv_tiwen.setImageResource(R.drawable.tiwen_on);
                tv_tiwen.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(2);
                break;

            case R.id.ll_friend:
                iv_friend.setImageResource(R.drawable.zaixiansuanming_on);
                tv_friend.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(3);
                break;
            case R.id.ll_setting:
                iv_setting.setImageResource(R.drawable.wode_on);
                tv_setting.setTextColor(0xff1B940A);
                viewPager.setCurrentItem(4);
                break;



            default:
                break;
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_home.setImageResource(R.drawable.shouye_zc);
        iv_address.setImageResource(R.drawable.xuanshang_zc);
        iv_friend.setImageResource(R.drawable.zaixiansuanming_zc);
        iv_setting.setImageResource(R.drawable.wode_zc);
        iv_tiwen.setImageResource(R.drawable.tiwen_zc);

        // TextView置为白色
        tv_home.setTextColor(0xffffffff);
        tv_address.setTextColor(0xffffffff);
        tv_friend.setTextColor(0xffffffff);
        tv_setting.setTextColor(0xffffffff);
        tv_tiwen.setTextColor(0xffffffff);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        restartBotton();
        //当前view被选择的时候,改变底部菜单图片，文字颜色
        switch (arg0) {
            case 0:
                iv_home.setImageResource(R.drawable.shouye_on);
                tv_home.setTextColor(0xff1B940A);
                break;
            case 1:
                iv_address.setImageResource(R.drawable.xuanshang_on);
                tv_address.setTextColor(0xff1B940A);
                break;

            case 2:
                iv_tiwen.setImageResource(R.drawable.tiwen_on);
                tv_tiwen.setTextColor(0xff1B940A);
                break;

            case 3:
                iv_friend.setImageResource(R.drawable.zaixiansuanming_on);
                tv_friend.setTextColor(0xff1B940A);
                break;
            case 4:
                iv_setting.setImageResource(R.drawable.wode_on);
                tv_setting.setTextColor(0xff1B940A);
                break;


            default:
                break;
        }

    }

}