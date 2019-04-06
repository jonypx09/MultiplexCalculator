package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class PowerConverter {

    private TextView powerTextInput;
    private TextView powerTextOutput;
    private Spinner powerOptionsIn;
    private Spinner powerOptionsOut;
    private BigDecimal mainResult;

    public PowerConverter (TextView powerTextInput, TextView powerTextOutput, Spinner powerOptionsIn, Spinner powerOptionsOut){
        super();
        this.powerTextInput = powerTextInput;
        this.powerTextOutput = powerTextOutput;
        this.powerOptionsIn = powerOptionsIn;
        this.powerOptionsOut = powerOptionsOut;

        powerOptionsIn.setSelection(0,false);
        powerOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        powerOptionsOut.setSelection(0,false);
        powerOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        String textInput = powerTextInput.getText().toString().replace(",", "");
        switch(powerOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromBTUsPerMinute(textInput, powerOptionsOut.getSelectedItemPosition(), powerTextOutput);
                break;
            case 1:
                convertFromFootPoundsPerMinute(textInput, powerOptionsOut.getSelectedItemPosition(), powerTextOutput);
                break;
            case 2:
                convertFromHorsepower(textInput, powerOptionsOut.getSelectedItemPosition(), powerTextOutput);
                break;
            case 3:
                convertFromKilowatts(textInput, powerOptionsOut.getSelectedItemPosition(), powerTextOutput);
                break;
            case 4:
                convertFromWatts(textInput, powerOptionsOut.getSelectedItemPosition(), powerTextOutput);
                break;
        }

    }


    public void convertFromBTUsPerMinute(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //BTUs per minute
                output.setText(input);
                break;
            case 1: //Foot-pounds per minute
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 778.16926227)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Horsepower
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0235808867).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilowatts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0175842642).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Watts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 17.58426421).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromFootPoundsPerMinute(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //BTUs per minute
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.0012850675)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Foot-pounds per minute
                output.setText(input);
                break;
            case 2: //Horsepower
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000030303).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilowatts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000022597).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Watts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0225969658).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 1){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromHorsepower(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //BTUs per minute
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 42.407226294)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Foot-pounds per minute
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 33000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Horsepower
                output.setText(input);
                break;
            case 3: //Kilowatts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.7456998716).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Watts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 745.69987158).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 2){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromKilowatts(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //BTUs per minute
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 56.869027219)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Foot-pounds per minute
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 44253.728957).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Horsepower
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.3410220896).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilowatts
                output.setText(input);
                break;
            case 4: //Watts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 3){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromWatts(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //BTUs per minute
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.0568690272)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Foot-pounds per minute
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 44.253728957).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Horsepower
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0013410221).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Kilowatts
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Watts
                output.setText(input);
                break;
        }
        if (selectedItem != 4){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }





    public void insertCommas(TextView powerTextInput, TextView powerTextOutput){
        String currentDisplay = powerTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                powerTextInput.setText(currentDisplay);
            }

            if (powerTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(powerTextInput.getText());
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
                powerTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (powerTextInput.getText() == "0") {
            powerTextInput.setText(number);
        }else{
            powerTextInput.setText(powerTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = powerTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                powerTextInput.setText(currentDisplay);
            }

        }
        insertCommas(powerTextInput, powerTextOutput);
        checkInSelection();
    }

    public void insertPeriod(View v){
        String currentDisplay = powerTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                powerTextInput.setText(powerTextInput.getText().toString() + ".");
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
        String decrementedDisplay = powerTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            powerTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            powerTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = powerTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    powerTextInput.setText(currentDisplay);
                }

                if (powerTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(powerTextInput.getText());
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
                    powerTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        powerTextInput.setText("0");
        powerTextOutput.setText("0");
        checkInSelection();
    }
}
