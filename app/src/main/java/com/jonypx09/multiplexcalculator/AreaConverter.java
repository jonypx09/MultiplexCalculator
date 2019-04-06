package com.jonypx09.multiplexcalculator;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AreaConverter {

    private TextView areaTextInput;
    private TextView areaTextOutput;
    private Spinner areaOptionsIn;
    private Spinner areaOptionsOut;
    private BigDecimal mainResult;

    public AreaConverter (TextView areaTextInput, TextView areaTextOutput, Spinner areaOptionsIn, Spinner areaOptionsOut){
        super();
        this.areaTextInput = areaTextInput;
        this.areaTextOutput = areaTextOutput;
        this.areaOptionsIn = areaOptionsIn;
        this.areaOptionsOut = areaOptionsOut;

        areaOptionsIn.setSelection(0,false);
        areaOptionsIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                checkInSelection();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        areaOptionsOut.setSelection(0,false);
        areaOptionsOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        String textInput = areaTextInput.getText().toString().replace(",", "");
        switch(areaOptionsIn.getSelectedItemPosition()){
            case 0:
                convertFromAcres(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 1:
                convertFromHectares(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 2:
                convertFromSquareCentimetres(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 3:
                convertFromSquareFeet(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 4:
                convertFromSquareInches(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 5:
                convertFromSquareKilometres(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 6:
                convertFromSquareMiles(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 7:
                convertFromSquareMetres(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 8:
                convertFromSquareMillimetres(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
            case 9:
                convertFromSquareYards(textInput, areaOptionsOut.getSelectedItemPosition(), areaTextOutput);
                break;
        }
    }


    public void convertFromAcres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                output.setText(input);
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.40468564224000003).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 40468564.224).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 43560).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6272640).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0040468564224).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0015625).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4046.8564224).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4046856422.4000006).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4840).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromHectares(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.471053814671653).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                output.setText(input);
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 107639.10416709722).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 15500031.000062).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.01).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.003861021585424458).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (1000000000 * 10)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 11959.900463010803).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareCentimetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.4710538146716536e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                output.setText(input);
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0010763910416709721).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.15500031000062).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1e-10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.8610215854244583e-11).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00011959900463010803).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareFeet(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00002295684113865932).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000009290304).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 929.0304).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                output.setText(input);
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 144).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9.290304000000001e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.587006427915519e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.09290304).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 92903.04000000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.11111111111111112).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareInches(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.5942250790735638e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.4516e-8).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.451599999999999).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.006944444444444444).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                output.setText(input);
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 6.4516e-10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.4909766860524435e-10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00064516).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 645.16).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0007716049382716049).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareKilometres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 247.10538146716533).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 100).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (1000000000 * 10)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10763910.416709721).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1550003100.0062).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                output.setText(input);
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.38610215854244584).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (1000000000 * 1000)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1195990.0463010804).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareMiles(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 640).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 258.9988110336).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 25899881103.36).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 27878400).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 4014489600.0000005).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.5899881103360003).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                output.setText(input);
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2589988.110336).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * (2589988110.336 * 1000)).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3097600).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareMetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0002471053814671653).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10.763910416709722).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1550.0031000062002).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.861021585424458e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                output.setText(input);
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1000000).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1.1959900463010802).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareMillimetres(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 2.471053814671653e-10).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 10e-11).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.009999999999999998).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000010763910416709721).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0015500031000062).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1e-12).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.861021585424458e-13).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000001).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                output.setText(input);
                break;
            case 9: //Square Yards
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.0000011959900463010801).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }


    public void convertFromSquareYards(String input, int selectedItem, TextView output){
        DecimalFormat format = new DecimalFormat("0.######");
        switch(selectedItem){
            case 0: //Acres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.00020661157024793388).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 1: //Hectares
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.000083612736).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 2: //Square Centimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 8361.273599999999).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 3: //Square Feet
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 9).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 4: //Square Inches
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 1296).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 5: //Square Kilometres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 8.3612736e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 6: //Square Miles
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 3.2283057851239667e-7).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 7: //Square Metres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 0.83612736).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 8: //Square Millimetres
                mainResult = BigDecimal.valueOf(Float.parseFloat(input) * 836127.36).setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
                break;
            case 9: //Square Yards
                output.setText(input);
                break;
        }
        if (selectedItem != 0){
            output.setText(format.format(mainResult.doubleValue()));
        }
    }





    public void insertCommas(TextView areaTextInput, TextView areaTextOutput){
        String currentDisplay = areaTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                areaTextInput.setText(currentDisplay);
            }

            if (areaTextInput.getText().length() > 3){
                StringBuilder newDisplayBuilder = new StringBuilder(areaTextInput.getText());
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
                areaTextInput.setText(newDisplay);
            }
        }
    }
    

    public void insertNumber(String number){
        if (areaTextInput.getText() == "0") {
            areaTextInput.setText(number);
        }else{
            areaTextInput.setText(areaTextInput.getText().toString() + number);
        }

        //Remove all commas and reset placement
        String currentDisplay = areaTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (currentDisplay.contains(",")){
                currentDisplay = currentDisplay.replace(",", "");
                areaTextInput.setText(currentDisplay);
            }
        }
        insertCommas(areaTextInput, areaTextOutput);
        checkInSelection();

//        adjustGrowingTextSize();
    }

    public void insertPeriod(View v){
        String currentDisplay = areaTextInput.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                areaTextInput.setText(areaTextInput.getText().toString() + ".");
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
        String decrementedDisplay = areaTextInput.getText().toString();

        if (decrementedDisplay.length() == 1){
            areaTextInput.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            areaTextInput.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = areaTextInput.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    areaTextInput.setText(currentDisplay);
                }

                if (areaTextInput.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(areaTextInput.getText());
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
                    areaTextInput.setText(newDisplay);
                }
            }
        }
        checkInSelection();
    }

    public void cancelEverything(View v){
        areaTextInput.setText("0");
        areaTextOutput.setText("0");
        checkInSelection();
    }
    
}
