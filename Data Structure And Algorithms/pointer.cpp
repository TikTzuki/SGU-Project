#include <stdio.h>
#include <iostream>
using namespace std;
int main(){
    int p[10];
    cout<< p[0] << " " << &p[0] << "\n";
	for(int i=0; i<5; i++){
        p[i+1] = i;
        cout<< p[i+1] << " " << &p[i+1] <<"\n";
    }
    cout<< p[0] << " " << &p[0] << "\n";
    cout<< p[10] << " " << &p[10] << "\n";
    cout<< p[11] << " " << &p[11] << "\n";
    cout<< p[12] << " " << &p[12] << "\n";
}
