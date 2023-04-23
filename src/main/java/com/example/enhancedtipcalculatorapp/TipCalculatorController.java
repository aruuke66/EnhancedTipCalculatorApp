//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.enhancedtipcalculatorapp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);
    @FXML
    private TextField amountTextField;
    @FXML
    private TextField numberOfPeopleTextField;
    @FXML
    private Label tipPercentageLabel;
    @FXML
    private Slider tipPercentageSlider;
    @FXML
    private TextField tipTextField;
    @FXML
    private TextField totalTextField;
    @FXML
    private TextField perPersonTextField;

    public TipCalculatorController() {
    }

    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try {
            BigDecimal amount = new BigDecimal(this.amountTextField.getText());
            BigDecimal number = new BigDecimal(this.numberOfPeopleTextField.getText());
            BigDecimal tip = amount.multiply(this.tipPercentage);
            BigDecimal total = amount.add(tip);
            BigDecimal perPeop = total.divide(number);
            this.tipTextField.setText(currency.format(tip));
            this.totalTextField.setText(currency.format(total));
            this.perPersonTextField.setText(currency.format(perPeop));
        } catch (NumberFormatException var7) {
            this.amountTextField.setText("Enter amount");
            this.amountTextField.selectAll();
            this.amountTextField.requestFocus();
            this.numberOfPeopleTextField.setText("Enter amount");
            this.numberOfPeopleTextField.selectAll();
            this.numberOfPeopleTextField.requestFocus();
        }

    }

    public void initialize() {
        currency.setRoundingMode(RoundingMode.HALF_UP);
        this.tipPercentageSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                TipCalculatorController.this.tipPercentage = BigDecimal.valueOf((double)newValue.intValue() / 100.0);
                TipCalculatorController.this.tipPercentageLabel.setText(TipCalculatorController.percent.format(TipCalculatorController.this.tipPercentage));
            }
        });
    }
}
