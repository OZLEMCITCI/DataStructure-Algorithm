package homework;

import java.lang.Math;

public class LoanCalculator {

    //Original Codes

//    public static double calculateLoanPayment(double loanAmount, double interestRate, double term) {
//        double interestRateMonthly = interestRate / 12;
//        double numPayments = term * 12;
//        return loanAmount * (interestRateMonthly / (1 - Math.pow(1 + interestRateMonthly, -numPayments)));
//    }

    //Corrected Codes
    public static double calculateLoanPayment(double loanAmount, double interestRate, double term) {
        if (loanAmount < 0 || interestRate < 0 || interestRate > 1 || term < 0 || term > 45) {
            throw new IllegalArgumentException("Loan amount must be non-negative, interest rate must be between 0 and 1, " +
                    "and term must be between 0 and 45.");
        } else if (term == 0) {
            return loanAmount;
        } else if (interestRate == 0) {
            return loanAmount / (term * 12);
        } else {
            double interestRateMonthly = interestRate / 12;
            double numPayments = term * 12;
            return loanAmount * (interestRateMonthly / (1 - Math.pow(1 + interestRateMonthly, -numPayments)));
        }
    }




   //Original Codes
//    public static double calculateInterest(double loanAmount, double interestRate, double term) {
//        return loanAmount * interestRate * term;
//    }

    //Corrected Codes
    public static double calculateInterest(double loanAmount, double interestRate, double term) {
        if (loanAmount < 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }

        if (interestRate < 0 || interestRate > 1) {
            throw new IllegalArgumentException("Interest rate must be a decimal value greater than zero and less than or equal to one.");
        }

        if (term < 0 || term > 45) {
            throw new IllegalArgumentException("Loan term must be a positive integer less than or equal to 30.");
        }

        // Calculate the total interest rate by multiplying the loan amount, interest rate, and loan term
        double totalInterest = loanAmount * interestRate * term;

        return totalInterest;
    }

//original codes
//    public static double calculateLoanBalance(double loanAmount, double interestRate, double term, double payment) {
//        double interestRateMonthly = interestRate / 12;
//        double numPayments = term * 12;
//        double balance = loanAmount;
//        for (int i = 0; i < numPayments; i++) {
//            double interest = balance * interestRateMonthly;
//            balance += interest - payment;
//
//        }
//        return balance;
//    }

    //corrected codes
    public static double calculateLoanBalance(double loanAmount, double interestRate, double term, double payment) {
        double interestRateMonthly = interestRate / 12;
        double numPayments = term * 12;
        double balance = loanAmount;
        for (int i = 0; i < numPayments; i++) {
            double interest = balance * interestRateMonthly;
            balance += interest - payment;
            if (balance <= 0) {
                return 0;
            }

        }
        return balance;
    }
   // original codes
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
        double loanAmount = 120000;
        double interestRate = 0.05;
        double term = 30;
        double payment = calculateLoanPayment(loanAmount, interestRate, term);
        System.out.println("Loan payment: " + payment);
        System.out.println("Total interest: " + calculateInterest(loanAmount, interestRate, term));
        System.out.println("Loan balance: " + calculateLoanBalance(loanAmount, interestRate, 20, payment));
        System.out.println("Loan term: " + calculateLoanTerm(loanAmount, interestRate, payment));
    }
}

