package com.example.siva1.change;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DecimalFormat;

//import com.amazonaws.auth.CognitoCachingCredentialsProvider;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
//import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import domain.Address;
//import domain.Cart;
//import domain.Customer;
//import domain.Merchant;
//import domain.Order;

public class Constants {
    public static final int LOCATION_PAY_DISTANCE_METERS = 2000;
    public static final int API_RESPONSE_CACHE_LIMIT = 120000;
    public static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
            .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    //    public static final String SERVER_ADDRESS = "www.changepay.in/api";
//    public static final String API_URL = "https://" + SERVER_ADDRESS + "/ChangePay/Customer/v2";
//    public static final String API_URL = "http://192.168.13.41:8080" + "/ChangePay/Customer/v3";
    public static final String API_URL = "http://35.154.220.16/api" + "/ChangePay/Customer/v3";
    public static final String LOGIN_URL = API_URL + "/Login";
    public static final String MERCHANT_SEARCH_URL = API_URL + "/merchantSearch";
    public static final String WALLET_URL = API_URL + "/getWallet";
    public static final String BASE_S3_PATH = "https://s3.ap-south-1.amazonaws.com/changepaybucket1/CustomerFiles/";
    public static final String RECHARGE_URL = API_URL + "/getOTP";
    public static final String GET_OTP = API_URL + "/getOTP";
    public static final String LOGOUT_URL = API_URL + "/Logout";
    public static final String REGISTER_URL = API_URL + "/RegisterNewCustomer";
    public static final String PLACE_ORDER_AT_MERCHANT_URL = API_URL + "/placeOrderAtMerchant";
    public static final String GET_ADDRESS_LIST_URL = API_URL + "/getAllAddresses";
    public static final String ADD_ADDRESS_URL = API_URL + "/addAddress";
    public static final String USE_OTP_URL = API_URL + "/useOTP";
    public static final String INITIATE_ONLINE_PAYMENT = API_URL + "/initiateOnlinePayment";
    public static final String COMPLETE_ONLINE_PAYMENT = API_URL + "/completeOnlinePayment";
    public static final String GET_ALL_CLUSTERS_URL = API_URL + "/getAllClusters";
    public static final String EDIT_ADDRESS_URL = API_URL + "/editAddress";
    public static final String DELETE_ADDRESS_URL = API_URL + "/removeAddress";
    public static final String DELETE_ACCOUNT_URL = API_URL + "/deleteAccount";
    public static final String GET_APPLICABLE_OFFER = API_URL + "/getApplicableOffers";
    public static final String UPDATE_DETAILS_API_URL = API_URL + "/updateDetails";
    public static final String GET_LANDGINGPAGE_OFFER_URL = API_URL + "/getLandingPageOffers";
    public static final String GET_AWS_TOKEN_URL = "/getAWSTokens";
    public static final String POPULATE_ORDER_CHARGES = API_URL + "/populateOrderCharges";
    //Order API calls
    public static final String UPDATE_ORDERS = API_URL + "/updateOrders";

    public static final DecimalFormat df2 = new DecimalFormat("0.00");

    public static final int CODE_SUCCESSFUL = 200;
    public static final int CODE_USER_NOT_FOUND = 401;
    //TODO:Move all of the API Status Code Constants to a different file imported here.
    public static final int CODE_INSUFFICIENT_FUNDS = 402;
    public static final int CODE_INSUFFICIENT_LIMIT = 405;
    public static final int CODE_INVALID_SESSION_DATA = 450;
    public static final int CODE_MESSAGE_NOT_SENT = 453;
    public static final int CODE_NO_INTERNET = 455;
    public static final int CODE_REQUEST_TIMEOUT = 456;
    public static final String PAYU_FURL = "https://www.payumoney.com/mobileapp/payumoney/failure.php";
    public static final String PAYU_SURL = "https://www.payumoney.com/mobileapp/payumoney/success.php";
}
//    //Firebase
//    public static final String FIREBASE_TOKEN = "firebase token";
//    private static final String AWS_ID_POOL_ID = "us-east-1:e7216481-e854-4d42-966b-32b3cfcdde22";
//    public static Order order;
//    public static ArrayList<Address> userAddresses = new ArrayList<>();
//    public static Customer customer = null;
//    public static String clusterID = null;
//    public static LocationManager locationManager = null;
//    public static String defaultOfferImage = "https://s3.ap-south-1.amazonaws.com/changepaybucket1/OfferImages/Offerheader.png";
//    // Hold a reference to the current animator,
//    // so that it can be canceled mid-way.
//    private static Animator mCurrentAnimator = null;
//
//    static {
//        Constants.df2.setMaximumFractionDigits(2);
//        Constants.df2.setMinimumFractionDigits(0);
//        Constants.df2.setCurrency(Currency.getInstance("INR"));
//        order = new Order();
//        order.setCart(new Cart());
////        order.getCart().setService(Service.ServiceEnum.FOOD_DELIVERY);
////        Constants.developerProvider = new AWS
////        Constants.df2.setMinimumFractionDigits(0);
//
//    }
//
//    public static void clearCart() {
//        order.setCart(new Cart());
//    }
//
//    public static boolean checkLocationEnabled(Activity activity) {
//
//        if (locationManager == null)
//            locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
//        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//    }
//
//    @SuppressLint("MissingPermission")
//    public static boolean getLocation(Activity activity, final LocationListener locationCallback) {
//        if (locationManager == null)
//            locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
//        if (checkPermissions(activity)) {
//            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            if (lastKnownLocation == null)
//                lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            if (lastKnownLocation != null)
//                locationCallback.domainOnLocationChanged(lastKnownLocation, false);
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 0, locationCallback);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean checkPermissions(Activity activity) {
//        if (ContextCompat.checkSelfPermission(activity,
//                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            return true;
//        } else {
//            requestPermissions(activity);
//            return false;
//        }
//    }
//
//    public static boolean isLocationEnabled(final Activity activity) {
//
//        if (!checkLocationEnabled(activity)) {
//            AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
//            alertDialog.setTitle("Enable Location");
//            alertDialog.setMessage("We need access to your location to sort the merchants by distance to you.");
//            alertDialog.setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                    activity.startActivity(intent);
//                }
//            });
//            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.cancel();
//                }
//            });
//            AlertDialog alert = alertDialog.create();
//            alert.show();
//        }
//        return checkLocationEnabled(activity);
//    }
//
//    public static void setLocationErrorLayout(LayoutInflater inflater, Activity activity, ViewGroup errorLayout) {
//        View error_location_layout;
//        if (!Constants.isLocationEnabled(activity)) {
//            error_location_layout = inflater.inflate(R.layout.error_location_disabled, null);
//        } else {
//            error_location_layout = inflater.inflate(R.layout.error_location_permission_disabled, null);
//        }
//        errorLayout.addView(error_location_layout);
//    }
//
//    public static String addRupeeSymbol(String inputString) {
//        return "\u20B9 " + inputString;
//    }
//
//    public static void requestPermissions(Activity activity) {
//        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
//        ActivityCompat.requestPermissions(activity, permissions, 1);
//    }
//
//    public static void hideSoftKeyboard(Activity activity) {
//        InputMethodManager inputMethodManager =
//                (InputMethodManager) activity.getSystemService(
//                        Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(
//                activity.getCurrentFocus().getWindowToken(), 0);
//    }
//
//    public static void showToast(Activity activity, String message, int toastLength) {
//        View layout = activity.getLayoutInflater().inflate(R.layout.toast_custom, (ViewGroup) activity.findViewById(R.id.custom_toast_layout_id));
//        ((TextView) layout.findViewById(R.id.text)).setText(message);
//        Toast toast = new Toast(activity);
//        toast.setDuration(toastLength);
//        toast.setView(layout);
//        toast.show();
//    }
//
//    //    @Override
////    public void onRequestPermissionsResult(int requestCode,
////                                           String permissions[], int[] grantResults) {
////        switch (requestCode) {
////            case 1: {
////                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
////
////                    // permission was granted, yay! do the
////                    // calendar task you need to do.
////
////                } else {
////
////                    // permission denied, boo! Disable the
////                    // functionality that depends on this permission.
////                }
////                return;
////            }
////        }
////    }
//
//    public static boolean isShopOpenRightNow(Merchant merchant) {
//        if (merchant.getFlags().contains(Merchant.MerchantFlags.IS_SHOP_CLOSED)) {
//            return false;
//        } else {
//            return Constants.isShopOpenRightNow(merchant.getOpenTime(), merchant.getCloseTime());
//        }
//    }
//
//    public static boolean isShopOpenRightNow(String openTime, String closeTime) {
//        boolean isShopOpen = false;
//        if (openTime == null) {
//            openTime = "10:00 AM";
//        }
//        if (closeTime == null) {
//            closeTime = "08:00 PM";
//        }
//        try {
//            SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd yyyy");
//            String today = dateFormatter.format(new Date());
//            SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy hh:mm aa");
//            long today_close_time = df.parse(today + " " + closeTime).getTime();
//            long today_open_time = df.parse(today + " " + openTime).getTime();
//            long time_right_now = System.currentTimeMillis();
//            if (today_close_time > today_open_time)
//                if (time_right_now < today_close_time && time_right_now > today_open_time)
//                    isShopOpen = true;
//                else {
//                    isShopOpen = false;
//                }
//            else {
//                long yesterdays_open_time = today_open_time - (1000 * 60 * 60 * 24);
//                long tommorrow_close_time = today_close_time + (1000 * 60 * 60 * 24);
//                if (
//                        (time_right_now > yesterdays_open_time && time_right_now < today_close_time)
//                                ||
//                                (time_right_now > today_open_time && time_right_now < tommorrow_close_time)
//                ) {
//                    isShopOpen = true;
//                } else {
//                    isShopOpen = false;
//                }
//            }
//
//
////            if (currentEpoch > OpenEpoch && currentEpoch < CloseEpoch)
////                return true;
////            else
////                return false;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return isShopOpen;
//
//    }
//
//    public static void markmandatory(TextView text) {
//
//        String simple = text.getText().toString();
//        String colored = "*";
//        SpannableStringBuilder builder = new SpannableStringBuilder();
//        builder.append(simple);
//        int start = builder.length();
//        builder.append(colored);
//        int end = builder.length();
//
//        builder.setSpan(new ForegroundColorSpan(Color.RED), start, end,
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        text.setText(builder);
//    }
//
//    public static double distanceTo(double lat1, double lon1, double lat2, double lon2, DistanceUnit unit) {
//        double theta = lon1 - lon2;
//        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
//                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
//        dist = Math.acos(dist);
//        dist = rad2deg(dist);
//        dist = dist * 60 * 1.1515;
//        switch (unit) {
//            case KILOMETER:
//                dist = dist * 1.609344;
//                break;
//
//            case METER:
//                dist = dist * 1.609344 * 1000;
//                break;
//            default:
//                break;
//        }
//        return (dist);
//    }
//
//    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
//    /* :: This function converts decimal degrees to radians : */
//    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
//    private static double deg2rad(double deg) {
//        return (deg * Math.PI / 180.0);
//    }
//
//    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
//    /* :: This function converts radians to decimal degrees : */
//    /* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
//    private static double rad2deg(double rad) {
//        return (rad * 180.0 / Math.PI);
//    }
//
//    // Hold a reference to the current animator,
//    // so that it can be canceled mid-way.
////    private static Animator mCurrentAnimator = null;
//    public static void zoomImageFromThumb(final View thumbView, final ImageView zoomImageView, View DestinationImageView, final int mShortAnimationDuration) {
//        // If there's an animation in progress, cancel it
//        // immediately and proceed with this one.
//        if (mCurrentAnimator != null) {
//            mCurrentAnimator.cancel();
//        }
//
//        // Load the high-resolution "zoomed-in" image.
//        //final ImageView expandedImageView = (ImageView) findViewById(
//        //        R.id.expanded_image);
//        //zoomImageView.setImageResource(imageResId);
//        // Calculate the starting and ending bounds for the zoomed-in image.
//        // This step involves lots of math. Yay, math.
//        final Rect startBounds = new Rect();
//        final Rect finalBounds = new Rect();
//        final Point globalOffset = new Point();
//
//
//        // The start bounds are the global visible rectangle of the thumbnail,
//        // and the final bounds are the global visible rectangle of the container
//        // view. Also set the container view's offset as the origin for the
//        // bounds, since that's the origin for the positioning animation
//        // properties (X, Y).
//        thumbView.getGlobalVisibleRect(startBounds);
//        DestinationImageView.getGlobalVisibleRect(finalBounds, globalOffset);
//
//        //startBounds.offset(-globalOffset.x, -globalOffset.y);
//        //finalBounds.offset(-globalOffset.x, -globalOffset.y);
//
//        // Adjust the start bounds to be the same aspect ratio as the final
//        // bounds using the "center crop" technique. This prevents undesirable
//        // stretching during the animation. Also calculate the start scaling
//        // factor (the end scaling factor is always 1.0).
//        float startScale;
//        if ((float) finalBounds.width() / finalBounds.height()
//                > (float) startBounds.width() / startBounds.height()) {
//            // Extend start bounds horizontally
//            startScale = (float) startBounds.height() / finalBounds.height();
//            float startWidth = startScale * finalBounds.width();
//            float deltaWidth = (startWidth - startBounds.width()) / 2;
//            startBounds.left -= deltaWidth;
//            startBounds.right += deltaWidth;
//        } else {
//            // Extend start bounds vertically
//            startScale = (float) startBounds.width() / finalBounds.width();
//            float startHeight = startScale * finalBounds.height();
//            float deltaHeight = (startHeight - startBounds.height()) / 2;
//            //startBounds.top -= deltaHeight;
//            startBounds.bottom += deltaHeight;
//        }
//
//        // Hide the thumbnail and show the zoomed-in view. When the animation
//        // begins, it will position the zoomed-in view in the place of the
//        // thumbnail.
//        thumbView.setAlpha(0f);
//        zoomImageViewBG.setVisibility(View.VISIBLE);
//        zoomImageView.setVisibility(View.VISIBLE);
//
//        // Set the pivot point for SCALE_X and SCALE_Y transformations
//        // to the top-left corner of the zoomed-in view (the default
//        // is the center of the view).
//        //ResultImageView.setPivotX(0f);
//        //ResultImageView.setPivotY(0f);
//
//        // Construct and run the parallel animation of the four translation and
//        // scale properties (X, Y, SCALE_X, and SCALE_Y).
//        AnimatorSet set = new AnimatorSet();
//        set
//                .play(ObjectAnimator.ofFloat(zoomImageView, View.X,
//                        startBounds.left, finalBounds.left))
//                .with(ObjectAnimator.ofFloat(zoomImageView, View.Y,
//                        startBounds.top, finalBounds.top))
//                .with(ObjectAnimator.ofFloat(zoomImageView, View.SCALE_X,
//                        startScale, 1f))
//                .with(ObjectAnimator.ofFloat(zoomImageView,
//                        View.SCALE_Y, startScale, 1f));
//        set.setDuration(mShortAnimationDuration);
//        set.setInterpolator(new DecelerateInterpolator());
//        set.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mCurrentAnimator = null;
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//                mCurrentAnimator = null;
//            }
//        });
//        set.start();
//        mCurrentAnimator = set;
//
//        // Upon clicking the zoomed-in image, it should zoom back down
//        // to the original bounds and show the thumbnail instead of
//        // the expanded image.
//        final float startScaleFinal = startScale;
//        zoomImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mCurrentAnimator != null) {
//                    mCurrentAnimator.cancel();
//                }
//                zoomImageViewBG.setVisibility(View.GONE);
//                // Animate the four positioning/sizing properties in parallel,
//                // back to their original values.
//                final AnimatorSet set = new AnimatorSet();
//                set.play(ObjectAnimator
//                        .ofFloat(zoomImageView, View.X, startBounds.left))
//                        .with(ObjectAnimator
//                                .ofFloat(zoomImageView,
//                                        View.Y, startBounds.top))
//                        .with(ObjectAnimator
//                                .ofFloat(zoomImageView,
//                                        View.SCALE_X, startScaleFinal))
//                        .with(ObjectAnimator
//                                .ofFloat(zoomImageView,
//                                        View.SCALE_Y, startScaleFinal));
//                set.setDuration(mShortAnimationDuration);
//                set.setInterpolator(new DecelerateInterpolator());
//                set.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        thumbView.setAlpha(1f);
//                        zoomImageView.setVisibility(View.INVISIBLE);
//                        mCurrentAnimator = null;
//                    }
//
//                    @Override
//                    public void onAnimationCancel(Animator animation) {
//                        thumbView.setAlpha(1f);
//                        zoomImageView.setVisibility(View.INVISIBLE);
//                        mCurrentAnimator = null;
//                    }
//                });
//                set.start();
//                mCurrentAnimator = set;
//            }
//        });
//
//    }
//
//    public static String getPathinS3ForACustomerPDF(final String personID, int index) {
//        return Constants.BASE_S3_PATH + personID + "/" + System.currentTimeMillis() + index + ".pdf";//getFileName(fileUri);//a8b02672-45b8-47b0-b026-7245b8d7b023/abc.jpg";
//
//    }
//
//    public static void upload(final Context mContext, final String pathInS3, final InputStream fileInputStream, final ResponseHandler responseHandler) {
//        Log.d("UPLOAD", "Upload Function Beginning");
//        CognitoCachingCredentialsProvider creds = new CognitoCachingCredentialsProvider(
//                mContext,
//                Constants.AWS_ID_POOL_ID, // Identity Pool ID
//                Regions.US_EAST_1 // Region
//        );
//        final String bucketName = "changepaybucket1";
//        try {
//            responseHandler.showLoadingLayout(mContext);
//            Constants.uploadInternal(mContext, bucketName, pathInS3, fileInputStream, creds, responseHandler);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    public static void uploadInternal(final Context mContext, String bucketName, String S3Path, InputStream fileInputStream, CognitoCachingCredentialsProvider creds, final IResponseHandler responseHandler) throws FileNotFoundException {
//        AmazonS3 s3;
//        s3 = new AmazonS3Client(creds);
//        OutputStream output = null;
//        Log.d("UploadPath", S3Path);
//
//        try {
//            File file;
//            try {
//                String relPath = S3Path.substring(53);
//                relPath = relPath.substring(relPath.lastIndexOf("/"));
//                file = new File(mContext.getCacheDir(), relPath);
//                output = new FileOutputStream(file);
//                byte[] buffer = new byte[4 * 1024]; // or other buffer size
//                int read;
//
//                while ((read = fileInputStream.read(buffer)) != -1) {
//                    output.write(buffer, 0, read);
//                }
//                output.flush();
//            } catch (Exception e) {
//                throw e;
//            } finally {
//                output.close();
//                fileInputStream.close();
//            }
//
//            TransferUtility transferUtility = new TransferUtility(s3, mContext);
//            if (file.exists()) {
//                TransferListener transferListener = new TransferListener() {
//                    @Override
//                    public void onStateChanged(int id, TransferState state) {
//                        if (state.equals(TransferState.COMPLETED)) {
//                            file.delete();
//                            responseHandler.notifySuccess(null, null);
//                        } else if (state.equals(TransferState.FAILED)) {
//                            file.delete();
//                            Constants.showToast((Activity) mContext, "Upload failed. Please try again after some time or contact support. " + state, Toast.LENGTH_LONG);
//                        }
////                        else {
////                            Constants.showToast((Activity) mContext, "The state is " + state, Toast.LENGTH_LONG);
////                        }
//                    }
//
//                    @Override
//                    public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
//                        long progress = bytesCurrent / bytesTotal;
//                        if (progress > 0 && progress < 0.25) {
//                            Constants.showToast((Activity) mContext, "Upload Started", Toast.LENGTH_SHORT);
//                            //Quarter 1
//                        } else if (progress >= 0.25 && progress < 0.50) {
//                            Constants.showToast((Activity) mContext, "25% done", Toast.LENGTH_SHORT);
//                            //Quarter 2
//                        } else if (progress >= 0.5 && progress < 0.75) {
//                            Constants.showToast((Activity) mContext, "50% done", Toast.LENGTH_SHORT);
//                            //Quarter 3
//                        } else if (progress >= 0.75 && progress <= 1) {
//                            Constants.showToast((Activity) mContext, "75% Done.", Toast.LENGTH_SHORT);
//                            //Quarter 4
//                        }
//                    }
//
//                    @Override
//                    public void onError(int id, Exception ex) {
//                        Log.e("UPLOAD", ex.getMessage());
//                        ex.printStackTrace();
//                        file.delete();
//                        responseHandler.notifyError(null);
//                    }
//                };
//                Log.d("UPLOAD", "The file exists. Now calling the TransferObserver");
//                String relPath = S3Path.substring(53);
//                Log.d("Upload", relPath);
//                TransferObserver observer = transferUtility.upload(
//                        bucketName,  //this is the bucket name on S3
//                        relPath, //this is the path and name
//                        file, //path to the file locally
//                        CannedAccessControlList.PublicRead //to make the file public
//                );
//                observer.setTransferListener(transferListener);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public enum DistanceUnit {
//        KILOMETER, METER
//    }
//
//}
