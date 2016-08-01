n = int(raw_input())
for i in range(n):
    input = int(raw_input())
    
    if input == 1:
        print "Not prime"
    elif input == 2:
        print "Prime"
    elif input%2 == 0:
        print "Not prime"
    else:
        i=3
        output = "Prime"
        while (i*i < input):
            if input%i == 0:
                output = "Not prime"
                break
            i += 2
        print output