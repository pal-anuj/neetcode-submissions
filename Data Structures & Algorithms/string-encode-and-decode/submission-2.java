class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb= new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res= new ArrayList<>();
        int n= str.length();
        int i=0;
        System.out.println(str);
        while(i<n){
            int len=0;

            while(str.charAt(i) != '#'){
                len = len * 10 + str.charAt(i) - '0';
                i++;
            }

            i++;

            String s= str.substring(i, i + len);
            res.add(s);
            i+=len;
        }

        return res;
    }
}
