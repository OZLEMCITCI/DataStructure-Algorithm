package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateLoanTerm {
    @Test
    public void calculateLoanBalance_with_negative_inputs() {
        double loanAmount = -5000;
        double interestRate = -0.1;
        double term = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            LoanCalculator.calculateLoanTerm(loanAmount, interestRate,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));
        });
    }

    @Test
    public void calculateLoanBalance_with_bigger_than_given_interestRate_and_term() {
        double loanAmount = 50000;
        double interestRate = 1.5;
        double term = 46;

        assertThrows(IllegalArgumentException.class, () -> {
            LoanCalculator.calculateLoanTerm(loanAmount, interestRate,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));
        });
    }
    @Test
    public void calculateLoanBalance_when_interest_rate_is_zero() {
        double loanAmount = 12000;
        double interestRate = 0;
        double term = 20;

        double expected = 240;
        double actual = LoanCalculator.calculateLoanTerm(loanAmount, interestRate,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));

        assertEquals(expected, actual );
    }

    @Test
    public void calculateLoanBalance_when_loan_amount_is_zero() {
        double loanAmount = 0;
        double interestRate = 0.05;
        double term = 16;

        double expected = 0.0;
        double actual = LoanCalculator.calculateLoanTerm(loanAmount, interestRate,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));

        assertEquals(expected, actual, 0.001);
    }



    @Test
    public void calculateLoanBalance_when_valid_values_entered_test1() {
        double loanAmount = 5000;
        double interestRate = 0.2;
        double term = 10;
        double expected = 120;
        double actual = LoanCalculator.calculateLoanTerm(loanAmount, interestRate,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));

        assertEquals(expected, actual);
    }

    @Test
    public void calculateLoanBalance_when_full_term_equals_paid_term() {
        double loanAmount = 20000;
        double interestRate = 0.08;
        double term = 20;

        double expected = 240;
        double actual = LoanCalculator.calculateLoanTerm(loanAmount, interestRate,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));

        assertEquals(expected, actual);
    }

    @Test
    public void calculateLoanBalance_when_valid_values_entered_test3() {
        double loanAmount = 200000;
        double interestRate = 0.05;
        double term = 5;


        double expected = 60;
        double actual =LoanCalculator.calculateLoanTerm(loanAmount, interestRate,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));

        assertEquals(expected, actual);
    }
}
