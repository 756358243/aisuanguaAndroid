package com.example.aisuangua;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/**
 * ViewPager适配器
 * @author zp
 *
 */
class ContentAdapter extends PagerAdapter {

    private List<View> views;

    public ContentAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }


    /**
     * 跳转到每个页面都要执行的方法
     */
    @Override
    public void setPrimaryItem(View container, int position, Object object) {
        //把这个position赋值到一个全局变量，通过这个就会知道滑动到哪个页面了

    }


}
