
#include <iostream>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
using namespace std;
struct myArray
{
  int *a;
  int num;
};
int initArray(myArray &Array)
{
  Array.a = 0;
  Array.num = 0;
  return 0;
}
myArray readFile(char *path)
{
  FILE *fp = fopen(path, "rt");
  myArray arr;
  initArray(arr);
  fscanf(fp, "%d", &arr.num);
  arr.a = new int[arr.num];
  for (int i = 0; i < arr.num; i++)
  {
    fscanf(fp, "%d ", &arr.a[i]);
  }
  fclose(fp);
  return arr;
}

int writeFile(myArray &Array, char *path)
{
  FILE *fp = fopen(path, "w");
  fprintf(fp, "%d\n", Array.num);
  for (int i = 0; i < Array.num; i++)
  {
    fprintf(fp, "%d ", Array.a[i]);
  }
  fclose(fp);
  return 0;
}
int printArray(myArray Array)
{
  for (int i = 0; i < Array.num; i++)
  {
    printf("%d ", Array.a[i]);
  }
}

int swap(myArray Array, int index1, int index2)
{
  int temp = Array.a[index1];
  Array.a[index1] = Array.a[index2];
  Array.a[index2] = temp;
  return 0;
}
int swap(int array[], int index1, int index2)
{
  int temp = array[index1];
  array[index1] = array[index2];
  array[index2] = temp;
  return 0;
}

int interchangeSort(int arr[], int n)
{
  int i, j;
  for (i = 0; i < n - 1; i++)
    for (j = i + 1; j < n; j++)
      if (arr[i] > arr[j])
        swap(arr, i, j);

  return 0;
}

int bubbleSort(int arr[], int n) // nhẹ nổi lên
{ 
  int i, j;
  for (i = 0; i < n - 1; i++)
    for (j = n - 1; j > i; j--)
      if (arr[j - 1] < arr[i])
        swap(arr, j - 1, j);
  return 0;
}

int insertSort(myArray arr)
{
  int temp, j;
  for (int i = 1; i < arr.num; i++)
  {
    temp = arr.a[i];
    j = i - 1;
    while (j >= 0 && arr.a[j] > temp)
    {
      swap(arr, j, j + 1);
      j--;
    }
    //arr.a[j+1]=temp;
    if (arr.a[j + 1] == temp)
    {
      printf("WTF ");
    }
  }
  return 0;
}

int selectionSort(myArray arr)
{
  int min;
  for (int i = 0; i < arr.num; i++)
  {
    for (int j = i; j < arr.num; j++)
    {
      min = i;
      if (arr.a[j] < arr.a[min])
      {
        min = j;
      }
      if (min != i)
        swap(arr, min, i);
    }
  }
  return 0;
}
int heapIFY(myArray arr, int n, int i)
{
  int root = i;
  int l = i * 2 + 1, r = i * 2 + 2;

  if (arr.a[root] < arr.a[l] && l < n)
    root = l;
  if (arr.a[root] < arr.a[r] && r < n)
    root = r;

  if (root != i)
  {
    swap(arr, root, i);
    heapIFY(arr, n, root);
  }
}

int heapSort(myArray arr)
{
  for (int i = arr.num / 2 - 1; i >= 0; i--)
  {
    heapIFY(arr, arr.num, i);
  }

  for (int i = arr.num - 1; i >= 0; i--)
  {
    swap(arr, 0, i);
    heapIFY(arr, i, 0);
  }
  return 0;
}

int partition(myArray arr, int start, int end)
{
  int left = start, right = end - 1, pivot = end;
  while (true)
  {
    while (left <= right && arr.a[left] <= arr.a[pivot])
      left++;
    while (right >= left && arr.a[right] >= arr.a[pivot])
      right--;
    if (left > right)
      break;
    swap(arr, left, right);
    left++;
    right--;
  }
  swap(arr, left, pivot);
  return left; //Tra ve chi so chia doi mang
}

int quickSort(myArray arr, int start, int end)
{
  if (start < end)
  {
    int pi = partition(arr, start, end);
    quickSort(arr, start, pi - 1);
    quickSort(arr, pi + 1, end);
  }
  return 0;
}
int main()
{
  /*
  char fileIn[] = "F:/GitHub/Data-Structures-and-Algorithms/arrIn.txt", fileOut[] = "F:/GitHub/Data-Structures-and-Algorithms/arrOut.txt";
  char *pathIn = fileIn, *pathOut = fileOut;
  myArray a;
  initArray(a);
  a = readFile(pathIn);
  insertSort(a);
  printArray(a);
  writeFile(a, pathOut);*/
  int n = 1;
  n=(float)n;
  //float m = (float) n;
  printf("%f",n);
}
