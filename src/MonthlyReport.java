import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


    public class MonthlyReport {


        public ArrayList<MonthlyLineRecord> records = new ArrayList<>();

        public MonthlyReport(String path) {
            String content = readFileContentsOrNull(path); // \n
            String[] lines = content.split("\r?\n"); //
            for (int i = 1; i < lines.length; i++) {
                String line = lines[i]; // "02,14000,true"
                String[] parts = line.split(","); // ["02", "14000", "true"]
                String itemName = parts[0]; // "02" -> 2
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);
                MonthlyLineRecord record = new MonthlyLineRecord(itemName, isExpense, quantity, sumOfOne);
                records.add(record);
            }
        }

        private String readFileContentsOrNull(String path) {
            try {
                return Files.readString(Path.of(path));
            } catch (IOException e) {
                System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
                return null;
            }
        }
        public void reconciliationOfReports() {

        }

    }


