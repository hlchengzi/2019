import copy
import numpy as np
# 定义最大代价
infinity = float('inf')
class Problem(object):
    def __init__(self, initial, goal=None):
        self.initial = initial
        self.goal = goal

    def actions(self, state):
        raise NotImplementedError

    def result(self, state, action):
        raise NotImplementedError

    def goal_test(self, node):
        return (node.state.board == self.goal.board)

    def path_cost(self, c, state1, action, state2):
        return c + 1

    def value(self, state):
        raise NotImplementedError


class PuzzleProblem(Problem):
    def __init__(self, initial=None, goal=None):
        Problem.__init__(self, initial, goal)
        self.state = initial
        self.goal = goal

    def actions(self, state):
        x, y = state.location(0)
        # 空格在边缘时减少活动
        action = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        if (x == 0):
            action.remove((-1, 0))
        if (x == 2):
            action.remove((1, 0))
        if (y == 0):
            action.remove((0, -1))
        if (y == 2):
            action.remove((0, 1))
        return list(action)

    def result(self, state, action):
        # 返回移动空格后的棋盘
        x, y = state.location(0)
        a, b = action
        n = state.board[x + a][y + b]
        s = copy.deepcopy(state)
        s.board[x + a][y + b] = 0
        s.board[x][y] = n
        return s

    def path_cost(self, node):
        # 展开子节点cost+1
        return node.path_cost + 1

    def h(self, now):
        # 当前棋盘每个格到目标棋盘的距离的平方和
        if now.state or self.goal:
            return now.state.distance(self.goal)
        else:
            return infinity


class Node:
    def __init__(self, state, parent=None, action=None, path_cost=0):
        self.state = state
        self.parent = parent
        self.action = action
        self.path_cost = path_cost
        self.fvalue = 0
        self.depth = 0
        if parent:
            self.depth = parent.depth + 1

    def __repr__(self):
        return "<Node {}>".format(self.state.board)

    def __lt__(self, node):
        # <运算符 队列排序使用
        return self.fvalue < node.fvalue

    def expand(self, problem):
        # 展开子节点
        l = []
        for action in problem.actions(self.state):
            n = self.child_node(problem, action)
            l.append(n)
        return l

    def child_node(self, problem, action):
        next = problem.result(self.state, action)
        return Node(next, self, action, problem.path_cost(self))

    def solution(self):
        return self.path()

    def printsolution(self):
        l = self.path()
        print("selution：")
        for x in range(len(l) - 1, -1, -1):
            print(" ↓")
            l[x].state.display()

    def path(self):
        # 返回父节点路径list
        node, path_back = self, []
        while node:
            path_back.append(node)
            node = node.parent
        return path_back

    def __eq__(self, other):
        # ==运算符
        return isinstance(other, Node) and self.state.board == other.state.board

    def __hash__(self):
        # not in 使用 比较对象Node
        board = self.state.board
        sum = 0
        for x in range(0, 3):
            for y in range(0, 3):
                number = board[x][y]
                sum = sum * 10 + number
        return sum


class GameState:
    def __init__(self, board=None, action=None):
        self.board = board
        self.action = action

    def display(state):
        board = state.board
        if board:
            for x in range(0, 3):
                for y in range(0, 3):
                    print(board[x][y], end=' ')
                print()

    def location(state, number):
        # 数字对应坐标
        for x in range(0, 3):
            for y in range(0, 3):
                if state.board[x][y] == number:
                    return (x, y)
        return (0, 0)

    def distance(statea, stateb):
        # 棋盘的距离
        board = statea.board
        s = 0
        for x in range(0, 3):
            for y in range(0, 3):
                number = board[x][y]
                a, b = stateb.location(number)
                d = (x - a) ** 2 + (y - b) ** 2
                s = s + d
        return s


"""Provides some utilities widely used by other modules"""

import bisect


class Queue:

    def __init__(self):
        raise NotImplementedError

    def extend(self, items):
        for item in items:
            self.append(item)


class PriorityQueue(Queue):

    def __init__(self, order=min, f=lambda x: x):
        self.A = []
        self.order = order
        self.f = f

    # 按顺序插入,按f（x）从小到大
    def append(self, item):
        item.fvalue = self.f(item)
        bisect.insort(self.A, item)
        # print("push")
        # item.state.display()

    def __len__(self):
        return len(self.A)

    # order=min输出最小 否则输出最大
    def pop(self):
        if self.order == min:
            return self.A.pop(0)
        else:
            return self.A.pop()

    def __contains__(self, item):
        return any(item.state.board == pair.state.board for pair in self.A)

    def __getitem__(self, key):
        for item in self.A:
            if item == key:
                return item

    def __delitem__(self, key):
        for item in enumerate(self.A):
            if item == key:
                self.A.pop(item)

def best_first_graph_search(problem, f):
    # 定义初始节点
    node = Node(problem.initial)
    node.fvalue = f(node)
    # 如果是最终结果，返回节点
    if problem.goal_test(node):
        return node
    # frotier是一个顺序队列，从小到大排列，排列比较通过f函数
    # 如果order是min，最小的先出队
    frontier = PriorityQueue(min, f)
    # 加入节点
    frontier.append(node)
    # print(node.fvalue)
    # 展开的节点
    explored = set()
    # 当栈不为空
    while frontier:
        # 节点出队
        node = frontier.pop()
        # print("pop")
        # node.state.display()
        # print(node.fvalue)
        # 如果是最终结果，返回节点
        if problem.goal_test(node):
            return node
        # 加入展开的节点
        explored.add(node)
        # 对于出栈的子节点
        for child in node.expand(problem):
            # 如果节点没有展开，并且子节点没在队中
            if child not in explored and child not in frontier:
                # 子节点入队
                frontier.append(child)
                # print(child.fvalue)
                # 如果子节点在队中
            elif child in frontier:
                incumbent = frontier[child]
                # 如果子节点的f值小于队中节点的f值
                if f(child) < f(incumbent):
                    # 删除栈中的节点，子节点入队
                    del frontier[incumbent]
                    frontier.append(child)
                    # print("change fvalue",child.state.display(),child.fvalue)
    return None


# a*算法 f=g+h
def astar_search(problem, h=None):
    h = problem.h
    return best_first_graph_search(problem, lambda n: h(n) + n.path_cost)

goal = GameState([[1,2,3],[8,0,4],[7,6,5]])
start = GameState([[2, 0, 3, ],
                   [8, 1,4, ],
                   [7, 6, 5]])
goal.action = PuzzleProblem().actions(goal)
start.action = PuzzleProblem().actions(start)
p = PuzzleProblem(start, goal)
result = astar_search(p)
result.printsolution()
