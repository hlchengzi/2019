# 这是一个解决问题1的类，里面有7个函数
# 1_init_()调用inputStudentGrade()初始化学生成绩数组
# QuickSort(self,myList, start, end)利用快排，对学生成绩列表进行排序
# inputStudentGrade(self)输入学生信息，对学生信息进行错误检查
#Statistics（）统计平均分，40分以上的人，最高分，最低分
# coutPartNum(self)计算每个成绩分段的人并返回
# 后面两个分别是画图，垂直和竖直，最后加上统计信息
import random
class part_1():
    # 初始化学生自己数组
    def __init__(self):
        # self.studentGrade=self.inputStudentGrade()
        self.studentGrade = [random.randint(0, 100) for _ in range(96)]
    # 利用快排对学生成绩进行排序，快排运用了分治的思想
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
    def inputStudentGrade(self):
        # print("input student number：",end='')
        # while True:
        #     studentNum = input()
        #     if studentNum.isdigit():
        #         break
        #     else:
        #         print("input not integer,please input again：",end='')
        studentScore=[]
        i=0
        # for i in range(int(studentNum)):
        while True:
            print("please input the %dth student score:" % (i + 1), end='')
            score=input()
            if self.func(score):
                if int(score)>100:
                    print("the %d scare > 100,please input again："%(i+1),end='')
                elif int(score)>=0:
                    studentScore.append(int(score))
                    i+= 1
                    # 表示输入了结果
                else:
                    break
            else:
                print("input not integer,please input again:",end='')
        return studentScore
    # 判断输入的是不是数字
    def func(self,z):
        try:
            z=int(z)
            return isinstance(z,int)
        except ValueError:
            return False
    def  Statistics(self):
        print(" Average Mark："+str(sum(self.studentGrade)/len(self.studentGrade)))
        num40=0
        for i in range(len(self.studentGrade)):
            if self.studentGrade[i]>=40:
                num40+=1
        print(" Pass Mark ："+str(num40))
        print(" pass Mark ："+str(self.studentGrade[len(self.studentGrade)-1]))
        print(" Lowest Mark："+str(self.studentGrade[0]))
        print('')

    # 计算会有每个分数段会有多少人，返回每个分数段的人数
    def coutPartNum(self):
        grade1 = grade2 = grade3 = grade4 = 0
        self.QuickSort(self.studentGrade, 0, len(self.studentGrade) - 1)
        for i in range(len(self.studentGrade)):
            if self.studentGrade[i] < 30:
                grade1 += 1
            elif self.studentGrade[i] < 40:
                grade2 += 1
            elif self.studentGrade[i] < 70:
                grade3 += 1
            else:
                grade4 += 1
        return grade1,grade2,grade3,grade4

    # 绘制水平直方分布图
    def drawFlowChart1(self):
        # 在画图前先将学生成绩排序
        grade1,grade2,grade3,grade4=self.coutPartNum()
        print('')
        print("  Student  histogram")
        print("gradeategories    numStudent")
        #使用
        print("  0-29  :" +'        ',end='')
        for i in range(int(grade1)):
            print(" *",end='')
        print('')
        print(" 30-39  :" +'        ',end='')
        for i in range(grade2):
            print(" *", end='')
        print('')
        print(" 40-69  :"+'        ',end='')
        for i in range(grade3):
            print(" *", end='')
        print('')
        print(" 70-100 :"+'        ',end='')
        for i in range(grade4):
            print(" *", end='')
        print('')
        print('')
        self.Statistics()

    # 绘制竖直直方分布图
    def drawFlowChart2(self):
        grade1, grade2, grade3, grade4 = self.coutPartNum()
        print('  Student  histogram')
        print("  0-29 "+" 30-39 "+" 40-69 "+" 70-100")

        while grade4>0 or grade3>0 or grade2>0 or grade1>0:
            if grade1>0:
                print("   *   ",end='')
            else:print("       ",end='')

            if grade2>0:
                print("   *   ",end='')
            else:print("       ",end='')

            if grade3>0:
                print("   *   ",end='')
            else:print("       ",end='')

            if grade4>0:
                print("   *   ",end='')
            else:print("       ",end='')

            print('')
            grade1-=1
            grade2-=1
            grade3-=1
            grade4-=1
        print('')
        self.Statistics()



# textStudengGrade=[random.randint(0,100)for _ in range(20) ]
# 初始化对象，经行学生成绩录入
text = part_1()
print(text.studentGrade)
#给成绩经行排序，并输出排序好以后的数组
text.QuickSort(text.studentGrade,0,len(text.studentGrade)-1)
print(text.studentGrade)
# 画表和统计信息
text.drawFlowChart1()
text.drawFlowChart2()