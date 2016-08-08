import random as rdm

t = rdm.choice(range(1,6))
print t
n_for_each_test = rdm.sample(range(1,201),t)
for i in n_for_each_test:
    k = rdm.choice(range(1,i))
    print i,k
    
    output_string = ''
    population = range(-1000, 1001)
    sample = rdm.sample(population, i)
    for s in sample:
        output_string += str(s) + ' '
    print output_string