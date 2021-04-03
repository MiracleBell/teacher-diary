package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Team {
    private StringProperty teamName;
    private ObservableList<Student> students;
    private ObservableList<Task> tasks;


    public Team(String teamName) {
        this.teamName = new SimpleStringProperty(teamName);
        this.students = FXCollections.observableArrayList();
        this.tasks = FXCollections.observableArrayList();
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Объект 'Student' не должен быть null");
        }
        students.add(student);
    }

    public Student getStudent(int index) {
        if (index < 0 || index >= students.size()) {
            throw new IndexOutOfBoundsException("По данному индексу в списке не найден объект");
        }
        return students.get(index);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        for (Student item : students) {
            for (Rating elem : item.getRatings()) {
                if (elem.getTask().equals(task)) {
                    item.getRatings().remove(elem);
                    break;
                }
            }
        }
    }

    public String getTeamName() {
        return teamName.get();
    }

    public StringProperty teamNameProperty() {
        return teamName;
    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }
}
