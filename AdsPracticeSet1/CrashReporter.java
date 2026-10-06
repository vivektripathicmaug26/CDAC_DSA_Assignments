class MethodStack {
    private String[] data = new String[10];
    private int top = -1;

    boolean push(String m) {
        if (top >= data.length - 1) {
            System.out.println("StackOverflowError: call depth exceeded 10");
            return false;
        }
        data[++top] = m;
        return true;
    }

    String pop() {
        if (isEmpty()) return null;
        return data[top--];
    }

    String peek() {
        if (isEmpty()) return null;
        return data[top];
    }

    boolean isEmpty() { 
        return top == -1; 
    }

    int size() { 
        return top + 1; 
    }

    void printTrace() {
        for (int i = top; i >= 0; i--) {
            System.out.println("at " + data[i]);
        }
    }
}

public class CrashReporter {
    public static void main(String[] args) {
        MethodStack stack = new MethodStack();
        stack.push("main");
        stack.push("processPayment");
        stack.push("gatewayCall");
        stack.printTrace();
    }
}
