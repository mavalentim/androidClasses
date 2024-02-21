package dk.itu.shoppingv1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {

    //Shopping V1

    // Model: Database of items
    private ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);


        itemsDB= new ItemsDB();
        TextView responseText = findViewById(R.id.textView1);
        EditText edit = findViewById(R.id.edit_text);


        Button checkItem= findViewById(R.id.list_button);
        checkItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response = itemsDB.whereDoesThisGo(edit.getText().toString());
                responseText.setText("Those go in "+response);
            }
        });
    }
}