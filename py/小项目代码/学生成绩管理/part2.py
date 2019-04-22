#不能使用ord()和chr()
#程序输入一个字符穿（暂时理解为小写字母）和一个旋转整数K(<0K<26)
def encoding():
    # 输入字符串和旋转整数
    inString=input("input encoding string:")
    while True:
        if inString.islower():
            break
        else:
            inString=input("not litter letter,please input again:")
    print("input thr rotation integer:")
    while True:
        inNumber = input()
        if inNumber.isdigit():
            if int(inNumber)== 0 or int(inNumber)>25:
                print("the number out of range,please input again:",end='')
            else:
                break
        else:
            print("not number,please input again:",end='')
    # 现在进行加密，构建一个字符数组(字符串)
    char26="abcdefghijklmnopqrstuvwxyz"
    # 现在按照字符串数组进行对照，进行编码加密
    encodingchar26=[]
    index=[]
    for i in range(len(char26)):
        encodingchar26.append(char26[(i+int(inNumber))%26])
    for i in range(len(inString)):
        j=0
        while not inString[i]==char26[j]:
            j+=1
        index.append(j)

    outstring = []
    for i in range(len(inString)):
        outstring.append(encodingchar26[index[i]])
    outstr=''.join(outstring)
    print("encoded is：",end='')
    print(outstr)
    return str(outstring)

def partB_decoding():
    while True:
        print('')
        print("e:encoding;  d:decoding;   q:quit")
        print("please input your choose：",end='')
        while True:
            choose = input()
            if choose.islower():
                if len(choose)>1:
                    print("only one letter!please input again:", end='')
                elif not (choose=='e'or choose=='d' or choose=='q'):
                    print("error letter,please input again:",end='')
                else:
                    break
            else:
                print("not letter,please input again:", end='')
        if choose=='e':
            encoding()
        elif choose=='d':
            decoding()
        elif choose=='q':
            return

# 解码输入的是一个要被解锁的，还有一个出现在密码文里面的单词
def decoding():
    print("decoding：")
    print("input decoding string:")
    inString1 = input()
    while True:
        if inString1.islower():
            break
        else:
            inString1 = input("not litter letter,please input again:")

    inString2 = input(" input decoding text string:")
    while True:
        if inString2.islower():
            break
        else:
            inString2 = input("not litter letter,please input again:")
    char26 = "abcdefghijklmnopqrstuvwxyz"
    index =[]
    K=[]
    index1=[]
    index2=[]
    for i in range(len(inString1)):
        j=0
        while not inString1[i]==char26[j]:
            j+=1
        index1.append(j)
    for i in range(len(inString2)):
        j=0
        while not inString2[i]==char26[j]:
            j+=1
        index2.append(j)

#     采用暴力求解,全部便利可能会存在多组解
    for i in range(len(inString1)-len(inString2)):
        # 挨着匹配，看存不存
        for j in range(len(inString2)-1):
            if not (index2[j]-index1[i+j])==(index2[j+1]-index1[i+j+1]):
                break
            if j==len(inString2)-2:
                index.append(i)
                K.append(index1[i]-index2[0]
                         )
    # 可能会有多种可能，全部输出
    if len(index)==0:
        print("not find")
    else:
        print("have %d possible"%len(index))
        for i in range(len(index)):
            print("start:"+str(index[i]))
            print(" rotation："+str(K[i]))
partB_decoding()