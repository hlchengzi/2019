import matplotlib.pyplot as plt
def laplace_function(x, beta):
    result = (1 / (2 * beta)) * np.e ** (-1 * (np.abs(x) / beta))
    return result


# 在-5到5之间等间隔的取10000个数
x = np.linspace(-5, 5, 10000)
y1 = [laplace_function(x_, 0.5) for x_ in x]
y2 = [laplace_function(x_, 1) for x_ in x]
y3 = [laplace_function(x_, 2) for x_ in x]

plt.plot(x, y1, color='r', label='beta:0.5')
plt.plot(x, y2, color='g', label='beta:1')
plt.plot(x, y3, color='b', label='beta:2')
plt.title("Laplace distribution")
plt.legend()
plt.show()

import pandas as pd
import numpy as np
def loadDataSet(fileName):
    numFeat = len(open(fileName).readline().split(','))    # 计算有多少列
    dataMat = []
    fr = open(fileName)
    for line in fr.readlines()[0:-1]:        #  遍历原始数据集每一行
        lineArr =[]
        curLine = line.strip().split(',')      # 是一列表类型
        #print(curLine)
        for i in range(numFeat):     # numFeat - 1的原因：因为原始数据的最后一列是类别，不是属性数据
            lineArr.append((curLine[i]))  # 一个一个传进lineArr列表向量
        dataMat.append(lineArr)     # 再传进dataMat列表向量
    return dataMat

a=loadDataSet("adult.data")
b=loadDataSet("adult.test")
EXdata=pd.DataFrame(data=a)
EXtest=pd.DataFrame(data=b)
Edata=np.array(EXdata)
Etext=np.array(EXtest)

def noisyCount(sensitivety, epsilon):
    beta = sensitivety / epsilon
    u1 = np.random.random()
    u2 = np.random.random()
    if u1 <= 0.5:
        n_value = -beta * np.log(1. - u2)
    else:
        n_value = beta * np.log(u2)
    return n_value
