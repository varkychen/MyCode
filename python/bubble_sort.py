from random import sample

n = int(raw_input("Enter N:"))
a = sample(range(101),n)

print "Sort a sample of", n, "elements in ascending order. Input array:", a

for i in range(n-1):
    for j in range(1, n-i):
        if a[j-1] > a[j]:
            a[j-1], a[j] = a[j], a[j-1]
    print "Intermediate array", i+1, ":", a
print a