import urllib
from BeautifulSoup import *

url = 'http://python-data.dr-chuck.net/comments_287332.html'

html = urllib.urlopen(url).read()
soup = BeautifulSoup(html)

tags = soup('span')
total = sum([int(x.contents[0]) for x in tags])

print total