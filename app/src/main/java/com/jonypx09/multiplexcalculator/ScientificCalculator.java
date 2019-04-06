package com.jonypx09.multiplexcalculator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.udojava.evalex.Expression;

public class ScientificCalculator{

    public Context mContext;
    private TextView scDisplay;
    private String scDisplayString;

    //One is stored for square rooting, other for large computations
    private BigDecimal mainResult;
    private double scResult;

    public ScientificCalculator(TextView scDisplay, Context context){
        this.scDisplay = scDisplay;
        this.scResult = 0;
        this.mainResult = BigDecimal.ZERO;
        this.mContext = context;
    }

    public void insertNumber(String number){
        if (scDisplay.getText() == "0") {
            scDisplay.setText(number);
        }else{
            scDisplay.setText(scDisplay.getText().toString() + number);
        }


        //Create new mechanism for inserting commas!

//        String currentDisplay = scDisplay.getText().toString();
//
//        if (!(currentDisplay.contains("."))){
//            if (currentDisplay.contains(",")){
//                currentDisplay = currentDisplay.replace(",", "");
//                scDisplay.setText(currentDisplay);
//            }
//
//            if (scDisplay.getText().length() > 3){
//                StringBuilder newDisplayBuilder = new StringBuilder(scDisplay.getText());
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
//                scDisplay.setText(newDisplay);
//            }
//        }

//        adjustGrowingTextSize();
    }

    public void insertPeriod(){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.contains("."))){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '.')){
                scDisplay.setText(scDisplay.getText().toString() + ".");
            }
        }
    }

    public void insertOne(){
        insertNumber("1");
    }

    public void insertTwo(){
        insertNumber("2");
    }

    public void insertThree(){
        insertNumber("3");
    }

    public void insertFour(){
        insertNumber("4");
    }

    public void insertFive(){
        insertNumber("5");
    }

    public void insertSix(){
        insertNumber("6");
    }

    public void insertSeven(){
        insertNumber("7");
    }

    public void insertEight(){
        insertNumber("8");
    }

    public void insertNine(){
        insertNumber("9");
    }

    public void insertZero(){
        insertNumber("0");
    }

    public void insertPlus(){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.endsWith("+"))){
            scDisplay.setText(scDisplay.getText().toString() + "+");
        }
    }

    public void insertMinus(){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.endsWith("-"))){
            scDisplay.setText(scDisplay.getText().toString() + "-");
        }
    }

    public void insertTimes(){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.endsWith("x"))){
            scDisplay.setText(scDisplay.getText().toString() + "x");
        }
    }

    public void insertDivide(){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.endsWith("÷"))){
            scDisplay.setText(scDisplay.getText().toString() + "÷");
        }
    }

    public void insertPi(){
        scDisplay.setText(Double.toString(Math.PI));
        scDisplay.setTextSize(45);
    }

    public void insertMod(){
        if (!(scDisplay.getText().toString().contains("Mod"))){
            scDisplay.setText(scDisplay.getText().toString() + " Mod ");
        }
    }


    public void insertLeftBracket(){
        if (scDisplay.getText() == "0") {
            scDisplay.setText("(");
        }else{
            scDisplay.setText(scDisplay.getText().toString() + "(");
        }
    }

    public void insertRightBracket(){
        if (scDisplay.getText() == "0") {
            scDisplay.setText(")");
        }else{
            scDisplay.setText(scDisplay.getText().toString() + ")");
        }
    }


    public void deleteDigit(View v){
        String decrementedDisplay = scDisplay.getText().toString();

        if (decrementedDisplay.length() == 1){
            scDisplay.setText("0");

        }else if (decrementedDisplay.length() >= 2) {
            scDisplay.setText(decrementedDisplay.substring(0, decrementedDisplay.length() - 1));

            //Remove all commas and reset placement
            String currentDisplay = scDisplay.getText().toString();

            if (!(currentDisplay.contains("."))){
                if (currentDisplay.contains(",")){
                    currentDisplay = currentDisplay.replace(",", "");
                    scDisplay.setText(currentDisplay);
                }

                if (scDisplay.getText().length() > 3){
                    StringBuilder newDisplay = new StringBuilder(scDisplay.getText());
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
                    scDisplay.setText(newDisplay);
                }
            }
        }
    }

    public void cancelEverything(View v){
        scDisplay.setText("0");
        scDisplay.setTextSize(70);
    }

    public void clearEntry(View v){
        scDisplay.setText("0");
    }

    public void changeSign(View v){
        String currentDisplay = scDisplay.getText().toString();

        if (currentDisplay.startsWith("-")){
            scDisplay.setText(scDisplay.getText().toString().substring(1));
        }else if (!(currentDisplay.startsWith("0"))){
            scDisplay.setText("-" + currentDisplay);
        }
    }


    //Computational Functions
    public boolean squareRootEval(int type){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.contains("∞"))){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                scDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            scDisplay.setText(currentNumString);

            try{
                BigDecimal result = null;
                result = new Expression(currentNumString).eval();
                double currentNumber = result.doubleValue();

                if (type == 0){
                    scResult = Math.sqrt(currentNumber);
                }else{
                    scResult = 1 / currentNumber;
                }
                scDisplay.setText(Double.toString(scResult));
                if (scDisplay.getText().toString() == "NaN"){
                    throw new Exception();
                }
                if (scDisplay.getText().toString().equals("Infinity")){
                    scDisplay.setText("∞");
                }

                //Adjust if it is a whole number (get rid of the .0)
                currentDisplay = scDisplay.getText().toString();
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                        && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                    scDisplay.setText(currentDisplay);
                }else{
                    scDisplay.setTextSize(50);
                }

                return true;
            }catch (Exception e){
                return false;
            }
        }else{
            if (type == 0) {
                scDisplay.setText("∞");
                scDisplay.setTextSize(100);
            }else{
                scDisplay.setText("0");
                scDisplay.setTextSize(100);
            }

            return true;
        }
    }

    public void squaredEval(){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.contains("∞"))){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                scDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            scDisplay.setText(currentNumString);

            BigDecimal result = null;
            result = new Expression(currentNumString).eval();
            double currentNumber = result.doubleValue();

            scResult = Math.pow(currentNumber, 2);
            scDisplay.setText(Double.toString(scResult));

            if (scDisplay.getText().toString() == "Infinity"){
                scDisplay.setText("∞");
                scDisplay.setTextSize(100);
            }else{
                //Adjust if it is a whole number (get rid of the .0)
                currentDisplay = scDisplay.getText().toString();
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                        && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                    scDisplay.setText(currentDisplay);
                }else{
                    scDisplay.setTextSize(50);
                }
            }
        }else{
            scDisplay.setText("∞");
            scDisplay.setTextSize(100);
        }
    }

    public void cubedEval(){
        String currentDisplay = scDisplay.getText().toString();

        if (!(currentDisplay.contains("∞"))){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                scDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            scDisplay.setText(currentNumString);
            double currentNumber = Double.parseDouble(currentNumString);

            scResult = Math.pow(currentNumber, 3);
            scDisplay.setText(Double.toString(scResult));

            //Adjust if it is a whole number (get rid of the .0)
            if (scDisplay.getText().toString() == "Infinity"){
                scDisplay.setText("∞");
                scDisplay.setTextSize(100);
            }else{
                currentDisplay = scDisplay.getText().toString();
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                        && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                    scDisplay.setText(currentDisplay);
                }else{
                    scDisplay.setTextSize(50);
                }
            }
        }else{
            scDisplay.setText("∞");
            scDisplay.setTextSize(100);
        }
    }

    public boolean factorialEval(){
        String currentDisplay = scDisplay.getText().toString();

        if (currentDisplay.contains("∞")){
            scDisplay.setText("Undefined");
            return false;
        }else{
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                scDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            scDisplay.setText(currentNumString);
            double currentNumber = Double.parseDouble(currentNumString);

            if (currentNumber > 1000){
                scDisplay.setText("∞");
            }else{
                //Won't produce correct result for non-integers
                mainResult = new Expression("fact(" + currentNumString + ")").eval();
                scDisplay.setText(Double.toString(mainResult.doubleValue()));
            }

            //Adjust if it is a whole number (get rid of the .0)
            currentDisplay = scDisplay.getText().toString();
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                    && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                scDisplay.setText(currentDisplay);
            }else{
                scDisplay.setTextSize(50);
            }
            return true;
        }
    }

    public void tenExponentEval(int type){
        String currentDisplay = scDisplay.getText().toString();

        if (currentDisplay != "∞"){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                scDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            scDisplay.setText(currentNumString);
            double currentNumber = Double.parseDouble(currentNumString);

            if (type == 0){
                //Add a try and catch branch here to handle very large numbers
                mainResult = BigDecimal.valueOf(Math.pow(10, currentNumber));
            }else{
                mainResult = new Expression("e^(" + currentNumString + ")").eval();
            }
            scDisplay.setText(mainResult.toString());

            //Adjust if it is a whole number (get rid of the .0)
            currentDisplay = scDisplay.getText().toString();
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                    && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                scDisplay.setText(currentDisplay);
            }else{
                scDisplay.setTextSize(50);
            }
        }
    }

    public void customExponentEval(int type){
        String currentDisplay = scDisplay.getText().toString();
        if (type == 0){
            if (!((currentDisplay.charAt(currentDisplay.length() - 1)) == '^')){
                scDisplay.setText(scDisplay.getText().toString() + "^");
            }
        }else{
            if (!(currentDisplay.endsWith("yroot "))){
                scDisplay.setText(scDisplay.getText().toString() + " yroot ");
            }
        }
    }

    public boolean logFunctionEval(int type){
        String currentDisplay = scDisplay.getText().toString();

        if ( (!(currentDisplay.equals("0"))) && (!(currentDisplay.equals("∞")))){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                scDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            scDisplay.setText(currentNumString);
//            double currentNumber = Double.parseDouble(currentNumString);

//        scResult = new Expression("(3.4 + -4.1)/2").eval();

            //Won't produce correct result for non-integers
            try{
                if (type == 0){
                    mainResult = new Expression("log10(" + currentNumString + ")").eval();
                }else{
                    mainResult = new Expression("log(" + currentNumString + ")").eval();
                }
                scDisplay.setText(Double.toString(mainResult.doubleValue()));

                //Adjust if it is a whole number (get rid of the .0)
                currentDisplay = scDisplay.getText().toString();
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                        && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                    scDisplay.setText(currentDisplay);
                }else{
                    scDisplay.setTextSize(50);
                }
                return true;
            }catch(Exception e){
                return false;
            }
        }else{
            //Tell the user that the input is invalid
            return false;
        }
    }

    public boolean trigFunctionEval(int type){
        String currentDisplay = scDisplay.getText().toString();

        if (currentDisplay.equals("∞")){
            scDisplay.setText("Undefined");
            return false;

        }else if (!(currentDisplay.equals("0"))){
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                    || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                scDisplay.setText(currentDisplay);
            }
            String currentNumString = new String();
            for (int i = 0; i < currentDisplay.length(); i++){
                if (!(currentDisplay.charAt(i) == ',')){
                    currentNumString += currentDisplay.charAt(i);
                }
            }
            scDisplay.setText(currentNumString);
            double currentNumber = Double.parseDouble(currentNumString);

//        scResult = new Expression("(3.4 + -4.1)/2").eval();

            //Won't produce correct result for non-integers

            boolean validInput = true;

            if ((type == 1) || (type == 3) || (type == 5)){
                if ((currentNumber >= 0) && (currentNumber <= 1)){
                    if (type == 1){
                        mainResult = new Expression("asin(" + currentNumString + ")").eval();
                    }else if (type == 3){
                        mainResult = new Expression("acos(" + currentNumString + ")").eval();
                    }else{
                        //This is not producting correct results -----------------------------------------------------------------------------------------------------------
                        mainResult = new Expression("atan(" + currentNumString + ")").eval();
                    }
                }else{
                    validInput = false;
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Error")
                            .setMessage("Invalid Number! Input must be between 0 and 1")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(
                                    "Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    })
                            .show();
                }
            }else{
                if (type == 0){
                    mainResult = new Expression("sin(" + currentNumString + ")").eval();
                }else if (type == 2){
                    mainResult = new Expression("cos(" + currentNumString + ")").eval();
                }else if (type == 4){
                    mainResult = new Expression("tan(" + currentNumString + ")").eval();
                }
            }
            if (validInput){
                scDisplay.setText(Double.toString(mainResult.doubleValue()));
            }

            //Adjust if it is a whole number (get rid of the .0)
            currentDisplay = scDisplay.getText().toString();
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                    && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                scDisplay.setText(currentDisplay);
            }else{
                scDisplay.setTextSize(50);
            }

            return true;

        }else{
            if (type == 0){
                mainResult = new Expression("sin(0)").eval();
                scDisplay.setText(Double.toString(mainResult.doubleValue()));
            }else if (type == 2){
                mainResult = new Expression("cos(0)").eval();
                scDisplay.setText(Double.toString(mainResult.doubleValue()));
            }else if (type == 4){
                mainResult = new Expression("tan(0)").eval();
                scDisplay.setText(Double.toString(mainResult.doubleValue()));
            }else{
                //Tell the user that the input is invalid
            }

            return true;
        }
    }


    public void evaluateEntry(){
        String currentDisplay = scDisplay.getText().toString();
        ArrayList<Double> operands = new ArrayList<Double>();
        ArrayList<Character> operators = new ArrayList<Character>();

        if (currentDisplay.contains("∞")){
            scDisplay.setText("∞");
            scDisplay.setTextSize(100);
        }else {
            if (currentDisplay.contains("+")
                    || currentDisplay.contains("-")
                    || currentDisplay.contains("x")
                    || currentDisplay.contains("÷")){
                if (currentDisplay.charAt(currentDisplay.length() - 1) == '+'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == '-'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == 'x'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == '÷'
                        || currentDisplay.charAt(currentDisplay.length() - 1) == '.'){
                    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
                    scDisplay.setText(currentDisplay);
                }


                String currentNumString = new String();

                String newCurrentDisplay = new String();

                for (int i = 0; i < currentDisplay.length(); i++){
                    if (!(currentDisplay.charAt(i) == ',')
                            && (!(currentDisplay.charAt(i) == '+'))
                            && (!(currentDisplay.charAt(i) == '-'))
                            && (!(currentDisplay.charAt(i) == 'x'))
                            && (!(currentDisplay.charAt(i) == '÷'))){
                        currentNumString += currentDisplay.charAt(i);
                        newCurrentDisplay += currentDisplay.charAt(i);
                    }else if ((currentDisplay.charAt(i) == '+')
                            ||(currentDisplay.charAt(i) == '-')
                            ||(currentDisplay.charAt(i) == 'x')
                            ||(currentDisplay.charAt(i) == '÷')) {
                        if (currentDisplay.charAt(i) == 'x'){
                            newCurrentDisplay += '*';
                        }else if (currentDisplay.charAt(i) == '÷'){
                            newCurrentDisplay += '/';
                        }else if (currentDisplay.charAt(i) == '÷'){
                            newCurrentDisplay += '/';
                        }else{
                            newCurrentDisplay += currentDisplay.charAt(i);
                        }
//                    operators.add(currentDisplay.charAt(i));
//                    operands.add(Double.parseDouble(currentNumString));
                        currentNumString = "";
                    }
                }
                scDisplay.setText(currentNumString);

                try{
                    BigDecimal result = null;
                    result = new Expression(newCurrentDisplay).eval();
                    scDisplay.setText(Double.toString(result.doubleValue()));
                }catch(Exception e){
                    scDisplay.setText("Error");
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Invalid Expression")
                            .setIcon(R.drawable.alert_circle)
                            .setPositiveButton(
                                    "Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            scDisplay.setText("0");
                                            dialog.cancel();
                                        }
                                    })
                            .show();
                }

                //Add commas if necessary

            }else{
                if (currentDisplay.contains(" yroot ")){
                    currentDisplay = currentDisplay.replace(" yroot ", "^(1/");
                    currentDisplay += ")";
                }
                if (currentDisplay.contains(" Mod ")){
                    currentDisplay = currentDisplay.replace(" Mod ", "%");
                }

                try{
                    BigDecimal result = null;
                    result = new Expression(currentDisplay).eval();
                    scDisplay.setText(Double.toString(result.doubleValue()));
                }catch(Exception e){
                    scDisplay.setText("Error");
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setTitle("Invalid Expression")
                            .setIcon(R.drawable.alert_circle)
                            .setPositiveButton(
                                    "Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            scDisplay.setText("0");
                                            dialog.cancel();
                                        }
                                    })
                            .show();
                }
            }

            if (scDisplay.getText().toString().equals("Infinity")){
                scDisplay.setText("∞");
            }

            //Adjust if it is a whole number (get rid of the .0)
            currentDisplay = scDisplay.getText().toString();
            if (currentDisplay.charAt(currentDisplay.length() - 1) == '0'
                    && currentDisplay.charAt(currentDisplay.length() - 2) == '.'){
                currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 2);
                scDisplay.setText(currentDisplay);
            }else{
                scDisplay.setTextSize(50);
            }
        }
    }

}
