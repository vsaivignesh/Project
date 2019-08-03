package com.example.libsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splscr extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}