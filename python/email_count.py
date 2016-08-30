import sqlite3

conn = sqlite3.connect('email_count.sqlite', isolation_level=None)
cur = conn.cursor()
cur.execute('DROP TABLE IF EXISTS Counts')
cur.execute('CREATE TABLE Counts (org TEXT, count INTEGER)')

fname = raw_input('Enter file name: ')
fh = open(fname)
for line in fh:
    if not line.startswith('From: '): continue
    pieces = line.split()
    org = pieces[1].split('@')[1].strip()
    print org
    
    cur.execute('SELECT count FROM Counts WHERE org = ?', (org, ))
    row = cur.fetchone()
    if row is None:
        cur.execute('INSERT INTO Counts (org, count) VALUES (?, 1)', (org, ))
    else:
        cur.execute('UPDATE Counts SET count = count+1 WHERE org = ?', (org, ))
conn.commit


print
print 'Counts:'
for row in cur.execute('SELECT org, count FROM Counts ORDER BY count DESC LIMIT 10'):
    print str(row[0]), row[1]
cur.close()
conn.close()