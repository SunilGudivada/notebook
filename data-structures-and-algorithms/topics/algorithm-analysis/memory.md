# Memory

Basics

**Bit** - `0` or `1`

**Byte** - `8` bits

**Mega Byte** - 1 million or $$2^{20}$$ bytes

**Giga Byte** - 1 Billion or $$2^{30}$$ bytes

{% hint style="success" %}
Old Machines, we used to assume 32 bits with 4 byte pointers

Modern Machines, we used to assume 64 bits with 8 byte pointers

* Can address more memory
* Pointers uses more memory
{% endhint %}

### Typical memory usage of primitive types and arrays

| Type      | Bytes |
| --------- | ----- |
| `boolean` | `1`   |
| `byte`    | `1`   |
| `char`    | `2`   |
| `int`     | `4`   |
| `float`   | `4`   |
| `long`    | `8`   |
| `double`  | `8`   |

### For one Dimensional arrays ( N )

> Note: Over head of `24 bytes`

| Type       | Bytes     |
| ---------- | --------- |
| `char[]`   | `2N + 24` |
| `int[]`    | `4N + 24` |
| `double[]` | `8N + 24` |

### For two Dimensional arrays ( M \* N )

| Type         | Bytes      |
| ------------ | ---------- |
| `char[][]`   | `2MN + 24` |
| `int[][]`    | `4MN + 24` |
| `double[][]` | `8MN + 24` |

### Java Objects

Object overhead - 16 bytes

Object Reference - 8 bytes

Padding - Each object uses a multiple of 8 bytes

{% tabs %}
{% tab title="Date" %}
```java
/**
* Memory Calculation
* Object Overhead + day + month + year + padding 
* 16 + 4 + 4 + 4 + 4 = 32 bytes
*/
public class date {
  private int day;      // 4 bytes
  private int month;    // 4 bytes
  private int year;     // 4 bytes 
} 
```
{% endtab %}

{% tab title="String" %}
```java
/**
* Memory Calculation
* Object Overhead + value + offset + count + hash + padding 
* 16 + (8 + 2N + 24) + ( 4 + 4 + 4 ) + 4 = 2N + 64 bytes
*/
public class string {

    private char[] value; // Reference to array : 8 + ( 2N + 24 )
    private int offset;   // 4 bytes
    private int count;    // 4 bytes
    private int hash;     // 4 bytes
    
}
```
{% endtab %}
{% endtabs %}
