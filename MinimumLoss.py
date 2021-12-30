#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumLoss' function below.
#
# The function is expected to return an INTEGER.
# The function accepts LONG_INTEGER_ARRAY price as parameter.
#

def minimumLoss(price):
    # Write your code here
    #print(price[::-1])
    l2 = price.copy()
    d={}
    for i in range(len(price)):
        d[price[i]] = i
    price = sorted(price)
    m = float("inf")
    for i in range(len(price)-1):
        print("i+1=",d[price[i+1]],"<",d[price[i]],"=i")
        if d[price[i+1]] < d[price[i]] : 
            m = min(m,price[i + 1] - price[i])
            print("price[i + 1]=",price[i + 1],"price[i]=",price[i])
            print("m=",m)
    print(m)
    return m
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    price = list(map(int, input().rstrip().split()))

    result = minimumLoss(price)

    fptr.write(str(result) + '\n')

    fptr.close()
    
