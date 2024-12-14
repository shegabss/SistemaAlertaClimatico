package com.example.sistemaalertasclimaticos;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField cidadeField;
    @FXML
    private Button enviarButton;

    @FXML
    private void handleEnviar() {
        String cidade = cidadeField.getText();
        if (cidade.isEmpty()) {
            showAlert("Erro", "Campo cidade não pode ser vazio.");
        } else {
            // Enviar cidade para o servidor via Kafka
            // Este método seria implementado para interagir com o produtor Kafka
            showAlert("Sucesso", "Cidade " + cidade + " registrada.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}
