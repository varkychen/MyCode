from random import sample

n = int(raw_input("Enter N:"))
a = sample(range(101),n)

print "Sort a sample of", n, "elements in ascending order. Input array:", a

for i in range(1,n):
    to_insert = a[i]
    j = i
    while j > 0 and a[j-1] > to_insert:
        a[j] = a[j-1]
        j -= 1
    a[j] = to_insert
    print "Intermediate array", i, ":", a
print a 