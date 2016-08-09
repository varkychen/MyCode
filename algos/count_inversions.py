def count_inversions_and_merge(x, y):
    i = j = count = 0
    result = list()
    
    for k in range(len(x) + len(y)):
        if i == len(x):
            result.append(y[j])
            j += 1
        elif j == len(y):
            result.append(x[i])
            i += 1
        elif x[i] < y[j]:
            result.append(x[i])
            i += 1
        elif y[j] < x[i]:
            result.append(y[j])
            count += len(x) - i
            j += 1
    return count, result

def array_split(a):
    count = 0
    if len(a) == 1:
        count, result = 0,a
    else:
        inv1, x = array_split(a[:len(a)/2])
        inv2, y = array_split(a[len(a)/2:])
        inv3, result = count_inversions_and_merge(x,y)
        count = inv1 + inv2 + inv3
        
    return count, result

fh = open('IntegerArray.txt')
a = [int(x) for x in fh.read().split('\n')]
b = array_split(a)

print "Result:", b[0]