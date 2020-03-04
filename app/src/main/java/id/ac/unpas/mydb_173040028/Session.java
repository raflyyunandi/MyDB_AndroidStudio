package id.ac.unpas.mydb_173040028;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    public static String PREF_NAME = "DataMahasiswa";

    public static void createSignInSession(Context context, String username){
        preferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = preferences.edit();
        editor.putString("username", username);
        editor.commit();
    }

    public static void logout(Context context){
        preferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
