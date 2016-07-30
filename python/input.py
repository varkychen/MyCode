from random import sample

def create_random_list():
    n = int(raw_input("Enter N:"))
    a = sample(range(101),n)
    print "Sort a sample of", n, "elements in ascending order. Input array:", a
    return a