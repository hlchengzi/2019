def WparKi(budget):
    countNumber = 0
    for i in budget:
        countNumber += (pow((i - min(budget)), 2))
    return countNumber

# Privacy_aware Machine机制，也就是要求基于上篇分区机制进行改进,要求给定k，隐私参数浪费的最少
# partK为需要寻找到的最优分区个数
K=4
parttition=[]
for i in range(K):
    parttition.append(i)
for i in range(K):
    parttition[i]=[]

def Privacy_aware(list1, partK):
    print("Privacy_aware Start:")
    # 当分区为0的话将返回整个的损失函数，和0索引
    if partK == 0:
        return 0,[]
    minW = float("inf")
    for j in range(partK-2, len(list1), 1):
        a,b=Privacy_aware(list1[0:(j - 1)], partK - 1)
        currentW = a + WparKi(list1[j :len(list1)])
        if (currentW < minW):
            minW = currentW
            parttition[partK-1]=list1[j:len(list1)]
            print("损失："+str(minW))
            print("分区最后:" + str(j + 1))
    print("Privacy_aware end!")
    return minW,parttition
    # return minW,parttition
a=[1,1,2,4,4,7,7,7,7]
# b=[1,1,2,4,4]
a,b=Privacy_aware(a,K)
print(a)
for i in range(K):
    print(b[i])
