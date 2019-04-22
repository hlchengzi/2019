import random
import numpy as np
class geneticTravel():
    def __init__(self):
        self.distance_matix=self.inputDis();#初始化地图
        self.maxNum=9#表示要走的城市个数是maxnum=,则总共有4个城市
        self.populationNum=int(self.maxNum*(self.maxNum-1)/2)*2#种群数量
        self.population=self.infoPopulation()#初始化种群
        self.crossPro=0.7#只定义了交叉，暂时不考虑变异
        self.variatepro=0.02#定义变异概率
        self.minStep=0#self.maxNum*(self.maxNum-1)
    #定义快排
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
    #定义距离矩阵,这个要从txt文件当中读取
    def inputDis(self):
        A = np.loadtxt('loadtxt.txt', delimiter=',')
        # A = [[1,0,0], [1, 2,0], [1, 2, 3]]
        return A
    #初始化种群数，一共是maxNum！个城市，现在产生int（maxNum*(maxNUm-1)/2）*2个个体
    def infoPopulation(self):
        #随机产生populationNum个个人,每个都是0-maxNum的随机序列
        temp=[]
        for i in range(self.populationNum):
            temp.append(list(np.random.permutation(range(self.maxNum))))
        return temp

    def max_list(self,lt):
        temp = 0
        max_str=lt[0]
        temp-0
        for i in lt:
            if lt.count(i) > temp:
                max_str = i
                temp = lt.count(i)/len(lt)
        return max_str,temp

    #判断种群是否稳定
    def judge(self):#还未写
        max_str,pro=self.max_list(self.population)
        print(pro)
        if self.minStep<self.maxNum*(self.maxNum-1):
            self.minStep+=1
            return max_str,False
        if  self.minStep>self.maxNum*(self.maxNum-1)*(self.maxNum-2)*self.maxNum:
            return  max_str,True
        if pro>=0.5:
            return max_str,True
        else:
            self.minStep+=1
            return max_str,False

    def coutDistance(self,disList):
        dis=self.distance_matix[disList[0]][0]
        for i in range(len(disList)-1):
            max1=max(disList[i],disList[i+1])
            min1 = min(disList[i],disList[i+1])
            dis+=self.distance_matix[max1][min1]
        dis+=self.distance_matix[disList[len(disList)-1]][0]
        return 0

    #评价种群当中的个体适应度,并排序
    def individualFitness(self):
        #遍历每一个解决方案，进行排序
        dis=[]
        for i in range(self.populationNum):
            dis.append(self.coutDistance(self.population[i]))
        #现在要做的是根据距离排序
        self.QuickSort(dis,self.population,0,len(dis)-1)
     #变异
    def variation(self, list1, list2):
        # 交叉的主要随机产生连个不相同的数字maxNum/2,a,b,将a,换成a+b，将a+b换成a
        R = random.random()
        if R > self.variatepro:
            return list1, list2
        print("变异")
        rand1=random.random()
        a = random.randint(0, (int(self.maxNum / 2)))
        b = random.randint(0, int(self.maxNum / 2))
        for i in range(self.maxNum):
            if rand1>=0.5:
                for i in range(self.maxNum):
                    if list1[i] == a:
                        list1[i] = a + b
                    if list1[i] == a + b:
                        list1[i] = a
            else:
                for i in range(self.maxNum):
                    if list2[i] == a:

                        
                        list2[i] = a + b
                    if list2[i] == a + b:
                        list2[i] = a
        return list1, list2
        #这个地方应该是交叉变异，现在只考虑交叉
        #**开始想的交叉实际上没有体现出交叉的事项，染色体片段交换。所以这个交叉实际上是变异

    def crossoveVariation(self,list1,list2):
        #交叉的主要随机产生连个不相同的数字maxNum/2,a,b,将a,换成a+b，将a+b换成a
        R=random.random()
        if R>self.crossPro:
            return list1,list2
        print("交叉前："+str(list1)+';'+str(list2))
        a=random.randint(0,self.maxNum-3)
        print("begin:"+str(a))
        #随机产生两个随机数，然后对两个数之间的片段进行交换
        for i in range(3):
            temp1=list1[a+i]
            temp2=list2[a+i]
            list1[a+i]=temp2
            list2[a+i]=temp1
    #         进行交叉互换后对结果进行处理
            for j in range(len(list1)):
                if list1[j]==list1[a+i] and j!=a+i:
                    print("list1[j]"+str(j)+str(list1[j])+str(temp2)+str(temp1))
                    list1[j]=temp1
                if list2[j]==list2[a+i] and j!=a+i:
                    list2[j]=temp2
        print("交叉后：" + str(list1) + ';' + str(list2))
        return list1,list2


    def solve(self):
        #当种群稳定是结束
        judge=False
        while not judge:
            answer,judge=self.judge()
#        如果种群不稳定，进行遗传演变
            self.individualFitness()
            #选择最前面两个进行交叉变异，将最后产生的结果把最后两个换掉
            new11,new12=self.crossoveVariation(self.population[0],self.population[1])
            new21,new22=self.variation(new11,new12)
            self.population[self.populationNum-1]=new21
            self.population[self.populationNum - 1] = new22
        print(answer)

if __name__ == '__main__':
    A=geneticTravel()
    print("1111:"+str(A.population))
    A.solve()