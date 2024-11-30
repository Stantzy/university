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
        int GetCount(){return Count;}
        int GetMin(){return Item[MinIndex()];}
        int GetMin(int L, int H){return Item[MinIndex(L, H)];}
        int MaxIndex();
        int MaxIndex(int, int);
        int GetMax(){return Item[MaxIndex()];}
        int GetMax(int L, int H){return Item[MaxIndex(L, H)];}
        void SwapIndex(int i1, int i2){int T = Item[i1]; Item[i1] = Item[i2]; Item[i2] = T;}
        void BubbleUp(int, int);
        void BubbleUp(){BubbleUp(0, Count-1);}
        void BubbleDown(int, int);
        void BubbleDown(){BubbleDown(0, Count-1);}
        void ExtrUp();
        void ExtrDown();
        void Solve(int, int);
        void Solve(){Solve(0, Count-1);};
        

};

  // n - the number of elements, L - lower border of the range, H - higher border
clVectorInt::clVectorInt(){Set(10, 0, 0);};
clVectorInt::clVectorInt(int n){Set(n, -100, 100);};
clVectorInt::clVectorInt(int n, int L, int H){Set(n, L, H);};

 // implementation of class functions
void clVectorInt::Solve(int L, int H){
    for(int i=Count-1; i>0; i--){
    if(i % 2 == 1) SwapIndex(i, MinIndex(0,i));
    else SwapIndex(i, MaxIndex(0,i));
    }
}
void clVectorInt::ExtrUp(){
    for(int i=Count-1; i > 0; i--)SwapIndex(i, MaxIndex(0, i));
}
void clVectorInt::ExtrDown(){
    for(int i=Count-1; i > 0; i--)SwapIndex(i, MinIndex(0, i));
}
void clVectorInt::BubbleUp(int L, int H){
    bool F;
    int k = 1;
    H = (H >= Count)?Count-1:H;
    do
    {
        F = false;
        for(int i=L; i <= H-k; i++){
            if(Item[i] > Item[i + 1]){SwapIndex(i, i+1); F = true;}
        }
        k++;
    } while (F);  
}
void clVectorInt::BubbleDown(int L, int H){
    bool F;
    int k = 1;
    H = (H >= Count)?Count-1:H;
    do
    {
        F = false;
        for(int i=L; i <= H-k; i++){
            if(Item[i] < Item[i + 1]){SwapIndex(i, i+1); F = true;}
        }
        k++;
    } while (F);  
}
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



int main(){
    srand(time(0));    // initializing the random number generator
    clVectorInt *X = new clVectorInt(10, -100, 100);
    X -> Print();
    X -> Solve();
    X -> Print();
    delete X;
    return 0;
}