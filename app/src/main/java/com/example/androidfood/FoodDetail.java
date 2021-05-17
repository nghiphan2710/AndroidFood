package com.example.androidfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import Model.Food;

public class FoodDetail extends AppCompatActivity {

    TextView food_name, food_price;
    ImageView img_food;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton floatingActionButton;
    ElegantNumberButton elegantNumberButton;

    String foodId="";

    FirebaseDatabase database;
    DatabaseReference detail_food;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        food_name = findViewById(R.id.food_name);
        food_price = findViewById(R.id.food_price);
        img_food = findViewById(R.id.img_food1);
        collapsingToolbarLayout = findViewById(R.id.collapsing);
        floatingActionButton = findViewById(R.id.cart_floating);
        elegantNumberButton = findViewById(R.id.number_btn);

        database = FirebaseDatabase.getInstance();
        detail_food = database.getReference("Food");



        if(getIntent() != null){
            foodId = getIntent().getStringExtra("foodId");
        }

        if(!foodId.isEmpty()){
            getDetailFood(foodId);
        }



    }

    private void getDetailFood(String foodId) {
        detail_food.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Food food = snapshot.getValue(Food.class);
                Picasso.with(getBaseContext()).load(food.getImg()).into(img_food);
                collapsingToolbarLayout.setTitle(food.getName());
                food_name.setText(food.getName());
                food_price.setText(food.getPrice());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}