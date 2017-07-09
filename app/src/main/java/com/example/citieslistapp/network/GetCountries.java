package com.example.citieslistapp.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;

/**
 * Created by Серёга on 07.07.2017.
 */

public abstract class GetCountries extends AsyncTask<String, Void, String> {

    ProgressDialog progressDialog;

    MainSettings mainSettings =  new MainSettings();
    Context context;
    Handler h;

    public GetCountries(ProgressDialog progressDialog, Context context) {
        this.context = context;
        this.progressDialog = progressDialog;
}

    public abstract void onSucess(String s);

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(progressDialog !=null && !progressDialog.isShowing()) {
            progressDialog.setTitle("Loading data, please wait...");
            progressDialog.setMessage("Progress");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(247);
            progressDialog.setIndeterminate(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            h = new Handler() {
                public void handleMessage(Message msg) {
                    progressDialog.setIndeterminate(false);
                    if (progressDialog.getProgress() < progressDialog.getMax()) {
                        progressDialog.incrementProgressBy(2);
                        progressDialog.incrementSecondaryProgressBy(3);
                        h.sendEmptyMessageDelayed(0, 100);
                    } else {
                        progressDialog.dismiss();
                    }
                }
            };
            h.sendEmptyMessageDelayed(0, 2000);
        }
    }

    @Override
    protected String doInBackground(String... params) {
        GetConnection http = new GetConnection();
        mainSettings.parseJson(http.getJsonObj(params), context);
        return http.getJsonObj(params);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("json", s);
        editor.putBoolean("isdata", true);
        editor.commit();
        onSucess(s);
    }
}