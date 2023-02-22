package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateInterestTest {
    @Test
    public void calculateInterest_with_negative_inputs() {
        double loanAmount = -5000;
        double interestRate = -0.1;
        double term = -5;

        assertThrows(IllegalArgumentException.class, () -> {
            LoanCalculator.calculateInterest(loanAmount, interestRate, term);
        });
    }

    @Test
    public void calculateInterest_with_bigger_than_given_interestRate_and_term() {
        double loanAmount = 50000;
        double interestRate = 1.5;
        double term = 46;

        assertThrows(IllegalArgumentException.class, () -> {
            LoanCalculator.calculateInterest(loanAmount, interestRate, term);
        });
    }
    @Test
    public void calculateInterest_when_interest_rate_is_zero() {
        double loanAmount = 12000;
        double interestRate = 0;
        double term = 20;

        double expected = 0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);

        assertEquals(expected, actual );
    }

    @Test
    public void calculateInterest_when_loan_amount_is_zero() {
        double loanAmount = 0;
        double interestRate = 0.05;
        double term = 16;

        double expected = 0.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void calculateInterest_when_term_is_zero() {
        double loanAmount = 400000;
        double interestRate = 0.04;
        double term = 0;

        double expected = 0.0;
        double actual =LoanCalculator.calculateInterest(loanAmount, interestRate, term);

        assertEquals(expected, actual);
    }


    @Test
    public void calculateInterest_when_valid_values_entered_test1() {
        double loanAmount = 5000;
        double interestRate = 0.2;
        double term = 10;

        double expected = 10000.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateInterest_when_valid_values_entered_test2() {
        double loanAmount = 20000;
        double interestRate = 0.08;
        double term = 20;

        double expected = 32000.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateInterest_when_valid_values_entered_test3() {
        double loanAmount = 200000;
        double interestRate = 0.05;
        double term = 5;

        double expected = 50000.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void calculateInterest_when_valid_values_entered_test4() {
        double loanAmount = 800000;
        double interestRate = 0.23;
        double term = 18;

        double expected = 3312000.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);

        assertEquals(expected, actual);
    }

    @Test
    public void calculateInterest_when_valid_values_entered_test6() {
        double loanAmount = 1000000;
        double interestRate = 0.02;
        double term = 45;
        double expected = 900000.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateInterest_when_valid_values_entered_test7() {
        double loanAmount = 100000;
        double interestRate = 0.09;
        double term = 5;
        double expected = 45000.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateInterest_when_valid_values_entered_test8() {
        double loanAmount = 500000;
        double interestRate = 0.06;
        double term = 30;
        double expected = 900000.0;
        double actual = LoanCalculator.calculateInterest(loanAmount, interestRate, term);
        assertEquals(expected, actual);
    }

}
