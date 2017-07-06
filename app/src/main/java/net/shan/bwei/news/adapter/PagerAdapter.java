package net.shan.bwei.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.shan.bwei.news.frag.PageFragment;

/**
 * Created by shanlianting on 2017/7/6.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    public String[] tags ={"aa","bb","ccc","ddd","eee","fffff"};
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tags[position];
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.getInstance(tags[position]);
    }

    @Override
    public int getCount() {
        return tags.length;
    }
}
