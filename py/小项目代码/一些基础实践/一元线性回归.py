import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn import datasets, linear_model
from sklearn.metrics import mean_squared_error, r2_score
from sklearn.model_selection import train_test_split

women = pd.read_csv('C:\\Users\\HuZhanPeng\\Desktop\\Regression\\women.csv')
women.head()

X = women[['height']] # 注意这种写法，得到的X仍然是dataframe类型
y = women['weight'].values # 得到的y是numpy.ndarray类型

%pylab inline
plt.scatter(X, y, color='black')
plt.xlabel('height')
plt.ylabel('weight')

regr = linear_model.LinearRegression()
regr.fit(X, y)

print('Intercept:{}'.format(regr.intercept_))
print('Coefficient:{}'.format(regr.coef_))

plt.scatter(X, y, color='black')
plt.plot(X, regr.predict(X), linewidth=3, color='blue')
plt.xlabel('height')
plt.ylabel('weight')