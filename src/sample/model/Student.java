package sample.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Student {
    private StringProperty fullName;
    private FloatProperty totalProgress;
    private ObservableList<Rating> ratings;


    public Student(String fullName, float totalProgress) {
        this.fullName = new SimpleStringProperty(fullName);
        this.totalProgress = new SimpleFloatProperty(totalProgress);
        this.ratings = FXCollections.observableArrayList();
    }

    public void updateTotalProgress() {
        float result = 0;
        for (Rating item : ratings) {
            result += item.getRating() * item.getTask().getTaskCoefficient() / 100;
        }
        totalProgress = new SimpleFloatProperty(result);
    }


    public Student(String fullName) {
        this(fullName, 0);
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public float getTotalProgress() {
        return totalProgress.get();
    }

    public FloatProperty totalProgressProperty() {
        return totalProgress;
    }

    public ObservableList<Rating> getRatings() {
        return ratings;
    }
}
