class Solution {
    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        String res = null;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                System.out.println(s.substring(i,j+1));
                if(isPalindrome(s.substring(i,j+1))){
                    if(j-i+1 >= max){
                        res = s.substring(i,j+1);
                        max = j-i+1;
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s){
        int p1 = 0;
        int p2 = s.length()-1;
        while(p2>=p1){
            if(s.charAt(p1) != s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
