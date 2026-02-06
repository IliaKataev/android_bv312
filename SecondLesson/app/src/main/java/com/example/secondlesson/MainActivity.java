package com.example.secondlesson;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalc;
    private Button buttonOrientation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalc = findViewById(R.id.button_calc);

        buttonCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        buttonOrientation = findViewById(R.id.button_orientation);
        buttonOrientation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrientationActivity.class);
                startActivity(intent);
            }
        });

    }


    //----------------------------------------------------
    // Меню через экшнбар
//   @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//   }
//
//   @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//       getMenuInflater().inflate(R.menu.main_menu, menu);
//       return true;
//   }
//
//   @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//       if(item.getItemId() == R.id.menu_calc){
//           Intent intent = new Intent(this, CalculatorActivity.class);
//           startActivity(intent);
//           return true;
//       }
//       return super.onOptionsItemSelected(item);
//   }


}