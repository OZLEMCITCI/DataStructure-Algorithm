package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateLoanBalance {
    @Test
    public void calculateLoanBalance_with_negative_inputs() {
        double loanAmount = -5000;
        double interestRate = -0.1;
        double term = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            LoanCalculator.calculateLoanBalance(loanAmount, interestRate, term,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));
        });
    }

    @Test
    public void calculateLoanBalance_with_bigger_than_given_interestRate_and_term() {
        double loanAmount = 50000;
        double interestRate = 1.5;
        double term = 46;

        assertThrows(IllegalArgumentException.class, () -> {
            LoanCalculator.calculateLoanBalance(loanAmount, interestRate, term,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));
        });
    }
    @Test
    public void calculateLoanBalance_when_interest_rate_is_zero() {
        double loanAmount = 12000;
        double interestRate = 0;
        double term = 20;

        double expected = 0.0;
        double actual = LoanCalculator.calculateLoanBalance(loanAmount, interestRate, term,LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term));

        assertEquals(expected, actual );
    }

    @Test
    public void calculateLoanBalance_when_loan_amount_is_zero() {
        double loanAmount = 0;
        double interestRate = 0.05;
        double term = 16;
        double payment=LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term);

        double expected = 0.0;
        double actual = LoanCalculator.calculateLoanBalance(loanAmount, interestRate, term,payment);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void calculateLoanBalance_when_term_is_zero() {
        double loanAmount = 400000;
        double interestRate = 0.04;
        double term = 0;
        double payment=LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term);

        double expected = 400000.0;
        double actual = LoanCalculator.calculateLoanBalance(loanAmount, interestRate, term,payment);

        assertEquals(expected, actual);
    }


    @Test
    public void calculateLoanBalance_when_valid_values_entered_test1() {
        double loanAmount = 5000;
        double interestRate = 0.2;
        double term = 10;
        double payment=LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term);

        double expected = 3647.175217463702;
        double actual = LoanCalculator.calculateLoanBalance(loanAmount, interestRate, 5,payment);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateLoanBalance_when_full_term_equals_paid_term() {
        double loanAmount = 20000;
        double interestRate = 0.08;
        double term = 20;
        double payment=LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term);

        double expected = 0.0;
        double actual = LoanCalculator.calculateLoanBalance(loanAmount, interestRate, term,payment);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void calculateLoanBalance_when_valid_values_entered_test3() {
        double loanAmount = 200000;
        double interestRate = 0.05;
        double term = 5;
        double payment=LoanCalculator.calculateLoanPayment(loanAmount,interestRate,term);

        double expected = 86029.79645003764;
        double actual = LoanCalculator.calculateLoanBalance(loanAmount, interestRate, 3,payment);

        assertEquals(expected, actual, 0.001);
    }
}
