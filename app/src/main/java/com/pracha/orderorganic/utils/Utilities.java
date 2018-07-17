package com.pracha.orderorganic.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by saif on 27-10-2017.
 */
public class Utilities {

    public static Boolean isJSONObject(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String source) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(source);
        }
    }

    public static Boolean isValidInput(Object str) {
        if (str != null && String.valueOf(str).length() > 0 &&
                !String.valueOf(str).equalsIgnoreCase("null")) {
            String new_string = String.valueOf(str).trim();
            if (new_string.isEmpty()) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static Boolean isStringNotNull(Object str) {
        if (str == null || String.valueOf(str).length() == 0 || String.valueOf(str).equalsIgnoreCase("null")) {
            return false;
        } else {
            return true;
        }
    }

    public static Boolean isBooleanValue(Object str) {
        if (str == null && String.valueOf(str).length() == 0 || String.valueOf(str).equalsIgnoreCase("null")) {
            return false;
        } else {
            return (Boolean) str;
        }
    }

    public static Boolean isStringEmpty(Object str) {
        if (str != null && String.valueOf(str).length() == 0 && !String.valueOf(str).equalsIgnoreCase("null")) {
            return true;
        } else {
            return false;
        }
    }

    public static void editTextFocusHandler(final EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // If has focus then change the alpha to 1
//                    editText.setAlpha(0.5f);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        editText.setBackgroundTintList(ColorStateList.valueOf(getR.color.white));
                    }
                } else {
                    // When focus is lost, check if some text has been entered.
                    // If not then set the alpha to 0.5f (50% transparent)
                    if (TextUtils.isEmpty(editText.getText().toString())) {
//                        editText.setAlpha(0.3f);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            editText.setBackgroundTintList(ColorStateList.valueOf(R.color.color_grey));
//                            editText.setBackgroundTintList(ColorStateList.valueOf(R.color.white));
                        }
                    }
                }
                editText.invalidate();
            }
        });
    }


    public static boolean appInstalledOrNot(Context context, String package_name) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(package_name, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }

    public static PackageInfo getInstalledAppDetails(Context context, String package_name) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(package_name, PackageManager.GET_ACTIVITIES);
            return pm.getPackageInfo(package_name,
                    PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
        }

        return null;
    }


    public static String getString(Object str) {
        if (str != null && String.valueOf(str).length() > 0 && !String.valueOf(str).equalsIgnoreCase("null")) {
            return String.valueOf(str);
        } else {
            return "";
        }
    }

    public static Boolean validateClickForNonInternet(Boolean is_active_internet, Context context) {
        if (is_active_internet) {

        } else {
            Utilities.showToast(Constants.NO_INTERNET_CONNECTION_TAG, context);
        }
        return is_active_internet;
    }

    static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public static String urlEncodeUTF8(Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    urlEncodeUTF8(entry.getKey().toString()),
                    urlEncodeUTF8(entry.getValue().toString())
            ));
        }
        return sb.toString();
    }

    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if (json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        return retMap;
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

    public static void showToast(String msg, Context ctx) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showToastLong(String msg, Context ctx) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
        }
    }


    public static void showToastCenter(String msg, Context ctx) {
        if (!TextUtils.isEmpty(msg)) {
            Toast toast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
    }

    public static String getDeviceOS() {
        // TODO Auto-generated method stub
        String os_details = "";
        StringBuilder builder = new StringBuilder();
        //		builder.append("android : ").append(Build.VERSION.RELEASE);

        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (fieldValue == Build.VERSION.SDK_INT) {
                builder = new StringBuilder();
                builder.append("").append(fieldName).append(" ").append(Build.VERSION.RELEASE);
                //		        builder.append("sdk=").append(fieldValue);
            }
        }

        //		Log.d(LOG_TAG, "OS: " + builder.toString());

        os_details = builder.toString();
        //		Log.d(LOG_TAG, "OS: " + builder.toString());
        return os_details;
    }

    public static String getAppVersion(Context activity) {
        // TODO Auto-generated method stub
        PackageInfo pInfo;
        String app_version = "";
        try {
            pInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            app_version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return app_version;
//		return "1.0.11";
    }

    public static String getDeviceId(Context activity) {
        return Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


    public static Boolean checkForceUpdate(Context context) {
        // TODO Auto-generated method stub
        // force update business login
        String current_version_name;
        int current_version_code = 0;
        Boolean is_force_upgrade_status = false;
//        DBUtilities dbUtilities = DBUtilities.getInstance();
        is_force_upgrade_status = false;

        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            current_version_name = pInfo.versionName;
            current_version_code = pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return false;
    }


    public static void openPlaystoreApp(Activity context, String package_name, int JOB_REQUEST_CODE) {
        try {
            context.startActivityForResult(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.APPLICATION_IN_PLAY_STORE_MARKET + package_name)), JOB_REQUEST_CODE);
        } catch (ActivityNotFoundException anfe) {
            context.startActivityForResult(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.APPLICATION_IN_PLAY_STORE + package_name)), JOB_REQUEST_CODE);
        }
    }

    /**
     * Check that Google Play services APK is installed and up to date.
     *
     * @return true if Google Play Services is available and up to
     * date on this device; false otherwise.
     */
 /*   public boolean isGooglePlayServicesAvailable(Context context) {
        GoogleApiAvailability apiAvailability =
                GoogleApiAvailability.getInstance();
        final int connectionStatusCode =
                apiAvailability.isGooglePlayServicesAvailable(context);
        return connectionStatusCode == ConnectionResult.SUCCESS;
    }*/
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

}
