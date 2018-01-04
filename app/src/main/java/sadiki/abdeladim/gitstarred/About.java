package sadiki.abdeladim.gitstarred;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

/**
 * Created by Abdeladim SADIKI on 04/01/2018.
 */

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View aboutPage = new AboutPage(this)
                .setDescription("The idea of this app is to list the most starred Github repos that were created in the last 30 days.\nHiddenfounders Mobile Coding Challenge\nPFE 2018")
                .isRTL(false)
                .addGroup("Connect with us")
                .addEmail("sadiki.abdeladim@gmail.com")
                .addFacebook("abdeladim.sadiki")
                .addGitHub("AbdeladimSadiki")
                .create();

        setContentView(aboutPage);
    }
}

