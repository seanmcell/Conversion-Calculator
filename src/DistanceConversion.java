import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.lang.String;

import java.text.DecimalFormat;


public class DistanceConversion {

    //private String input;
    int radioLeftSelection = 0;
    int radioRightSelection = 0;

    DistanceConversion()
    {

    }


    public GridPane getPane()
    {
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: Grey");
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


        RadioButton leftYards = new RadioButton("Yards");
        leftYards.setToggleGroup(groupLeft);
        //leftGrams.setAlignment(Pos.TOP_LEFT);
        leftYards.setSelected(true);
        gridPane.add(leftYards, 0, 1);

        RadioButton leftMiles = new RadioButton("Miles");
        leftMiles.setToggleGroup(groupLeft);
        //leftOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftMiles, 0, 2);

        RadioButton leftMeters = new RadioButton("Meters");
        leftMeters.setToggleGroup(groupLeft);
        //leftLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftMeters, 0, 3);

        RadioButton leftKilometers = new RadioButton("Kilometers");
        leftKilometers.setToggleGroup(groupLeft);
        //leftTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftKilometers, 0, 4);


        final ToggleGroup groupRight = new ToggleGroup();


        RadioButton rightYards = new RadioButton("Yards");
        rightYards.setToggleGroup(groupRight);
        //rightGrams.setAlignment(Pos.TOP_LEFT);
        rightYards.setSelected(true);
        gridPane.add(rightYards, 1, 1);

        RadioButton rightMiles = new RadioButton("Miles");
        rightMiles.setToggleGroup(groupRight);
        //rightOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightMiles, 1, 2);

        RadioButton rightMeters = new RadioButton("Meters");
        rightMeters.setToggleGroup(groupRight);
        //rightLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightMeters, 1, 3);

        RadioButton rightKilometers = new RadioButton("Kilometers");
        rightKilometers.setToggleGroup(groupRight);
        //rightTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightKilometers, 1, 4);


        //----------------------------------------RadioButton Selected----------------------------------------------

        convertButton.setOnAction(e -> {



            if(groupLeft.getSelectedToggle() == leftYards)
            {
                radioLeftSelection = 0;
            }
            else if(groupLeft.getSelectedToggle() == leftMiles)
            {
                radioLeftSelection = 1;
            }
            else if(groupLeft.getSelectedToggle() == leftMeters)
            {
                radioLeftSelection = 2;
            }
            else if(groupLeft.getSelectedToggle() == leftKilometers)
            {
                radioLeftSelection = 3;
            }




            if(groupRight.getSelectedToggle() == rightYards)
            {
                radioRightSelection = 0;
            }
            else if(groupRight.getSelectedToggle() == rightMiles)
            {
                radioRightSelection = 1;
            }
            else if(groupRight.getSelectedToggle() == rightMeters)
            {
                radioRightSelection = 2;
            }
            else if(groupRight.getSelectedToggle() == rightKilometers)
            {
                radioRightSelection = 3;
            }


            label.setText((convert(input.getText(), radioLeftSelection, radioRightSelection)));


        });
        return gridPane;
    }

    /*
        google
        1 yard = 0.000568182
        1 yard = 0.9144
        1 yard = 0.0009144

        1 mile = 1760
        1 mile = 1609.34
        1 mile = 1.60933999997549

        1 meter = 1.0936105801618560829
        1 meter = 0.0006213696478192363851
        1 meter = 0.00099999751450000127877

        1 kilometer = 1093.6105801618562055
        1 kilometer = 0.62136964781923642587
        1 kilometer = 999.99751450000121622




    */

    public String convert(String input, int leftType, int rightType)
    {

        double conversion;
        switch(leftType)
        {

            //-------------Yard to ? ---------------------------------------------
            case 0:
            {
                if(rightType == 0)
                {
                    return input;
                }
                else if(rightType == 1)
                {
                    conversion = (Double.parseDouble(input)*0.000568182);
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*0.9144;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.0009144;
                    return this.toString(conversion);
                }
            }break;

            //-------------Mile to ? ---------------------------------------------
            case 1:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)*1760;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    return input;
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*1609.34;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*1.60933999997549;
                    return this.toString(conversion);
                }
            }break;

            //-------------Meter to ? ---------------------------------------------
            case 2:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)*1.0936105801618560829;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)*0.0006213696478192363851;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    return input;
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.00099999751450000127877;
                    return this.toString(conversion);
                }

            }break;

            //-------------Kilometer to ? ---------------------------------------------
            case 3:
            {
                if(rightType == 0)
                {
                    conversion = Math.floor(Double.parseDouble(input)*1093.6105801618562055);
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)*0.62136964781923642587;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*999.99751450000121622;
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
