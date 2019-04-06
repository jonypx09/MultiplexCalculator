package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class BasicCalculator {


    private TextView bcDisplay;
    private String bcDisplayString;
    private BigDecimal mainResult;

    public BasicCalculator (TextView bcDisplay){
        super();
        this.bcDisplay = bcDisplay;
    }

    public void insertNumber(String number){
        if (bcDisplay.getText().toString() == "0") {
            bcDisplay.setText(number);
        }else{
            bcDisplay.setText(bcDisplay.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                bcDisplay.setText(currentDisplay);
            }

            if (bcDisplay.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(bcDisplay.getText());
                int j = 0;

                for (int i = newDisplayBuilder.length() - 1; i >= 0; i--){
                    if ((newDisplayBuilder.charAt(i) == '+') || (newDisplayBuilder.charAt(i) == '-')
                            ||(newDisplayBuilder.charAt(i) == 'x') || (newDisplayBuilder.charAt(i) == '÷')){
                        j = -1;
                    }
                    if ((j % 3 == 0) && (j != 0)){
                        newDisplayBuilder.insert(i + 1, ",");
                    }
                    j ++;
                }

                //Check for leading commas beside operator symbols


                String newDisplay = newDisplayBuilder.toString();
                bcDisplay.setText(newDisplay);
            }
        }

//        adjustGrowingTextSize();
    }

    public void insertPeriod(View v){
        String currentDisplay = bcDisplay.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                bcDisplay.setText(bcDisplay.getText().toString() + ".");
            }
        }
    }

    public void insertOne(View v){
        insertNumber("1");
    }

    public void insertTwo(View v){
        insertNumber("2");
    }

    public void insertThree(View v){
        insertNumber("3");
    }

    public void insertFour(View v){
        insertNumber("4");
    }

    public void insertFive(View v){
        insertNumber("5");
    }

    public void insertSix(View v){
        insertNumber("6");
    }

    public void insertSeven(View v){
        insertNumber("7");
    }

    public void insertEight(View v){
        insertNumber("8");
    }

    public void insertNine(View v){
        insertNumber("9");
    }

    public void insertZero(View v){
        insertNumber("0");
    }


}
