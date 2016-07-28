n = int(raw_input('Enter N:'))
a = [int(e) for e in raw_input().strip().split(' ')[:n]]

print 'Sort', n, 'elements of input array', a, 'in ascending order.'


for i in range(n-1):
    smallest = i
    for j in range(i,n):
        if a[i] > a[j]:
            smallest = j
    if smallest != i:
        a[i],a[smallest] = a[smallest],a[i]
    print 'Intermediate result', i+1, 'is', a
print a
    
