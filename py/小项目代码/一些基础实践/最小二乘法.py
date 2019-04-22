import numpy as np
from numpy.linalg import  inv
from numpy import dot
from numpy import mat
import matplotlib.pyplot as plt

a = [[1,2],
     [1,9],
     [1,4],
     [1,7],
     [1,4],
     [1,6]]
b = mat(a)
y = [2,9,4,7,4,6]

theta = dot(dot(inv(dot(b.T,b)),b.T),y)
print(theta)
