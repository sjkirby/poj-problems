#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int max(int x, int y){
  if (x>y){
    return x;
  }
  return y;
}

int nums[1010];
int maxi[1010];

void reset(){
	memset(nums,10001,sizeof(int)*1010);
  memset(maxi,0,sizeof(int)*1010);
}

int greatest(int m,int num){
  int out = 0;
  int i = 0;
  for(i = 0;i<m;i++){
    if(nums[i]<num){
      if(maxi[i]>out){
        out = maxi[i];
      }
    }
  }
  return out+1;
}

int main(){
  reset();
  int i=0;
  int n=0;
  int in = 0;
  scanf("%i",&n);
  while(i!=n){
    scanf("%i",&nums[i]);
    i++;
  }
  for (i=0;i<n;i++){
    maxi[i]=greatest(i,nums[i]);
  }
  int mym=0;
  for (i=0;i<n;i++){
    mym = max (mym, maxi[i]);
  }
  printf("%i\n",mym);
}