import urllib
from BeautifulSoup import *

url = 'http://python-data.dr-chuck.net/known_by_Mowmita.html '
i = 0

while i <= 7:
    print 'Retrieving:', url
    html = urllib.urlopen(url).read()
    soup = BeautifulSoup(html)
    tags = soup('a')
    url = tags[17].get('href')
    i += 1