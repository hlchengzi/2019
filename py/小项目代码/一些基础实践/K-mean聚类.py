#!/usr/bin/python
# coding=utf-8
from numpy import *
import re
# 加载数据
def loadDataSet(fileName):  # 解析文件，按tab分割字段，得到一个浮点数字类型的矩阵
    dataMat = []              # 文件的最后一个字段是类别标签
    fr = open(fileName)
    for line in fr.readlines():
        curLine = line.strip().split('::')
        fltLine = [float(curLine[0]),float(1)]   # 将每个元素转成float类型  只考录买该商品用户的平均隐私参数
        # fltLine = [float(curLine[0]), float(curLine[1])]  # 将每个元素转成float类型  录买该商品用户的平均隐私参数 和人数
        dataMat.append(fltLine)
    fr.close()
    print(dataMat)
    return dataMat

# 计算欧几里得距离
def distEclud(vecA, vecB):
    return sqrt(sum(power(vecA - vecB, 2))) # 求两个向量之间的距离

# 构建聚簇中心，取k个(此例中为4)随机质心
def randCent(dataSet, k):
    n = shape(dataSet)[1]
    print("N"+str(n))
    print(dataSet)
    centroids = mat(zeros((k,n)))   # 每个质心有n个坐标值，总共要k个质心
    for j in range(n):
        minJ = min(dataSet[:,j])
        print("max:"+str(minJ[0]))
        maxJ = max(dataSet[:,j])
        print("min"+str(maxJ)[0])
        rangeJ = float(maxJ-minJ)
        centroids[:,j] = minJ + rangeJ * random.rand(k, 1)
    return centroids

# k-means 聚类算法
def kMeans(dataSet, k, distMeans =distEclud, createCent = randCent):
    m = shape(dataSet)[0]
    print("M:"+str(m))
    clusterAssment = mat(zeros((m,2)))    # 用于存放该样本属于哪类及质心距离
    # clusterAssment第一列存放该数据所属的中心点，第二列是该数据到中心点的距离
    centroids = createCent(dataSet, k)
    clusterChanged = True   # 用来判断聚类是否已经收敛
    while clusterChanged:
        clusterChanged = False;
        for i in range(m):  # 把每一个数据点划分到离它最近的中心点
            minDist = inf; minIndex = -1;
            for j in range(k):
                distJI = distMeans(centroids[j,:], dataSet[i,:])
                if distJI < minDist:
                    minDist = distJI; minIndex = j  # 如果第i个数据点到第j个中心点更近，则将i归属为j
            if clusterAssment[i,0] != minIndex: clusterChanged = True;  # 如果分配发生变化，则需要继续迭代
            clusterAssment[i,:] = minIndex,minDist**2   # 并将第i个数据点的分配情况存入字典
        print(centroids)   #表示迭代情况
        for cent in range(k):   # 重新计算中心点
            ptsInClust = dataSet[nonzero(clusterAssment[:,0].A == cent)[0]]   # 去第一列等于cent的所有列
            centroids[cent,:] = mean(ptsInClust, axis = 0)  # 算出这些数据的中心点
    return centroids, clusterAssment
# --------------------测试----------------------------------------------------
# 用测试数据及测试kmeans算法

outFile = "kmeannnnn"
datMat = mat(loadDataSet('movice_mean_pri2'))
myCentroids,clustAssing = kMeans(datMat,4)
print("分的类别\n\t："+str(myCentroids))
print(size(clustAssing))
print("具体每一个的分类，和到质心的距离\n\t"+str(clustAssing[1,:]))
print("ssss:")
print(len(clustAssing[1:]))
with open(outFile, 'w') as Out:
   for i in range(len(clustAssing[1:])):
  #      # a=str(clustAssing).strip('[').strip(']').strip('[').strip(']')
        a = str(clustAssing[1:][i,:])
        Out.writelines(a+'\n')