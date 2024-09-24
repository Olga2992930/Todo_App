package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import main.Main;
import task.Task;

public class ListCommand {
    public Main main;

    public ListCommand(Main main) {
        this.main = main;
    }

    public void run(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (String name : main.taskManager.getTaskNames()) {
            Task task = main.taskManager.getTask(name);
            tasks.add(task);
        }

        Map<String, List<Task>> grouped = sortAndGroupByLabel(tasks);
        for (Entry<String, List<Task>> entry : grouped.entrySet()) {
            System.out.println("Label: " + entry.getKey());
            for (Task task : entry.getValue()) {
                System.out.println(" - " + task.title);
            }
        }
    }

    public static Map<String, List<Task>> sortAndGroupByLabel(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> task.label != null && !task.label.isEmpty())
                .collect(Collectors.groupingBy(
                        task -> task.label,
                        Collectors.toList()));
    }
}
