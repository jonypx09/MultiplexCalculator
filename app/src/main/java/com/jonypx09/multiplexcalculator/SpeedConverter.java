package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class SpeedConverter {

    private TextView speedTextInput;
    private TextView speedTextOutput;
    private Spinner speedOptionsIn;
    private Spinner speedOptionsOut;
    private BigDecimal mainResult;

    public SpeedConverter (TextView speedTextInput, TextView speedTextOutput, Spinner speedOptionsIn, Spinner speedOptionsOut){
        super();
        this.speedTextInput = speedTextInput;
        this.speedTextOutput = speedTextOutput;
        this.speedOptionsIn = speedOptionsIn;
        this.speedOptionsOut = speedOptionsOut;

        speedOptionsIn.setSelection(0,false);
        speedOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        speedOptionsOut.setSelection(0,false);
        speedOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        String textInput = speedTextInput.getText().toString().replace(",", "");
        switch(speedOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromCentimetresPerSecond(textInput, speedOptionsOut.getSelectedItemPosition(), speedTextOutput);
                break;
            case 1:
                convertFromFeetPerSecond(textInput, speedOptionsOut.getSelectedItemPosition(), speedTextOutput);
                break;
            case 2:
                convertFromKilometresPerHour(textInput, speedOptionsOut.getSelectedItemPosition(), speedTextOutput);
                break;
            case 3:
                convertFromKnots(textInput, speedOptionsOut.getSelectedItemPosition(), speedTextOutput);
                break;
            case 4:
                convertFromMach(textInput, speedOptionsOut.getSelectedItemPosition(), speedTextOutput);
                break;
            case 5:
                convertFromMetresPerSecond(textInput, speedOptionsOut.getSelectedItemPosition(), speedTextOutput);
                break;
            case 6:
                convertFromMilesPerHour(textInput, speedOptionsOut.getSelectedItemPosition(), speedTextOutput);
                break;
        }

    }


    public void convertFromCentimetresPerSecond(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres per second
                output.setText(input);
                break;
            case 1: //Feet per second
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.032808399)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilometres per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.036).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Knots
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0194384449).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Mach
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000291036).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Metres per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Miles per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0223693629).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromFeetPerSecond(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres per second
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 30.48)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet per second
                output.setText(input);
                break;
            case 2: //Kilometres per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.09728).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Knots
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5924838013).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Mach
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000887078).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Metres per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.3048).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Miles per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.6818181818).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 1){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromKilometresPerHour(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres per second
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 27.777777778)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.9113444153).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilometres per hour
                output.setText(input);
                break;
            case 3: //Knots
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5399568035).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Mach
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0008084336).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Metres per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.2777777778).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Miles per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.6213711922).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 2){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromKnots(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres per second
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 51.444444444)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.6878098571).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilometres per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.852).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Knots
                output.setText(input);
                break;
            case 4: //Mach
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.001497219).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Metres per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.5144444444).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Miles per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.150779448).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 3){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromMach(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres per second
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 34360)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1127.2965879).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilometres per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1236.96).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Knots
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 667.9049676).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Mach
                output.setText(input);
                break;
            case 5: //Metres per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 343.6).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Miles per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 768.61130995).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 4){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromMetresPerSecond(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres per second
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 100)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.280839895).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilometres per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.6).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Knots
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.9438444924).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Mach
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0029103609).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Metres per second
                output.setText(input);
                break;
            case 6: //Miles per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.2369362921).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 5){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromMilesPerHour(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Centimetres per second
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 44.704)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Feet per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.4666666667).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Kilometres per hour
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.609344).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Knots
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8689762419).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Mach
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0013010477).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Metres per second
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.44704).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Miles per hour
                output.setText(input);
                break;
        }
        if (selectedItem != 6){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }





    public void insertCommas(TextView speedTextInput, TextView speedTextOutput){
        String currentDisplay = speedTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                speedTextInput.setText(currentDisplay);
            }

            if (speedTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(speedTextInput.getText());
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
                speedTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (speedTextInput.getText() == "0") {
            speedTextInput.setText(number);
        }else{
            speedTextInput.setText(speedTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = speedTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                speedTextInput.setText(currentDisplay);
            }

        }
        insertCommas(speedTextInput, speedTextOutput);
        checkInSelection();
    }

    public void insertPeriod(View v){
        String currentDisplay = speedTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                speedTextInput.setText(speedTextInput.getText().toString() + ".");
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
        String decrementedDisplay = speedTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            speedTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            speedTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = speedTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    speedTextInput.setText(currentDisplay);
                }

                if (speedTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(speedTextInput.getText());
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
                    speedTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        speedTextInput.setText("0");
        speedTextOutput.setText("0");
        checkInSelection();
    }
}
