package sample.control.mainframe;

import control.FloatField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.util.PrimaryFields;

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
//        PrimarySingleFields.getCurrentRating().change(Float.parseFloat(progressField.getText()));
        Rating rating = new Rating(
                PrimaryFields.getCurrentRating().getTask(),
                Float.parseFloat(progressField.getText())
        );
        PrimaryFields.getCurrentStudent().getRatings().remove(
                PrimaryFields.getCurrentRating()
        );
        PrimaryFields.getCurrentStudent().getRatings().add(rating);
        PrimaryFields.getCurrentStudent().updateTotalProgress();

        pressCancel();
    }

    @FXML
    public void pressCancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
