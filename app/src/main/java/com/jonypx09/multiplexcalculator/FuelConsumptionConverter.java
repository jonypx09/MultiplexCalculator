package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FuelConsumptionConverter {

    private TextView fuelTextInput;
    private TextView fuelTextOutput;
    private Spinner fuelOptionsIn;
    private Spinner fuelOptionsOut;
    private BigDecimal mainResult;

    public FuelConsumptionConverter (TextView fuelTextInput, TextView fuelTextOutput, Spinner fuelOptionsIn, Spinner fuelOptionsOut){
        super();
        this.fuelTextInput = fuelTextInput;
        this.fuelTextOutput = fuelTextOutput;
        this.fuelOptionsIn = fuelOptionsIn;
        this.fuelOptionsOut = fuelOptionsOut;

        fuelOptionsIn.setSelection(0,false);
        fuelOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        fuelOptionsOut.setSelection(0,false);
        fuelOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        String textInput = fuelTextInput.getText().toString().replace(",", "");
        switch(fuelOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromMilesPerGallonUS(textInput, fuelOptionsOut.getSelectedItemPosition(), fuelTextOutput);
                break;
            case 1:
                convertFromMilesPerGallonUK(textInput, fuelOptionsOut.getSelectedItemPosition(), fuelTextOutput);
                break;
            case 2:
                convertFromLitresPer100Km(textInput, fuelOptionsOut.getSelectedItemPosition(), fuelTextOutput);
                break;
            case 3:
                convertGallonUSPerMile(textInput, fuelOptionsOut.getSelectedItemPosition(), fuelTextOutput);
                break;
            case 4:
                convertGallonUKPerMile(textInput, fuelOptionsOut.getSelectedItemPosition(), fuelTextOutput);
                break;
        }

    }


    public void convertFromMilesPerGallonUS(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        if (Float.parseFloat(input) == 0){
            mainResult = BigDecimal.ZERO;
        }else{
            switch(selectedItem){
                case 0: //Miles per Gallon US
                    output.setText(input);
                    break;
                case 1: //Miles per Gallon UK
                    mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1.2009499255)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 2: //Litres per 100km
                    mainResult = BigDecimal.valueOf(235.21458329 / Float.parseFloat(input)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 3: //Gallon US per mile
                    mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 4: //Gallon UK per mile
                    mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8326741845).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
            }
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromMilesPerGallonUK(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        if (Float.parseFloat(input) == 0){
            mainResult = BigDecimal.ZERO;
        }else{
            switch(selectedItem){
                case 0: //Miles per Gallon US
                    mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.8326741846)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 1: //Miles per Gallon UK
                    output.setText(input);
                    break;
                case 2: //Litres per 100km
                    mainResult = BigDecimal.valueOf(282.48093628 / Float.parseFloat(input)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 3: //Gallon US per mile
                    mainResult = BigDecimal.valueOf(1.2009499255 / Float.parseFloat(input)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 4: //Gallon UK per mile
                    mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
            }
        }
        if (selectedItem != 1){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertFromLitresPer100Km(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        if (Float.parseFloat(input) == 0){
            mainResult = BigDecimal.ZERO;
        }else{
            switch(selectedItem){
                case 0: //Miles per Gallon US
                    mainResult = BigDecimal.valueOf((235.21458329 / Float.parseFloat(input))).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 1: //Miles per Gallon UK
                    mainResult = BigDecimal.valueOf(282.48093628/ Float.parseFloat(input)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 2: //Litres per 100km
                    output.setText(input);
                    break;
                case 3: //Gallon US per mile
                    mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0042514371).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
                case 4: //Gallon UK per mile
                    mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0035400619).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                    break;
            }
        }
        if (selectedItem != 2){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertGallonUSPerMile(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Miles per Gallon US
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 1)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Miles per Gallon UK
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.2009499255).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Litres per 100km
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 235.2145833).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Gallon US per mile
                output.setText(input);
                break;
            case 4: //Gallon UK per mile
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.8326741845).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 3){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }

    public void convertGallonUKPerMile(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Miles per Gallon US
                mainResult = BigDecimal.valueOf((Float.parseFloat(input) * 0.8326741845)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Miles per Gallon UK
                mainResult = BigDecimal.valueOf(1 / Float.parseFloat(input) * 1).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Litres per 100km
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 282.48093631).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Gallon US per mile
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.2009499256).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Gallon UK per mile
                output.setText(input);
                break;
        }
        if (selectedItem != 4){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }





    public void insertCommas(TextView fuelTextInput, TextView fuelTextOutput){
        String currentDisplay = fuelTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                fuelTextInput.setText(currentDisplay);
            }

            if (fuelTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(fuelTextInput.getText());
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
                fuelTextInput.setText(newDisplay);
            }
        }
    }

    public void insertNumber(String number){
        if (fuelTextInput.getText() == "0") {
            fuelTextInput.setText(number);
        }else{
            fuelTextInput.setText(fuelTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = fuelTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                fuelTextInput.setText(currentDisplay);
            }

        }
        insertCommas(fuelTextInput, fuelTextOutput);
        checkInSelection();
    }

    public void insertPeriod(View v){
        String currentDisplay = fuelTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                fuelTextInput.setText(fuelTextInput.getText().toString() + ".");
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
        String decrementedDisplay = fuelTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            fuelTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            fuelTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = fuelTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    fuelTextInput.setText(currentDisplay);
                }

                if (fuelTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(fuelTextInput.getText());
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
                    fuelTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        fuelTextInput.setText("0");
        fuelTextOutput.setText("0");
        checkInSelection();
    }
}
