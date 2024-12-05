import java.io.IOException;

// Пользовательское исключение
class MyAppException extends Exception {
    public MyAppException(String message, Throwable cause) {
        super(message, cause);
    }
}

class ExceptionHandling {
    public static void method1() {
        System.out.println(1 / 0); // Деление на ноль
    }

    public static void method2() {
        throw new NullPointerException("nulls everywhere!");
    }

    public static void method3() throws IOException {
        throw new IOException("File not found");
    }

    public static void main(String[] args) {
        try {
            handleMethods();
        } catch (MyAppException e) {
            e.printStackTrace();
        }
    }

    public static void handleMethods() throws MyAppException {
        try {
            method1();
        } catch (ArithmeticException e) {
            throw new MyAppException("Caught ArithmeticException", e);
        }

        try {
            method2();
        } catch (NullPointerException e) {
            throw new MyAppException("Caught NullPointerException", e);
        }

        try {
            method3();
        } catch (IOException e) {
            throw new MyAppException("Caught IOException", e);
        }
    }
}
