#include<bits/stdc++.h>
//#include <stdio.h>
using namespace std;

/* Algorithm:
  1. Created a stack of nodes and visited array
  2. Insert the root in the stack.
  3. Run a loop till the stack is not empty
  4. Pop the element from the stack and print the element.
  5. For every adjacent and unisisited node of current node, mark the node and insert it in the stack
*/
class Graph{
  int V;
  list<int> *adj;

  public:
    Graph(int V); //Constructor
    void addEdge(int v, int w);
    void DFS();
    //prints all not yetvisitedvertices reachable from s
    void DFSUtil(int s, vector<bool> &visited);
};

Graph::Graph(int V){
  this->V = V;
  adj = new list<int>[V];
}

void Graph::addEdge(int v, int w){
  adj[v].push_back(w);
}

void Graph::DFSUtil(int s, vector<bool> &visited){
  stack<int> stack;

  stack.push(s);

  while(!stack.empty()){
    s = stack.top();
    stack.pop();

    if(!visited[s]){
      cout << s << " ";
      visited[s] = true;
    }

    for(auto i = adj[s].begin; i != adj[s].end(); ++i){
      if(!visited[*i])
        stack.push(*i);
    }
  }
}

void Graph:DFS(){
  vector<bool> visited(V, false);

  for(inti=0; i<V ; i++){
    if(!visited[i])
      DFSUtil(i, visited);
  }
}
int main(void)
{
  Graph g(5);
  g.addEdge(1, 0);
  g.addEdge(0, 2);
  g.addEdge(2, 1);
  g.addEdge(0, 3);
  g.addEdge(1, 4);

  g.DFS(0);
return 0;
}
