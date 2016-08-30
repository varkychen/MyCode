import sqlite3
conn = sqlite3.connect('email_count.sqlite')
cur = conn.cursor()

print
print 'Counts:'
for row in cur.execute('SELECT org, count FROM Counts ORDER BY count DESC LIMIT 10'):
    print str(row[0]), row[1]
cur.close()