package com.example.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    @DisplayName("1. 문자가 비어있거나 null값이면 0 반환")
    public void add_null_or_empty() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    @DisplayName("2. 하나의 수 입력되면 그 수 반환")
    public void add_one_num() {
        assertEquals(3, cal.add("3"));
    }

    @Test
    @DisplayName("3. 쉼표(,)로 구분된 수의 합 반환")
    public void add_comma() {
        assertEquals(3, cal.add("1,2"));
        assertEquals(3, cal.add("3"));
    }

    @Test
    @DisplayName("4. 쉼표(,), 콜론(:)으로 구분된 수의 합 반환")
    public void add_comma_or_colon() {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    @DisplayName("5. 커스텀 구분자로 구분한 수의 합 반환")
    public void add_custom() {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @org.junit.Test(expected = RuntimeException.class)
    @DisplayName("6. 음수인 경우 예외 발생")
    public void add_negative() throws Exception{
        cal.add("-2,-1,3");
    }
}