package com.example.citieslistapp.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.citieslistapp.R;
import com.example.citieslistapp.adapters.RecycleCitiesAdapter;
import com.example.citieslistapp.network.MainSettings;

import java.util.ArrayList;

/**
 * Created by Серёга on 08.07.2017.
 */

public class ExampleFragment extends Fragment {

    private View view;

    private RecyclerView recyclerView;

    private static final int LAYOUT = R.layout.fragment_recycler_view;

    public static ExampleFragment getInstance() {
        Bundle args = new Bundle();
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("No data");
        recyclerView.setAdapter(new RecycleCitiesAdapter(arrayList));
        return view;
    }

}