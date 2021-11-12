package sample;
import com.company.*;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.util.Duration;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    private int count=0;
    private int size;
    private int index=0;
    boolean check;
    @FXML
    private Button bfsButton;
    @FXML
    private Button dfsButton;
    @FXML
    private Button euclidean;
    @FXML
    private Button manhaten;
    @FXML
    private TextField textfield;
    @FXML
    private Button bt0;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button next;
    @FXML
    private Button previous;
    ArrayList<Button> buttonlist = new ArrayList<>();
    ArrayList<String> currentList=new ArrayList<>();
    IPuzzleSolver bfs =new BFS();
    IPuzzleSolver dfs =new DFS();
    IPuzzleSolver amanhatten=new InformedSearchManhattan();
    IPuzzleSolver aeuclidean=new InformedSearchEuclidean();

    public void enable()
    {
        textfield.setDisable(false);
        bfsButton.setDisable(false);
        dfsButton.setDisable(false);
        manhaten.setDisable(false);
        euclidean.setDisable(false);
    }
    public void disable()
    {
        textfield.setDisable(true);
        bfsButton.setDisable(true);
        dfsButton.setDisable(true);
        manhaten.setDisable(true);
        euclidean.setDisable(true);
    }
    private void makeBtnList()
    {
        buttonlist.clear();
        buttonlist.add(bt0);
        buttonlist.add(bt1);
        buttonlist.add(bt2);
        buttonlist.add(bt3);
        buttonlist.add(bt4);
        buttonlist.add(bt5);
        buttonlist.add(bt6);
        buttonlist.add(bt7);
        buttonlist.add(bt8);
    }
    private boolean checkText()
    {
        String t = textfield.getText();
        if(t.contains("0")&&t.contains("1")&&t.contains("2")&&t.contains("3")&&t.contains("4")&&t.contains("5")
                &&t.contains("6")&&t.contains("7")&&t.contains("8")&&t.length()==9) {
            return true;
        }
        else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input Not Valid");
            errorAlert.setContentText("Please Enter a valid Initial State");
            errorAlert.showAndWait();
            return false;
        }
    }
    private void checkGoal(String t){
        if(t.equals("012345678"))
            next.setDisable(true);
    }
    private void iteration()
    {

        for (int i = 0; i < 9; i++) {
            if(currentList.get(count).charAt(i) ==' ')
            {
                index=i;
                buttonlist.get(index).setStyle("-fx-background-color: #424949;");
            }{
                buttonlist.get(i).setText(Character.toString(currentList.get(count).charAt(i)));
            }
        }

    }
    public void Breadth_First(ActionEvent e) {
        check=checkText();
        if (check == true) {
            disable();
            next.setDisable(false);
            makeBtnList();
            String t = textfield.getText();
            checkGoal(t);
            currentList = (ArrayList<String>) bfs.solvePuzzle(t.replace('0',' '));
            count = 0;
            size = currentList.size();
            if (size == 0) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input Not Solvable");
                errorAlert.setContentText("Please Enter a Solvable Initial State");
                errorAlert.showAndWait();
                reset(e);
            } else {
                buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
                iteration();
            }
        }
    }


    public void Depth_First(ActionEvent e) throws InterruptedException {
        check = checkText();
        if (check == true) {
            disable();
            next.setDisable(false);
            makeBtnList();
            String t = textfield.getText();
            checkGoal(t);
            currentList = (ArrayList<String>) dfs.solvePuzzle(t.replace('0',' '));
            count = 0;
            size = currentList.size();
            if (size == 0) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input Not Solvable");
                errorAlert.setContentText("Please Enter a Solvable Initial State");
                errorAlert.showAndWait();
                reset(e);
            } else {
                buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
                iteration();
            }
        }
    }
    public void Manhatten(ActionEvent e) throws InterruptedException {
        check = checkText();
        if (check == true) {
            disable();
            next.setDisable(false);
            makeBtnList();
            String t = textfield.getText();
            checkGoal(t);
            currentList = (ArrayList<String>) amanhatten.solvePuzzle(t.replace('0',' '));
            count = 0;
            size = currentList.size();
            if (size == 0) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input Not Solvable");
                errorAlert.setContentText("Please Enter a Solvable Initial State");
                errorAlert.showAndWait();
                reset(e);
            } else {
                buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
                iteration();
            }
        }
    }
    public void Euclidean(ActionEvent e) throws InterruptedException {
        check = checkText();
        if (check == true) {
            disable();
            next.setDisable(false);
            makeBtnList();
            String t = textfield.getText();
            checkGoal(t);
            currentList = (ArrayList<String>) aeuclidean.solvePuzzle(t.replace('0',' '));
            count = 0;
            size = currentList.size();
            if (size == 0) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Input Not Solvable");
                errorAlert.setContentText("Please Enter a Solvable Initial State");
                errorAlert.showAndWait();
                reset(e);
            } else {
                buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
                iteration();
            }
        }
    }
    public void Next(ActionEvent e){
        previous.setDisable(false);
        count++;
         if(count==size-1)
        {
            buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
            iteration();
            next.setDisable(true);
        }
        else{
             buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
             iteration();
        }
    }
    public void Previous(ActionEvent e){
        next.setDisable(false);
         if(count==1)
        {
            count--;
            buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
            iteration();
            previous.setDisable(true);
        }
        else{
            count--;
             buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
             iteration();
        }
    }
    public void reset(ActionEvent e)
    {
        if(!buttonlist.isEmpty()){
            for(int i=0;i<9;i++) {
                buttonlist.get(i).setText("");
            }
            buttonlist.get(index).setStyle("-fx-background-color: #ffffff;");
        }
        buttonlist.clear();
        currentList.clear();
        next.setDisable(true);
        previous.setDisable(true);
        count=0;
        enable();
    }
}
