package com.example.citieslistapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citieslistapp.R;
import com.example.citieslistapp.adapters.CityAdapter;
import com.example.citieslistapp.application.CityApplication;
import com.example.citieslistapp.base.CityPresenter;
import com.example.citieslistapp.model.CityObject;
import com.example.citieslistapp.service.CityService;
import com.example.citieslistapp.service.CityViewInterface;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;

public class InfoActivity extends AppCompatActivity implements CityViewInterface{

    @Inject
    CityService mService;

    private CityPresenter mPresenter;
    Intent intent;
    View appView2;
    TextView tvTitleCity;
    String titleCity;

    @Bind(R.id.recycleView2) RecyclerView mRecyclerView;
    private CityAdapter mAdapter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
            intent = getIntent();
            titleCity = intent.getStringExtra("intent");
            resolveDependecy();
            ButterKnife.bind(InfoActivity.this);
            configViews();
            mPresenter =  new CityPresenter(InfoActivity.this);
            mPresenter.onCreate();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void configViews() {
        appView2 = findViewById(R.id.appView2);
        tvTitleCity = (TextView)findViewById(R.id.tvTitleCity);
        tvTitleCity.setText(titleCity);
        if (isNetworkAvailable()) {
            mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mAdapter = new CityAdapter(getLayoutInflater());
            mRecyclerView.setAdapter(mAdapter);
        }
        else{
            Snackbar.make(appView2, "Connection is not available", Snackbar.LENGTH_LONG).show();
        }
    }

    public void resolveDependecy(){
        ((CityApplication)getApplication())
                .getApiComponent()
                .inject(InfoActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchCities();
        mProgressDialog =  new ProgressDialog(InfoActivity.this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setTitle("Downloading Information");
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.show();
    }

    @Override
    public void onCompleted() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mProgressDialog.dismiss();
        if (isNetworkAvailable()) {
            Toast.makeText(InfoActivity.this, message, Toast.LENGTH_LONG).show();
        }
        else{
            Snackbar.make(appView2, "Connection is not available", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCityInformations(CityObject cityObject) {
        mAdapter.addCityInfrormationsResponse(cityObject);
    }

    @Override
    public Observable<CityObject> getCities() {
        return mService.getCities(titleCity, 10, "sergeydeveloper");
    }
}
