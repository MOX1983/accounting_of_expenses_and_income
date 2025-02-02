package com.example.finance;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import static com.example.finance.WriteDate.writeDateCSV;

public class HelloController {

    String file = "src/main/java/com/example/finance/Expenses.csv";
    String IncomeFile = "src/main/java/com/example/finance/Income.csv";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonExpenses;

    @FXML
    private Button ButtonIncome;

    ObservableList<String> langs = FXCollections.observableArrayList("Продукты", "Здоровье", "Гигиена", "Транспорт", "Другое");
    @FXML
    private ChoiceBox<String> category_expenses;

    ObservableList<String> list = FXCollections.observableArrayList("Зарплата", "Стипендия", "Подарок", "Другое");
    @FXML
    private ChoiceBox<String> categoryIncome;

    @FXML
    private TableView<String> tableExpenses;

    @FXML
    private TableView<String> tableIncome;

    @FXML
    private TableColumn<?, ?> addmon_income_tabl;

    @FXML
    private TableColumn<?, ?> category_expenses_tabl;

    @FXML
    private TableColumn<?, ?> category_income_tabl;

    @FXML
    private TableColumn<?, ?> mon_income_tabl;

    @FXML
    private TextField textExpenses;

    @FXML
    private TextField textIncome;

    @FXML
    private PieChart E;

    @FXML
    private PieChart I;

    @FXML
    void initialize() {
        category_expenses.setItems(langs);
        ButtonExpenses.setOnAction(event -> {
            writeDateCSV(file, category_expenses.getValue(), textExpenses.getText());
        });
        categoryIncome.setItems(list);
        ButtonIncome.setOnAction(event -> {
            writeDateCSV(IncomeFile, categoryIncome.getValue(), textIncome.getText());
        });
    }

}
