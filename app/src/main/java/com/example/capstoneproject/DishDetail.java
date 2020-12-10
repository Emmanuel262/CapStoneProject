package com.example.capstoneproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class DishDetail extends AppCompatActivity {
    private Toolbar cuisine_toolbar;
    private ImageView image_cuisine;
    private TextView cuisine_name;
    private TextView txt_price,cuisine_description;
    String name,image_url,description,price;
    public List<String> favoriteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);
        cuisine_toolbar = findViewById(R.id.cuisine_toolbar);
        setSupportActionBar(cuisine_toolbar);
        image_cuisine = findViewById(R.id.image_cuisine);
        cuisine_name = findViewById(R.id.cuisine_name);
        txt_price = findViewById(R.id.txt_price);
        cuisine_description = findViewById(R.id.cuisine_description);
        cuisine_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        favoriteList = new ArrayList<>();
        getExtra();
    }
    private void getExtra(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("dish_name");
            image_url = extras.getString("image_url");
            description = extras.getString("description");
            price = extras.getString("price");
        }else{
            finish();
        }
        cuisine_toolbar.setTitle(name);
        cuisine_name.setText("Dish : "+name);
        cuisine_description.setText(description);
        txt_price.setText(price);
        Glide.with(this).load(image_url).into(image_cuisine);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_restaurant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_favorite){
            Toast.makeText(this,"Added to Favorite",Toast.LENGTH_SHORT).show();
            favoriteList.add(name);

        }else if(id == R.id.action_share){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_name)+" : "+name+" "+description+" "+price);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
            Toast.makeText(this,"Share on Other Apps",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}