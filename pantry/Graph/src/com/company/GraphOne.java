package com.company;

import java.util.List;

public class GraphOne {

    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;
    public int count_cities = 1;

    public GraphOne(int V){
        vertexList = new Vertex[V];

        adjMat = new int[V][V];
        nVerts = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                adjMat[i][j] = 0;
        }
        theStack = new StackX(V);
    }
    public void addVertex(int lab){
        vertexList[nVerts++] = new Vertex(lab);
    }
    public void addEdge(List<Integer> arr){
        adjMat[arr.get(0)-1][arr.get(1)-1] = 1;
        adjMat[arr.get(1)-1][arr.get(0)-1] = 1;
    }
    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }
    public int getAdUnvisitedVertex(int v){
        for (int i = 0; i < nVerts; i++)
            if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false)
                return i;
        return -1;
    }
    public void dfs(){
        vertexList[0].wasVisited = true;
        /*displayVertex(0);*/
        theStack.push(0);

        while (!theStack.isEmpty()){
            int v = getAdUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                /*displayVertex(v);*/
                theStack.push(v);
                count_cities++;
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}
