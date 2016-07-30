from input import create_random_list

def merge(x, y):
    i = j = 0
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
        elif i == len(x) or y[j] < x[i]:
            result.append(y[j])
            j += 1
    return result

def array_split(a):
    if len(a) == 1:
        result = a
    else:
        x = array_split(a[:len(a)/2])
        y = array_split(a[len(a)/2:])
        result = merge(x,y)
        
    print "Intermediate result:", result
    return result

a = create_random_list()
b = array_split(a)

print "Result:", b