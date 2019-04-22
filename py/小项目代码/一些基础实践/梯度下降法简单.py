import numpy as np
from  numpy.linalg import inv
from numpy import dot
from numpy import mat
a = [[1,2],
     [1,9],
     [1,4],
     [1,7],
     [1,4],
     [1,6]]
b = mat(a)
y = [2,9,4,7,4,6]

theta = [1.0,1.0]
alpha = [0.1,0.1]
for i in range(100):
    theta = theta - dot(dot(alpha,(dot(theta,a)-y)),a)
print(theta)