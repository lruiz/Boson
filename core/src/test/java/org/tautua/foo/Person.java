package org.tautua.foo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Larry Ruiz
 */
public class Person {
    private String lastName;
    private String firstName;
    private int age;
    private List<String> roles = new ArrayList();
    private Task currentTask;
    private Task[] tasksQueue;
    private Status status = Status.OK;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setTasksQueue(Task[] tasksQueue) {
        this.tasksQueue = tasksQueue;
    }

    public List<Task> getTasksQueue() {
        return Arrays.asList(tasksQueue);
    }

    public void setCurrentTask(Task currentTask) {
        this.currentTask = currentTask;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void addRole(String role){
        roles.add(role);
    }
}
