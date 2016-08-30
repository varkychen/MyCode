import json
import urllib

address = raw_input('Enter location: ')
parameters = urllib.urlencode({'sensor' : 'false', 'address' : address})
url = 'http://python-data.dr-chuck.net/geojson?' + parameters
print 'Retrieving', url

data = urllib.urlopen(url).read()
print 'Retrieved', len(data), 'characters'

input = json.loads(data)
print input['results'][0]['place_id']