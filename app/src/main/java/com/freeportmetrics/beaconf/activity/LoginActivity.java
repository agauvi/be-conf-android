package com.freeportmetrics.beaconf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.freeportmetrics.beaconf.R;
import com.freeportmetrics.beaconf.Utils;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View someView = findViewById(R.id.content);
        View root = someView.getRootView();
        root.setBackgroundColor(getResources().getColor(android.R.color.white));

        String userId = Utils.getDefaults(Utils.USER_ID_PREF_KEY, this);
        if(userId!=null){
            Intent intent = new Intent(this, RoomStatusActivity.class);
            startActivity(intent);
            finish();
        }
    }
    
    public void submitUserId(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String userId = editText.getText().toString();
        Utils.setDefaults(Utils.USER_ID_PREF_KEY, userId, this);

        Intent intent = new Intent(this, RoomStatusActivity.class);
        startActivity(intent);
    }
}