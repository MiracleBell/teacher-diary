package sample.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Student {
    private StringProperty fullName;
    private FloatProperty totalProgress;
    private ObservableList<Task> tasks;
    private ObservableList<Rating> ratings;


    public Student(String fullName, float totalProgress) {
        this.fullName = new SimpleStringProperty(fullName);
        this.totalProgress = new SimpleFloatProperty(totalProgress);
        this.tasks = FXCollections.observableArrayList();
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

    public ObservableList<Task> getTasks() {
        return tasks;
    }
}
