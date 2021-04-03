package sample.control.dialog;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AddRatingController {
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;


    @FXML
    public void pressAccept() throws IOException {
        pressCancel();
    }

    @FXML
    public void pressCancel() throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
