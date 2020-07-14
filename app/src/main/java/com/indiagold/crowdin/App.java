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

    String clientId = "4F3pxkZEWTpofXfHxWbY";
    String clientSecret = "i83xaCIVOoTKKMobanVUjxEpsHiWOYON1tsKUFbp";
    String organizationName = "CrowdinIndiagold";
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Crowdin.init(this,
                new CrowdinConfig.Builder()
                        .withDistributionHash("1a41018ed9540982e9db878je38")
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
