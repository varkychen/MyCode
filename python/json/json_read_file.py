import json
import urllib

url = raw_input('Enter location: ')
print 'Retrieving', url

data = urllib.urlopen(url).read()
print 'Retrieved', len(data), 'characters'

input = json.loads(data)
comments = input['comments']
print 'Count:', len(comments)

sum = 0
for comment in comments:
    sum += comment['count']
print 'Sum:', sum