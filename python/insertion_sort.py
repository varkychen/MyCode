from random import sample

n = int(raw_input("Enter N:"))
a = sample(range(101),n)

print "Sort a sample of", n, "elements in ascending order. Input array:", a

for i in range(1,n):
    smallest = a[i]
    j = i;
    while j > 0 and a[j-1] > smallest:
        a[j] = a[j-1]
        j -= 1
    a[j] = smallest
    print "Intermediate array", i, ":", a
print a