package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TemperatureConverter {

    private TextView temperatureTextInput;
    private TextView temperatureTextOutput;
    private Spinner tempOptionsIn;
    private Spinner tempOptionsOut;
    private BigDecimal mainResult;

    public TemperatureConverter (TextView temperatureTextInput, TextView temperatureTextOutput, Spinner tempOptionsIn, Spinner tempOptionsOut){
        super();
        this.temperatureTextInput = temperatureTextInput;
        this.temperatureTextOutput = temperatureTextOutput;
        this.tempOptionsIn = tempOptionsIn;
        this.tempOptionsOut = tempOptionsOut;
        mainResult = BigDecimal.ZERO;

        tempOptionsIn.setSelection(0,false);
        tempOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        tempOptionsOut.setSelection(0,false);
        tempOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkOutSelection();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void checkInSelection(){
//        DecimalFormat format = new DecimalFormat("0.#####");
//
//        if (tempOptionsIn.getSelectedItemPosition() == 0){
//            String textOutput = temperatureTextInput.getText().toString().replace(",", "");
//            temperatureTextOutput.setText(textOutput);
//
//        }else if (tempOptionsIn.getSelectedItemPosition() == 1){
//            String textOutput = temperatureTextInput.getText().toString().replace(",", "");
//            mainResult = BigDecimal.valueOf((Float.parseFloat(textOutput) - 32) / 1.8).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
//
//            temperatureTextOutput.setText(format.format(mainResult.doubleValue()));
//        }else{
//            String textOutput = temperatureTextInput.getText().toString().replace(",", "");
//            mainResult = BigDecimal.valueOf(Float.parseFloat(textOutput) - 273.15).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
//
//            temperatureTextOutput.setText(format.format(mainResult.doubleValue()));
//        }

        String textInput = temperatureTextInput.getText().toString().replace(",", "");
//        textInput = mainResult.toString();
        switch(tempOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromCelsius(textInput, tempOptionsOut.getSelectedItemPosition(), temperatureTextOutput);
                break;
            case 1:
                convertFromFahrenheit(textInput, tempOptionsOut.getSelectedItemPosition(), temperatureTextOutput);
                break;
            case 2:
                convertFromKelvin(textInput, tempOptionsOut.getSelectedItemPosition(), temperatureTextOutput);
                break;
        }
    }

    public void checkOutSelection(){
        String textInput = temperatureTextInput.getText().toString().replace(",", "");
        switch(tempOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromCelsius(textInput, tempOptionsOut.getSelectedItemPosition(), temperatureTextOutput);
                break;
            case 1:
                convertFromFahrenheit(textInput, tempOptionsOut.getSelectedItemPosition(), temperatureTextOutput);
                break;
            case 2:
                convertFromKelvin(textInput, tempOptionsOut.getSelectedItemPosition(), temperatureTextOutput);
                break;
        }
    }



    public void convertFromCelsius(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.#####");
        switch(selectedItem){
            case 0: //Celsius
//                mainResult = BigDecimal.valueOf(0);
//                output.setText(format.format(mainResult.doubleValue()));
                output.setText(input);
                break;
            case 1: //Fahrenheit
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1.8) + 32).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                output.setText(format.format(mainResult.doubleValue()));
                break;
            case 2: //Kelvin
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) + 273.15).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                output.setText(format.format(mainResult.doubleValue()));
                break;
        }
    }


    public void convertFromFahrenheit(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.#####");
        switch(selectedItem){
            case 0: //Celsius
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) - 32) / 1.8).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                output.setText(format.format(mainResult.doubleValue()));
                break;
            case 1: //Fahrenheit
//                mainResult = BigDecimal.valueOf(0);
//                output.setText(format.format(mainResult.doubleValue()));
                output.setText(input);
                break;
            case 2: //Kelvin
                mainResult = BigDecimal.valueOf((Float.parseFloat(input)) + 459.67 * 5/9).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                output.setText(format.format(mainResult.doubleValue()));
                break;
        }
    }


    public void convertFromKelvin(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.#####");
        switch(selectedItem){
            case 0: //Celsius
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) - 273.15).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                output.setText(format.format(mainResult.doubleValue()));
                break;
            case 1: //Fahrenheit
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * (9/5)) - 459.67).setScale(5, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                output.setText(format.format(mainResult.doubleValue()));
                break;
            case 2: //Kelvin
//                mainResult = BigDecimal.valueOf(0);
//                output.setText(format.format(mainResult.doubleValue()));
                output.setText(input);
                break;
        }
    }














    public void insertCommas(TextView tempTextInput, TextView tempTextOutput){
        String currentDisplay = tempTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                tempTextInput.setText(currentDisplay);
            }

            if (tempTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(tempTextInput.getText());
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
                tempTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (temperatureTextInput.getText() == "0") {
            temperatureTextInput.setText(number);
            temperatureTextOutput.setText(number);
        }else{
            temperatureTextInput.setText(temperatureTextInput.getText().toString() + number);
            temperatureTextOutput.setText(temperatureTextOutput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = temperatureTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                temperatureTextInput.setText(currentDisplay);
                temperatureTextOutput.setText(currentDisplay);
            }

//            insertCommas(temperatureTextInput, temperatureTextOutput);

//            if (temperatureTextInput.getText().length() > 3){
//                StringBuilder newDisplayBuilder = new StringBuilder(temperatureTextInput.getText());
//                int j = 0;
//
//                for (int i = newDisplayBuilder.length() - 1; i >= 0; i--){
//                    if ((newDisplayBuilder.charAt(i) == '+') || (newDisplayBuilder.charAt(i) == '-')
//                            ||(newDisplayBuilder.charAt(i) == 'x') || (newDisplayBuilder.charAt(i) == '÷')){
//                        j = -1;
//                    }
//                    if ((j % 3 == 0) && (j != 0)){
//                        newDisplayBuilder.insert(i + 1, ",");
//                    }
//                    j ++;
//                }
//
//                //Check for leading commas beside operator symbols
//
//
//                String newDisplay = newDisplayBuilder.toString();
//                temperatureTextInput.setText(newDisplay);
//                temperatureTextOutput.setText(newDisplay);
//            }
        }
        insertCommas(temperatureTextInput, temperatureTextOutput);
        checkInSelection();

//        adjustGrowingTextSize();
    }

    public void insertPeriod(View v){
        String currentDisplay = temperatureTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                temperatureTextInput.setText(temperatureTextInput.getText().toString() + ".");
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
        String decrementedDisplay = temperatureTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            temperatureTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            temperatureTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = temperatureTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    temperatureTextInput.setText(currentDisplay);
                }

                if (temperatureTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(temperatureTextInput.getText());
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
                    temperatureTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        temperatureTextInput.setText("0");
        temperatureTextOutput.setText("0");
        checkInSelection();
    }
    
    
}
