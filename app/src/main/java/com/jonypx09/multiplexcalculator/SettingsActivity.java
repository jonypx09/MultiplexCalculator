package com.jonypx09.multiplexcalculator;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    public static final String DARK_MODE_SWITCH = "dark_mode_switch";
    public static final String AMOLED_MODE_SWITCH = "amoled_mode_switch";
    public static final String FAV_SHORTCUT1 = "fav_shortcut1";
    public static final String FAV_SHORTCUT2 = "fav_shortcut2";
    public static final String FAV_SHORTCUT3 = "fav_shortcut3";

    private SharedPreferences sharedPref;
    private Boolean switchPref;
    private Boolean amoledPref;
    private Preference prefFeedback;


    //Colour Scheme for Dark Mode
    private int[][] statesDark = new int[][] {
            new int[] { android.R.attr.state_checked}, // checked
            new int[] {-android.R.attr.state_checked}, // unchecked
            new int[] {-android.R.attr.state_enabled}

    };
    private int[] colorsDark = new int[] {
            Color.parseColor("#FF00D7C3"),
            Color.GRAY,
            Color.WHITE
    };
    private ColorStateList darkTheme = new ColorStateList(statesDark, colorsDark);

    private ListView optionsList;

    private TextView preferenceTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        optionsList = (ListView) findViewById(R.id.optionsList);


        switchPref = sharedPref.getBoolean(SettingsActivity.DARK_MODE_SWITCH, false);
        amoledPref = sharedPref.getBoolean(SettingsActivity.AMOLED_MODE_SWITCH, false);
        if (switchPref){
//            getWindow().getDecorView().setBackgroundColor(Color.parseColor("#4d4d4d"));
            if (amoledPref){
                setTheme(R.style.SettingsFragmentStyleAmoled);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e2e2d")));
                getWindow().setStatusBarColor(Color.BLACK);
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#2e2e2d"));
                ((Activity)this).setTaskDescription(taskDescription);
            }else{
                setTheme(R.style.SettingsFragmentStyleDark);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00463E")));
                getWindow().setStatusBarColor(Color.parseColor("#FF003C35"));
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00463E"));
                ((Activity)this).setTaskDescription(taskDescription);
            }

//            getWindow().setStatusBarColor(Color.parseColor("#FF00463E"));
//            preferenceTitles.setTextColor(Color.WHITE);

//            optionsList.setForegroundTintList(darkTheme);

        }else{
//            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            setTheme(R.style.SettingsFragmentStyle);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00A192")));
            getWindow().setStatusBarColor(Color.parseColor("#FF006E60"));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00A192"));
            ((Activity)this).setTaskDescription(taskDescription);
//            getWindow().setStatusBarColor(Color.parseColor("#FF00A192"));
//            preferenceTitles.setTextColor(Color.BLACK);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        //Refer to the following link to add click event to static preference links
        /**
         *
         * https://guides.codepath.com/android/settings-with-preferencefragment
         *
         */

        // handle the preference change here
        if (key.equals("dark_mode_switch")) {
            switchPref = sharedPref.getBoolean(SettingsActivity.DARK_MODE_SWITCH, false);
            if (switchPref){
//                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#4d4d4d"));
                setTheme(R.style.SettingsFragmentStyleDark);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00463E")));
                getWindow().setStatusBarColor(Color.parseColor("#FF003C35"));
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00463E"));
                ((Activity)this).setTaskDescription(taskDescription);

//                preferenceTitles.setTextColor(Color.WHITE);

                recreate();
//                finish();
//                startActivity(getIntent());


            }else{
//                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                setTheme(R.style.SettingsFragmentStyle);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00A192")));
                getWindow().setStatusBarColor(Color.parseColor("#FF006E60"));
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00A192"));
                ((Activity)this).setTaskDescription(taskDescription);

                recreate();
//                finish();
//                startActivity(getIntent());

//                preferenceTitles.setTextColor(Color.BLACK);
            }

        }else if (key.equals("amoled_mode_switch")){


            //Implement AMOLED Dark Mode Here as well as in the first branch

            switchPref = sharedPref.getBoolean(SettingsActivity.AMOLED_MODE_SWITCH, false);
            if (switchPref){
                setTheme(R.style.SettingsFragmentStyleAmoled);

                recreate();
            }else{
                setTheme(R.style.SettingsFragmentStyleDark);
                recreate();
            }




        }
    }

//    @Override
//    public void onBackPressed(){
//        super.onBackPressed();
//        startActivity(new Intent(SettingsActivity.this, MainActivity.class));
//    }

}
