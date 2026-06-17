import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Task {
    private int id;
    private String desc;
    private String status;
    private String date;

    public Task(int id, String desc, String status, String date) {
        this.id =id;
        this.desc = desc;
        this.status = status;
        this.date = date;
    }

    public void setId(int newId){
        id = newId;
    }
    public void setDesc(String newDesc){
        desc = newDesc;
    }
    public void setStatus(String newStatus){
        status = newStatus;
    }
    public void setDate(String newDate){
        date = newDate;
    }

    public int getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
    public String getStatus() {
        return status;
    }
    public String getDate() {
        return date;
    }
}