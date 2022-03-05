package edu.neu.coe.info6205.union_find;

import java.util.Scanner;

public class UnionFind_Client {
    public static int count(int tc) {
        int connections = 0;
        int[] num = new int[tc];
        UF_HWQUPC union = new UF_HWQUPC(tc, true);
        for (int i = 0; i <= tc - 1; i++) {
            num[i] = i;
            if (i != 0) {
                boolean isConnected = union.connected(num[i], num[i - 1]);
                if (!isConnected) {
                    union.union(num[i], num[i - 1]);
                    ++connections;
                }
            }
        }
        return connections;
    }

    public static void main(String args[]) {
        int count = 15;
        int input =  100;
        
        while (count != 0)  {
            int connection = count(input);
            System.out.println("Total inputs: " + input + ", Total Connection(m)" + connection);
            count--;
            input*=2;
        }
    }
}