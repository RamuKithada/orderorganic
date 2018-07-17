package com.pracha.orderorganic.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.pracha.orderorganic.apis.MYURL;
import com.pracha.orderorganic.utils.Constants;


public class MySharedPreference {
    // To check User Opened First time or not (make variable public to access from outside)

    // Sharedpref file name
    private static final String PREF_NAME = "ProPref";
    // Shared Preferences
    static SharedPreferences pref;
    // Editor for Shared preferences
    static Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    static int PRIVATE_MODE = 0;

    public static final String IS_TESTING_POINTED = "is_testing_pointed";
    public static final String USER_EMAIL = "user_email";
    public static final String USERNAME = "username";
    public static final String FIRSTNAME = "first_name";
    public int getAppOpenedTimes() {
        return pref.getInt(Constants.SHARED_PREF_APP_OPEN_COUNT, 0);
    }

    public void setAppOpenCount() {
        editor.putInt(Constants.SHARED_PREF_APP_OPEN_COUNT, pref.getInt(Constants.SHARED_PREF_APP_OPEN_COUNT, 0) + 1);
        editor.commit();
    }

    // Constructor
    public MySharedPreference(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void clearSharePreferenceData() {
        editor.clear().commit();
    }

    public void setUserAuthenticationStatus(Boolean status) {
        editor.putBoolean(Constants.SHARED_PREF_IS_AUTHENTICATED_USER, status);
        editor.commit();
    }

    public Boolean isUserAuthenticationStatus() {
        return pref.getBoolean(Constants.SHARED_PREF_IS_AUTHENTICATED_USER, false);
    }

    public void setUserEmail(String userEmail) {
        editor.putString(USER_EMAIL, userEmail);
        editor.commit();
    }


    public String getUserEmail() {
        return pref.getString(USER_EMAIL, null);
    }

    public void setUsername(String username) {
        editor.putString(USERNAME,username);
        editor.commit();
    }

    public String getUsername() {
        return pref.getString(USERNAME,null);
    }

    public void setFirstName(String first_name) {
        editor.putString(FIRSTNAME,first_name);
        editor.commit();
    }

    public String getFirstName() {
        return pref.getString(FIRSTNAME,null);
    }


    public void setServerAuthenticationStatus(Boolean status) {
        editor.putBoolean(Constants.SHARED_PREF_IS_SERVER_AUTHENTICATION, status);
        editor.commit();
    }

    public Boolean isServerAuthenticationStatus() {
        return pref.getBoolean(Constants.SHARED_PREF_IS_SERVER_AUTHENTICATION, false);
    }

    public void setFacebookAuthenticationStatus(Boolean status) {
        editor.putBoolean(Constants.SHARED_PREF_IS_FACEBOOK_VERIFIED, status);
        editor.commit();
    }

    public Boolean isFacebookAuthenticationStatus() {
        return pref.getBoolean(Constants.SHARED_PREF_IS_FACEBOOK_VERIFIED, false);
    }

    public void setFacebookEmailID(String email) {
        editor.putString(Constants.SHARED_PREF_FACEBOOK_EMAIL, email);
        editor.commit();
    }

    public String getFacebookEmailID() {
        return pref.getString(Constants.SHARED_PREF_FACEBOOK_EMAIL, null);
    }

    public void setFacebookToken(String email) {
        editor.putString(Constants.SHARED_PREF_FACEBOOK_TOKEN, email);
        editor.commit();
    }

    public String getFacebookToken() {
        return pref.getString(Constants.SHARED_PREF_FACEBOOK_TOKEN, null);
    }

    public void setGoogleAuthenticationStatus(Boolean status) {
        editor.putBoolean(Constants.SHARED_PREF_IS_GOOGLE_VERIFIED, status);
        editor.commit();
    }

    public Boolean isGoogleAuthenticationStatus() {
        return pref.getBoolean(Constants.SHARED_PREF_IS_GOOGLE_VERIFIED, false);
    }

    public void setGoogleEmailID(String email) {
        editor.putString(Constants.SHARED_PREF_GOOGLE_EMAIL, email);
        editor.commit();
    }

    public String getGoogleEmailID() {
        return pref.getString(Constants.SHARED_PREF_GOOGLE_EMAIL, null);
    }

    public void setGoogleToken(String email) {
        editor.putString(Constants.SHARED_PREF_GOOGLE_TOKEN, email);
        editor.commit();
    }

    public String getGoogleToken() {
        return pref.getString(Constants.SHARED_PREF_GOOGLE_TOKEN, null);
    }

    public void setAppFirstTimeOpenCompletedStatus(Boolean status) {
        editor.putBoolean(Constants.SHARED_PREF_IS_FIRST_TIME_OPEN_COMPLETED, status);
        editor.commit();
    }

    public Boolean isAppFirstTimeOpenCompletedStatus() {
        return pref.getBoolean(Constants.SHARED_PREF_IS_FIRST_TIME_OPEN_COMPLETED, false);
    }

    public static String getPointedBaseURL(Context context) {
        // TODO Auto-generated method stub
        if (context != null) {
            if (getTestPointingStatus(context) == 0)
                return MYURL.PRODUCTION_BASE_URL;
            else if (getTestPointingStatus(context) == 1)
                return MYURL.TEST_BASE_URL;
            else
                return MYURL.PRODUCTION_BASE_URL;
        } else {
            if (getTestPointingStatus() == 0)
                return MYURL.PRODUCTION_BASE_URL;
            else if (getTestPointingStatus() == 1)
                return MYURL.TEST_BASE_URL;
            else
                return MYURL.PRODUCTION_BASE_URL;
        }
    }

    public static String getPointedPASBaseURL(Context context) {
        // TODO Auto-generated method stub
        if (context != null) {
            if (getTestPointingStatus(context) == 0)
                return MYURL.PRODUCTION_BASE_URL;
            else if (getTestPointingStatus(context) == 1)
                return MYURL.TEST_BASE_URL;
            else
                return MYURL.PRODUCTION_BASE_URL;
        } else {
            if (getTestPointingStatus() == 0)
                return MYURL.PRODUCTION_BASE_URL;
            else if (getTestPointingStatus() == 1)
                return MYURL.TEST_BASE_URL;
            else
                return MYURL.PRODUCTION_BASE_URL;
        }
    }

    public static int getTestPointingStatus(Context context) {
        try {
            pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
            int pointing_value = pref.getInt(IS_TESTING_POINTED, 0);
        } catch (Exception e) {
            // TODO: handle exception
            Boolean status = false;
            status = pref.getBoolean(IS_TESTING_POINTED, false);
            if (status) {
                editor.putInt(IS_TESTING_POINTED, 1);
                editor.commit();
            } else {
                editor.putInt(IS_TESTING_POINTED, 0);
                editor.commit();
            }
        }
        return pref.getInt(IS_TESTING_POINTED, 0);
    }

    public static int getTestPointingStatus() {
        try {
            int pointing_value = pref.getInt(IS_TESTING_POINTED, 0);
        } catch (Exception e) {
            // TODO: handle exception
            Boolean status = pref.getBoolean(IS_TESTING_POINTED, false);
            if (status != null) {
                if (status) {
                    editor.putInt(IS_TESTING_POINTED, 1);
                    editor.commit();
                } else {
                    editor.putInt(IS_TESTING_POINTED, 0);
                    editor.commit();
                }
            } else {
                editor.putInt(IS_TESTING_POINTED, 0);
                editor.commit();
            }
        }
        return pref.getInt(IS_TESTING_POINTED, 0);
    }

    public void createTestPointingStatus(int server_pointer) {
        editor.putInt(IS_TESTING_POINTED, server_pointer);
        editor.commit();
    }


    public boolean getsocialmediaStatus() {
        return pref.getBoolean("socialmediaStatus", false);
    }

    public void setsocialmediaStatus(boolean social) {
        editor.putBoolean("socialmediaStatus", social);
        editor.commit();
    }


    public int getOtheruserLogincount() {
        return pref.getInt("otheruserlogincount", 0);
    }

    public void setOtheruserLogincount(int logincount) {
        editor.putInt("otheruserlogincount", logincount);
        editor.commit();
    }


}
