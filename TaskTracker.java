import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

public class TaskTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("book.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Task task = new Task(Integer.valueOf(values[0]), values[1] ,values[2], values[3]);
                tasks.add(task);
            }
        }
        catch (Exception e){}
        System.out.println("Choose one option:\n1: view list\n2: add to list\n3: remove item from list\n4: edit existing item\n5: quit");
        String option = scanner.nextLine();
        switch(option) {
            case "1":
                viewList(tasks);
                break;
            case "2":
                System.out.println("enter description: ");
                String desc = scanner.nextLine();
                System.out.println("enter status: ");
                String status = scanner.nextLine();
                addToList(tasks, desc, status);
                break;
            case "3":
                removeFromList(tasks);
                break;
            case "4":
                editItem(tasks);
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("invalid option please try again.");
                break;
        }
    }

    public static void viewList(List<Task> tasks) {
        for(Task task : tasks) {
            System.out.println(task.getId() + " | " + task.getDesc() + " | " + task.getStatus() + " | " + task.getDate());
        }
    }
    public static Task addToList(List<Task> tasks, String desc, String status) {
        return new Task(tasks.size() + 1, desc, status, LocalDate.now().toString());
    }
    public static void removeFromList(List<Task> tasks) {
        
    }
    public static void editItem(List<Task> tasks) {
        
    }
}