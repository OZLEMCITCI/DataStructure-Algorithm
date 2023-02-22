package homework;

import java.lang.Math;

public class LoanCalculator {
    public static double calculateLoanPayment(double loanAmount, double interestRate, double term) {
        double interestRateMonthly = interestRate / 12;
        double numPayments = term * 12;
        return loanAmount * (interestRateMonthly / (1 - Math.pow(1 + interestRateMonthly, -numPayments)));
    }

    public static double calculateInterest(double loanAmount, double interestRate, double term) {
        return loanAmount * interestRate * term;
    }

    public static double calculateLoanBalance(double loanAmount, double interestRate, double term, double payment) {
        double interestRateMonthly = interestRate / 12;
        double numPayments = term * 12;
        double balance = loanAmount;
        for (int i = 0; i < numPayments; i++) {
            double interest = balance * interestRateMonthly;
            balance += interest - payment;
            if (balance < 0.01) {
                balance = 0;
                break;
            }
        }
        return balance;
    }

    public static int calculateLoanTerm(double loanAmount, double interestRate, double payment) {
        double interestRateMonthly = interestRate / 12;
        double balance = loanAmount;
        int term = 0;
        while (balance > 0) {
            double interest = balance * interestRateMonthly;
            balance += interest - payment;
            term += 1;
        }
        return term;
    }

    public static void main(String[] args) {
        double loanAmount = 5000;
        double interestRate = 0.2;
        double term = 10;
        double payment = calculateLoanPayment(loanAmount, interestRate, term);
        System.out.println("Loan payment: " + payment);
        System.out.println("Total interest: " + calculateInterest(loanAmount, interestRate, term));
        System.out.println("Loan balance: " + calculateLoanBalance(loanAmount, interestRate, 30, payment));
        System.out.println("Loan term: " + calculateLoanTerm(loanAmount, interestRate, payment));
    }
}

