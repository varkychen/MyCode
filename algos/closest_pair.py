import sys
import random

def create_random_points(n ,N):
    x = random.sample(range(N),n)
    y = random.sample(range(N),n)
    a = []
    for i in range(n):
        a.append((x[i], y[i]))
    return a

def brute_force_closest_pair(a, restrict_to_7 = False):
    closest_pair = None
    if(len(a) >= 2):
        for i in range(len(a) - 1):
            min_comps = min(i+8, len(a)) if restrict_to_7 else len(a)
            for j in range(i+1, min_comps):
                distance = ((a[i][0] - a[j][0]) ** 2 + (a[i][1] - a[j][1]) ** 2) ** 0.5
                if closest_pair is None or closest_pair[2] > distance:
                    closest_pair = a[i], a[j], distance
    return closest_pair
    
def merge_sort_points(a, is_vertical):
    index = 1 if is_vertical else 0
    result = []
    if len(a) == 1:
        result = a
    else:
        q = merge_sort_points(a[:len(a)/2], is_vertical)
        r = merge_sort_points(a[len(a)/2:], is_vertical)
        result = merge_points(q, r, is_vertical)
    return result

def merge_points(q, r, is_vertical):
    index = 1 if is_vertical else 0
    i = j = 0
    result = []
    while i != len(q) or j != len(r):
        if i == len(q):
            result.append(r[j])
            j += 1
        elif j == len(r):
            result.append(q[i])
            i += 1
        elif q[i][index] < r[j][index]:
            result.append(q[i])
            i += 1
        elif r[j][index] < q[i][index]:
            result.append(r[j])
            j += 1
    return result

def xsplit(a):
    return a[:len(a)/2], a[len(a)/2:]

def ysplit(a, midx):
    qy = []
    ry = []
    for p in a:
        if p[0] <= midx[0]:
            qy.append(p)
        else:
            ry.append(p)
    return qy, ry
    
def closest_split_pair(px, py, midx, delta):
    minx = max(midx[0] - delta, px[0][0])
    maxx = min(midx[0] + delta, px[-1][0])
    
    sy = []
    for p in py:
        if p[0] >= minx and p[0] <= maxx:
            sy.append(p)
    return brute_force_closest_pair(sy, True)

def fetch_closest_pair(q, r, p):
    min_distance = min(q[2], r[2], p[2]) if p is not None else min(q[2], r[2])
    
    if min_distance == q[2]:
        return q
    elif min_distance == r[2]:
        return r
    else:
        return p
    
def closest_pair(px, py):
    if len(px) == 2 or len(px) == 3:
        return brute_force_closest_pair(px)
    else:
        midx = px[len(px)/2 - 1]
        qx,rx = xsplit(px)
        qy,ry = ysplit(py, midx)
        q = closest_pair(qx, qy)
        r = closest_pair(rx, ry)
        delta = min(q[2], r[2])
        p = closest_split_pair(px, py, midx, delta)
        
        return fetch_closest_pair(q, r, p)
        
def display(a, q, r, population):
    border = population - 1
    output = []
    for i in range(population):
        line = []
        for j in range(population):
            line.append(". ")
        output.append(line)
    
    for p in a:
        output[border - p[1]][p[0]] = "+ "
    
    output[border - q[1]][q[0]] = "* "
    output[border - r[1]][r[0]] = "* "
    
    xaxis = ""
    for i in range(len(output)):
        print "".join(output[i]) + str(border - i)
        xaxis += str(i%10) + " "
    print xaxis
    
        
    
sample = int(sys.argv[1])
population = int(sys.argv[2])
p = create_random_points(sample, population)

print p
q, r, dist = brute_force_closest_pair(p)
print "Brute Force Closest pair:", q, r, "Distance: ", dist

px = merge_sort_points(p, False)
py = merge_sort_points(p, True)

q, r, dist = closest_pair(px, py)
print "Divide and Conquer Closest pair:", q, r, "Distance:", dist
display(px, q, r, population)