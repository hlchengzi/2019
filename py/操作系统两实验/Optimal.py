import numpy
class Optimal():
    def __init__(self):
        print("初始化")
        self.maxbrock=3
        self.memory=self.info()
        self.pageReady=[7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1]
    def info(self):
        temp=[]
        for i in range(self.maxbrock):
            temp.append(float("inf"))
        return temp
    def printMemory(self):
        for i in range(self.maxbrock):
            print(str(self.memory[i])+"  ",end='')
        print('')
    def judge(self,myList,num):
        for i in range(len(myList)):
            if myList[i] == num:
                return True
        return False
    def optimal1(self):
#         最佳置换算法，产生缺进程时，将内存当中最长时间不会访问的页面置换掉
        print("最佳置换算法")
        for i in range(len(self.pageReady)):
#             将进程装进内存里面，如果内存直接没满，直接加入，如果满了以后先判断页面是不是在内存里面先将不会再被使用的淘汰掉，没有的话就淘汰未来最长时间不会被访问的页淘汰掉
            if float("inf") in self.memory:
                for ii in range(self.maxbrock):
                    if float("inf")==self.memory[ii]:
                        self.memory[ii]=self.pageReady[i]
                        break
                self.printMemory()
            elif(self.judge(self.memory,self.pageReady[i])):
            #     如果里面存在的话直接打印
                self.printMemory()
            else:
#                 便利之后的数组,找到未来最长时间不会被访问的数据
                time=[float("inf"),float("inf"),float("inf")]
                for j in range(self.maxbrock):
                    for k in range(len(self.pageReady[i:len(self.pageReady)])):
                        k=k+i
                        if(self.memory[j]==self.pageReady[k]):
                            time[j]=k-i
                            break
#                将最大的那个移出去，将i加入
                max=0
                maxnum=[]
                for ii in range(self.maxbrock):
                    maxnum.append(0)
                for j in range(self.maxbrock):
                    for k in range(self.maxbrock):
                        if time[j]>=time[k]:
                            maxnum[j]+=1
                for ii in range(self.maxbrock):
                    if maxnum[ii]==self.maxbrock:
                        max=ii
                        break
                self.memory[ii]=self.pageReady[i]
                self.printMemory()
    def FIFO(self):
        print("FIFO:")
        for i in range(len(self.pageReady)):
            #             将进程装进内存里面，如果内存直接没满，直接加入，如果满了以后先判断页面是不是在内存里面先将不会再被使用的淘汰掉，没有的话就淘汰未来最长时间不会被访问的页淘汰掉
            if float("inf") in self.memory:
                for ii in range(self.maxbrock):
                    if float("inf") == self.memory[ii]:
                        self.memory[ii] = self.pageReady[i]
                        break
                self.printMemory()
            elif (self.judge(self.memory, self.pageReady[i])):
                #     如果里面存在的话直接打印
                self.printMemory()
            else:
                #                 便利之后的数组,找到未来最长时间不会被访问的数据
                qu=0
                k=0
                while k<len(self.pageReady[0:i]):
                    kk=0
                    while kk<len(self.memory):
                        if self.memory[kk]==self.pageReady[k]:
                            qu=kk
                            break;
                        else:
                            kk+=1
                    if self.memory[qu]==self.pageReady[k]:
                        break
                    k+=1

                #     j=0
                #     while j<3:
                #         if self.memory[j]== self.pageReady[k]:
                # #             表示找到了最先加入列表的这个
                #             qu = j
                #             print("text:"+str(qu)+','+str(self.pageReady[k])+','+str(self.memory[j]))
                #             break
                #         else:
                #             j+=1

                self.memory[qu]=self.pageReady[i]
                self.printMemory()


A=Optimal()
B=Optimal()
A.optimal1()
# B.FIFO()