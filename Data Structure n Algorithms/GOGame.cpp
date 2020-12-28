#include <stdio.h>
#include <iostream>
using namespace std;
int getWinner(char *path);
void readFile(char matrix[10][10], int &n, char *path);
void printMatrix(char matrix[10][10],int n);
void group(char matrix[10][10], int n, int i, int j, char chest ,bool &isDeath, int &count);
int countDeath(char matrix[10][10], int n, char chest);
int main(){
	getWinner("matrix-data.txt");
}

int getWinner(char *path){
	int size, xDeath, oDeath;
    char matrix[10][10];
    readFile(matrix, size, path);
    xDeath = countDeath(matrix,size,'X');
    oDeath = countDeath(matrix,size,'O');
    /*
	printMatrix(matrix, size);
	cout<<"x="<<xDeath<<" o="<<oDeath;
	*/
	if(xDeath>oDeath)
		return 1;
	if(xDeath<oDeath)
		return -1;
	return 0;

int countDeath(char matrix[10][10], int n, char chest){
	int sumDeath=0;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(matrix[i][j]==chest){
                bool isDeath = true;
                int count = 0;
				group(matrix,n,i,j,chest, isDeath, count);
				if(isDeath){
					sumDeath+=count;
				}
			}
        }
    }
    return sumDeath;
}

void group(char matrix[10][10], int n, int i, int j, char chest, bool &isDeath , int &count){
    matrix[i][j] = 'c';
    count++;
    if(i==0||i==n-1||j==0||j==n-1){
        isDeath=false;
    }
        if(matrix[i+1][j]==chest)
            group(matrix,n,i+1,j,chest, isDeath, count);
        if(matrix[i-1][j]==chest)
            group(matrix,n,i-1,j,chest, isDeath, count);
        if(matrix[i][j+1]==chest)
            group(matrix,n,i,j+1,chest, isDeath, count);
        if(matrix[i][j-1]==chest)
            group(matrix,n,i,j-1,chest, isDeath, count);
}

void readFile(char matrix[10][10], int &n, char *path){
    int i=0, j=0;
    FILE *f = fopen(path, "r");
    fscanf(f,"%d\n", &n);
    for(i=0 ; i<n ; i++){
        for( j=0 ; j<n ; ){
            char chest;
            fscanf(f,"%c",&chest);
            if(chest=='O' || chest=='X'){
                matrix[i][j]=chest;
                j++;
            }
        }
    }
}

void printMatrix(char matrix[10][10], int n){
    int i=0, j=0;
    cout<<"Size ="<<n<<"\n";
    for(i=0; i<n; i++){
        for(j=0; j<n; j++){
            cout<<matrix[i][j]<<" ";
        }
        cout<<"\n";
    }
}
