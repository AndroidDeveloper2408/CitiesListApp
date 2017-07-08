package com.example.citieslistapp.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Серёга on 07.07.2017.
 */

public abstract class GetCountries extends AsyncTask<String, Void, String> {

    ProgressDialog progressDialog;

    MainSettings mainSettings =  new MainSettings();
    Context context;


    public GetCountries(ProgressDialog progressDialog, Context context) {
        this.context = context;
        this.progressDialog = progressDialog;
    }

    public abstract void onSucess(String s);

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(progressDialog !=null && !progressDialog.isShowing()) {
            progressDialog.setMessage("Update data");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }
    }

    @Override
    protected String doInBackground(String... params) {
        GetConnection http = new GetConnection();
        return http.getJsonObj(params);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(progressDialog !=null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        onSucess(s);
    }

}
