#include <stdio.h>

int main(){
	int i = 1;
	char c = 0;
	int acc=0;
	
	while(c=getchar()){
		if(c==EOF || c == '#') break;
		if(c=='\n'){
			printf("%i\n",acc);
			i=1;
			acc=0;
			continue;
		}
		if(c==' '){
			i++;
			continue;
		}
			
		acc+=(c-'A'+1)*i;
		i++;
	}
	//printf("%d\n",acc);
}