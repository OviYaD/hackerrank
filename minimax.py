#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'miniMaxSum' function below.
#
# The function accepts INTEGER_ARRAY arr as parameter.
#

def miniMaxSum(arr):
    # Write your code here
    min=100000000000000000000000000000
    max=0
    
    for i in range(len(arr)):
        sum=0
        for j in range(len(arr)):
            if i==j:
                continue
            else:
                sum+=arr[j]
        if max<sum:
            max=sum
        if min>sum:
            min=sum
    print(min,max)

if __name__ == '__main__':

    arr = list(map(int, input().rstrip().split()))

    miniMaxSum(arr)
