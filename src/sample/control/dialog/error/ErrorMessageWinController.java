package sample.control.dialog.error;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErrorMessageWinController {
    @FXML
    private Button acceptButton;

    @FXML
    public void pressAccept() {
        Stage stage = (Stage) acceptButton.getScene().getWindow();
        stage.close();
    }
}
