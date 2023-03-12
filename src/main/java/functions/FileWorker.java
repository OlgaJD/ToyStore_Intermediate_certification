package functions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.io.FileWriter;

public class FileWorker {
    private String dataFile = "distributed_prize.txt";


    public void saveData() {
        DateFormat dateFormat = new SimpleDateFormat("d.MM.yyyyг., HH:mm");
        String date = dateFormat.format(new Date());
        SystemFunction systemWork = new SystemFunction();
        try (FileWriter writer  = new FileWriter(dataFile, true)) {
            writer.append((systemWork.getDataSave()) + ". " + "Выдан: " + date + "\n");
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}