#include <iostream>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
using namespace std;

typedef struct tagNode{
    int data;
    tagNode* next;
} *Node;
typedef struct tagLig{
    Node font;
    Node rear;
} SLL;
void initSLL(SLL &list){
    list.font=list.rear=NULL;
}
int isEmpty(SLL list){
    if(list.font==NULL) return 1;
    return 0;
}
int adToHead(SLL &list, int data){
    Node p = new tagNode;
    if(!p) return 0;
    p->data=data;
    p->next=NULL;
    if(isEmpty(list)){
        list.font=list.rear=p;
    }
    p->next=list.font;
    list.font=p;
    return 1;
}
