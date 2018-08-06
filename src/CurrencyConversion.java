import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.lang.String;

import java.text.DecimalFormat;


public class CurrencyConversion {

    //private String input;
    int radioLeftSelection = 0;
    int radioRightSelection = 0;

    CurrencyConversion()
    {

    }


    public GridPane getPane()
    {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: Green");
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setAlignment(Pos.TOP_CENTER);


        //------------------------------------------TextFields--------------------------------------------

        TextField input = new TextField();
        input.setAlignment(Pos.TOP_LEFT);
        gridPane.add(input, 0, 0);
        //inputLeft.getText();


        Label label = new Label("Result");
        label.setStyle("-fx-font: normal bold 20px 'serif' ");
        label.setAlignment(Pos.TOP_LEFT);
        gridPane.add(label, 1, 0);

        Button convertButton = new Button("Vert It!");
        gridPane.add(convertButton,0,5);




        //-------------------------------------RadioButtons-------------------------------------------------

        final ToggleGroup groupLeft = new ToggleGroup();


        RadioButton leftUSD = new RadioButton("USD");
        leftUSD.setToggleGroup(groupLeft);
        //leftGrams.setAlignment(Pos.TOP_LEFT);
        leftUSD.setSelected(true);
        gridPane.add(leftUSD, 0, 1);

        RadioButton leftEUR = new RadioButton("EUR");
        leftEUR.setToggleGroup(groupLeft);
        //leftOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftEUR, 0, 2);

        RadioButton leftCAD = new RadioButton("CAD");
        leftCAD.setToggleGroup(groupLeft);
        //leftLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftCAD, 0, 3);

        RadioButton leftAUS = new RadioButton("AUS");
        leftAUS.setToggleGroup(groupLeft);
        //leftTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftAUS, 0, 4);


        final ToggleGroup groupRight = new ToggleGroup();


        RadioButton rightUSD = new RadioButton("USD");
        rightUSD.setToggleGroup(groupRight);
        //rightGrams.setAlignment(Pos.TOP_LEFT);
        rightUSD.setSelected(true);
        gridPane.add(rightUSD, 1, 1);

        RadioButton rightEUR = new RadioButton("EUR");
        rightEUR.setToggleGroup(groupRight);
        //rightOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightEUR, 1, 2);

        RadioButton rightCAD = new RadioButton("CAD");
        rightCAD.setToggleGroup(groupRight);
        //rightLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightCAD, 1, 3);

        RadioButton rightAUS = new RadioButton("AUS");
        rightAUS.setToggleGroup(groupRight);
        //rightTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightAUS, 1, 4);


        //----------------------------------------RadioButton Selected----------------------------------------------

        convertButton.setOnAction(e -> {



            if(groupLeft.getSelectedToggle() == leftUSD)
            {
                radioLeftSelection = 0;
            }
            else if(groupLeft.getSelectedToggle() == leftEUR)
            {
                radioLeftSelection = 1;
            }
            else if(groupLeft.getSelectedToggle() == leftCAD)
            {
                radioLeftSelection = 2;
            }
            else if(groupLeft.getSelectedToggle() == leftAUS)
            {
                radioLeftSelection = 3;
            }




            if(groupRight.getSelectedToggle() == rightUSD)
            {
                radioRightSelection = 0;
            }
            else if(groupRight.getSelectedToggle() == rightEUR)
            {
                radioRightSelection = 1;
            }
            else if(groupRight.getSelectedToggle() == rightCAD)
            {
                radioRightSelection = 2;
            }
            else if(groupRight.getSelectedToggle() == rightAUS)
            {
                radioRightSelection = 3;
            }


            label.setText((convert(input.getText(), radioLeftSelection, radioRightSelection)));


        });
        return gridPane;
    }

    /*
        xe.com

        1 USD = 0.864639 EUR
        1 USD = 1.29953 CAD
        1 USD = 1.35122 AUD

        1 EUR = 1.15655 USD
        1 EUR = 1.50283 CAD
        1 EUR = 1.56277 AUD

        1 CAD = 0.769512 USD
        1 CAD = 0.665409 EUR
        1 CAD = 1.03990 AUD

        1 AUD = 0.740071 USD
        1 AUD = 0.639911 EUR
        1 AUD = 0.961593 CAD

    */

    public String convert(String input, int leftType, int rightType)
    {

        double conversion;
        switch(leftType)
        {

            //-------------USD to ? ---------------------------------------------
            case 0:
            {
                if(rightType == 0)
                {
                    return input;
                }
                else if(rightType == 1)
                {
                    conversion = (Double.parseDouble(input)*0.864639);
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*1.29953;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*1.35122;
                    return this.toString(conversion);
                }
            }break;

            //-------------EURO to ? ---------------------------------------------
            case 1:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)*1.15655;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    return input;
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*1.50283;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*1.56277;
                    return this.toString(conversion);
                }
            }break;

            //-------------CAD to ? ---------------------------------------------
            case 2:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)*0.769512;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)*0.665409;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    return input;
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*1.03990;
                    return this.toString(conversion);
                }

            }break;

            //-------------AUS to ? ---------------------------------------------
            case 3:
            {
                if(rightType == 0)
                {
                    conversion = Math.floor(Double.parseDouble(input)*0.740071);
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)*0.639911;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*0.961593;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    return input;
                }

            }break;
        }
        return null;
    }

    public String toString(Double dub)
    {
        return Double.toString(dub);
    }


}
