import abc
import os

print('hello world')

# 遇到逗号 输出空格
print('hello', 'world', '!')

print("10 + 20 =", 10 + 20)

""""
输出：
hello world !
10 + 20 = 30
"""


"""
name = input()
print(name)

age = input("Please enter your age:",)
print(age)


name = input('please enter your name',)
print('my name is', name)
"""


a = 10
if a > 0:
    print(a)
else:
    print(-a)

print('\\\t\\')
# \       \

print(r'\\\t\\')
# \\\t\\  --> r 引号中不转义

print('''one... two... three''')
# one...two...three

# 命令行：
print('''line1
...line2
...line3''')

# 程序：
print('''line1
line2
line3''')

flag = True

print(5 > 3 or 1 > 3) # True

print(False or True) # True

print(3 and 0) # 0

print(3 and 1) # 1

print(not 3) # False

print(not 3 > 1) # False

print(10 / 3) # 3.3333333333333335

print(9 / 3) # 3.0

print(10 // 3) # 3


print(ord('a')) # 97

print(ord('中')) # 20013

print(chr(25991)) # 文

print('\u4e2d\u6587') # 中文

x = b'abc'

y = 'abc'

print(len(x))
print(len(y))

print(len('abc')) # 3
print(len('中文')) # 2


