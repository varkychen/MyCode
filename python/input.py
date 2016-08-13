from random import sample

def create_random_list():
    n = int(raw_input("Enter N:"))
    a = sample(range(101),n)
    return a