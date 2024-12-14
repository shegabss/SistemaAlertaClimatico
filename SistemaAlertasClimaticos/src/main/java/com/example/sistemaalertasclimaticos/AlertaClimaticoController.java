package com.example.sistemaalertasclimaticos;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import com.example.model.AlertaClimatico;

public class AlertaClimaticoController {

    @FXML private ListView<String> alertaListView;
    @FXML private TextField cidadeField;
    @FXML private TextField descricaoField;
    @FXML private Button enviarAlertaButton;

    private KafkaService kafkaService;

    public AlertaClimaticoController() {
        kafkaService = new KafkaService();
    }

    @FXML
    public void initialize() {
        // Carregar alertas anteriores ou criar lógica de atualização
        carregarAlertas();

        // Configurar o botão de envio de alertas
        enviarAlertaButton.setOnAction(event -> enviarAlerta());
    }

    private void carregarAlertas() {
        // Aqui você pode carregar os alertas via Kafka ou via API REST
        alertaListView.getItems().add("Alerta de teste: Tempestade em CidadeX");
    }

    private void enviarAlerta() {
        String cidade = cidadeField.getText();
        String descricao = descricaoField.getText();

        if (cidade.isEmpty() || descricao.isEmpty()) {
            mostrarMensagemDeErro("Cidade e descrição são obrigatórios!");
            return;
        }

        // Enviar alerta para Kafka
        AlertaClimatico alerta = new AlertaClimatico(cidade, descricao);
        kafkaService.enviarAlerta(alerta);

        // Atualizar a lista de alertas
        alertaListView.getItems().add("Novo alerta: " + cidade + " - " + descricao);

        // Limpar campos de entrada
        cidadeField.clear();
        descricaoField.clear();
    }

    private void mostrarMensagemDeErro(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
