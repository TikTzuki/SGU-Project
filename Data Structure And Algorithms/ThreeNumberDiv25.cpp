#include <iostream>
#include <cmath>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

using namespace std;
int *genNumbers(int N);
void printNumber(int *a, int N);
void printArray(int *a, int n);
int random(int minN, int maxN);
int partition(int *&arr, int start, int end);
int quickSort(int *&arr, int start, int end);
int swap(int *&Array, int index1, int index2);
int main()
{

    srand((int)time(0));
    int n;
    cout << "Nhap n \n";
    cin >> n;
    int *a = genNumbers(n);
    printNumber(a, n);
}
int *genNumbers(int n)
{
    int *array = new int[n];
    for (int i = 0; i < n; i++)
    {
        array[i] = random(0, 49);
    }
    return array;
}
void printNumber(int *a, int n)
{
    int *trilogy = new int[3];
    //sap xep lai mang a tu nho den lon;
    quickSort(a, 0, n - 1);
    //
    for (int i = 0; i < n; i++)
    {
        trilogy[0] = a[i];
        for (int j = i + 1; j < n; j++)
        {
            trilogy[1] = a[j];
            for (int k = j + 1; k < n; k++)
            {
                trilogy[2] = a[k];
                if ((trilogy[0] + trilogy[1] + trilogy[2]) % 25 == 0)
                    printArray(trilogy, 3);
            }
        }
    }
}

void printArray(int *a, int n)
{
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    cout << "\n";
}

int random(int minN, int maxN)
{
    return minN + rand() % (maxN + 1 - minN);
}

//sort
int partition(int *&arr, int start, int end)
{
    int left = start, right = end - 1, pivot = end;
    while (true)
    {
        while (left <= right && arr[left] <= arr[pivot])
            left++;
        while (right >= left && arr[right] >= arr[pivot])
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

int quickSort(int *&arr, int start, int end)
{
    if (start < end)
    {
        int pi = partition(arr, start, end);
        quickSort(arr, start, pi - 1);
        quickSort(arr, pi + 1, end);
    }
    return 0;
}

int swap(int *&Array, int index1, int index2)
{
    int temp = Array[index1];
    Array[index1] = Array[index2];
    Array[index2] = temp;
    return 0;
}