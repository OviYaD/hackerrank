#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'isValid' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def isValid(s):
    # Write your code here
    d={}
    for i in s:
        if i not in d:
            d[i]=1
        else:
            d[i]+=1
    temp={}
    print("d=",d)
    for i in d.items():
        if i[1] not in temp:
            temp[i[1]]=1
        else:
            temp[i[1]]+=1
    count=[]
    print("temp",temp)
    for i in temp.items():
        #if i[1] not in count:
            count.append(i[1])
    print("count",count)
    if len(temp)>1 and len(count)>1:
        if len(count)>2:
            return "NO"
        elif count[1]>1:
            return "NO"
        else:
            return "YES"
    else:
        return "YES"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = isValid(s)

    fptr.write(result + '\n')

    fptr.close()
