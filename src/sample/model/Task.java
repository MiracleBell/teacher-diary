package sample.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {
    private StringProperty taskName;
    private StringProperty taskDescription;
    private FloatProperty taskCoefficient;
    private FloatProperty progress;


    public Task(String taskName, String taskDescription, Float taskCoefficient) {
        if (taskName == null || taskName.equals("")) {
            throw new NullPointerException("Поле 'taskName' не должно быть пустым");
        }
        if (taskDescription == null || taskDescription.equals("")) {
            throw new NullPointerException("Поле 'taskContent' не должно быть пустым");
        }
        if (taskCoefficient == null) {
            throw new NullPointerException("Поле 'taskCoefficient' не должно быть пустым");
        }
        if (taskCoefficient.compareTo(new Float(0)) <= 0) {
            throw new IllegalArgumentException("Значение 'taskCoefficient' должно быть положительным");
        }

        this.taskName = new SimpleStringProperty(taskName);
        this.taskDescription = new SimpleStringProperty(taskDescription);
        this.taskCoefficient = new SimpleFloatProperty(taskCoefficient);
        this.progress = new SimpleFloatProperty(0);
    }

    public Task(String taskName, String taskDescription, float taskCoefficient) {
        this(taskName, taskDescription, new Float(taskCoefficient));
    }

    public void changeProgress(final float rating) {
        this.progress.set(rating);
    }

    public String getTaskName() {
        return taskName.get();
    }

    public StringProperty taskNameProperty() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription.get();
    }

    public StringProperty taskDescriptionProperty() {
        return taskDescription;
    }

    public float getTaskCoefficient() {
        return taskCoefficient.get();
    }

    public FloatProperty taskCoefficientProperty() {
        return taskCoefficient;
    }

    public float getProgress() {
        return progress.get();
    }

    public FloatProperty progressProperty() {
        return progress;
    }
}
