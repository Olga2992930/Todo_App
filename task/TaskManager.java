package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class TaskManager {
    File folder;
    // TODO: Spara priorities till fil
    // TODO: Lägg in detta i en egen klass: PriorityManager
    public ArrayList<Priority> priorities = new ArrayList<>();

    public TaskManager() {
        folder = new File("./tasks/");
        folder.mkdirs();

        priorities.add(new Priority("superviktigt"));
        priorities.add(new Priority("oviktigt"));
    }

    public void save(Task task) throws Exception {
        File file = new File(folder, "task-" + task.title + ".txt");
        if (!file.exists())
            file.createNewFile();

        FileWriter writer = new FileWriter(file);

        // TODO: Spara all information (label, dates etc)
        writer.append(task.title + "\n");
        writer.append(task.description + "\n");
        writer.append(task.completed + "\n");
        writer.append(task.label + "\n");

        writer.flush();
        writer.close();
    }

    public void remove(Task task) {
        File file = new File(folder, "task-" + task.title + ".txt");
        file.delete();
    }

    public void markCompleted(Task task) throws Exception {
        task.completed = true;
        save(task);
    }

    public ArrayList<String> getTaskNames() {
        String[] fileNames = folder.list();
        ArrayList<String> taskNames = new ArrayList<>();
        for (String fileName : fileNames) {
            String lastPart = fileName.substring("task-".length());
            String taskName = lastPart.substring(0, lastPart.length() - ".txt".length());

            taskNames.add(taskName);
        }

        return taskNames;
    }

    public Task getTask(String taskName) {
        File file = new File(folder, "task-" + taskName + ".txt");
        if (!file.exists()) {
            return null;
        }

        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffered = new BufferedReader(reader);
            
            Task task = new Task();
            // TODO: Läs all information (label, dates etc)
            task.title = buffered.readLine();
            task.description = buffered.readLine();
            task.completed = buffered.readLine().equals("true");
            task.label = buffered.readLine();

            buffered.close();

            return task;
        } catch (Exception e) {
            return null;
        }
    }
}