class Calculator{
    /**
     * @deprecated Use {@link #addNumber(int, int)} instead.
     */
    @Deprecated
    public int add(int a, int b){
        return a + b;
    }

    /**
     *
     * 두 수를 더하는 메서드
     * @param a 첫 번째 정수
     * @param b 두 번째 정수
     * @return 두 수의 합
     */
    public int addNumber(int a, int b){
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(1,2));
        System.out.println(calculator.addNumber(2,4));
    }
}