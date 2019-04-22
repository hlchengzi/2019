class works:

    def __init__(self,_runtime,_period):
        self.runtime = _runtime
        self.period = _period
# workA = works(10,20)

class LLF:
    # 初始化两个工作和对应的总时间
    def __init__(self,workA,workB,allRunTime):
        self.workA = works(workA.runtime,workA.period)         #  初始化A，B任务
        self.workB = works(workB.runtime,workB.period)
        self.runTime = allRunTime  #  表示总的运行时间
        self.time = 0              # 当前时间，每次加5


    def workLLF(self):
        flagA=False
        flagB=False
        mustTimeA=20
        mustTimeB=50
        nowRunTimeA = self.workA.runtime
        waitTimeA = mustTimeA - nowRunTimeA - self.time  # A 的松弛度
        nowRunTimeB = self.workB.runtime
        waitTimeB = mustTimeB - nowRunTimeB - self.time  # B 的松弛度
        # 5 是两个运行时间的最大公约数
        for i in range(int(self.runTime/5)): #每次时间加5，计算A，B任务是不是完成，每个20秒加A任务，每隔50秒加B任务
            # print(str(self.time) + "A: " + str(mustTimeA) + " " + str(nowRunTimeA) + " " + str(waitTimeA) + "B: " + str(
            #     mustTimeB) + " " + str(nowRunTimeB) + " " + str(waitTimeB))
            # 初始化A
            if(0 == self.time%20):
                mustTimeA =(int)(i/4)*20+20
                nowRunTimeA = self.workA.runtime
                waitTimeA = mustTimeA- nowRunTimeA-self.time  # A 的松弛度
            # 初始化B
            if (0 == self.time % 50):
                mustTimeB = (int)(i/10) * 50+50
                nowRunTimeB = self.workB.runtime
                waitTimeB = mustTimeB - nowRunTimeB - self.time  # B 的松弛度

            #每次运行时候，先看本次运行任务是不是完成，
            #比较没运行的两个松弛度。短的先运行

            # 表示两个都结束，都才开始的时候
            if waitTimeA>=10 and  waitTimeB>=25:
                print("都结束或者都开始")
                if(waitTimeA==10 and waitTimeB==25):
                    print("刚开始")
                    if(waitTimeA<=waitTimeB):
                    #如果A的松弛度低，A先执行
                        flagA=True
                        flagB=False
                    else:
                        flagA = False
                        flagB = True

            elif  waitTimeA>=10 or  waitTimeB>=25:
                print("两个中有一个在运行")
                if waitTimeA>=10:
                    print("A结束")
                    waitTimeA+=20
                    flagA=False
                    flagB = True
                else:
                    print("B结束")
                    waitTimeB+=50
                    flagA = True
                    flagB = False
            #表示两个都在执行过程当中
            else:
                print("两个都没结束")
                # 首先判断有没有等待时间为0的，有的话先执行
                if(0 == waitTimeA):
                    print("A的等待时间为0")
                    flagA = True
                    flagB =False
                elif (0 == waitTimeB):
                    print("B的等待时间为0")
                    flagB = True
                    flagA = False
                #表示现在是A在运行
            if (flagA):
                        nowRunTimeA -= 5
                        waitTimeA = mustTimeA - nowRunTimeA - self.time
                        flagA = True
                        flagB = False
            if (flagB):
                        nowRunTimeB -= 5
                        waitTimeB = mustTimeB - nowRunTimeB - self.time
                        flagB = True
                        flagA = False

            print(str(self.time) + "A: " + str(mustTimeA) + " " + str(nowRunTimeA) + " " + str(waitTimeA) + "B: " + str(
                mustTimeB) + " " + str(nowRunTimeB) + " " + str(waitTimeB))
            self.time += 5

    def printAB(self):
        print(self.workA.runtime)
        print(self.workB.runtime)
workA = works(10,20)
workB = works(25,50)
text = LLF(workA,workB,50)
# text.workLLF

