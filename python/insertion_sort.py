from random import sample

n = int(raw_input("Enter N:"))
a = sample(range(101),n)

print "Sort a sample of", n, "elements in ascending order. Input array:", a

for i in range(1,n):
    to_insert = a[i]
    for j in range(i, -1, -1):
        if j == 0:
            a[j] = to_insert
        elif a[j-1] > to_insert:
            a[j] = a[j-1]
        else:
            a[j] = to_insert
            break
    print "Intermediate array", i, ":", a
print a