package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.capstoneproject.Adapters.CuisineAdapter;
import com.example.capstoneproject.Adapters.RestaurantAdapter;
import com.example.capstoneproject.Models.Cuisine;
import com.example.capstoneproject.Models.Restaurant;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    int restaurant_id;
    String name,image_url,description;
    private Toolbar toolbar;
    private ImageView image_restaurant;
    private TextView rest_name,res_description;
    private ArrayList<Restaurant>restaurants;
    private ArrayList<Cuisine>cuisines;
    private RestaurantAdapter restaurantAdapter;
    private CuisineAdapter cuisineAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView rest_cuisine_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.home_toolbar);
        image_restaurant = findViewById(R.id.image_restaurant);
        rest_name = findViewById(R.id.rest_name);
        res_description = findViewById(R.id.res_description);
        rest_cuisine_list = findViewById(R.id.rest_cuisine_list);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getExtra();
    }
    private void getExtra(){
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            restaurant_id = extras.getInt("restaurant_id");
            name = extras.getString("res_name");
            image_url = extras.getString("image_url");
            description = extras.getString("description");
        }else{
            finish();
        }
        toolbar.setTitle(name);
        rest_name.setText("Restaurant : "+name);
        res_description.setText(description);
        Glide.with(this).load(image_url).into(image_restaurant);
        pojoData(restaurant_id);
    }
    private void pojoData(int restaurant_id){
        cuisines = new ArrayList<>();
        if(restaurant_id == 1){
            cuisines.add(new Cuisine(1,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            cuisines.add(new Cuisine(2,1,"Chicken Fry","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            cuisines.add(new Cuisine(3,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            cuisines.add(new Cuisine(4,1,"Rice","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        }else if(restaurant_id == 2){
            cuisines.add(new Cuisine(1,1,"Igitoki","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            cuisines.add(new Cuisine(4,1,"Nyamachoka","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        }else if(restaurant_id == 3){
            cuisines.add(new Cuisine(1,1,"Inyama","https://www.delonghi.com/Global/recipes/multifry/174.jpg","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            cuisines.add(new Cuisine(2,1,"Chicken Leg","https://soupeduprecipes.com/wp-content/uploads/2019/08/chicken-fried-rice.png","5,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            cuisines.add(new Cuisine(3,1,"King Burger","https://www.delonghi.com/Global/recipes/multifry/174.jpg","3,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
            cuisines.add(new Cuisine(4,1,"Price Tag","https://www.delonghi.com/Global/recipes/multifry/174.jpg","15,000 Frw","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        }
        cuisineAdapter = new CuisineAdapter(this,cuisines);
        LinearLayoutManager lManager = new LinearLayoutManager(Detail.this, LinearLayoutManager.HORIZONTAL, false);
        rest_cuisine_list.setLayoutManager(lManager);
        rest_cuisine_list.setAdapter(cuisineAdapter);
    }
}