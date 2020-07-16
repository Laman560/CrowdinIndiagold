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
    String organizationName = "CrowdinIndiagold";
    String distributionhash = "f2b2074f37a112482f4ce98je38";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Crowdin.init(this,
                new CrowdinConfig.Builder()
                        .withDistributionHash(distributionhash)
                        .withRealTimeUpdates()
                        .withScreenshotEnabled()
                        .withSourceLanguage("English")
                        .withAuthConfig(new AuthConfig(clientId, clientSecret, organizationName))
                        .withNetworkType(NetworkType.ALL)                                           
                        .withUpdateInterval(900)                                 
                        .build());
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Crowdin.authorize(this);
    }
}
