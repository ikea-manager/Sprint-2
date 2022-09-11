public class Main {

    public static void main(String[] args) {
        YearReport report = new YearReport("resources/y.2021.csv");
        MonthlyReport report01 = new MonthlyReport("resources/m.202101.csv");
        MonthlyReport report02 = new MonthlyReport("resources/m.202102.csv");
        MonthlyReport report03 = new MonthlyReport("resources/m.202103.csv");
        System.out.println(report01);

    }

}

