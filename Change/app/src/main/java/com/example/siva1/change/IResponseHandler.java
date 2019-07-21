package com.example.siva1.change;

import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface IResponseHandler {
    public void notifySuccess(JSONObject response, ViewGroup viewParent);
    public void notifyError(VolleyError error);
    public void notifyRetry(View errorView, JSONObject requestData);
}
