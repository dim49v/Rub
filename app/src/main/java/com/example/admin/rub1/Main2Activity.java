package com.example.admin.rub1;

import android.app.Activity;
import android.os.Bundle;

public class Main2Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //открытие области представления
        super.onCreate(savedInstanceState);
        setContentView(new Draw(this));
    }
}

