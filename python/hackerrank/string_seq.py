def encode_string(input):
    start = 0
    output_string = ''
    for i in range(len(input)):
        if input[start] != input[i]:
            output_string += str(len(input[start:i])) + input[start]
            start = i
    output_string += str(len(input[start:])) + input[start]
    return output_string
    
print encode_string('aaaaabbbbccccccaaaaaaa')
print encode_string('xxxxyycdd')