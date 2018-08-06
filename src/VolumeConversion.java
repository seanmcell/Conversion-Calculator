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
        gridPane.setStyle("-fx-background-color: White");
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


        RadioButton leftGrams = new RadioButton("Grams");
        leftGrams.setToggleGroup(groupLeft);
        //leftGrams.setAlignment(Pos.TOP_LEFT);
        leftGrams.setSelected(true);
        gridPane.add(leftGrams, 0, 1);

        RadioButton leftOz = new RadioButton("Oz");
        leftOz.setToggleGroup(groupLeft);
        //leftOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftOz, 0, 2);

        RadioButton leftLbs = new RadioButton("lbs");
        leftLbs.setToggleGroup(groupLeft);
        //leftLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftLbs, 0, 3);

        RadioButton leftTon = new RadioButton("Ton");
        leftTon.setToggleGroup(groupLeft);
        //leftTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(leftTon, 0, 4);


        final ToggleGroup groupRight = new ToggleGroup();


        RadioButton rightGrams = new RadioButton("Grams");
        rightGrams.setToggleGroup(groupRight);
        //rightGrams.setAlignment(Pos.TOP_LEFT);
        rightGrams.setSelected(true);
        gridPane.add(rightGrams, 1, 1);

        RadioButton rightOz = new RadioButton("Oz");
        rightOz.setToggleGroup(groupRight);
        //rightOz.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightOz, 1, 2);

        RadioButton rightLbs = new RadioButton("lbs");
        rightLbs.setToggleGroup(groupRight);
        //rightLbs.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightLbs, 1, 3);

        RadioButton rightTon = new RadioButton("Ton");
        rightTon.setToggleGroup(groupRight);
        //rightTon.setAlignment(Pos.TOP_LEFT);
        gridPane.add(rightTon, 1, 4);


        //----------------------------------------RadioButton Selected----------------------------------------------

        convertButton.setOnAction(e -> {



            if(groupLeft.getSelectedToggle() == leftGrams)
            {
                radioLeftSelection = 0;
            }
            else if(groupLeft.getSelectedToggle() == leftOz)
            {
                radioLeftSelection = 1;
            }
            else if(groupLeft.getSelectedToggle() == leftLbs)
            {
                radioLeftSelection = 2;
            }
            else if(groupLeft.getSelectedToggle() == leftTon)
            {
                radioLeftSelection = 3;
            }




            if(groupRight.getSelectedToggle() == rightGrams)
            {
                radioRightSelection = 0;
            }
            else if(groupRight.getSelectedToggle() == rightOz)
            {
                radioRightSelection = 1;
            }
            else if(groupRight.getSelectedToggle() == rightLbs)
            {
                radioRightSelection = 2;
            }
            else if(groupRight.getSelectedToggle() == rightTon)
            {
                radioRightSelection = 3;
            }


            label.setText((convert(input.getText(), radioLeftSelection, radioRightSelection)));


        });
        return gridPane;
    }

    /*
        1 g = 0.035274 oz
        1 g = 0.00220462 lbs
        1 g = 0.00000110231 tons

        1 oz = 1/.035274 grams
        1 oz = 0.0625 lbs
        1 oz = 0.00003125 tons

        1 lbs = 1/0.00220462 grams
        1 lbs = 1/0.0625 oz
        1 lbs = 0.0005

        1 ton = 1/0.00000110231 grams
        1 ton = 1/0.00003125 oz
        1 ton = 1/0.0005 lbs
     */


    /*
       Measurement Types
       0 = Grams
       1 = Oz
       2 = lbs
       3 = Ton
    */

    public String convert(String input, int leftType, int rightType)
    {

        double conversion;
        switch(leftType)
        {

            //-------------Gram to ? ---------------------------------------------
            case 0:
            {
                if(rightType == 0)
                {
                    return input;
                }
                else if(rightType == 1)
                {
                    conversion = (Double.parseDouble(input)*0.035274);
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*0.00220462;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.00000110231;
                    return this.toString(conversion);
                }
            }break;

            //-------------Oz to ? ---------------------------------------------
            case 1:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)/0.035274;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    return input;
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)*0.0625;
                    return this.toString(conversion);
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.00003125;
                    return this.toString(conversion);
                }
            }break;

            //-------------lbs to ? ---------------------------------------------
            case 2:
            {
                if(rightType == 0)
                {
                    conversion = Double.parseDouble(input)/0.00220462;
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)/0.0625;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    return input;
                }
                else if(rightType == 3)
                {
                    conversion = Double.parseDouble(input)*0.0005;
                    return this.toString(conversion);
                }

            }break;

            //-------------tons to ? ---------------------------------------------
            case 3:
            {
                if(rightType == 0)
                {
                    conversion = Math.floor(((Double.parseDouble(input)/0.00000110231)* 100) / 100);
                    return this.toString(conversion);
                }
                else if(rightType == 1)
                {
                    conversion = Double.parseDouble(input)/0.00003125;
                    return this.toString(conversion);
                }
                else if(rightType == 2)
                {
                    conversion = Double.parseDouble(input)/0.0005;
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
