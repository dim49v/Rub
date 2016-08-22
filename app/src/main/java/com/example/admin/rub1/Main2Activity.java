package com.example.admin.rub1;

import android.app.Activity;
import android.os.Bundle;

public class Main2Activity extends Activity {
    public boolean resh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Draw(this));
    }
}

