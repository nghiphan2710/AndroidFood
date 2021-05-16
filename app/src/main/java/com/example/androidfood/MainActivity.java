package com.example.androidfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class MainActivity extends AppCompatActivity {
    Button btnSignin, btnSignup,btnAddfood;

    ImageView ivLogo;
    RelativeLayout ivBackground;

    Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            ivBackground.setBackground(new BitmapDrawable(getResources(), bitmap));
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignin = findViewById(R.id.btn_signin);
        btnSignup = findViewById(R.id.btn_signup);
        btnAddfood = findViewById(R.id.btn_addfood);
        ivLogo = findViewById(R.id.iv_logo);
        ivBackground = findViewById(R.id.img_backround);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(MainActivity.this,SignUp.class);
                startActivity(signup);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(MainActivity.this,SignIn.class);
                startActivity(signin);
            }
        });
        btnAddfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addfood = new Intent(MainActivity.this,AddFood.class);
                startActivity(addfood);
            }
        });

        Picasso picasso = Picasso.with(this);
        picasso.load(
                R.drawable.logo_eat_it
        ).into(ivLogo);

        picasso.load(
                R.drawable.my_bg
        ).into(target);


    }
}