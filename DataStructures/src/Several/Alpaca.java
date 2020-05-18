package Several;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Contest programming Alpaca CCPL 2017
 * 
 * @author wilsonsoto
 * @since 08.09.17
 */
public class Alpaca {

    public static void main(String[] args) {
    	    	
    	final FastReader in = new FastReader();
    	int n = in.nextInt()-1;
    	int m = in.nextInt();
    	    	
        BigInteger x = BigInteger.valueOf(2);
        x = x.pow(n);
        BigInteger y = BigInteger.valueOf(-1);
        y = y.pow(n);        
        
        x = x.subtract(y);
        x = x.divide(BigInteger.valueOf(3));
        
        System.out.println(x.mod(BigInteger.valueOf(m)));
                
    }
    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
        
}

