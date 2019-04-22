#include <iostream>
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<cmath>
#include<time.h>
using namespace std;

int expMechanism(int* score, int m, double epsilon, int sensitivity)
{
    double *exponents_list=new double[100];
    int i=0,j=0;
    double expo;
    double sum=0;
    double r;
    double sum_exp=0;

    for(i=0;i<m;i++)
    {
        expo = 0.5*(double)(score[i])*epsilon/sensitivity;
        exponents_list[i]=exp(expo);
    }
    for(i=0;i<m;i++)
    {
        sum=sum+exponents_list[i];
    }
    for(i=0;i<m;i++)
        exponents_list[i]=exponents_list[i]/sum;
    srand((int)time(0));
    r=((double)(rand()%100))/100;
    for(j=0;;j++)
    {
        sum_exp=sum_exp+exponents_list[j];
        if(sum_exp>r)
            break;
    }
    return j;
}

int main()
{
    int score[5] = {5,8,10,10,10}; //输入的各项评分
    double epsilon = 1.0;
    int sensitivity = 1;
    int m = sizeof(score)/sizeof(int);
    int result = expMechanism(score, m, epsilon, sensitivity);
    cout<<result<<endl; //输出项的序号
    return 0;
}
