import sys
import random

def quicksort(arr, l, r, prefix):
    print prefix, "Before quicksort:", arr[l:r], "l:", l, "r:", r
    if (r-l) > 1:
        p = arr[l]
        i = l+1
        print prefix, "Before partitioning:", arr[l:r], "pivot:", p
        for j in range(l+1, r):
            print "%s i: %d j: %d arr[i]: %d arr[j]: %d Intermediate array: %s" % (prefix, i, j, arr[i], arr[j], arr[l:r])
            if arr[j] < p:
                arr[i], arr[j] = arr[j], arr[i]
                i = i+1
        arr[i-1], arr[l] = arr[l], arr[i-1]
        print prefix, "After partitioning:", arr[l:r]
        quicksort(arr, l, i-1, prefix + '  ')
        quicksort(arr, i, r, prefix + '  ')
    print prefix, "After quicksort:", arr[l:r]

n = int(sys.argv[1])
N = int(sys.argv[2])
a = random.sample(range(1,N+1), n)

quicksort(a, 0, len(a), '')