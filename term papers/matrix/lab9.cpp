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
        int CountIdentMax();
        int CountIdentMax(int, int);
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
int clVectorInt::CountIdentMax(){return CountIdentMax(0, Count - 1);}
int clVectorInt::CountIdentMax(int iL, int iH){
    int CountIdent = 0;
    for(int i=iL;i<=iH;i++){
        if(Item[i]==Item[MaxIndex()])CountIdent++;
    };
    return CountIdent;
}


int main(){
    srand(time(0));    // initializing the random number generator
    clVectorInt *X = new clVectorInt(10, 0, 3);
    X -> Print();
    cout<<"Max X = " << X -> GetMax() << endl;
    cout<<"Number of identical maximum elements: " << X -> CountIdentMax() << endl;
    delete X;
    return 0;
}