import java.util.Scanner;

public class Main {
    YearReport report21 = new YearReport("resources/y.2021.csv");
    MonthlyReport reportJan21 = new MonthlyReport("resources/m.202101.csv");
    MonthlyReport reportFeb21 = new MonthlyReport("resources/m.202102.csv");
    MonthlyReport reportMar21 = new MonthlyReport("resources/m.202103.csv");
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {

            } else if (command == 2) {

            } else if (command == 3) {
                new Main().reconciliationOfReports();
            } else if (command == 4) {

            } else if (command == 5) {

            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

    }





    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
    public void reconciliationOfReports() {
        System.out.println(reportJan21.records.get(1).sumOfOne);
    }




}

