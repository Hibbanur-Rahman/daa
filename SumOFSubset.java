import java.io.*;
 
class sos {
    int m;
    int w[];
    int x[];
    public sos() {
        w = new int[40];
        x = new int[40];
    }
 
    public void sos1(int s, int k, int r) {
        int i;
        x[k] = 1;
        if (s + w[k] == m) {
            for (i = 0; i <= k; i++)
                System.out.print(x[i] + "\t");
            System.out.println();
            System.out.print("Elements of set are :");
            for (i = 0; i <= k; i++)
 
                if (x[i] == 1)
 
                    System.out.print(w[i] + "\t");
 
            System.out.println();
 
        } else if ((s + w[k] + w[k + 1]) <= m)
            sos1(s + w[k], k + 1, r - w[k]);
        if ((s + r - w[k] >= m) && (s + w[k + 1] <= m)) {
            x[k] = 0;
            sos1(s, k + 1, r - w[k]);
        }
    }
}
 
 
 
 
class SumOFSubset {
    public static void main(String args[]) throws IOException {
        BufferedReader Bobj = new BufferedReader(new InputStreamReader(System.in));
        int i, r = 0;
        sos o = new sos();
        System.out.print("Enter the number of elements of set : ");
        int n = Integer.parseInt(Bobj.readLine());
        System.out.print("Enter the elements : ");
        for (i = 0; i < n; i++) {
            o.w[i] = Integer.parseInt(Bobj.readLine());
            r = r + o.w[i];
        }
 
        System.out.print("Enter the sum to be computed: ");
        o.m = Integer.parseInt(Bobj.readLine());
        System.out.println("Subset whose sum is " + o.m + " are as follows: ");
        o.sos1(0, 0, r);
    }
}