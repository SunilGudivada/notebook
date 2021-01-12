# Dijkstra's two-stack algorithm

Evaluate `( 1 + ( ( 2 + 3 )  * ( 4 * 5 ) ) )`

## **Algorithm**

**Maintain two stacks , push items to the stack based on the type of the encountered String or Value**

* Value: push onto the value stack. 
* Operator: push onto the operator stack. 
* Left parenthesis: ignore. 
* Right parenthesis: pop operator and two values; push the result of applying that operator to those values onto the operand stack.

## Code

```java
public class Evaluate {
    
    public static void main(String[] args) {
    Stack<String> operations = new Stack<>();
    Stack<Double> values = new Stack<>();

    String expr = "( 1 + ( 5 * ( 4 * 5 ) ) )";

    String[] tokens = expr.split(" ");
    for (String str : tokens)
      switch (str) {
        case "+":
        case "*":
          operations.push(str);
          break;
        case "(":
          break;
        case ")":
          String op = operations.pop();
          if (op.equals("+")) {
            values.push(values.pop() + values.pop());
          } else if (op.equals("*")) {
            values.push(values.pop() * values.pop());
          }
          break;
        default:
          if (!str.equals("")) values.push(Double.parseDouble(str));
          break;
      }
    System.out.println(values.pop());
  }
}
```



