package com.example.velasquez_chinhotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.TargetApi;
        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.view.WindowManager;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.ImageView;
        import android.widget.SearchView;
        import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
        import androidx.cardview.widget.CardView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{
    CardView cardView, cardView2, cardView3;
    ImageView imageView;
    ImageView icons;
    TextView textView, textView2, textView3, textView4, textView5;
    SearchView searchView;
    View view2, twinroom, singleroom, triple, penthouse, couple;

    Animation anim_from_button, anim_from_top, anim_from_left;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.firstText);
        textView2 = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView2);
        textView4 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView4);
        searchView = findViewById(R.id.searchView);

        icons = (ImageView) findViewById(R.id.icons);
        view2 = (View) findViewById(R.id.view2);
        twinroom = (View) findViewById(R.id.twinroom);

        singleroom = (View) findViewById(R.id.singleroom);
       couple = (View) findViewById(R.id.couple);
         triple = (View) findViewById(R.id.triple);
         penthouse = (View) findViewById(R.id.penthouse);
        /*view2 = (View) findViewById(R.id.view2);*/

        //Load Animations
        anim_from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        //Set Animations
        cardView.setAnimation(anim_from_button);
        cardView2.setAnimation(anim_from_button);
        cardView3.setAnimation(anim_from_button);
        imageView.setAnimation(anim_from_top);
        textView.setAnimation(anim_from_top);
        textView2.setAnimation(anim_from_top);
        textView3.setAnimation(anim_from_top);
        textView4.setAnimation(anim_from_top);
        textView5.setAnimation(anim_from_top);
        searchView.setAnimation(anim_from_left);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondActivity = new Intent(Dashboard.this, Choice1.class);
                startActivity(secondActivity);
            }
        });
        //Hide status bar and navigation bar at the bottom
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icons:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, HOME.class);
                startActivity(intent1);
                break;
            case R.id.view2:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Choice2.class);
                startActivity(intent2);
                break;
            case R.id.twinroom:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Choice3.class);
                startActivity(intent3);
                break;
            case R.id.singleroom:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Choice4.class);
                startActivity(intent4);
                break;
                 case R.id.couple:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, Choice5.class);
                startActivity(intent5);
                break;

                 case R.id.triple:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, Choice6.class);
                startActivity(intent6);
                break;

                 case R.id.penthouse:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this, Choice7.class);
                startActivity(intent7);
                break;



        }}}
