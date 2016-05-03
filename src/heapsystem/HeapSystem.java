package heapsystem;

public class HeapSystem {
    String name[]; int cAns[]; int wAns[];
    int length;
    
    public HeapSystem(String n[],int c[],int w[],int l){
        this.name = n;
        this.cAns = c;
        this.wAns = w;
        this.length = l;
    }
    
    public int left(int i){
        return i*2;
    }
    public int right(int i){
        return (i*2)+1;
    }
    public void minheapify(int i){
        int l = left(i);
        int r = right(i);
        int minimum = i;

        if (l <= length && cAns[l]<cAns[minimum]) minimum = l;
        if (r <= length && cAns[r]<cAns[minimum]) minimum = r;
        if (minimum != i) {
            exchange(i, minimum);
            minheapify(minimum);
        }
    }
    public void BuildMinHeap(){
        for (int i = length / 2; i >= 0; i--)
            minheapify(i);
    }
    public void heapSort(){
        for (int i = length; i > 0; i--) {
            exchange(0, i);
            length--;
            minheapify(0);
        }
    }
    public void exchange(int i,int n){
        int temp = cAns[i];
        cAns[i] = cAns[n];
        cAns[n] = temp;

        temp = wAns[i];
        wAns[i] = wAns[n];
        wAns[n] = temp;

        String stemp = name[i];
        name[i] = name[n];
        name[n] = stemp;
    }
}
