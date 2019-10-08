package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText weightET;
    ShipItem shipItem;
    TextView baseView;
    TextView addedView;
    TextView totalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        shipItem = new ShipItem();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightET = findViewById(R.id.Text);
        weightET.addTextChangedListener(weightTextWatcher);

        baseView = findViewById(R.id.BaseCost);
        addedView = findViewById(R.id.AddedCost);
        totalView = findViewById(R.id.TotalCost);
    }


    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                double weight = Double.parseDouble(charSequence.toString());
                shipItem.setWeight(weight);
            }
            catch (NumberFormatException e) {
                shipItem.setWeight(0.0);
            }
            displayCost();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private void displayCost() {
        baseView.setText(String.format("$%.02f",shipItem.getBaseCost()));
        addedView.setText(String.format("$%.02f",shipItem.getAddedCost()));
        totalView.setText(String.format("$%.02f",shipItem.getTotalCost()));
    }
}
