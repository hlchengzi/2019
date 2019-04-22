# class work():
#     def __init__(self,A,B):
#         self.workLocation=A
#         self.startTime=B
# A=[]
# for i in range(10):
#     temp=work()
class Os6():
    def __init__(self,list1):
        self.workList=list1
        self.startLocation=100
        self.allNum=0
    def FCFS(self):
        print("FCFS")
        self.allNum=0
        nowLoaction=self.startLocation
        nextLoaction=self.workList[0]
        print("下一个要访问的磁道"+"移动距离")
        for i in range(len(self.workList)):
            dis=abs(nextLoaction-nowLoaction)
            self.allNum+=dis
            print(str(self.workList[i])+"       "+str(dis))
            if i<len(self.workList)-1:
                nowLoaction=self.workList[i]
                nextLoaction=self.workList[i+1]
        print("平均寻道长度："+str(self.allNum/len(self.workList)))
    #     下一个要移动的是到当前位置最近的
    def outshow(self,goalList):
        self.allNum = 0
        nowLoaction1 = self.startLocation
        nextLoaction1 = goalList[0]
        for i in range(len(goalList)):
            dis = abs(nextLoaction1 - nowLoaction1)
            self.allNum += dis
            print(str(goalList[i]) + "       " + str(dis))
            if i < len(goalList) - 1:
                nowLoaction1 = goalList[i]
                nextLoaction1 = goalList[i + 1]
        print("平均寻道长度：" + str(self.allNum / len(self.workList)))
    def QuickSort(self,myList, start, end):
        # 判断low是否小于high,如果为false,直接返回
        if start < end:
            i, j = start, end
            base = myList[i]
            while i < j:
                # 如果列表后边的数,比基准数大或相等,则前移一位直到有比基准数小的数出现
                while (i < j) and (myList[j] >= base):
                    j = j - 1
                # 如找到,则把第j个元素赋值给第个元素i,此时表中i,j个元素相等
                myList[i] = myList[j]
                # 同样的方式比较前半区
                while (i < j) and (myList[i] <= base):
                    i = i + 1
                myList[j] = myList[i]
            # 做完第一轮比较之后,列表被分成了两个半区,并且i=j,需要将这个数设置回base
            myList[i] = base

            # 递归前后半区
            self.QuickSort(myList, start, i - 1)
            self.QuickSort(myList, j + 1, end)
        return myList
    def SSTF(self):
        print("SSTF")
        self.allNum = 0
        tempList=self.workList
        goalList=[];
        nowLoaction = self.startLocation
        goali=0
        mindis = float("inf")
        for J in range(len(tempList)):
            for i in range(len(tempList)):
                if(tempList[i]!=float("inf") ):
                    dis=abs(nowLoaction-tempList[i])
                    if dis<mindis:
                        goali=i
                        mindis=dis
            goalList.append(self.workList[goali])
            nowLoaction=self.workList[goali]
            a=float("inf")
            tempList[goali] = a
            mindis = float("inf")
        print(goalList)

#         现在根据到
        self.outshow(goalList)

    def SCAN(self):
        print("SCAN")
#         循环算法：电梯调度算法
        nowLocation=self.startLocation
        # 先找到方向，然后找最近的，先排序，然后输出
        goalListTemp=self.workList
        self.QuickSort(goalListTemp,0,len(goalListTemp)-1)
        goalList=[]
        if self.startLocation<goalListTemp[0]:
            self.outshow(goalListTemp)
        elif self.startLocation>goalListTemp[len(goalListTemp)-1]:
            for i in range(len(goalListTemp)):
                goalList.append(goalListTemp[len(goalListTemp)-i-1])
            self.outshow(goalList)
        else:
            flat=0
            while goalListTemp[flat]<self.startLocation:
                flat+=1
            if abs(goalListTemp[flat]-self.startLocation)<abs(goalListTemp[flat+1]-self.startLocation):
                # 表示先向后方移动
                for i in goalListTemp[flat:len(goalListTemp)]:
                    goalList.append(i)
                for i in range(len(goalListTemp[0:flat])):
                    goalList.append(goalListTemp[len(goalListTemp[0:flat])-i-1])
            print(goalList)
            self.outshow(goalList)
    def CSCAN(self):
        print("CSCAN")
        nowLocation = self.startLocation
        # 先找到方向，然后找最近的，先排序，然后输出
        goalListTemp = self.workList
        self.QuickSort(goalListTemp, 0, len(goalListTemp) - 1)
        goalList = []
        if self.startLocation < goalListTemp[0]:
            self.outshow(goalListTemp)
        elif self.startLocation > goalListTemp[len(goalListTemp) - 1]:
            for i in range(len(goalListTemp)):
                goalList.append(goalListTemp[len(goalListTemp) - i - 1])
            self.outshow(goalList)
        else:
            flat = 0
            while goalListTemp[flat] < self.startLocation:
                flat += 1
            if abs(goalListTemp[flat] - self.startLocation) < abs(goalListTemp[flat + 1] - self.startLocation):
                # 表示先向后方移动
                for i in goalListTemp[flat:len(goalListTemp)]:
                    goalList.append(i)
                for i in goalListTemp[0:flat]:
                    goalList.append(i)
            print(goalList)
            self.outshow(goalList)
listText1=[55,58,39,18,90,160,150,38,184]
listText2=[55,58,39,18,90,160,150,38,184]
listText3=[55,58,39,18,90,160,150,38,184]
listText4=[55,58,39,18,90,160,150,38,184]
A=Os6(listText1)
A.FCFS()
B=Os6(listText2)
B.SSTF()
C=Os6(listText3)
C.SCAN()
D=Os6(listText4)
D.CSCAN()
