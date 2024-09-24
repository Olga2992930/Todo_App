package task;

import java.util.Date;

public class Task {
    public String title;
    public String description;
    public boolean completed = false;

    // Tid / schemalägg task
    public Date deadline;
    public String time;
    public TaskType type;

    public Priority priority;

    public String label;

    @Override
    public String toString() {
        String s = "Titel: " + title;
        s += "\n";
        s += "Beskrivning: " + description;
        s += "\n";
        //s += "Typ: " + type.name();
        return s;
    }
}
