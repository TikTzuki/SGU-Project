#include <iostream>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
using namespace std;
void xuatMaTran(int a[][50], int m, int n);
int main(){
    int arr[50][50];
    int N=9;
    int firstCol = N/2;
    arr[0][firstCol] = 1;

    int col = firstCol;
    int row = 0;
    
    for(int i = 2; i<=N*N ; i++){
        //di len o phia tren ben phai
        row --;
        col ++;
        if(row < 0)
            row = N-1;
        if(row > N-1)
            row = 0;
        if(col > N-1)
            col = 0;
        //Truong hop arr[i][j] da duoc dien:
        if(arr[row][col]!=0){
            //quay lai o truoc do
            row++;
            col--;
            if(row > N-1)
                row = 0;
            if(col < 0)
                col = N-1;
            //di xuong o duoi
            row++;
            if(row>N-1)
                row = 0;
            //gan gia tri i vao o nay
            arr[row][col] = i;
            continue;
        }

        //Truong hop arr[i][j] chua duoc dien:
        arr[row][col] = i;
    }

    xuatMaTran(arr, N, N);
}

void xuatMaTran(int a[][50], int m, int n)
{
   for(int i = 0; i < m; i++)
   {
      for(int j = 0; j < n; j++)
         printf("%d\t", a[i][j]);
      printf("\n");
   }
}