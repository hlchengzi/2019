import pandas as pd
import matplotlib.pyplot as plt
import  numpy as np
from sklearn.linear_model import LogisticRegression

df_train = pd.read_csv('F:/BaiduNetdiskDownload/PythonML/Datasets/Breast-Cancer/breast-cancer-train.csv')
df_test = pd.read_csv('F:/BaiduNetdiskDownload/PythonML/Datasets/Breast-Cancer/breast-cancer-test.csv')
df_test_negative = df_test.loc[df_test['Type'] == 0 ][['Clump Thickness' , 'Cell Size']]
df_test_positive = df_test.loc[df_test['Type'] == 1 ][['Clump Thickness' , 'Cell Size']]

plt.scatter(df_test_negative['Clump Thickness'], df_test_negative['Cell Size'],marker='o',s=200,c='red')
plt.scatter(df_test_positive['Clump Thickness'], df_test_positive['Cell Size'],marker='x',s=150,c='black')
plt.xlabel('Clump Thickness')
plt.ylabel('Cell Size')
plt.show()

intercept = np.random.random([1])
coef = np.random.random([2])
lx = np.arange(1,12)
ly = (-intercept-lx * coef[0])/coef[1]
plt.plot(lx, ly, c='y')
#现在随机生成了一条直线

plt.scatter(df_test_negative['Clump Thickness'], df_test_negative['Cell Size'],marker='o',s=200,c='red')
plt.scatter(df_test_positive['Clump Thickness'], df_test_positive['Cell Size'],marker='x',s=150,c='black')
plt.xlabel('Clump Thickness')
plt.ylabel('Cell Size')
plt.show()

lr = LogisticRegression()

lr.fit(df_train[['Clump Thickness' , 'Cell Size']],df_train['Type'])
print(str(lr.score(df_test[['Clump Thickness' , 'Cell Size']],df_test['Type'])))
#通过样本里面的10个进行学习狭线形模型，得到正确率86.86%
intercept=lr.intercept_
coef=lr.coef_[0,:]
ly = (-intercept-lx * coef[0])/coef[1]
plt.plot(lx, ly, c='green')
plt.scatter(df_test_negative['Clump Thickness'], df_test_negative['Cell Size'],marker='o',s=200,c='red')
plt.scatter(df_test_positive['Clump Thickness'], df_test_positive['Cell Size'],marker='x',s=150,c='black')
plt.xlabel('Clump Thickness')
plt.ylabel('Cell Size')
plt.show()

lr = LogisticRegression()
