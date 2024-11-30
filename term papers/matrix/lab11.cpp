#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

/*
  11.Преобразовать исходную матрицу A(MxN)
  при помощи циклического сдвига столбцов влево
*/

using namespace std;
class Matrix{
    private:
        int **Item;
        int Row;
        int Col;
    public:
        Matrix();
        Matrix(int R, int C, int Low, int High);
        Matrix(char *FileName);
        void Out();
        void Out(char *FileName);
        void CyclicShiftLeft();
};

Matrix::Matrix(){
    Row = 5; Col = 5;
    Item = new int*[Row];
    for(int i=0;i<Row;i++)Item[i]=new int[Col];
    for(int i=0;i<Row;i++)
        for(int j=0;j<Col;j++)Item[i][j]=0;
}
Matrix::Matrix(int R, int C, int Low, int High){
    Row = R; Col = C;
    Item = new int*[Row];
    for(int i=0;i<Row;i++)Item[i]=new int[Col];
    for(int i=0;i<Row;i++)
        for(int j=0;j<Col;j++)Item[i][j]=rand()%(High - Low + 1)+Low;
}
Matrix::Matrix(char *FileName){
    ifstream In(FileName);
    In>>Row>>Col;
    Item = new int*[Row];
    for(int i=0;i<Row;i++)Item[i]=new int[Col];
    for(int i=0;i<Row;i++)
        for(int j=0;j<Col;j++)In>>Item[i][j];
    In.close();
}

void Matrix::CyclicShiftLeft(){
    for(int i=0;i<Row;i++){
        int tmp = Item[i][0];
        for(int j=0;j<Col-1;j++)Item[i][j] = Item[i][j+1];
        Item[i][Col-1] = tmp;
    }
}
void Matrix::Out(){
    cout<<endl;
    cout<<"Rows: "<<Row<<"\t"<<"Cols: "<<Col<<endl;
    for(int i=0;i<Row;i++){
        for(int j=0;j<Col;j++)cout<<Item[i][j]<<"\t";
        cout<<endl;
    }
    cout<<endl;
}
void Matrix::Out(char *FileName){
    ofstream On(FileName);
    On<<Row<<"\t"<<Col<<endl;
    for(int i=0;i<Row;i++){
        for(int j=0;j<Col;j++)On<<Item[i][j]<<"\t";
        On<<endl;
    }
    On.close();
}

int main(){
    srand(time(0));
    Matrix *X = new Matrix(5, 5, -1000, 1000);
    cout<<"The original matrix:"<<endl;
    X -> Out();
    X -> CyclicShiftLeft();
    cout<<"Cyclically shifted to the left matrix:"<<endl;
    X -> Out();
    X -> ~Matrix();
    return 0;
}