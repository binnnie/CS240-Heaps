1. We created multiple instances of our ThreeHeap object and tested the methods on them in multiple states. We tried
methods on empty heaps to check for the exceptions being thrown, we tried removing values from a heap, we tried
inserting values out of order to see if the object kept the heap order structure and we tried building a heap from list.

2. - buildHeap = O(n)
- isEmpty = O(1)
- size = O(1)
- insert = O(log(n))
- findMin = O(1)
- deleteMin = O(log(n))

3. a. O(log(n))
b. O(n^3)
c. O(n^2)

4. a.
    int maxDiff(int[] arr)
        int maxDiff = 0
        for (i:arr)
            for(j:arr)
                if (i-j > maxDiff)
                    maxDiff = i-j
                if (j-i > maxDiff)
                    maxDiff = j-i
        return maxDiff

b. Yes, data can remain the same:
    int maxDiff(int[] arr)
        int max = arr[0]
        int min = arr[0]
        for (i:arr)
            if (i > max)
                max = i
            if (i < min)
                min = i
        return max - min

c. No, with our current data guarantees it could not be written in O(1) time. In order for it to run in O(1) time our
data would need to be sorted in which case you can just return the difference between the first and the final element in
the array.