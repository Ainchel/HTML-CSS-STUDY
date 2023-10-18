'''
Created on 2023. 10. 18.

@author: ckd39
'''
import random

# -*- coding:utf-8 -*-

i = random.randint(1, 10)
print(i)

def lotto():
    lotto = set()
    
    while(len(lotto) != 6):
        lotto.add(random.randint(1,45))
        
    return lotto

#############################

result = list(lotto())
result.sort()
print(result)