#get_ipython().run_line_magic('matplotlib', 'inline')
import matplotlib.pylab as plt
import numpy as np
from sklearn import datasets

class LinearRegression():
    def __init__(self):
        self.w = None

    def fit(self, X, y):
        # Insert constant ones for bias weights
        print("first:", X.shape)
        # 在第0项，插入 1，让x0项为1
        X = np.insert(X, 0, 1, axis=1)
        print("second:", X.shape)
        # inv(): 对当前值取逆， dot()：矩阵计算
        X_ = np.linalg.inv(X.T.dot(X))
        # 算出来 最好的 一组参数 theta
        self.w = X_.dot(X.T).dot(y)

    def predict(self, X):
        # Insert constant ones for bias weights
        X = np.insert(X, 0, 1, axis=1)
        y_pred = X.dot(self.w)
        return y_pred



def mean_squared_error(y_true, y_pred):
    mse = np.mean(np.power(y_true - y_pred, 2))
    return mse



def main():
    # load the diabetes dataset
    diabetes = datasets.load_diabetes()

    # Use only one feature
    X = diabetes.data[:, np.newaxis, 2]
    print(X.shape)
    # split the data into training/testing sets
    x_train, x_test = X[:-20], X[-20:]

    # Split the targets into training/testing sets
    y_train, y_test = diabetes.target[:-20], diabetes.target[-20:]

    clf = LinearRegression()
    clf.fit(x_train, y_train)
    y_pred = clf.predict(x_test)

    # Print the mean squared error
    print("Mean Squared Error:", mean_squared_error(y_test, y_pred))

    # Plot the results
    plt.scatter(x_test[:, 0], y_test, color='black')
    plt.plot(x_test[:, 0], y_pred, color="blue", linewidth=3)
    plt.show()


main()