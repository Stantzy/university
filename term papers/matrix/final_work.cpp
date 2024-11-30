#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>


using namespace std;
class Matrix{
    private:
        int **Item;
        int Row;
        int Col;
    public:
        Matrix();
        // set F to false if need to delete COL
        Matrix(int R, int C, int Low, int High, bool F=true);  
        Matrix(const char *FileName, bool F=true);
        ~Matrix();
        void Out();
        void Out(const char *FileName);
        int CheckOddRows(int R);
        int CheckOddCols(int C);
        int FindMax();                                          // Task 2a
        int FindMin();                                          // Task 2a
        int Count(int xMin, int xMax);
        int Count(){return Count(FindMin(), FindMax());};       // Task 2b
        void OutDelMin();                                       // Task 3
        void OutDelMin(const char *FileName);
        int GetColMin(int xMin);
        int GetColMin(){return GetColMin(FindMin());};
        void DelCol(Matrix X, Matrix Y);
};


Matrix::Matrix(){
    Row = 11; Col = 11;
    Item = new int*[Row];
    for(int i=0; i<Row; i++)Item[i] = new int[Col];
    for(int i=0; i<Row; i++)
        for(int j=0; j<Col; j++)Item[i][j] = 0;
}
Matrix::Matrix(int R, int C, int Low, int High, bool F){
    if(F){
        Row = CheckOddRows(R); Col = CheckOddCols(C);
    }
    else{
        Row = CheckOddRows(R); Col = CheckOddCols(C) - 1;
    }
    Item = new int*[Row];
    for(int i=0; i<Row; i++)Item[i] = new int[Col];
    for(int i=0; i<Row; i++)
        for(int j=0; j<Col; j++)Item[i][j] = rand()%(High-Low+1)+Low;
}
Matrix::Matrix(const char *FileName, bool F){
    ifstream In(FileName);
    if(F){
        In >> Row >> Col;
    }
    else{
        In >> Row >> Col;
        Col--;
    }
    Item = new int*[Row];
    for(int i=0; i<Row; i++)Item[i] = new int[Col];
    for(int i=0; i<Row; i++)
            for(int j=0; j<Col; j++)In>>Item[i][j];
    In.close();
}
Matrix::~Matrix(){
    delete [] Item;
}

void Matrix::Out(){
    for(int i=0; i<Row; i++){
        for(int j=0; j<Col; j++)cout<<Item[i][j]<<"\t";
        cout << endl;
    }
    cout << endl;
}
void Matrix::Out(const char *FileName){
    ofstream On(FileName);
    On << "Rows: " << Row << "\t" << "Cols: " << Col << endl;
    for(int i=0; i<Row; i++){
        for(int j=0; j<Col; j++)On<<Item[i][j]<<"\t";
        On << endl;
    }
    On.close();
}
/*    OUTPUT WITHOUT A COLUMN
void Matrix::OutDelMin(const char *FileName){
    ofstream On(FileName);
    On << "The Matrix without a column:" << endl;
    On << "Rows: " << Row << "\t" << "Cols:" << Col-1 << endl;
    for(int i=0; i<Row; i++){
        for(int j=0; j<Col; j++){
            if(j == GetColMin())continue;
            On << Item[i][j] << "\t";
        }
        On << endl;
    }
    On.close();
}

void Matrix::OutDelMin(){
    cout << "The Matrix without a column:" << endl;
    for(int i=0; i<Row; i++){
        for(int j=0; j<Col; j++){
            if(j == GetColMin())continue;
            cout << Item[i][j] << "\t";
        }
        cout << endl;
    }
    cout << endl;
}
*/
int Matrix::GetColMin(int xMin){
    for(int i=0; i<Row; i++){
        for(int j=0; j<Col; j++)
            if((i >= j) && (Item[i][j] == xMin))return j;
    }
    return 0;
}
int Matrix::CheckOddRows(int R){
    if((R % 2 == 0) || (R < 11)){
        cout << "###ERROR_1: An odd number of ROWS must be entered." << endl;
        while((R % 2 == 0) || (R < 11)){
            cout << "Enter an odd number of rows larger than 10: " << endl;
            cin >> R;
        };
    };
    return R;
}
int Matrix::CheckOddCols(int C){
    if((C % 2 == 0) || (C < 11)){
        cout << "###ERROR_2: An odd number of COLS must be entered." << endl;
        while((C % 2 == 0) || (C < 11)){
            cout << "Enter an odd number of cols larger than 10: " << endl;
            cin >> C;
        };
    };
    return C;
}
int Matrix::FindMax(){
    int xMax = Item[0][0];
    for(int i=0; i < Row; i++){
        for(int j=0; j < Col; j++)
            xMax = ((i >= j) && (Item[i][j] > xMax))?Item[i][j]:xMax;
    }
    return xMax;
}
int Matrix::FindMin(){
    int xMin = Item[0][0];
    for(int i=0; i < Row; i++){
        for(int j=0; j < Col; j++)
            xMin = ((i >= j) && (Item[i][j] < xMin))?Item[i][j]:xMin;
    }
    return xMin;
}
int Matrix::Count(int xMin, int xMax){
    int Counter = 0;
    double Rng;
    Rng = xMin + ((xMax - xMin) / 4);
    for(int i=0; i < Row; i++){
        for(int j=0; j < Col; j++)
            if((i >= j) && (Item[i][j] >= Rng))Counter++;
    }
    return Counter;
}
void Matrix::DelCol(Matrix X, Matrix Y){
    bool Flag = true;
    for(int i=0; i<X.Row; i++){
        for(int j=0; j<X.Col-1; j++){
            if(j == X.GetColMin())Flag = false;
            if(Flag)Y.Item[i][j] = X.Item[i][j];
            else Y.Item[i][j] = X.Item[i][j + 1];
        }
    }
}


int main(){
    srand(time(0));
    Matrix *X = new Matrix(11, 11, -10000, 10000);
    Matrix *Y = new Matrix(11, 11, -10000, 10000, false);
    X -> Out();
    cout << "Max: " << X -> FindMax() << endl;
    cout << "Min: " << X -> FindMin() << endl;
    cout << "Number of values according to the condition of task 2b: " << X->Count();
    cout << endl;
    cout << "Number of col with min: " << X -> GetColMin() << endl;
    Y -> DelCol(*X, *Y);
    Y -> Out();
   /*
    ifstream In("In.txt");
    Matrix *X = new Matrix("In.txt");
    Matrix *Y = new Matrix("In.txt", false);
    In.close();
    ofstream On("task2.txt");
    X -> Out("task1.txt");
    On << "Max: " << X -> FindMax() << endl;
    On << "Min: " << X -> FindMin() << endl;
    On << "Number of values according to the condition of task 2b: " << X->Count();
    On << endl;
    On << "Number of col with min: " << X -> GetColMin() << endl;
    On << endl;
    Y -> DelCol(*X, *Y);
    Y -> Out("task3.txt");
    On.close();
    */
    X -> ~Matrix();
    Y -> ~Matrix();
    return 0;
}
