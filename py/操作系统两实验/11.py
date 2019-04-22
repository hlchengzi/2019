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
        flagA=True
        flagB=False
        mustTimeA=20
        mustTimeB=50
        nowRunTimeA = self.workA.runtime
        waitTimeA = mustTimeA - nowRunTimeA - self.time  # A 的松弛度
        nowRunTimeB = self.workB.runtime
        waitTimeB = mustTimeB - nowRunTimeB - self.time  # B 的松弛度
        print(str(self.time) + "A: " + str(mustTimeA) + " " + str(nowRunTimeA) + " " + str(waitTimeA) + "B: " + str(
            mustTimeB) + " " + str(nowRunTimeB) + " " + str(waitTimeB))
        # 5 是两个运行时间的最大公约数
        for i in range(int(self.runTime/5)): #每次时间加5，计算A，B任务是不是完成，每个20秒加A任务，每隔50秒加B任务
            # print(str(self.time) + "A: " + str(mustTimeA) + " " + str(nowRunTimeA) + " " + str(waitTimeA) + "B: " + str(
            #     mustTimeB) + " " + str(nowRunTimeB) + " " + str(waitTimeB))
            # 初始化A
            if (0 == self.time % 20):
                mustTimeA = (int)(i / 4) * 20 + 20
                nowRunTimeA = self.workA.runtime
                waitTimeA = mustTimeA - nowRunTimeA - self.time  # A 的松弛度
                # 初始化B
            if (0 == self.time % 50):
                mustTimeB = (int)(i / 10) * 50 + 50
                nowRunTimeB = self.workB.runtime
                waitTimeB = mustTimeB - nowRunTimeB - self.time  # B 的松弛度


            self.time+=5
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
            if nowRunTimeA==5:
                mustTimeA=(int)(i / 4) * 20 + 40
                nowRunTimeA=10

workA = works(10,20)
workB = works(25,50)
text = LLF(workA,workB,50)
text.workLLF()