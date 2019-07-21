package com.example.siva1.change;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieManager;
import java.util.HashMap;

import static com.android.volley.VolleyLog.TAG;
import static com.example.siva1.change.Constants.CODE_INSUFFICIENT_FUNDS;
import static com.example.siva1.change.Constants.CODE_INSUFFICIENT_LIMIT;
import static com.example.siva1.change.Constants.CODE_INVALID_SESSION_DATA;
import static com.example.siva1.change.Constants.CODE_MESSAGE_NOT_SENT;
import static com.example.siva1.change.Constants.CODE_NO_INTERNET;
import static com.example.siva1.change.Constants.CODE_REQUEST_TIMEOUT;
import static com.example.siva1.change.Constants.CODE_USER_NOT_FOUND;

/**
 * Created by guptapc on 10/09/18.
 */

public class VolleyService {

    public static HashMap<String, APIResponse> responseCache;
    static CookieManager cookieManager;
    Context mContext;
    LayoutInflater inflater;
    ViewGroup viewGroup;
    View showLoadingLayoutInView;
    View showErrorLayoutInView;


    public VolleyService(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
        if (cookieManager == null) {
//            cookieManager = new CookieManager(new PersistentCookieStoreJava(mContext), CookiePolicy.ACCEPT_ALL);
//            CookieHandler.setDefault(this.cookieManager);
        }
    }

    public static HashMap<String, APIResponse> getResponseCache() {
        if (VolleyService.responseCache == null) {
            VolleyService.setResponseCache(new HashMap<String, APIResponse>());
        }
        return responseCache;
    }

    public static void setResponseCache(HashMap<String, APIResponse> responseCache) {
        VolleyService.responseCache = responseCache;
    }

    public void postDataVolley(final ResponseHandler resultListener, final String URL, final JSONObject requestData, boolean forceRefresh) {

        this.showLoadingLayoutInView = resultListener.getLoadingLayout();
        this.showErrorLayoutInView = resultListener.getErrorLayout();
        try {
            Log.d(TAG, "In the post Volley method and hitting URL " + URL);
            Log.d(TAG, "Hitting with the request data " + requestData.toString());
            if (VolleyService.getResponseCache().keySet().contains(URL) && VolleyService.getResponseCache().get(URL).isRecentResponse() && !forceRefresh) {
                Log.d(TAG, "Cached Response Present");
                resultListener.notifySuccess(VolleyService.getResponseCache().get(URL).getResponseData(), null);
            } else {
                Log.d(TAG, "Making a new POST call now");
                RequestQueue queue = Volley.newRequestQueue(mContext);
                JsonObjectRequest jsonObj;

                final View loadingScreen;
                if (showLoadingLayoutInView != null && showLoadingLayoutInView.getParent() != null) {
                    Log.d(TAG, "Now setting the loading screen");
                    viewGroup = (ViewGroup) showLoadingLayoutInView.getParent();
                    loadingScreen = inflater.inflate(R.layout.loading_screen, null);
//                    loadingScreen.bringToFront();
                    viewGroup.addView(loadingScreen, showLoadingLayoutInView.getLayoutParams());
                } else {
                    loadingScreen = null;
                    viewGroup = null;
                }
                jsonObj = new JsonObjectRequest(URL, requestData, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        VolleyService.getResponseCache().put(URL, new APIResponse(response, System.currentTimeMillis() + ""));
                        try {
                            Log.d(TAG, "The statusCode received from the " + URL + " API is " + response.getInt("statusCode"));
                            Log.d(TAG, "The status received from the API is " + response.getString("status"));
                            if (viewGroup != null) {
                                Log.d(TAG, "removing the Loading showLoadingLayoutInView");
                                viewGroup.removeView(loadingScreen);
                            }
                            if (response.getInt("statusCode") == Constants.CODE_SUCCESSFUL)
                                resultListener.notifySuccess(response, viewGroup);
                            else {
                                populateErrorView(response.getInt("statusCode"), resultListener, requestData, response.getString("status"));
                                resultListener.notifySuccess(response, viewGroup);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (resultListener != null) {

                            if (viewGroup != null) {
                                Log.d(TAG, "removing the Loading showLoadingLayoutInView");
                                viewGroup.removeView(loadingScreen);
                            }
                            if(!isNetworkConnected())
                            populateErrorView(CODE_NO_INTERNET, resultListener, requestData, "No internet Connection Found!");
                            else
                            populateErrorView(CODE_REQUEST_TIMEOUT, resultListener, requestData, "Unable to get the response, Request Timeout!");


                            resultListener.notifyError(error);


                        }

                    }
                });
                jsonObj.setRetryPolicy(new DefaultRetryPolicy(
                        15000,
                        4,
                        1.4f));
                queue.add(jsonObj);
            }
        } catch (Exception e) {
            Log.d(TAG, "Exception " + e);
        }

    }


    private void populateErrorView(int reasonCode, final ResponseHandler resultListener, final JSONObject requestData, final String reasonMessage) {

        if (showErrorLayoutInView != null) {

            viewGroup = (ViewGroup) showErrorLayoutInView.getParent();
            final View loaderrorView = inflater.inflate(R.layout.error_no_internet, null);
            loaderrorView.bringToFront();
            Button retry = loaderrorView.findViewById(R.id.retry);
            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resultListener.notifyRetry(loaderrorView, requestData);
                }
            });
            TextView errortext = loaderrorView.findViewById(R.id.errorText);
            ImageView errorImage=loaderrorView.findViewById(R.id.errorImage);

            switch (reasonCode) {

                case CODE_USER_NOT_FOUND:
                    retry.setText("OK");
                    errorImage.setImageResource(R.drawable.error_user_not_found);
                    errortext.setText(reasonMessage);
                    viewGroup.addView(loaderrorView, showErrorLayoutInView.getLayoutParams());
                    break;

                case CODE_INSUFFICIENT_FUNDS:
                    errortext.setText(reasonMessage);
                    errorImage.setImageResource(R.drawable.error_insufficient_fund);
                    viewGroup.addView(loaderrorView, showErrorLayoutInView.getLayoutParams());
                    break;

                case CODE_INSUFFICIENT_LIMIT:
                    errortext.setText(reasonMessage);
                    errorImage.setImageResource(R.drawable.error_insufficient_limit);
                    viewGroup.addView(loaderrorView, showErrorLayoutInView.getLayoutParams());
                    break;

                case CODE_INVALID_SESSION_DATA:
                    errortext.setText(reasonMessage);
                    errorImage.setImageResource(R.drawable.error_invalid_session);
//                    Intent intent = new Intent(mContext, LoginActivity.class);
//                    mContext.startActivity(intent);
                    break;
                case CODE_MESSAGE_NOT_SENT:
                    errortext.setText(reasonMessage);
                    errorImage.setImageResource(R.drawable.error_message_not_sent);
                    viewGroup.addView(loaderrorView, showErrorLayoutInView.getLayoutParams());
                    break;

                case CODE_NO_INTERNET:
                    errortext.setText(reasonMessage);
                    errorImage.setImageResource(R.drawable.error_no_iternet);
                    viewGroup.addView(loaderrorView, showErrorLayoutInView.getLayoutParams());
                    break;
                case CODE_REQUEST_TIMEOUT:
                    errortext.setText(reasonMessage);
                    errorImage.setImageResource(R.drawable.error_request_timeout);
                    viewGroup.addView(loaderrorView, showErrorLayoutInView.getLayoutParams());
                    break;

                default:
                    retry.setText("OK");
                    errortext.setText(reasonMessage);
                    errorImage.setImageResource(R.drawable.error_internal);
                    viewGroup.addView(loaderrorView, showErrorLayoutInView.getLayoutParams());
                    break;
            }

        }

    }

    class APIResponse {
        JSONObject responseData;
        String rcvTS;

        public APIResponse() {
        }

        public APIResponse(JSONObject responseData, String rcvTS) {
            this.responseData = responseData;
            this.rcvTS = rcvTS;
        }

        public JSONObject getResponseData() {
            return responseData;
        }

        public void setResponseData(JSONObject responseData) {
            this.responseData = responseData;
        }

        public String getRcvTS() {
            return rcvTS;
        }

        public void setRcvTS(String rcvTS) {
            this.rcvTS = rcvTS;
        }

        public boolean isRecentResponse() {
            return (System.currentTimeMillis() - Double.parseDouble(rcvTS)) < 120000;
        }
    }

    private boolean isNetworkConnected() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }




}