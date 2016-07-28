from random import sample

n = int(raw_input("Enter N:"))
a = sample(range(101),n)

print "Sort a sample of", n, "elements in ascending order. Input array:", a


for i in range(n-1):
    smallest = i
    for j in range(i+1,n):
        print a[smallest], '>', a[j], a[smallest] > a[j]
        if a[smallest] > a[j]:
            smallest = j
    a[i],a[smallest] = a[smallest],a[i]
    print "Intermediate array", i+1, ":", a

print a
    
