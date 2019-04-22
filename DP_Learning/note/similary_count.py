# coding=utf-8

from math import sqrt
import pandas as pd
import tqdm

# line = [user,source,item,lable]
users = {}
users_list = list()
path = 'C:...'
for line in open(path + "..."):
    lines = line.strip().split(",")
    if lines[0] not in users_list:
        users_list.append(lines[0])
    if lines[0] not in users:
        users[lines[0]] = {}
    users[lines[0]][lines[2]] = float(float(lines[1]) + 100)


class recommender:
    # data：数据集，这里指users
    # k：表示得出最相近的k的近邻
    # metric：表示使用计算相似度的方法
    # n：表示推荐book的个数
    def __init__(self, data, k=3, metric='pearson', n=12):

        self.k = k
        self.n = n
        self.username2id = {}
        self.userid2name = {}
        self.productid2name = {}

        self.metric = metric
        if self.metric == 'pearson':
            self.fn = self.pearson
        if type(data).__name__ == 'dict':
            self.data = data

    def convertProductID2name(self, id):

        if id in self.productid2name:
            return self.productid2name[id]
        else:
            return id

    # 定义的计算相似度的公式，用的是皮尔逊相关系数计算方法
    def pearson(self, rating1, rating2):
        sum_xy = 0
        sum_x = 0
        sum_y = 0
        sum_x2 = 0
        sum_y2 = 0
        n = 0
        for key in rating1:
            if key in rating2:
                n += 1
                x = rating1[key]
                y = rating2[key]
                sum_xy += x * y
                sum_x += x
                sum_y += y
                sum_x2 += pow(x, 2)
                sum_y2 += pow(y, 2)
        if n == 0:
            return 0

        # 皮尔逊相关系数计算公式
        denominator = sqrt(sum_x2 - pow(sum_x, 2) / n) * sqrt(sum_y2 - pow(sum_y, 2) / n)
        if denominator == 0:
            return 0
        else:
            return (sum_xy - (sum_x * sum_y) / n) / denominator

    def computeNearestNeighbor(self, username):
        distances = []
        for instance in self.data:
            if instance != username:
                distance = self.fn(self.data[username], self.data[instance])
                distances.append((instance, distance))

        distances.sort(key=lambda artistTuple: artistTuple[1], reverse=True)
        return distances

    # 推荐算法的主体函数
    def recommend(self, user):
        # 定义一个字典，用来存储推荐的标签和兴趣度
        recommendations = {}
        # 计算出user与所有其他用户的相似度，返回一个list
        nearest = self.computeNearestNeighbor(user)
        userRatings = self.data[user]
        totalDistance = 0.0
        # 得住最近的k个近邻的总距离
        for i in range(self.k):
            totalDistance += nearest[i][1]
        if totalDistance == 0.0:
            totalDistance = 1.0
        # 将与user最相近的k个人中user没有看过的书推荐给user，并且这里又做了一个分数的计算排名
        for i in range(self.k):
            # 第i个人的与user的相似度，转换到[0,1]之间
            weight = nearest[i][1] / totalDistance
            # 第i个人的name
            name = nearest[i][0]
            # 第i个用户看过的书和相应的打分
            neighborRatings = self.data[name]

            for artist in neighborRatings:
                if not artist in userRatings:
                    if artist not in recommendations:
                        recommendations[artist] = (neighborRatings[artist] * weight)
                    else:
                        recommendations[artist] = (recommendations[artist] + neighborRatings[artist] * weight)

        recommendations = list(recommendations.items())
        recommendations = [(self.convertProductID2name(id1), v) for (id1, v) in recommendations]

        # 做了一个排序
        recommendations.sort(key=lambda artistTuple: artistTuple[1], reverse=True)

        # return recommendations[:self.n], nearest

        return recommendations[:12], nearest


def adjustrecommend(users_list):
    print
    users_list
    # bookid_list = []
    r = recommender(users)
    itemsCF_list = pd.DataFrame(columns=['top1',
                                         'top2', 'top3', 'top4', 'top5', 'top6',
                                         'top7', 'top8', 'top9', 'top10', 'top11', 'top12',
                                         'nearuser1', 'nearuser2', 'nearuser3', 'nearuser4', 'nearuser5',
                                         'nearuser6', 'nearuser7', 'nearuser8', 'nearuser9', 'nearuser10'], index=None)
    for u in range(len(users_list)):
        # for u in range(1):
        bookid_list = []
        k, nearuser = r.recommend(users_list[u])
        for i in range(len(k)):
            bookid_list.append(k[i][0])
        print
        bookid_list
        if len(bookid_list) == 12:
            bookid_list = bookid_list
        else:
            n = 12 - len(bookid_list)
            for i in range(n):
                bookid_list.append(None)
        nearuser = nearuser[:10]
        if len(nearuser) == 10:
            nearuser = nearuser[:10]
        else:
            n = 10 - len(nearuser)
            for i in range(n):
                nearuser.append(None)
        rows = {'box_id': users_list[u],
                'top1': bookid_list[0],
                'top2': bookid_list[1],
                'top3': bookid_list[2],
                'top4': bookid_list[3],
                'top5': bookid_list[4],
                'top6': bookid_list[5],
                'top7': bookid_list[6],
                'top8': bookid_list[7],
                'top9': bookid_list[8],
                'top10': bookid_list[9],
                'top11': bookid_list[10],
                'top12': bookid_list[11],
                'nearuser1': nearuser[0][0],
                'nearuser2': nearuser[1][0],
                'nearuser3': nearuser[2][0],
                'nearuser4': nearuser[3][0],
                'nearuser5': nearuser[4][0],
                'nearuser6': nearuser[5][0],
                'nearuser7': nearuser[6][0],
                'nearuser8': nearuser[7][0],
                'nearuser9': nearuser[8][0],
                'nearuser10': nearuser[9][0]}
        itemsCF_list = itemsCF_list.append(rows, ignore_index=True)
    return itemsCF_list
    # return bookid_list, nearuser[:15]  # bookid_list推荐书籍的id，nearuser[:15]最近邻的15个用户


def run_fun():
    userCF_list = adjustrecommend(users_list)
    print
    userCF_list.head(10)
    userCF_list.to_csv('C:...",
    index = False, mode = 'wb+')
    if __name__ == '__main__':
        import sys
        reload(sys)
        sys.setdefaultencoding('utf8')
        run_fun()

