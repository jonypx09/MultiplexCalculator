package com.jonypx09.multiplexcalculator;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private Boolean switchPref;
    private Boolean amoledPref;

    private String privacyPolicy =

            "<p> Jonathan Pelastine built the Multiplex Calculator app as a Free app. This SERVICE is provided by\n" +
                    "                    Jonathan Pelastine at no cost and is intended for use as is.\n" +
                    "                  </p> <p>This page is used to inform visitors regarding my policies with the collection, use, and disclosure\n" +
                    "                    of Personal Information if anyone decided to use my Service.\n" +
                    "                  </p> <p>If you choose to use my Service, then you agree to the collection and use of information in\n" +
                    "                    relation to this policy. The Personal Information that I collect is used for providing and improving\n" +
                    "                    the Service. I will not use or share your information with anyone except as described\n" +
                    "                    in this Privacy Policy.\n" +
                    "                  </p> <p><strong>Information Collection and Use</strong></p> <p>For a better experience, while using our Service, I may require you to provide us with certain\n" +
                    "                    personally identifiable information. The information that I request will be retained on your device and is not collected by me in any way.\n" +
                    "                  </p> <p>The app does use third party services that may collect information used to identify you.</p> <div><p>Link to privacy policy of third party service providers used by the app</p> <ul><li><a href=\"https://www.google.com/policies/privacy/\" target=\"_blank\">Google Play Services</a></li><!----><!----><!----><!----><!----><!----><!----></ul></div> <p><strong>Log Data</strong></p> <p> I want to inform you that no log data is collected whenever you use my Service.\n" +
                    "                    To report any issues with this app, please contact me at \n jpxsoftware@gmail.com\n" +
                    "                  </p> <p><strong>Cookies</strong></p> <p>Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers.\n" +
                    "                    These are sent to your browser from the websites that you visit and are stored on your device's internal\n" +
                    "                    memory.\n" +
                    "                  </p> <p>This Service does not use these “cookies” in any way." +
                    "                  </p> <p><strong>Security</strong></p> <p> I value your trust in providing us your Personal Information, thus we are striving\n" +
                    "                    to use commercially acceptable means of protecting it. But remember that no method of transmission over\n" +
                    "                    the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee\n" +
                    "                    its absolute security.\n" +
                    "                  </p> <p><strong>Links to Other Sites</strong></p> <p>This Service may contain links to other sites. If you click on a third-party link, you will be directed\n" +
                    "                    to that site. Note that these external sites are not operated by me. Therefore, I strongly\n" +
                    "                    advise you to review the Privacy Policy of these websites. I have no control over\n" +
                    "                    and assume no responsibility for the content, privacy policies, or practices of any third-party sites\n" +
                    "                    or services.\n" +
                    "                  </p> <p><strong>Children’s Privacy</strong></p> <p>These Services do not address anyone under the age of 13. I do not knowingly collect\n" +
                    "                    personally identifiable information from children under 13. In the case I discover that a child\n" +
                    "                    under 13 has provided me with personal information, I immediately delete this from\n" +
                    "                    our servers. If you are a parent or guardian and you are aware that your child has provided us with personal\n" +
                    "                    information, please contact me so that I will be able to do necessary actions.\n" +
                    "                  </p> <p><strong>Changes to This Privacy Policy</strong></p> <p> I may update our Privacy Policy from time to time. Thus, you are advised to review\n" +
                    "                    this page periodically for any changes. I will notify you of any changes by posting\n" +
                    "                    the new Privacy Policy on this page. These changes are effective immediately after they are posted on\n" +
                    "                    this page.\n" +
                    "                  </p> <p><strong>Contact Us</strong></p> <p>If you have any questions or suggestions about my Privacy Policy, do not hesitate to contact\n" +
                    "                    me.\n" +
                    "                  </p>";

    private String creditsList =

            "\n<p>\u2022Udo Klimaschewski for <a href=\"https://github.com/uklimaschewski/EvalEx\">EvalEx</a>, an advanced evalutor expression</p>" +
            "\n<p>\u2022Mehdi Sakout for providing a template for the About Page</p>";

    private String eula = "";


    private String changelogHistory =
            "<p><strong>1.3</strong></p><p>-Minor bug fixes in Basic Calculator<br/>" +
            "<p><strong>1.2</strong></p><p>-Fixed a crash with a few calculator functions<br/>" +
                    "-Optimized rendering of default and dark themes\n</p>" +
            "<p><strong>1.1</strong></p><p>-Fixed a broken link with Google Play<br/>" +
                    "-Modified Changelog Page to show history of changes\n</p>" +
            "<p><strong>1.0</strong></p><p>-Initial Release (No Changes)\n</p>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Special Thanks to Medyo for providing template
        //Link to GitHub: https://github.com/medyo/android-about-page
        Element changelogElement = new Element();
        changelogElement.setTitle("Changelog");
        changelogElement.setIconDrawable(R.drawable.delta);
        changelogElement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(AboutActivity.this)
                        .setTitle("Changelog History")
                        .setMessage(Html.fromHtml(changelogHistory))
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Whatever...
                            }
                        }).show();
            }
        });

        Element creditsElement = new Element();
        creditsElement.setTitle("Credits");
        creditsElement.setIconDrawable(R.drawable.copyright);
        creditsElement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(AboutActivity.this)
                        .setTitle("Credits")
                        .setMessage(Html.fromHtml(creditsList))
                        .setCancelable(true)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Whatever...
                            }
                        }).show();
            }
        });

        Element disclaimerElement = new Element();
        disclaimerElement.setTitle("End User License Agreement");
        disclaimerElement.setIconDrawable(R.drawable.alert_octagon);

        Element privacyElement = new Element();
        privacyElement.setTitle("Privacy Policy");
        privacyElement.setIconDrawable(R.drawable.shield_lock);
        privacyElement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new AlertDialog.Builder(AboutActivity.this)
                        .setTitle("Privacy Policy")
                        .setMessage(Html.fromHtml(privacyPolicy))
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Whatever...
                            }
                        }).show();
            }
        });

        Element gitHubElement = new Element();
        gitHubElement.setTitle("Fork my project on GitHub");
        gitHubElement.setIconDrawable(R.drawable.about_icon_github);
        gitHubElement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent gitHubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/jonypx09"));
                startActivity(gitHubIntent);
            }
        });

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Multiplex Calculator is a simple app that combines the functionalities " +
                        "of a calculator along with the ability to convert various units of measurement")
                .setImage(R.mipmap.ic_launcher)
                .addGroup("Version 1.3")
                .addItem(changelogElement)
                .addGroup("Connect")
                .addEmail("jpxsoftware@gmail.com")
                .addPlayStore("com.jonypx09.multiplexcalculator")
                .addItem(gitHubElement)
                .addGroup("Misc")
                .addItem(creditsElement)
                .addItem(disclaimerElement)
                .addItem(privacyElement)
                .create();

//        aboutPage.setBackgroundColor(Color.WHITE);
        setContentView(aboutPage);


//        setContentView(R.layout.activity_about);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        switchPref = sharedPref.getBoolean(SettingsActivity.DARK_MODE_SWITCH, false);
        amoledPref = sharedPref.getBoolean(SettingsActivity.AMOLED_MODE_SWITCH, false);
        if (switchPref){
            if (amoledPref){
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#2e2e2d"));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2e2e2d")));
                getWindow().setStatusBarColor(Color.BLACK);
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#2e2e2d"));
                ((Activity)this).setTaskDescription(taskDescription);
            }else{
                setTheme(R.style.SettingsFragmentStyleDark);
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#4d4d4d"));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00463E")));
                getWindow().setStatusBarColor(Color.parseColor("#FF003C35"));
                ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00463E"));
                ((Activity)this).setTaskDescription(taskDescription);
            }
        }else{
            setTheme(R.style.SettingsFragmentStyle);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00A192")));
            getWindow().setStatusBarColor(Color.parseColor("#FF006E60"));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00A192"));
            ((Activity)this).setTaskDescription(taskDescription);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
