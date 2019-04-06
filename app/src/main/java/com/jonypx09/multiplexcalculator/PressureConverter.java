package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class PressureConverter {

    private TextView pressureTextInput;
    private TextView pressureTextOutput;
    private Spinner pressureOptionsIn;
    private Spinner pressureOptionsOut;
    private BigDecimal mainResult;

    public PressureConverter (TextView pressureTextInput, TextView pressureTextOutput, Spinner pressureOptionsIn, Spinner pressureOptionsOut){
        super();
        this.pressureTextInput = pressureTextInput;
        this.pressureTextOutput = pressureTextOutput;
        this.pressureOptionsIn = pressureOptionsIn;
        this.pressureOptionsOut = pressureOptionsOut;

        pressureOptionsIn.setSelection(0,false);
        pressureOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        pressureOptionsOut.setSelection(0,false);
        pressureOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void checkInSelection(){

        String textInput = pressureTextInput.getText().toString().replace(",", "");
        switch(pressureOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromAtmospheres(textInput, pressureOptionsOut.getSelectedItemPosition(), pressureTextOutput);
                break;
            case 1:
                convertFromBars(textInput, pressureOptionsOut.getSelectedItemPosition(), pressureTextOutput);
                break;
            case 2:
                convertFromKilopascals(textInput, pressureOptionsOut.getSelectedItemPosition(), pressureTextOutput);
                break;
            case 3:
                convertFromPascals(textInput, pressureOptionsOut.getSelectedItemPosition(), pressureTextOutput);
                break;
            case 4:
                convertFromPoundsSquareInch(textInput, pressureOptionsOut.getSelectedItemPosition(), pressureTextOutput);
                break;
        }

    }


    public void convertFromAtmospheres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Atmopsheres
                output.setText(input);
                break;
            case 1: //Bars
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1.01325)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilopascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 101.325).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Pascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 101325).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Pounds per Square Inch
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 14.69595).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromBars(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Atmopsheres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.9869)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Bars
                output.setText(input);
                break;
            case 2: //Kilopascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Pascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Pounds per Square Inch
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 14.50377).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 1){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromKilopascals(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Atmopsheres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.0098692327)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Bars
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilopascals
                output.setText(input);
                break;
            case 3: //Pascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Pounds per Square Inch
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.145038).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 2){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromPascals(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Atmopsheres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.0000098692326999)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Bars
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilopascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Pascals
                output.setText(input);
                break;
            case 4: //Pounds per Square Inch
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000145).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 3){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromPoundsSquareInch(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Atmopsheres
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.068046)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Bars
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.068948).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilopascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.894757).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Pascals
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6894.757).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Pounds per Square Inch
                output.setText(input);
                break;
        }
        if (selectedItem != 4){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }




    public void insertCommas(TextView pressureTextInput, TextView pressureTextOutput){
        String currentDisplay = pressureTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                pressureTextInput.setText(currentDisplay);
            }

            if (pressureTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(pressureTextInput.getText());
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
                pressureTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (pressureTextInput.getText() == "0") {
            pressureTextInput.setText(number);
        }else{
            pressureTextInput.setText(pressureTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = pressureTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                pressureTextInput.setText(currentDisplay);
            }

        }
        insertCommas(pressureTextInput, pressureTextOutput);
        checkInSelection();
    }

    public void insertPeriod(View v){
        String currentDisplay = pressureTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                pressureTextInput.setText(pressureTextInput.getText().toString() + ".");
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
        String decrementedDisplay = pressureTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            pressureTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            pressureTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = pressureTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    pressureTextInput.setText(currentDisplay);
                }

                if (pressureTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(pressureTextInput.getText());
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
                    pressureTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        pressureTextInput.setText("0");
        pressureTextOutput.setText("0");
        checkInSelection();
    }
    
    
}
