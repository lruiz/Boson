package org.tautua.foo;

/**
 * Created by IntelliJ IDEA.
 * User: Lruiz
 * Date: Jul 27, 2008
 * Time: 9:04:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class TaskImpl implements Task {
    private String uuid;
    private int priority;

    public TaskImpl() {
    }

    public TaskImpl(String uuid, int priority) {
        this.uuid = uuid;
        this.priority = priority;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
