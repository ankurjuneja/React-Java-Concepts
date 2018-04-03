**Evaluate Post fix expression**
```
    public int evalPostFixExp(String expr) {
        if(expr.equals(""))
            return 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c))
                stack.push(c-'0');
            else if(isOp(c)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(execOp(c,a,b));
            } else
                throw new IllegalArgumentException("Invalid input");
        }
        return stack.pop();
    }

    private int execOp(char op, int a, int b) {
        switch (op) {
            case '+':
                return (a+b);
            case '-':
                return (a-b);
            case '*':
                return (a*b);
            case '/':
                return (a/b);
            case '^':
                return (int) Math.pow(a,b);
        }
        throw new IllegalArgumentException("Invalid Input");
    }

    private boolean isOp (char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }
```
