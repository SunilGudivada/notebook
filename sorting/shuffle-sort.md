# Shuffle sort

## Java Implementation

```java
public class dummy{
    public void shuffle(Object[] a){
        int N = a.length;
        Random rand;
        for(int i=0;i<N;i++){
            int randomNum = rand.nextInt(i + 1);
            swap(a[i], a[randomNum]);
        }
    }
}
```

