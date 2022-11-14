package com.example.workshops_2;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import net.synedra.validatorfx.Validator;

import java.util.regex.Pattern;

public class StudentController {

    @FXML
    private Label idLbl;

    @FXML
    private Label lastNameLbl;

    @FXML
    private Label firstNameLbl;

    @FXML
    private Label PCNLbl;

    @FXML
    private Label titleLbl;

    @FXML
    private TextField idTxtFld;

    @FXML
    private TextField PCNTxtFld;

    @FXML
    private TextField firstNameTxtFld;

    @FXML
    private TextField lastNameTxtFld;

    @FXML
    private Button ValidateBtn;

    @FXML
    private Label idErrorLbl;

    @FXML
    private Label pcnErrorLbl;

    @FXML
    private Label firstNameErrorLbl;

    @FXML
    private Label lastNameErrorLbl;

    @FXML
    private Label SuccessLabel;

    @FXML
    void ValidateBtn_click(ActionEvent event) {
        idErrorLbl.setText("");
        pcnErrorLbl.setText("");
        firstNameErrorLbl.setText("");
        lastNameErrorLbl.setText("");
        SuccessLabel.setText("");

        boolean idValid = true;
        boolean pcnValid = true;
        boolean firstNameValid = true;
        boolean lastNameValid = true;

        Color red = Color.RED;
        Color green = Color.GREEN;
        if(idTxtFld.getText().isEmpty()){
            idErrorLbl.setTextFill(red);
            idErrorLbl.setText("Please fill in an ID");
            idValid = false;
        }
        if(PCNTxtFld.getText().isEmpty()){
            pcnErrorLbl.setTextFill(red);
            pcnErrorLbl.setText("Please fill in a PCN");
            pcnValid = false;
        }
        if(firstNameTxtFld.getText().isEmpty()){
            firstNameErrorLbl.setTextFill(red);
            firstNameErrorLbl.setText("Please fill in a first name");
            firstNameValid = false;
        }
        if(lastNameTxtFld.getText().isEmpty()){
            lastNameErrorLbl.setTextFill(red);
            lastNameErrorLbl.setText("Please fill in a last name");
            lastNameValid = false;
        }
        Pattern digitPattern = Pattern.compile("[^0-9]");
        if(digitPattern.matcher(idTxtFld.getText()).find() && idValid){
            idErrorLbl.setTextFill(red);
            idErrorLbl.setText("ID has to be numbers");
            idValid = false;
        }
        if(digitPattern.matcher(PCNTxtFld.getText()).find()&& pcnValid){
            pcnErrorLbl.setTextFill(red);
            pcnErrorLbl.setText("PCN has to be numbers");
            pcnValid = false;
        }
        Pattern textPattern = Pattern.compile("[^a-zA-Z]");
        if(textPattern.matcher(firstNameTxtFld.getText()).find() && firstNameValid){
            firstNameErrorLbl.setTextFill(red);
            firstNameErrorLbl.setText("First name has to be only letters");
            firstNameValid = false;
        }
        if(textPattern.matcher(lastNameTxtFld.getText()).find() && lastNameValid){
            lastNameErrorLbl.setTextFill(red);
            lastNameErrorLbl.setText("Last name has to be only letters");
            lastNameValid = false;
        }


        if((firstNameTxtFld.getText().length() < 2 || firstNameTxtFld.getText().length() > 20) && firstNameValid){
            firstNameErrorLbl.setTextFill(red);
            firstNameErrorLbl.setText("First name has to be at least 2 and at most 20 characters");
        }
        if((lastNameTxtFld.getText().length() < 2 || lastNameTxtFld.getText().length() > 20) && lastNameValid){
            lastNameErrorLbl.setTextFill(red);
            lastNameErrorLbl.setText("Last name has to be at least 2 and at most 20 characters");
        }

        if(idValid && pcnValid && firstNameValid && lastNameValid){
            int id;
            int pcn;
            String firstName = firstNameTxtFld.getText();
            String lastName = lastNameTxtFld.getText();

            try{
                id = Integer.parseInt(idTxtFld.getText());
                pcn = Integer.parseInt(PCNTxtFld.getText());
            }catch(NumberFormatException ex){
                SuccessLabel.setTextFill(red);
                SuccessLabel.setText("Something went wrong, please make sure all fields are correct");
                return;
            }

            SuccessLabel.setTextFill(green);
            SuccessLabel.setText("congratulations, everything is filled in correctly.");
            Student student = new Student(id, pcn, firstName, lastName);
            System.out.println(student.toString());
        }
    }



}
