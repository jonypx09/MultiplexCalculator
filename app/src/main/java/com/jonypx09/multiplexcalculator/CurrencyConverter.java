package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class CurrencyConverter {


    private TextView currencyTextInput;
    private TextView currencyTextOutput;
    private BigDecimal mainResult;

    public CurrencyConverter (TextView currencyTextInput, TextView currencyTextOutput){
        super();
        this.currencyTextInput = currencyTextInput;
        this.currencyTextOutput = currencyTextOutput;
    }

    public void insertNumber(String number){
        if (currencyTextInput.getText() == "0") {
            currencyTextInput.setText(number);
        }else{
            currencyTextInput.setText(currencyTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = currencyTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                currencyTextInput.setText(currentDisplay);
            }

            if (currencyTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(currencyTextInput.getText());
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
                currencyTextInput.setText(newDisplay);
            }
        }

//        adjustGrowingTextSize();
    }

    public void insertPeriod(View v){
        String currentDisplay = currencyTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                currencyTextInput.setText(currencyTextInput.getText().toString() + ".");
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

    public void deleteDigit(View v){
        String decrementedDisplay = currencyTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            currencyTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            currencyTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = currencyTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    currencyTextInput.setText(currentDisplay);
                }

                if (currencyTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(currencyTextInput.getText());
                    int j = 0;
                    for (int i = newDisplay.length() - 1; i >= 0; i--){
                        if ((newDisplay.charAt(i) == '+') || (newDisplay.charAt(i) == '-')
                                ||(newDisplay.charAt(i) == 'x') || (newDisplay.charAt(i) == '÷')){
                            j = -1;
                        }
                        if ((j % 3 == 0) && (j != 0)){
                            newDisplay.insert(i + 1, ",");
                        }
                        j ++;
                    }
                    currencyTextInput.setText(newDisplay);
                }
            }
        }
    }

    public void cancelEverything(View v){
        currencyTextInput.setText("0");
        currencyTextOutput.setText("0");
    }

}
