package com.paypal.compliance.casemgmt.util;

import java.util.LinkedList;
import java.util.Queue;

public class FindNumberOfIterationToFlipMatrix {

    //Write a program to find the number of iteration required to flip the entire matrix to 1's given that in a single iteration
    //all 1's can flip its immediate neighbours 0's to 1's connected through horizontally and vertically.

    // {1,0,0}                              // {1,1,0}                              // {1,1,1}
    // {1,0,0}  ===> first iteration ==>   //  {1,1,1}      ===> second iteration   // {1,1,1}
    // {0,0,1}                             //  {1,1,1}                              // {1,1,1}

  //########################################. BFS METHOD ########################################################### 
  
  public static void bfs(String[] args) {

        int[][] matrix= {
                {1,0,0},
                {1,0,0},
                {0,0,1}
        };

        Queue<Position> queue = new LinkedList<Position>();
        for(int i =0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    queue.add(new Position(i,j));
                }
            }
        }

        int numOfIteration = countNumOfIteration(matrix,queue);
        System.out.println("Num of Iteration = " + numOfIteration);
    }


    private static int countNumOfIteration(int[][] matrix, Queue<Position> queue){

        //Corner case Check
        //If Queue is Empty , then no 0 found the in the matrix so can't flip the matreix to 1.
        if(queue.isEmpty()){
            System.out.println("No 1's found in the Matrix. Can not flip the matrix to 1's");
            return -1;
        }
        // If Queue size is equal to matrix size, then all are 1's
        if(queue.size()== Math.multiplyExact(matrix.length,matrix[0].length)){
            return 0;
        }
        int numOfIteration = 0;

        while(!queue.isEmpty()){
            int size =  queue.size();
            boolean flipped_once = false;
            boolean countIteration = false;
            for(int i =0;i< size;i++){
                Position position = queue.poll();
                boolean flipped_once = flipNeighbours(position.x, position.y,matrix,matrix.length,matrix[0].length,queue);
                if(flipped_once) countIteration = true;
            }
            if(countIteration)numOfIteration++;
        }
        return numOfIteration;
    }

    private static boolean flipNeighbours(int x, int y, int[][] matrix, int m ,int n, Queue<Position> queue) {
        boolean flipped_once= false;
        //right
        if(x+1 < m  && matrix[x+1][y]==0) {
            matrix[x+1][y]=1;
            queue.add(new Position(x+1,y));
            flipped_once=true;
        }
        //left
        if(x-1 >=0  && matrix[x-1][y]==0) {
            matrix[x-1][y]=1;
            queue.add(new Position(x-1,y));
            flipped_once=true;
        }
        //bottom
        if(y+1 < n  && matrix[x][y+1]==0) {
            matrix[x][y+1]=1;
            queue.add(new Position(x,y+1));
            flipped_once=true;
        }
        //top
        if(y-1 >=0  && matrix[x][y-1]==0) {
            matrix[x][y-1]=1;
            queue.add(new Position(x,y-1));
            flipped_once=true;
        }
        return flipped_once;
    }
}

class Position{

    int x;
    int y;

    Position(int x, int y){
        this.x= x;
        this.y=y;
    }
}
