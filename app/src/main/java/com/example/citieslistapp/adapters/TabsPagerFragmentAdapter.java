package com.example.citieslistapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.citieslistapp.fragments.ExampleFragment;

/**
 * Created by Серёга on 08.07.2017.
 */

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Current Country Cities";
    }

    @Override
    public Fragment getItem(int position) {
        return ExampleFragment.getInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
