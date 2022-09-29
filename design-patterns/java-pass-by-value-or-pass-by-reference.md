# Java Pass by Value or Pass by Reference

*   Java always passes arguments _by value_, NOT by reference.

    \


    ```java
    public class Main {

         public static void main(String[] args) {
              Foo f = new Foo("f");
              changeReference(f); // It won't change the reference!
              modifyReference(f); // It will modify the object that the reference variable "f" refers to!
         }

         public static void changeReference(Foo a) {
              Foo b = new Foo("b");
              a = b;
         }

         public static void modifyReference(Foo c) {
              c.setAttribute("c");
         }

    }
    ```

    \
    I will explain this in steps:

    1.  Declaring a reference named `f` of type `Foo` and assign it a new object of type `Foo` with an attribute `"f"`.

        ```java
        Foo f = new Foo("f");
        ```

        <img src="https://i.stack.imgur.com/arXpP.png" alt="enter image description here" data-size="original">
    2.  From the method side, a reference of type `Foo` with a name `a` is declared and it's initially assigned `null`.

        ```java
        public static void changeReference(Foo a)
        ```

        <img src="https://i.stack.imgur.com/k2LBD.png" alt="enter image description here" data-size="original">
    3.  As you call the method `changeReference`, the reference `a` will be assigned the object which is passed as an argument.

        ```java
        changeReference(f);
        ```

        <img src="https://i.stack.imgur.com/1Ez74.png" alt="enter image description here" data-size="original">
    4.  Declaring a reference named `b` of type `Foo` and assign it a new object of type `Foo` with an attribute `"b"`.

        ```java
        Foo b = new Foo("b");
        ```

        <img src="https://i.stack.imgur.com/Krx4N.png" alt="enter image description here" data-size="original">
    5.  `a = b` makes a new assignment to the reference `a`, **not** `f`, of the object whose attribute is `"b"`.

        <img src="https://i.stack.imgur.com/rCluu.png" alt="enter image description here" data-size="original">
    6.  As you call `modifyReference(Foo c)` method, a reference `c` is created and assigned the object with attribute `"f"`.

        <img src="https://i.stack.imgur.com/PRZPg.png" alt="enter image description here" data-size="original">
    7.  `c.setAttribute("c");` will change the attribute of the object that reference `c` points to it, and it's the same object that reference `f` points to it.

        <img src="https://i.stack.imgur.com/H9Qsf.png" alt="enter image description here" data-size="original">

    I hope you understand now how passing objects as arguments works in Java :tada:
