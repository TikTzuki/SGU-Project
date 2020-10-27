
#include <iostream>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
using namespace std;

typedef struct tagNode{
    int data;
    tagNode *left;
    tagNode *right;
} *Node;
typedef struct BSTtree{
    Node root;
} BST;
void initBST(BST &tree){
    tree.root=NULL;
}
void LRN(Node p){
    if(p){
        LRN(p->left);
        LRN(p->right);
        printf("%d, ",p->data);
    }
}
void NLR(Node p){
    if(p){
        printf("%d, ",p->data);
        LRN(p->left);
        LRN(p->right);
    }
}
void LNR(Node p){
    if(p){
        LRN(p->left);  
        printf("%d, ",p->data);     
        LRN(p->right);
    }
}
void traversalTreee(BST tree, int type){
    switch (type)
    {
    case 1:
        cout<<"NLR: ";
        NLR(tree.root);
        break;
    case 2:
        cout<<"LNR: ";
        LNR(tree.root);
        break;
    case 3:
        cout<<"LRN: ";
        LRN(tree.root);
        break;
    default:
        break;
    }
}
int soLe(Node p){
    if(p){
        int b = soLe(p->left);
        int a = soLe(p->right);
        int count=a+b;
        if(p->data%2!=0)
            count++;
        return count;
    }
    return 0;
}
int nut1CayCon(Node p){
    if(p){
        int a = nut1CayCon(p->left);
        int b = nut1CayCon(p->right);
        int count=a+b;
        if((!p->left&&p->right)||(p->left&&!p->right)){
            count ++;
        }
        return count;
    }
    return 0;
}
int insert(Node &p, int k){
    if(p){
    if(p->data==k){
        printf("them that bai");
        return 0;
    }
    if(p->data > k){
        return insert(p->left,k);
    }else{
        return insert(p->right,k);
    }
    }
    p = new tagNode;
    p->data=k;
    p->left=p->right=NULL;
    return 1;
}
int main(){
    BST tree;
    initBST(tree);
    insert(tree.root, 7);
    insert(tree.root, 2);
    insert(tree.root, 34);
    insert(tree.root, 1);
    insert(tree.root, 15);
    insert(tree.root, 9);
    insert(tree.root, 41);
    insert(tree.root, 6);
    insert(tree.root, 12);
    insert(tree.root, 16);
    insert(tree.root, 40);
    insert(tree.root, 45);
    traversalTreee(tree,3);
    //cout<<tree.root->data;
    int count=0;
    printf("So le %d", soLe(tree.root));
    printf("Nut 1 cay con %d", nut1CayCon(tree.root));
}