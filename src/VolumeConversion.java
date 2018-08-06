import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.lang.String;

import java.text.DecimalFormat;


public class VolumeConversion {

    //private String input;
    int radioLeftSelection = 0;
    int radioRightSelection = 0;

    VolumeConversion()
    {

    }


    public GridPane getPane()
    {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: Violet");
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


        RadioButton leftMilliliter = new RadioButton("Milliliter");
        leftMilliliter.setToggleGroup(groupLeft);
        //leftGrams.setAlignment(Pos.TOP_LEFT);
        leftMilliliter.setSelected(true);
        gridPane.add(leftMilliliter, 0, 1);

        RadioButton leftPint = new RadioButton("Pint");
        leftPint.setToggleGroup(groupLeft);
        //leftOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftPint, 0, 2);

        RadioButton leftQuart = new RadioButton("Quart");
        leftQuart.setToggleGroup(groupLeft);
        //leftLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftQuart, 0, 3);

        RadioButton leftGallon = new RadioButton("Gallon");
        leftGallon.setToggleGroup(groupLeft);
        //leftTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftGallon, 0, 4);


        final ToggleGroup groupRight = new ToggleGroup();


        RadioButton rightMilliliter = new RadioButton("Milliliter");
        rightMilliliter.setToggleGroup(groupRight);
        //rightGrams.setAlignment(Pos.TOP_LEFT);
        rightMilliliter.setSelected(true);
        gridPane.add(rightMilliliter, 1, 1);

        RadioButton rightPint = new RadioButton("Pint");
        rightPint.setToggleGroup(groupRight);
        //rightOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightPint, 1, 2);

        RadioButton rightQuart = new RadioButton("Quart");
        rightQuart.setToggleGroup(groupRight);
        //rightLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightQuart, 1, 3);

        RadioButton rightGallon = new RadioButton("Gallon");
        rightGallon.setToggleGroup(groupRight);
        //rightTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightGallon, 1, 4);


        //----------------------------------------RadioButton Selected----------------------------------------------

        convertButton.setOnAction(e -> {



            if(groupLeft.getSelectedToggle() == leftMilliliter)
            {
                radioLeftSelection = 0;
            }
            else if(groupLeft.getSelectedToggle() == leftPint)
            {
                radioLeftSelection = 1;
            }
            else if(groupLeft.getSelectedToggle() == leftQuart)
            {
                radioLeftSelection = 2;
            }
            else if(groupLeft.getSelectedToggle() == leftGallon)
            {
                radioLeftSelection = 3;
            }




            if(groupRight.getSelectedToggle() == rightMilliliter)
            {
                radioRightSelection = 0;
            }
            else if(groupRight.getSelectedToggle() == rightPint)
            {
                radioRightSelection = 1;
            }
            else if(groupRight.getSelectedToggle() == rightQuart)
            {
                radioRightSelection = 2;
            }
            else if(groupRight.getSelectedToggle() == rightGallon)
            {
                radioRightSelection = 3;
            }


            label.setText((convert(input.getText(), radioLeftSelection, radioRightSelection)));


        });
        return gridPane;
    }

    /*
        1 Milliliter = 0.00211338 pint
        1 Milliliter = 0.0010566900000002748 quart
        1 Milliliter = 0.00026417250000006871 gallon

        1 Pint = 473.17727480179217991 milliliter
        1 Pint = 0.50000084725450000267 quart
        1 Pint = 0.12500021181362500067 gallon

        1 Quart = 946.35454960358435983 milliliter
        1 Quart = 2.0000033890180000107 pint
        1 Quart = 0.12500021181362500067 gallon

        1 Gallon = 3785.4181984143374393 milliliter
        1 Gallon = 7.5708363968286738199 pint
        1 Gallon = 4.0000067780360000214 quart
    */

    public String convert(String input, int leftType, int rightType)
    {

        double conversion;
        switch(leftType)
        {

            //-------------Milliliter to ? ---------------------------------------------
            case 0:
            {
                if(rightType == 0)
                {
                    return input;
                }
                else if(rightType == 1)
                {
                    conversion = (Double.parseDouble(input)*0.00211338);
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*0.0010566900000002748;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.00026417250000006871;
                    return this.toString(conversion);
                }
            }break;

            //-------------Pint to ? ---------------------------------------------
            case 1:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)*473.17727480179217991;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    return input;
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*0.50000084725450000267;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.12500021181362500067;
                    return this.toString(conversion);
                }
            }break;

            //-------------Quart to ? ---------------------------------------------
            case 2:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)*946.35454960358435983;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)*2.0000033890180000107;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    return input;
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.12500021181362500067;
                    return this.toString(conversion);
                }

            }break;

            //-------------Gallon to ? ---------------------------------------------
            case 3:
            {
                if(rightType == 0)
                {
                    conversion = Math.floor(Double.parseDouble(input)*3785.4181984143374393);
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)*7.5708363968286738199;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*4.0000067780360000214;
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
