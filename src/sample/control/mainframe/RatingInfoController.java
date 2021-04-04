package sample.control.mainframe;

import control.FloatField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.model.Rating;
import sample.util.DialogService;
import sample.util.PrimaryFields;

import java.io.IOException;

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
    public void pressAccept() throws IOException {
        float value = Float.parseFloat(progressField.getText());
        //Проверка на корректность данных
        if (value < 0 || value > 100) {
            new DialogService().callWindow("../view/dialog/error/invalidRatingData.fxml", "Ошибка!");
            return;
        }

        //чтобы изменения отобразились сразу, пересоздается объект
        Rating rating = new Rating(
                PrimaryFields.getCurrentRating().getTask(),
                Float.parseFloat(progressField.getText())
        );
//        старый объект удаляется
        PrimaryFields.getCurrentStudent().getRatings().remove(
                PrimaryFields.getCurrentRating()
        );
        //заменяется новым
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
