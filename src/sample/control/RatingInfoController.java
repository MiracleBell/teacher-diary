package sample.control;

import control.FloatField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.model.Rating;

public class RatingInfoController {
    @FXML
    private TableView<Rating> table;
    @FXML
    private TableColumn<Rating, String> taskNameColumn;
    @FXML
    private TableColumn<Rating, Float> taskProgressColumn;
    @FXML
    private FloatField progressField;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;


    @FXML
    public void pressAccept() {
        Main.getCurrentTask().changeProgress(Float.parseFloat(progressField.getText()));
//        Main.getCurrentStudent().getRatings().remove(Main.getCurrentRating());
//        Main.getCurrentStudent().getRatings().add(new Rating(Float.parseFloat(progressField.getText())));
        pressCancel();
    }

    @FXML
    public void pressCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
