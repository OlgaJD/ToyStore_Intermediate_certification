package functions;


import java.io.FileWriter;

public class FileWorker {
    private String dataFile = "distributed_prize.txt";


    public void saveData() {
        SystemFunction systemWork = new SystemFunction();
        try (FileWriter writer  = new FileWriter(dataFile, true)) {
            writer.append(systemWork.getDataSave());
            writer.flush();
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}