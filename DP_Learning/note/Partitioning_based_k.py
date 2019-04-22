import numpy as np
import random
import pandas as pd


#Privacy-aware Machine
# 首先明确目标，是要建立两个基于分区机制的个性化差分隐私机制
class Partitioning_based():
    # 初始化列表 输入的是用户的幸喜（包含个性化的隐私预算和用户的数据）
    def __init__(self,userInformation,userPrivacyBudget,K):
        self.user=userInformation[:]
        self.budget=userPrivacyBudget[:]
        self.parttition = np.zeros(K)

    # 使用快速排序将输入数据按照隐私预算大小进行排序
    def QuickSort(self,myList,myOtherList, start, end):
        # 判断low是否小于high,如果为false,直接返回
        if start < end:
            i, j = start, end
            base = myList[i]
            base1= myOtherList[i]
            while i < j:
                # 如果列表后边的数,比基准数大或相等,则前移一位直到有比基准数小的数出现
                while (i < j) and (myList[j] >= base):
                    j = j - 1
                # 如找到,则把第j个元素赋值给第个元素i,此时表中i,j个元素相等
                myList[i] = myList[j]
                myOtherList[i] = myOtherList[j]
                # 同样的方式比较前半区
                while (i < j) and (myList[i] <= base):
                    i = i + 1
                myList[j] = myList[i]
                myOtherList[j] = myOtherList[i]
            # 做完第一轮比较之后,列表被分成了两个半区,并且i=j,需要将这个数设置回base
            myList[i] = base
            myOtherList[i]= base1

            # 递归前后半区
            self.QuickSort(myList,myOtherList, start, i - 1)
            self.QuickSort(myList,myOtherList, j + 1, end)
        return myList

#     接下来就是两个机制
    #现在写一个函数用来计算一个列表里面的损失大小,也就是一个小分区里面的
    def WparKi(self,budget):
        countNumber= 0
        for i in budget:
            countNumber+=pow((i-min(budget)),2)
        return countNumber

    #Privacy_aware Machine机制，也就是要求基于上篇分区机制进行改进,要求给定k，隐私参数浪费的最少
    #partK为需要寻找到的最优分区个数
    #K表示分区个数
    def Privacy_aware(self,list1,partK):
        #当分区为0的话将返回整个的损失函数，和0索引
        if partK==0:
            return 0,0
        minW=float("inf")
        t=0
        for j in range(partK-1,len(list1),1):
            currentW,self.parttition[partK-1]=self.Privacy_aware(list1[0:j-1],partK-1)
            currentW+=self.WparKi(list1[j:len(list1)])
            if(currentW<minW):
                minW=currentW
                self.parttition[partK-1]=j
                #print(minW)
                # print("分区最后:" + str(j + 1))
                #print("Privacy_aware end!")
                #return minW
                t=j
        return minW,t

    def Utitity_based(self):
        print("Utitity_based start:")
        self.QuickSort(self.budget, self.user, 0, len(self.budget)-1)
        print("Utitity_based end!")

#对数据和用户进行赋值
# a=[1,1,1,42,2,2]
# b=[1,1,1,42,2,2]
a=[random.random()for _ in range(100) ]
b=[random.random()for _ in range(100) ]
# 表示分区的个数
K=40
A= Partitioning_based(a,b,K)
#在实现的时候，先对隐私预算进行排序 排序没有问题
A.QuickSort(A.budget,A.user,0,len(A.budget)-1);
print(A.user)
print(A.budget)
X,Y=A.Privacy_aware(A.budget,K);
print('Y:'+str(A.parttition))
