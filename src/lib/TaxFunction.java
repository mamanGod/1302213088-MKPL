package lib;

public class TaxFunction {

    private static final int MAX_CHILDREN_COUNT = 3;
    private static final int MIN_MONTHLY_SALARY = 54000000;
    private static final int MIN_ADDITIONAL_DEDUCTION = 4500000;
    private static final int CHILD_DEDUCTION = 1500000;

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthsWorked, int deductible, boolean isMarried, int childrenCount) {
        int totalIncome = (monthlySalary + otherMonthlyIncome) * monthsWorked;
        int totalDeduction = deductible + MIN_MONTHLY_SALARY;

        if (monthsWorked > 12) {
            System.err.println("More than 12 months working per year");
            monthsWorked = 12;
        }

        totalDeduction += isMarried ? MIN_ADDITIONAL_DEDUCTION : 0;
        totalDeduction += Math.min(childrenCount, MAX_CHILDREN_COUNT) * CHILD_DEDUCTION;

        int taxableIncome = totalIncome - totalDeduction;
        int tax = (int) Math.round(0.05 * taxableIncome);

        return Math.max(tax, 0);
    }
}
