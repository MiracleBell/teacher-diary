package sample.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class Rating {
    private Task task;
    private FloatProperty rating;

    public Rating(Task task, float rating) {
        if (task == null) {
            throw new NullPointerException("task не может указывать на null");
        }
        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException("Рейтинг не может выходить за диапазон от 0 до 100");
        }
        this.task = task;
        this.rating = new SimpleFloatProperty(rating);
    }

    public Rating(Task task) {
        this(task, 0);
    }

    public Rating(float rating) {
        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException("Рейтинг не может выходить за диапазон от 0 до 100");
        }
        this.rating = new SimpleFloatProperty(rating);

    }

    public float getRating() {
        return rating.get();
    }

    public FloatProperty ratingProperty() {
        return rating;
    }

    public Task getTask() {
        return task;
    }

    public void change(float newRating) {
        if (newRating < 0 || newRating > 100) {
            throw new IllegalArgumentException("Рейтинг не может выходить за диапазон от 0 до 100");
        }
        rating = new SimpleFloatProperty(newRating);
    }
}
