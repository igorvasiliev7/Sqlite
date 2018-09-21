package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import server.dao.factory.DaoFactory;
import server.model.Todo;
import server.model.User;


import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class TodoController implements Initializable{

    @FXML
    private TextField txtTodoName;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtDeadline;
    @FXML
    private TextField txtEmail;
    @FXML
    private CheckBox cheTodo;
    @FXML
    private CheckBox cheUser;
    @FXML
    private Button btnAdd;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnAdd.setOnAction(event -> {
            try {
                Add();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    private void Add() throws ParseException {

        if(cheTodo.isSelected()){
            Todo todo = new Todo();
            todo.setName(txtTodoName.getText());
            todo.setDate((new SimpleDateFormat("dd.mm.yyyy").parse(txtDeadline.getText())));
            try {
                DaoFactory.todoDaoImpl().save(todo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(cheUser.isSelected()){
            User user = new User();
            user.setName(txtUserName.getText());
            user.setEmail(txtEmail.getText());
            try {
                DaoFactory.userDaoImpl().save(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
