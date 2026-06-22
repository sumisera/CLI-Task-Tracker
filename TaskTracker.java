import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public class TaskTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("List.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Task task = new Task(Integer.valueOf(values[0]), values[1] ,values[2], values[3]);
                tasks.add(task);
            }
        }
        catch (Exception e){System.out.println("Error: " + e.getMessage());}
        while (true){
        System.out.println("Choose one option:\n1: view list\n2: add to list\n3: remove item from list\n4: quit");
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
                Task task= new Task(tasks.size() + 1,desc, status,LocalDate.now().toString());
                tasks.add(task);
                addToList(task);
                break;
            case "3":
                System.out.println("enter id of item you would like to remove: ");
                int id = Integer.parseInt(scanner.nextLine().trim());
                removeFromList(tasks, id);
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("invalid option please try again.");
                break;
        }
        }
    }

    public static void viewList(List<Task> tasks) {
        for(Task task : tasks) {
            System.out.println(task.getId() + " | " + task.getDesc() + " | " + task.getStatus() + " | " + task.getDate());
        }
    }
    public static void addToList(Task task) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("List.csv", true));) {
            writer.write(task.getId() + "," + task.getDesc() + "," + task.getStatus() + "," + task.getDate());
            writer.newLine();
            writer.close();
        }
        catch (Exception e){System.out.println("Error: " + e.getMessage());}
    }
    public static void removeFromList(List<Task> tasks, int id) {
        Boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
           if(tasks.get(i).getId() == id) {
                tasks.remove(i);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Invlaid id");
            return;
        }
        //reassigns ids
        for(int i = 0; i < tasks.size(); i++) {
            tasks.get(i).setId(i+1);
        }
        // Rewrite the entire CSV to reflect the updated list
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("List.csv", false))) {
            for (Task task : tasks) {
                writer.write(task.getId() + "," + task.getDesc() + "," + task.getStatus() + "," + task.getDate());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Task " + id + " removed.");
    }
    
}