import argparse
import numpy as np

parser = argparse.ArgumentParser(description="print what you input?")
parser.add_argument("echo")
parser.add_argument("echo1")
parser.add_argument("echo2")
args = parser.parse_args()
print(args.echo)
print(args.echo1)
print(args.echo2)
def matrix_factorization(R, P, Q, K, steps=5000, alpha=0.0002, beta=0.02):  #（迭代次数5000、步长，正则化系数）
    Q = Q.T
    for step in range(steps):
        for i in range(len(R)):
            for j in range(len(R[i])):
                if R[i][j] > 0:
                    eij = R[i][j] - np.dot(P[i,:],Q[:,j])
                    for k in range(K):
                        P[i][k] = P[i][k] + alpha * (2 * eij * Q[k][j] - beta * P[i][k])
                        Q[k][j] = Q[k][j] + alpha * (2 * eij * P[i][k] - beta * Q[k][j])
        eR = np.dot(P,Q)
        e = 0
        for i in range(len(R)):
            for j in range(len(R[i])):
                if R[i][j] > 0:
                    e = e + pow(R[i][j] - np.dot(P[i,:],Q[:,j]), 2)
                    for k in range(K):
                        e = e + (beta/2) * (pow(P[i][k],2) + pow(Q[k][j],2))
        if e < 0.001:
            break
    return P, Q.T

R = [
    [5, 3, 0, 1],
    [4, 0, 3, 1],
    [1, 1, 0, 5],
    [1, 0, 0, 4],
    [0, 1, 5, 4],
    ]
R = np.array(R)
N = len(R)      #表示行数， 物品数量
M = len(R[0])   #表示列数， 用户数量
print(str(M)+str(N))
K = 2  #两个因子
P = np.random.rand(N,K)
Q = np.random.rand(M,K)

nP, nQ = matrix_factorization(R, P, Q, K)
nR = np.dot(nP, nQ.T)

print(nP)
print("-----------------------------")
print(nQ)
print("-----------------------------")
print(nR)
print("-----------------------------")
print(R)
