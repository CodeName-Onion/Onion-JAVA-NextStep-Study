package com.example.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String s) {
        if (isBlank(s)) {//입력값이 없는 경우
            return 0;
        }
        return sum(toInts(split(s)));
    }

    private boolean isBlank(String s) {//입력값이 없거나 null인 경우
        return s == null || s.isEmpty();
    } //빈 문자열이 전달될 경우 판별

    private String[] split(String s) {//구분자에 따라 문자열 나누어 주기
        //커스텀 구분자
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        //커스텀 구분자 없을 경우 쉼표/콜론으로 나누기
        return s.split(",|:");
    }

    private int[] toInts(String[] values) {//문자열 배열을 정수 배열로 변환
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {//음수인 경우 예외
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수가 입력됨");
        }
        return number;
    }

    private int sum(int[] numbers) {//입력된 배열의 수를 모두 더해줌
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
