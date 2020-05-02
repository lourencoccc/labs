package lab;

import java.util.Date;

/**
 * Created by joaolourenco on 05/03/15.
 */
public class JTask {
    private String name;
    private int priority;
    private Date startDate;
    private Date endDate;

    public JTask() {}

    public JTask(String name, int priority, Date startDate, Date endDate) {
        this.name = name;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JTask jTask = (JTask) o;

        if (priority != jTask.priority) return false;
        if (endDate != null ? !endDate.equals(jTask.endDate) : jTask.endDate != null) return false;
        if (name != null ? !name.equals(jTask.name) : jTask.name != null) return false;
        if (startDate != null ? !startDate.equals(jTask.startDate) : jTask.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + priority;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JTask{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
