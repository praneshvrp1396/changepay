package com.example.siva1.change;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created on 10/09/18.
 */

public abstract class ResponseHandler implements IResponseHandler {

    public View loadingLayout;
    public View errorLayout;
    View loadingScreen;
    public final String TAG = "ResponseHandleer";

    public ResponseHandler(View loadingLayout, View errorLayout) {
        this.loadingLayout = loadingLayout;
        this.errorLayout = errorLayout;
    }


    /**
     * The showLoadingLayout and stopLoadingLayout functions are used to show and stop the loading layout when the response handler
     * object is used as a callback outside of the Volley Service(Because that implicitly sets and removes the loading layouts.
     * This was introduced specifically to show the loading screen when uploading a file for a Print Order.
     * @param mContext
     */
    public void showLoadingLayout(Context mContext) {
        ViewGroup viewGroup;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (loadingLayout != null && loadingLayout.getParent() != null) {
            Log.d(TAG, "Now setting the loading screen");
            viewGroup = (ViewGroup) loadingLayout.getParent();
            loadingScreen = inflater.inflate(R.layout.loading_screen, null);
            viewGroup.addView(loadingScreen, loadingLayout.getLayoutParams());
        }
    }

    /**
     * The showLoadingLayout and stopLoadingLayout functions are used to show and stop the loading layout when the response handler
     * object is used as a callback outside of the Volley Service(Because that implicitly sets and removes the loading layouts.
     * This was introduced specifically to show the loading screen when uploading a file for a Print Order.
     */
    public void stopLoadingLayout() {
        ViewGroup viewGroup;
        if (loadingScreen != null && loadingLayout != null && loadingLayout.getParent() != null) {
            Log.d(TAG, "removing the Loading showLoadingLayoutInView");
            viewGroup = (ViewGroup) loadingLayout.getParent();
            viewGroup.removeView(loadingScreen);
        }

    }

    public View getLoadingLayout() {
        return loadingLayout;
    }

    public void setLoadingLayout(View loadingLayout) {
        this.loadingLayout = loadingLayout;
    }

    public View getErrorLayout() {
        return errorLayout;
    }

    public void setErrorLayout(View errorLayout) {
        this.errorLayout = errorLayout;
    }
}
