#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;
class clVectorInt{                //  the Vector-array
        int *Item;                //  items of array
        int Count;                //  the Counter of array
    public:
        clVectorInt();
        clVectorInt(int);
        clVectorInt(int, int, int);
        ~clVectorInt(){delete [] Item;};
        void Set(int, int, int);
        void Print();
        int MinIndex();
        int MinIndex(int, int);
        int GetItem(int n){return Item[n];}
        int GetMin(){return Item[MinIndex()];};
        int GetMin(int L, int H){return Item[MinIndex(L, H)];};
        int MaxIndex();
        int MaxIndex(int, int);
        int GetMax(){return Item[MaxIndex()];};
        int GetMax(int L, int H){return Item[MaxIndex(L, H)];};
        int CountNegMinMax();     //  counting negative items between min and max
};

  // n - the number of elements, L - lower border of the range, H - higher border
clVectorInt::clVectorInt(){Set(10, 0, 0);};
clVectorInt::clVectorInt(int n){Set(n, -100, 100);};
clVectorInt::clVectorInt(int n, int L, int H){Set(n, L, H);};

 // implementation of class functions
void clVectorInt::Set(int n, int Low, int High){
    Count = n;
    Item = new int [Count];
    if(High <= Low){for(int i = 0; i < Count; i++) Item[i] = 0;
        return;
    }
    for(int i = 0; i < Count; i++)Item[i]=rand()%(High - Low + 1)+Low;
}
void clVectorInt::Print(){
    cout<< "----Show Vector----" << endl;
    for(int i=0; i < Count; i++)cout<< Item[i] << "\t";
    cout<< endl << "----End Show Vector----" << endl;
}
int clVectorInt::MinIndex(){return MinIndex(0, Count - 1);}
int clVectorInt::MinIndex(int iL, int iH){
    int Im = iL;
    for(int i=iL;i<=iH;i++)Im = (Item[i] < Item[Im])?i:Im;
    return Im;
}
int clVectorInt::MaxIndex(){return MaxIndex(0, Count - 1);}
int clVectorInt::MaxIndex(int iL, int iH){
    int Im = iL;
    for(int i=iL;i<=iH;i++)Im = (Item[i] > Item[Im])?i:Im;
    return Im;
}
int clVectorInt::CountNegMinMax(){
    int Count = 0;
    int min = MinIndex();
    int max = MaxIndex();
    if(min < max){
        for(int i=MinIndex() + 1;i<MaxIndex();i++){
            if(Item[i] < 0){
                Count++;
           }
        }
    }
    if(max < min){
        for(int i=MaxIndex() + 1;i<MinIndex();i++){
            if(Item[i] < 0){
                Count++;
           }
    }
    }
    return Count;
}

int main(){
    srand(time(0));    // initializing the random number generator
    clVectorInt *X = new clVectorInt(1000, -1000, 1000);
    X -> Print();
    cout<<"Max X[" << X -> MaxIndex() << "] = " << X -> GetMax() << endl;
    cout<<"Min X[" << X -> MinIndex() << "] = " << X -> GetMin() << endl;
    cout<<"Number of items < 0 between min and max items: " << X -> CountNegMinMax() << endl;
    delete X;
    return 0;
}