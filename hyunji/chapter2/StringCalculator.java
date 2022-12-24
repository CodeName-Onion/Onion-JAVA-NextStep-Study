package chapter2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String s){
        if(isBlank(s)) return 0;

        return sum(toInts(getSplit(s)));
    }
    private static boolean isBlank(String s) { //문자열이 빈 문자열 or null인지 확인
        return s == null || s.isEmpty();
    }

    private static String[] getSplit(String s) { //문자열을 특정 문자로 나누어 반환
        //커스텀 구분자 정규 표현식
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if(m.find()){
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }
        //커스텀 구분자가 없을 경우, 숨표 또는 콜론으로 나누기
        return s.split(",|:");
    }

    private int[] toInts(String[] values){ //문자열 배열을 숫자 배열로 변환하여 반환
        int[] numbers = new int[values.length];
        for(int i=0; i<numbers.length; i++){
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String value) { //음수일 경우 예외처리, 양수면 반환
        int number = Integer.parseInt(value);
        if(number < 0) throw new RuntimeException();
        return number;
    }

    private static int sum(int[] values) { //숫자 배열의 합을 반환
        int sum =0;
        for(int value : values){
            sum+=value;
        }
        return sum;
    }
}
