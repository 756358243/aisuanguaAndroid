package com.example.aisuangua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aisuangua.MyFragment.ShouYeFragment;
import com.example.aisuangua.MyFragment.SuanMingFragment;
import com.example.aisuangua.MyFragment.TiWenFragment;
import com.example.aisuangua.MyFragment.WoDeFragment;
import com.example.aisuangua.MyFragment.XuanShangFragment;

public class MainActivity extends FragmentActivity implements OnClickListener {
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

    // 4个Fragment
    private Fragment shouyeFragment;
    private Fragment xuanshangFragment;
    private Fragment tiwenFragment;
    private Fragment suanmingFragment;
    private Fragment wodeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
        // 初始化并设置当前Fragment
        initFragment(0);

    }

    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (shouyeFragment == null) {
                    shouyeFragment = new ShouYeFragment();
                    transaction.add(R.id.fl_content, shouyeFragment);
                } else {
                    transaction.show(shouyeFragment);
                }
                break;
            case 1:
                if (xuanshangFragment == null) {
                    xuanshangFragment = new XuanShangFragment();
                    transaction.add(R.id.fl_content, xuanshangFragment);
                } else {
                    transaction.show(xuanshangFragment);
                }

                break;
            case 2:
                if (tiwenFragment == null) {
                    tiwenFragment = new TiWenFragment();
                    transaction.add(R.id.fl_content, tiwenFragment);
                } else {
                    transaction.show(tiwenFragment);
                }

                break;
            case 3:
                if (suanmingFragment == null) {
                    suanmingFragment = new SuanMingFragment();
                    transaction.add(R.id.fl_content, suanmingFragment);
                } else {
                    transaction.show(suanmingFragment);
                }

                break;
            case 4:
                if (wodeFragment == null) {
                    wodeFragment = new WoDeFragment();
                    transaction.add(R.id.fl_content, wodeFragment);
                } else {
                    transaction.show(wodeFragment);
                }

                break;

            default:
                break;
        }

        // 提交事务
        transaction.commit();

    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (shouyeFragment != null) {
            transaction.hide(shouyeFragment);
        }
        if (xuanshangFragment != null) {
            transaction.hide(xuanshangFragment);
        }
        if (tiwenFragment != null) {
            transaction.hide(tiwenFragment);
        }
        if (suanmingFragment != null) {
            transaction.hide(suanmingFragment);
        }
        if (wodeFragment != null) {
            transaction.hide(wodeFragment);
        }
    }

    private void initEvent() {
        // 设置按钮监听
        ll_home.setOnClickListener(this);
        ll_address.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        ll_setting.setOnClickListener(this);
        ll_tiwen.setOnClickListener(this);
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
                initFragment(0);
                break;
            case R.id.ll_address:
                iv_address.setImageResource(R.drawable.rili_on);
                tv_address.setTextColor(0xff1B940A);
                initFragment(1);
                break;
            case R.id.ll_tiwen:
                iv_tiwen.setImageResource(R.drawable.tiwen_on);
                tv_tiwen.setTextColor(0xff1B940A);
                initFragment(2);
                break;

            case R.id.ll_friend:
                iv_friend.setImageResource(R.drawable.zaixiansuanming_on);
                tv_friend.setTextColor(0xff1B940A);
                initFragment(3);
                break;

            case R.id.ll_setting:
                iv_setting.setImageResource(R.drawable.wode_on);
                tv_setting.setTextColor(0xff1B940A);
                initFragment(4);
                break;

            default:
                break;
        }

    }

    private void restartBotton() {
        // ImageView置为灰色
        iv_home.setImageResource(R.drawable.shouye_zc);
        iv_address.setImageResource(R.drawable.rili_zc);
        iv_tiwen.setImageResource(R.drawable.tiwen_zc);
        iv_friend.setImageResource(R.drawable.zaixiansuanming_zc);
        iv_setting.setImageResource(R.drawable.wode_zc);
        // TextView置为白色
        tv_home.setTextColor(0xff000000);
        tv_address.setTextColor(0xff000000);
        tv_friend.setTextColor(0xff000000);
        tv_setting.setTextColor(0xff000000);
        tv_tiwen.setTextColor(0xff000000);
    }



}