import java.util.Scanner;

public class Main {
    YearReport report21 = new YearReport("resources/y.2021.csv");
    MonthlyReport report21m01 = new MonthlyReport("resources/m.202101.csv");
    MonthlyReport report21m02 = new MonthlyReport("resources/m.202102.csv");
    MonthlyReport report21m03 = new MonthlyReport("resources/m.202103.csv");
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                YearReport report21 = new YearReport("resources/y.2021.csv");
            } else if (command == 2) {

            } else if (command == 3) {
                if(!(new Main().read())) {
                    new Main().reconciliationOfReports();
                } else System.out.println("Считайте сначала отчеты");
            } else if (command == 4) {
                if (!(new Main().read())) {
                    new Main().print01();
                    new Main().print02();
                    new Main().print03();
                } else System.out.println("Считайте сначала отчеты");
            } else if (command == 5) {
                if (!(new Main().read())) {
                    new Main().printAll2021();
                } else System.out.println("Считайте сначала отчеты");
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
                    if (report21.records.get(i).amount == report21m01.sumExpense()) {
                        System.out.println("Сверка расходов за январь месяц прошла успешно");
                    } else System.out.println("Сверка расходов за январь месяц не прошла");
                }
                if (report21.records.get(i).month == 2) {
                    if (report21.records.get(i).amount == report21m02.sumExpense()) {
                        System.out.println("Сверка расходов за февраль месяц прошла успешно");
                    } else System.out.println("Сверка расходов за февраль месяц не прошла");
                }
                if (report21.records.get(i).month == 3) {
                    if (report21.records.get(i).amount == report21m03.sumExpense()) {
                        System.out.println("Сверка расходов за март месяц прошла успешно");
                    } else System.out.println("Сверка расходов за март месяц не прошла");
                }
            } else {
                if (report21.records.get(i).month == 1) {
                    if (report21.records.get(i).amount == report21m01.sumNonExpense()) {
                        System.out.println("Сверка доходов за январь месяц прошла успешно");
                    } else System.out.println("Сверка доходов за январь месяц не прошла");
                }
                if (report21.records.get(i).month == 2) {
                    if (report21.records.get(i).amount == report21m02.sumNonExpense()) {
                        System.out.println("Сверка доходов за февраль месяц прошла успешно");
                    } else System.out.println("Сверка доходов за февраль месяц не прошла");
                }
                if (report21.records.get(i).month == 3) {
                    if (report21.records.get(i).amount == report21m03.sumNonExpense()) {
                        System.out.println("Сверка доходов за март месяц прошла успешно");
                    } else System.out.println("Сверка доходов за март месяц не прошла");
                }
            }

        }
    }

    public void printAll2021() {
        System.out.println("Доходность в 2021 году:");
        System.out.println("Январь");
        report21m01.profitability();

        System.out.println("Февраль");
        report21m02.profitability();

        System.out.println("Март");
        report21m03.profitability();

        System.out.println("Средний доход в этом году составил: " + averagePlus());
        System.out.println("Средние расходы в этом году составили: " + averageMinus());

    }

    public void print01() {
        System.out.println("Январь");
        for (int i = 0; i < report21m01.records.size(); i++) {
            if (report21m01.findMax() == (report21m01.records.get(i).quantity * report21m01.records.get(i).sumOfOne)) {
                System.out.println("Самый прибыльный товар " + report21m01.records.get(i).itemName);
                System.out.println("С доходом равным " + report21m01.findMax());
            }
        }
    }

    public void print02() {
        System.out.println("Февраль");
        for (int i = 0; i < report21m02.records.size(); i++) {
            if (report21m02.findMax() == (report21m02.records.get(i).quantity * report21m02.records.get(i).sumOfOne)) {
                System.out.println("Самый прибыльный товар " + report21m02.records.get(i).itemName);
                System.out.println("С доходом равным " + report21m02.findMax());
            }
        }
    }

    public void print03() {
        System.out.println("Март");
        for (int i = 0; i < report21m03.records.size(); i++) {
            if (report21m03.findMax() == (report21m03.records.get(i).quantity * report21m03.records.get(i).sumOfOne)) {
                System.out.println("Самый прибыльный товар " + report21m03.records.get(i).itemName);
                System.out.println("С доходом равным " + report21m03.findMax());
            }
        }
    }

    int averagePlus(){
        int average = 0;
        average = (report21m01.sumNonExpense() + report21m02.sumNonExpense() + report21m03.sumNonExpense())/3;
        return average;
    }
    int averageMinus(){
        int average = 0;
        average = (report21m01.sumExpense() + report21m02.sumExpense() + report21m03.sumExpense())/3;
        return average;
    }

    boolean read(){
        boolean result = true;
        if (report21.records.isEmpty()){
            result = false;
        }
        return  result;
    }






}

