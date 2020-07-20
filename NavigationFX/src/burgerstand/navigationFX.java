/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerstand;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class navigationFX extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        
//////////////////// Scene Declarations ////////////////////
        
        AnchorPane root = new AnchorPane();        
        Scene sceneOrder = new Scene(root, 800, 600);

        AnchorPane root2 = new AnchorPane();
        Scene sceneAddItem = new Scene(root2, 800, 600);
        
        primaryStage.setTitle("Menu Items");
        primaryStage.setScene(sceneOrder);
       
//////////////////// End Scene Declarations ////////////////////
        

/////////////////// Start SceneOrder ////////////////////

        ListView<locationFX> item = new ListView();

        // menu items
        item.getItems().add(new locationFX("Cleveland", 0.0, 0.0,true));
        item.getItems().add(new locationFX("North Pole", 500.0, -100.0,false));
        item.getItems().add(new locationFX("Campbell Hill", -50.0, -50.0,false));
        item.getItems().add(new locationFX("Tokyo", -100.0, 1000.0,true));
        
        truckFX Truck1 = new truckFX("Big-Red", 100.0, 100.0, 20, item.getItems().get(0));
        
        //Label is on the left hand side
        Label showCal = new Label("Select item to drive to");
        Label showCal2 = new Label("Current Fuel: " + Truck1.getCurrentFuel());

        Button btn = new Button();
        btn.setText("Drive");
        btn.setOnAction((ActionEvent event) ->
        {   //you have to select the item in the menu then press button
            int x;
            x = item.getSelectionModel().getSelectedIndex();
            
            if(Truck1.getCurrentFuel()<= 0){
                showCal2.setText("Not enough fuel to here");
            }else{
            showCal.setText("You are in: " + item.getItems().get(x).getItemName());
            }
            
            if(Truck1.getCurrentFuel()<= 0){
                showCal2.setText("Not enough fuel");
            }else{
            showCal2.setText("You now have " + Truck1.getCurrentFuel() + "/ " + Truck1.getMaxFuel() + " fuel left" );
            }
            
            
            
            Truck1.drive(item.getItems().get(x));
        });
        
        Button AddItem = new Button();
        Button ReFill = new Button();
        
        ReFill.setText("Roadside assistance");
        ReFill.setOnAction((ActionEvent event) ->
        {
            Truck1.ReFuel();
            showCal.setText("Safelite repair, Safelite replace");
            showCal2.setText("You refuled! you have" + Truck1.getCurrentFuel() + "/ " + Truck1.getMaxFuel() + " fuel left" );
        });
        
        AddItem.setText("Add Location");
        AddItem.setOnAction((ActionEvent event) ->
        {
            primaryStage.setScene(sceneAddItem);
        });
        
                
        
        
        AnchorPane.setBottomAnchor(btn, 10.0);
        AnchorPane.setRightAnchor(btn, 10.0);
        
        AnchorPane.setBottomAnchor(AddItem, 130.0);
        AnchorPane.setRightAnchor(AddItem, 150.0);
        
        AnchorPane.setBottomAnchor(ReFill, 130.0);
        AnchorPane.setRightAnchor(ReFill, 10.0);
        
        //AnchorPane.setBottomAnchor(btnAddItem, 130.0);//-----
        //AnchorPane.setRightAnchor(btnAddItem, 10.0);//-----
        
        AnchorPane.setTopAnchor(item, 10.0);
        AnchorPane.setRightAnchor(item, 10.0);
        
        AnchorPane.setTopAnchor(showCal, 10.0);
        AnchorPane.setLeftAnchor(showCal, 10.0);
        
        AnchorPane.setTopAnchor(showCal2, 40.0);
        AnchorPane.setLeftAnchor(showCal2, 10.0);
        
        root.getChildren().add(btn);
        root.getChildren().add(AddItem);
        root.getChildren().add(ReFill);
        root.getChildren().add(item);
        root.getChildren().add(showCal);
        root.getChildren().add(showCal2);
        
/////////////////// End SceneOrder //////////////////// 


/////////////////// Start SceneAddItem ////////////////////
        
        Label lblItemName = new Label("Location: ");
        Label lblItemCals = new Label("x-Coordinates: ");
        Label lblItemCost = new Label("y-Coordinates: ");
        Label lblItemGas = new Label ("Gas");
        //Label lblItemyLocation = new Label("yLocation: ");
        
        TextField itemName = new TextField();
        //TextField itemxLocation = new TextField();
        //TextField itemyLocation = new TextField();
        TextField itemCals = new TextField();
        TextField itemCost = new TextField();
        RadioButton itemGas = new RadioButton("gas?");
        
        Button btnConfirm = new Button();
        btnConfirm.setText("Confirm");
        btnConfirm.setOnAction((ActionEvent event) ->
        {
            String name;
            double cals;
            double cost;
            boolean gas;
            
            name = itemName.getText();
            cals = Double.parseDouble(itemCals.getText());
            cost = Double.parseDouble(itemCost.getText());
            gas = itemGas.isSelected();
            
            item.getItems().add(new locationFX(name, cals, cost, gas));
            
            primaryStage.setScene(sceneOrder);
        });
        
        Button btnCancel = new Button();
        btnCancel.setText("Cancel");
        btnCancel.setOnAction((ActionEvent event) ->
        {
            primaryStage.setScene(sceneOrder);
        });
        
        AnchorPane.setTopAnchor(lblItemName, 10.0);
        AnchorPane.setLeftAnchor(lblItemName, 10.0);
        
        AnchorPane.setTopAnchor(itemName, 10.0);
        AnchorPane.setLeftAnchor(itemName, 80.0);
        
        AnchorPane.setTopAnchor(lblItemCals, 70.0);
        AnchorPane.setLeftAnchor(lblItemCals, 10.0);
        
        AnchorPane.setTopAnchor(itemCals, 70.0);
        AnchorPane.setLeftAnchor(itemCals, 80.0);
        
        AnchorPane.setTopAnchor(lblItemCost, 130.0);
        AnchorPane.setLeftAnchor(lblItemCost, 10.0);
        
        AnchorPane.setTopAnchor(itemCost, 130.0);
        AnchorPane.setLeftAnchor(itemCost, 80.0);
        
        AnchorPane.setTopAnchor(itemGas, 190.0);
        AnchorPane.setLeftAnchor(itemGas, 50.0);
        
        AnchorPane.setTopAnchor(lblItemGas, 190.0);
        AnchorPane.setLeftAnchor(lblItemGas, 10.0);
        
        AnchorPane.setTopAnchor(btnConfirm, 190.0);
        AnchorPane.setLeftAnchor(btnConfirm, 120.0);
        
        AnchorPane.setTopAnchor(btnCancel, 190.0);
        AnchorPane.setLeftAnchor(btnCancel, 220.0);
        
        root2.getChildren().addAll(lblItemName, itemName, lblItemCals,
                itemCals, itemGas, lblItemGas, lblItemCost, itemCost,
                btnConfirm, btnCancel);

/////////////////// End SceneAddItem ////////////////////
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
