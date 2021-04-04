package sample.util;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogService {
    public void callWindow(String path, String titleText) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(path));

        stage.setScene(new Scene(root));
        stage.setTitle(titleText);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(PrimaryFields.getMainStage());
        stage.showAndWait();
    }
}
