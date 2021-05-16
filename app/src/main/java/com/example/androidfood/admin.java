package com.example.androidfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class admin extends AppCompatActivity {
    Button btn_addfood, btn_signin;
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
        setContentView(R.layout.activity_admin);

        btn_addfood = findViewById(R.id.btn_addfoodadmin);
        btn_signin =  findViewById(R.id.btn_signupadmin);
        ivLogo = findViewById(R.id.iv_logoadmin);
        ivBackground = findViewById(R.id.img_backroundadmin);

        btn_addfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addfood = new Intent(admin.this,AddFood.class);
                startActivity(addfood);
            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siginupadmin = new Intent(admin.this,SignupAdmin.class);
                startActivity(siginupadmin);
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