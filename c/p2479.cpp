#include <cstdio>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int a[50000],maxAsc[50000][2],maxDesc[50000][2];

int main()
{
	int cases, n, t, count, in,out;
	scanf("%i",&t);
	while(t--)
	{
		out=-999999;
		scanf("%i",&n);	
		count=0;
		while (n--)
		{
			scanf("%i",&in);
			a[count]=in;
			count++;
		}
		maxAsc[0][0]=a[0];
		maxAsc[0][1]=a[0];
		for (int i=1;i<count;i++)
		{
			maxAsc[i][0]=max(a[i],a[i]+maxAsc[i-1][0]);
			maxAsc[i][1]=max(maxAsc[i][0],maxAsc[i-1][1]);
		}
		maxDesc[count-1][0]=a[count-1];
		maxDesc[count-1][1]=a[count-1];
		for (int i=count-2;i>=0;i--)
		{
			maxDesc[i][0]=max(a[i],a[i]+maxDesc[i+1][0]);
			maxDesc[i][1]=max(maxDesc[i][0],maxDesc[i+1][1]);
		}
		for (int i=0;i<count-1;i++)
		{
			out=max(out, maxAsc[i][1]+maxDesc[i+1][1]);
		}
		printf("%i\n",out);
	}
}