package com.example.cs311_u2_subnode_rafsanbhuiyan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private Button secondButton;

    //Initialize all the variables
    Button pressButton;
    EditText nameInput;
    EditText idInput;
    EditText addressInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

   /* secondButton = (Button)findViewById(R.id.buttonNext);
    secondButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });*/

    //Get the button from layout resource
    pressButton = findViewById(R.id.submitButton);

    //Set on click listener
    pressButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Get the EditText variables from the layout resource
            nameInput = findViewById(R.id.textInput1);
            idInput = findViewById(R.id.textInput2);
            addressInput = findViewById(R.id.textInput3);

            //Call the onClickListener to take user input and process
            pressButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Initialize the variables
                    boolean validateName = false;
                    boolean validateAddress = false;
                    boolean validateID = false;
                    boolean numberFlag = false;
                    char ch;

                    //Read user input
                    String customerName = nameInput.getText().toString().trim();
                    String customerAddress = addressInput.getText().toString().trim();
                    int customerID = Integer.valueOf(idInput.getText().toString().trim());

                    String customerIDStringType = String.valueOf(customerID);

                    //if statement to verify the conditions fo the name input
                    if(customerName.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Please Enter User Name",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        for (int i = 0; i < nameInput.length(); i++) {
                            ch = customerName.charAt(i);
                            if (Character.isDigit(ch)) {
                                numberFlag = true;
                            }
                        }
                        if (numberFlag == true) {
                            Toast.makeText(getApplicationContext(), "Error!! Please Enter" +
                                            " a Valid Name",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            validateName = true;
                        }
                    }




                    //if statement to verify the user input for customer ID
                    if(customerIDStringType.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Please Enter User ID",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(customerID <0 || customerID>1000)
                    {
                        Toast.makeText(getApplicationContext(), "Please Enter a Valid ID",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        validateID = true;
                    }


                    //if statement to verify the user input for customer address
                    if(customerAddress.isEmpty())
                    {
                        Toast.makeText(getApplicationContext(), "Please Enter User Address",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        validateAddress = true;
                    }

                    if(validateAddress == true && validateID == true && validateName == true) {
                        Intent i = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(i);
                    }
                }
            });
    }
    } );
    }
}
