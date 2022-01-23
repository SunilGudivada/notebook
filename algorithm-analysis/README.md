# Algorithm analysis

## Overview

When we study an algorithm we typically want to know a few things:

* Is the algorithm correct (for all given inputs will it always produce the desired output?)
* How much of a given resource will it consume in order to produce the output?

### Resource Consumption

When we analyze algorithms, we are typically concerned about the amount of resources required by the algorithm to solve a given problem. The two major resources that are usually measured are:

* time
* memory

They are not the only things that we measure but they are the ones we will focus on for this course.

An algorithm that is fast (uses less time resource) may not actually do well in terms of memory consumption and vice versa. Depending on the situation, you may end up choosing an algorithm that uses more of one resource in order to use less of the other. Some algorithms may perform better for some input sets than others (smaller data size, properties such as being already nearly sorted, etc.). Similarly the environment that the algorithm is running on can also affect its actual speed. Understanding the nature of the problem you need to solve and environment for the computational task can help you choose the best algorithm for a task.

### Input Size

When analyzing an algorithm, we typically perform the analysis based on some input size. Resource consumption is measured against the size of the input. This is essentially saying that the more input you have the more resources will be consumed to solve the problem.

The nature of the input size can be different depending on the problem. It can be number of items (numbers for example) being operated on, the number of bits involved in the data set, it can even be measured by multiple values. When analyzing its important to state what the input size is as part of the analysis.

### Running Time

The _**running time**_ of an algorithm is the number of operations (addition, subtraction, branching etc.) performed by the algorithm with respect to its data size. When performing a running time analysis, we make very broad assumptions that are not necessarily true in reality but it turns out that this isn't really a problem. Thus, the amount of time it takes to perform any one operation is considered to be the same. If we are able to express the number of operations performed by the algorithm for a given data size, then we can come up with a mathematical expression to describe the run time.

### Growth Rates

While a mathematical description of an algorithm's resource consumption is useful, typically it is more details than what we need. Instead of an exact mathematical expression to describe how much resource is consumed by algorithm, we are actually more interested in how performance will be affected as the amount of data grows.

{% hint style="info" %}
Algorithms Analysis does not answer the question "How much of a resource is consumed to process _**n**_ pieces of data"... the real question it answers is "How much _**more**_ of the same resource will it consume to process n+1 pieces of data"
{% endhint %}

The general descriptions of how an algorithm grows are useful because it gives us a sense of the expected behaviour in terms of resource consumption.

For example, this little blurb comes from the description of map data structure in the C++ standard library:

> `std::map` is a sorted associative container that contains key-value pairs with unique keys. Keys are sorted by using the comparison function `Compare`. Search, removal, and insertion operations have _**logarithmic complexity**_
>
> [https://en.cppreference.com/w/cpp/container/map](https://en.cppreference.com/w/cpp/container/map)

the use of the term _**logarithmic complexity**_ indicates to the reader how the resource consumption will behave as more and more data is stored into the container. This will allow the reader to decide if this is the container they wish to use or if another would better suit their needs without actually having to dig through the implementation.

With this in mind, lets take a look at some common growth rates. Keep in mind though that these are just the more common ones taken with only one single numeric value to represent data size. Other expressions can exist and this is by no means an exhaustive list.

### Constant

A constant resource need is one where the resource need does not grow. That is processing 1 piece of data takes the same amount of resource as processing 1 million pieces of data. The graph of such a growth rate looks like a horizontal line

![](<../.gitbook/assets/image (31) (1).png>)

### Logarithmic

A logrithmic growth rate is a growth rate where the resource needs grows by one unit each time the data is doubled. This effectively means that as the amount of data gets bigger, the curve describing the growth rate gets flatter (closer to horizontal but never reaching it). The following graph shows what a curve of this nature would look like.

![](<../.gitbook/assets/image (47) (1).png>)

### Linear

A linear growth rate is a growth rate where the resource needs and the amount of data is directly proportional to each other. That is the growth rate can be described as a straight line that is not horizontal.

![](<../.gitbook/assets/image (59) (1).png>)

### Loglinear (Linearithmic)

A loglinear (sometimes called linearithmic) growth rate is a slightly curved line. the curve is more pronounced for lower values than higher ones

![](<../.gitbook/assets/image (44) (1).png>)

### Quadratic

A quadratic growth rate is one that can be described by a parabola.

![](<../.gitbook/assets/image (82) (1).png>)

### Cubic

While this may look very similar to the quadratic curve, it grows significantly faster

![](<../.gitbook/assets/image (61) (1).png>)

### Exponential

An exponential growth rate is one where each extra unit of data requires a doubling of resource. As you can see the growth rate starts off looking like it is flat but quickly shoots up to near vertical (note that it can't actually be vertical)

![](<../.gitbook/assets/image (30) (1).png>)
