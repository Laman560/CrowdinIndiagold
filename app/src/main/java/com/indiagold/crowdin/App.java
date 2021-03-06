package com.indiagold.crowdin;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.crowdin.platform.data.model.AuthConfig;
import com.crowdin.platform.Crowdin;
import com.crowdin.platform.CrowdinConfig;
import com.crowdin.platform.data.remote.NetworkType;

public class App extends AppCompatActivity {

    String clientId = "kQ3mHY0GLJXZ6UI3QoSD";
    String clientSecret = "Dykxw0IosHzPd8XkWZIYz6uiaskuKR6DFveh0Y68";
    String organizationName = null;
    String distributionhash = "6122e5509896afe40bf7168je38";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Crowdin.init(this,
                new CrowdinConfig.Builder()
                        .withDistributionHash(distributionhash)
                        .withRealTimeUpdates()
                        .withScreenshotEnabled()
                        .withSourceLanguage("en")
                        .withAuthConfig(new AuthConfig(clientId, clientSecret ,organizationName))
                        .withNetworkType(NetworkType.ALL)
                        .withUpdateInterval(3)
                        .build());
    }

    @Override
    public void onCreate( Bundle savedInstanceState,  PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Crowdin.authorize(this);
    }
}
