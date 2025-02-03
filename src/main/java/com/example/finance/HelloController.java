package com.example.finance;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.example.finance.ReadDate.readDateCSV;
import static com.example.finance.WriteDate.writeDateCSV;

public class HelloController {

    String file = "src/main/java/com/example/finance/Expenses.csv";
    String IncomeFile = "src/main/java/com/example/finance/Income.csv";

    String sumMoney(String f){
        Double sum = 0.0;
        for(Categor c: readDateCSV(f)){
            sum += c.getMoney();
        }
        return "" + sum;
    }

    @FXML
    private Label eLable;

    @FXML
    private Label iLable;

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

    ObservableList<Categor> listExpenses = FXCollections.observableArrayList(readDateCSV(file));
    ObservableList<Categor> listIncome = FXCollections.observableArrayList(readDateCSV(IncomeFile));

    @FXML
    private TableView<Categor> tableExpenses;

    @FXML
    private TableView<Categor> tableIncome;

    @FXML
    private TableColumn<Categor, Double> addmon_income_tabl;

    @FXML
    private TableColumn<Categor, String> category_expenses_tabl;

    @FXML
    private TableColumn<Categor, String> category_income_tabl;

    @FXML
    private TableColumn<Categor, Double> mon_income_tabl;

    @FXML
    private TextField textExpenses;

    @FXML
    private TextField textIncome;

    ObservableList<PieChart.Data> eDatePieChart = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> iDatePieChart = FXCollections.observableArrayList();

    void setDateE(){
        for(Categor c : readDateCSV(file)){
            eDatePieChart.add(new PieChart.Data(c.getName(), c.getMoney()));
        }
    }

    void setDateI(){
        for(Categor c : readDateCSV(IncomeFile)){
            iDatePieChart.add(new PieChart.Data(c.getName(), c.getMoney()));
        }
    }


    @FXML
    private PieChart E;

    @FXML
    private PieChart I;

    ObservableList<Categor> refreshE(){
        listExpenses.clear();
        listExpenses = FXCollections.observableArrayList(readDateCSV(file));
        return listExpenses;
    }
    ObservableList<Categor> refreshI(){
        listIncome.clear();
        listIncome = FXCollections.observableArrayList(readDateCSV(IncomeFile));
        return listIncome;
    }

    @FXML
    void initialize() {

        eLable.setText(sumMoney(file));
        iLable.setText(sumMoney(IncomeFile));

        category_expenses.setItems(langs);
        ButtonExpenses.setOnAction(event -> {
            writeDateCSV(file, new Categor(category_expenses.getValue(), Double.parseDouble(textExpenses.getText())));
            tableExpenses.setItems(refreshE());
        });

        categoryIncome.setItems(list);
        ButtonIncome.setOnAction(event -> {
            writeDateCSV(IncomeFile, new Categor(categoryIncome.getValue(), Double.parseDouble(textIncome.getText())));
            tableIncome.setItems(refreshI());
        });

        category_expenses_tabl.setCellValueFactory(new PropertyValueFactory<Categor, String>("name"));
        mon_income_tabl.setCellValueFactory(new PropertyValueFactory<Categor, Double>("money"));
        tableExpenses.setItems(listExpenses);

        category_income_tabl.setCellValueFactory(new PropertyValueFactory<Categor, String>("name"));
        addmon_income_tabl.setCellValueFactory(new PropertyValueFactory<Categor, Double>("money"));
        tableIncome.setItems(listIncome);

        setDateE();
        E.setData(eDatePieChart);

        setDateI();
        I.setData(iDatePieChart);
    }

}
