#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'migratoryBirds' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def migratoryBirds(arr):
    # Write your code here
    d={}
    for i in arr:
        if i not in d:
            d[i]=1
        else:
            d[i]=d[i]+1
    l=[]
    i=0
    j=-1
    print(d)
    for key,value in d.items():
        if(value>=i):
            print(value,"=",i,"    ",j,">",key)
            if value==i:
                if j>key:
                    j=key    
            else:
                i=value
                j=key
    return j
                
                    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = migratoryBirds(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
