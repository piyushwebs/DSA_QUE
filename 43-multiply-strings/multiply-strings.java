class Solution {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int n = n1.length;

        String ans = "";

        for(int i=n-1;i>=0;i--)
        {
            String mulVal = multiplyString(n2,n1[i]-'0');
            StringBuilder str = new StringBuilder(mulVal);
            for(int j = 0;j<n-i-1;j++)
            {
                str.append("0");
            }
            
            mulVal = str.toString();
            ans = addNum(ans,mulVal);
        }
        int k = 0;
        while(k<ans.length() && ans.charAt(k)=='0')
        {
           k++;
        }
        if(k==ans.length())
        {
            return "0";
        }
        return ans.substring(k);
    }
    public String multiplyString(char[] num1,int num2)
    {
        int carry = 0;
        int n = num1.length;
        StringBuilder str = new StringBuilder("");
        for(int i=n-1;i>=0;i--)
        {
           int val = num1[i]-'0';
           int mul = ((val * num2) + carry);
           str.insert(0,Integer.toString(mul%10));
           carry = mul/10;
        }
        if(carry!=0)
        {
            str.insert(0,Integer.toString(carry));
        }
        return str.toString();
    }
    public String addNum(String num1,String num2)
    {
        int carry = 0;
        
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int n = arr1.length;
        int m = arr2.length;

        StringBuilder str = new StringBuilder("");

        int i=n-1;
        int j=m-1;

        while(i>=0 || j>=0 || carry!=0)
        {
            int sum = 0;
            if(i>=0 && j>=0)
            {
               sum = (arr1[i]-'0')+(arr2[j]-'0')+carry;
              
              i--;
              j--;
            }
            else if(i>=0)
            {
                 sum =(arr1[i]-'0')+carry;
                i--;
            }
            else if(j>=0)
            {
                 sum = (arr2[j]-'0')+carry;
                j--;
            }
            else 
            {
                 sum = carry;
            }
            carry = sum/10;
            str.insert(0,Integer.toString(sum%10));
        }

        return str.toString();
    }
}