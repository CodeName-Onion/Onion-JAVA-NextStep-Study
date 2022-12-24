package chapter2Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    public void setup(){
        cal = new StringCalculator();
    }

    @Test
    public void add_null_or_empty(){
        Assertions.assertEquals(0, cal.add(""));
        Assertions.assertEquals(0, cal.add(null));
    }

    @Test
    public void add_only_one(){
        Assertions.assertEquals(1, cal.add("1"));
    }

    @Test
    public void add_comma(){
        Assertions.assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void add_comma_or_colon(){
        Assertions.assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void add_custom(){
        Assertions.assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test
    public void add_minus(){
        assertThrows(RuntimeException.class, ()->{cal.add("-1,2,3");});
    }
}