import urllib
import xml.etree.ElementTree as ET

url = raw_input('Enter location: ')
print 'Retrieving', url

data = urllib.urlopen(url).read()
print 'Retrieved', len(data), 'characters'

tree = ET.fromstring(data)
counts = tree.findall('.//count')
sum = 0
for item in counts:
    sum += int(item.text)

print 'Count:', len(counts)
print 'Sum:', sum