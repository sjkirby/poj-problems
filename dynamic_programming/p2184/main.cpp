#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;

int main()
{
	int n,s,f,mid=100000,j,dp[200001],out=0;
	bool exist[200001];
	memset (dp,0,sizeof(dp));
	memset (exist,0,sizeof(exist));
	
	//for (int i=0;i<200001;i++) exist[i]=0;
	exist[100000]=1;
	//freopen ("test.h","r",stdin);
	scanf("%i",&n);
	j=n;
	while (j--)
	{
		/*for (int i=0;i<200001;i++)
		{
			if (exist[i])
			{
				printf("Line %i %i exists value %i\n",n-j,i,dp[i]);
			}
		}
		*/
		scanf("%i%i",&s,&f);
		if (s<=0&&f<=0) continue;
		if(s<=0)
		{
			for (int i=0;i<200001;i++)
			{
				if (!exist[i]) continue;
				if (exist[i+s])
				{
					dp[i+s]=max(dp[i+s],dp[i]+f);
				}
				else 
				{
					exist[i+s]=1;
					dp[i+s]=dp[i]+f;
				}
			}
		}
		else
		{
			for (int i=200000;i>=0;i--)
			{
				if (!exist[i]) continue;
				if  (exist[i+s])
				{
					dp[i+s]=max(dp[i+s],dp[i]+f);
				}
				else 
				{
					exist[i+s]=1;
					dp[i+s]=dp[i]+f;
				}
			}
		}
	}
	for (int i=100000;i<200001;i++)
	{
		if(exist[i])
		{
			if (dp[i]>=0)
			{
				out=max(out,i-100000+dp[i]);
				//printf("%i exists value %i\n",i,dp[i]);
			}
		}
	}
	printf("%i\n",out);
}