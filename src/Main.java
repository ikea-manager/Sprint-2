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
        for (int i = 0; i < report21.records.size(); i++) {
            if (report21.records.get(i).Expense) {
                if (report21.records.get(i).month == 1) {
                    if (report21.records.get(i).amount == reportJan21.sumExpense()) {
                        System.out.println("Сверка расходов за январь месяц прошла успешно");
                    } else System.out.println("Сверка расходов за январь месяц не прошла");
                }
                if (report21.records.get(i).month == 2) {
                    if (report21.records.get(i).amount == reportFeb21.sumExpense()) {
                        System.out.println("Сверка расходов за февраль месяц прошла успешно");
                    } else System.out.println("Сверка расходов за февраль месяц не прошла");
                }
                if (report21.records.get(i).month == 3) {
                    if (report21.records.get(i).amount == reportMar21.sumExpense()) {
                        System.out.println("Сверка расходов за март месяц прошла успешно");
                    } else System.out.println("Сверка расходов за март месяц не прошла");
                }
            } else {
                if (report21.records.get(i).month == 1) {
                    if (report21.records.get(i).amount == reportJan21.sumNonExpense()) {
                        System.out.println("Сверка доходов за январь месяц прошла успешно");
                    } else System.out.println("Сверка доходов за январь месяц не прошла");
                }
                if (report21.records.get(i).month == 2) {
                    if (report21.records.get(i).amount == reportFeb21.sumNonExpense()) {
                        System.out.println("Сверка доходов за февраль месяц прошла успешно");
                    } else System.out.println("Сверка доходов за февраль месяц не прошла");
                }
                if (report21.records.get(i).month == 3) {
                    if (report21.records.get(i).amount == reportMar21.sumNonExpense()) {
                        System.out.println("Сверка доходов за март месяц прошла успешно");
                    } else System.out.println("Сверка доходов за март месяц не прошла");
                }
            }

        }
    }



}

