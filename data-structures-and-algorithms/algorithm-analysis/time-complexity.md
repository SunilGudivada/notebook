# Asymptotic Notation

## Worst Case Running Time

For an algorithm $$A$$, t(x) represents the number it of steps it takes to process input x using algorithm A.

The worst case run time for processing data set $$T_A(n)$$

Worst case running time looks at the number of steps it takes at most to go through an algorithm for input of size n

$$
T(n) = \{ max \ { t(x), \ where \ x \ is \ input \ of\ size \ n } \}
$$

Thus, what it means is that if we looked at all possible inputs of size n the set of inputs that lead to the most steps is the expression we use for T(n). In practice it isn't really practical to look at every possible set of input of size n, and thus, we typically argue for a set of input that will lead to doing the most operations possibles.

## Lower Bound and Upper Bound

### Upper bound

The upper bound is typically expressed with big-O notation. Note that upper bound is not just applicable to worst case. Upper bound can be applied to worst case, average even best case.

" $$T(n)$$ is in $$O(f(n))$$" iff for some constants $$c$$ and $$n_0$$, $$T(n) \leq c f(n)$$ for all $$n \geq n_0​​$$

### Lower bound

Similar to upper bound, a lower bound is not something that only applies to best case run time. The lower bound of a function is described by big - $$\Omega$$notation. Formally:

" $$T(n)$$ is in $$\Omega(f(n))$$" iff for some constants $$c$$ and $$n_0$$, $$T(n) \geq c f(n)$$ for all $$n \geq n_0​​$$

To prove this, what we need to argue is simply that there is at least one set of input of size n for which f(n) is the lower bound (at least c\*f(n) steps must be taken to handle that particular input).

![Common Data Structure Operations](<../../.gitbook/assets/image (21) (1).png>)

![Array Sorting algorithms](<../../.gitbook/assets/image (5) (1).png>)

![BIG-0 Cheat sheet](<../../.gitbook/assets/image (76).png>)

## Reference

* [https://www.bigocheatsheet.com/](https://www.bigocheatsheet.com/)
