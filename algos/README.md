Algorithms - Design and Analysis Course I
=========================================

Contains

1. Count Inversions  
  Given a set of numbers, find out the number of inversions, i.e. - Find out number of pair of numbers that are not in sorted in ascending order 

2. Closest Pair  
  From a set of points find the pair having the least euclidean distance. Provides both a O(n^2) and O(nlogn) implementations.
  Includes a visual representation for better visualization. For example - 

  ``closest_pair.py 10 25  
  [(24, 2), (7, 23), (5, 16), (1, 12), (2, 14), (22, 24), (9, 8), (10, 10), (13, 18), (23, 3)]  
  Brute Force Closest pair: (24, 2) (23, 3) Distance:  1.41421356237  
  Divide and Conquer Closest pair: (23, 3) (24, 2) Distance: 1.41421356237  
  . . . . . . . . . . . . . . . . . . . . . . + . . 24  
  . . . . . . . + . . . . . . . . . . . . . . . . . 23  
  . . . . . . . . . . . . . . . . . . . . . . . . . 22  
  . . . . . . . . . . . . . . . . . . . . . . . . . 21  
  . . . . . . . . . . . . . . . . . . . . . . . . . 20  
  . . . . . . . . . . . . . . . . . . . . . . . . . 19  
  . . . . . . . . . . . . . + . . . . . . . . . . . 18  
  . . . . . . . . . . . . . . . . . . . . . . . . . 17  
  . . . . . + . . . . . . . . . . . . . . . . . . . 16  
  . . . . . . . . . . . . . . . . . . . . . . . . . 15  
  . . + . . . . . . . . . . . . . . . . . . . . . . 14  
  . . . . . . . . . . . . . . . . . . . . . . . . . 13  
  . + . . . . . . . . . . . . . . . . . . . . . . . 12  
  . . . . . . . . . . . . . . . . . . . . . . . . . 11  
  . . . . . . . . . . + . . . . . . . . . . . . . . 10  
  . . . . . . . . . . . . . . . . . . . . . . . . . 9  
  . . . . . . . . . + . . . . . . . . . . . . . . . 8  
  . . . . . . . . . . . . . . . . . . . . . . . . . 7  
  . . . . . . . . . . . . . . . . . . . . . . . . . 6  
  . . . . . . . . . . . . . . . . . . . . . . . . . 5  
  . . . . . . . . . . . . . . . . . . . . . . . . . 4  
  . . . . . . . . . . . . . . . . . . . . . . . * . 3  
  . . . . . . . . . . . . . . . . . . . . . . . . * 2  
  . . . . . . . . . . . . . . . . . . . . . . . . . 1  
  . . . . . . . . . . . . . . . . . . . . . . . . . 0  
  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4``  