import sys


year = int(input().strip())
count=0
if(year>1918 and year<=2700):
    if(year%400==0 or (year%4==0 and year%100!=0)):
        count=1
    if(count==1):
        print('12.09.'+str(year))
    else:
        print('13.09.'+str(year))
if(year<1918 and year>=1700):
    if(year%4==0):
        count=1
    if(count==1):
        print('12.09.'+str(year))
    else:
        print('13.09.'+str(year))
if(year==1918):
    print('26.09.1918')
