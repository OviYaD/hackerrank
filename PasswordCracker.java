import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int cnt = sc.nextInt();
            Set<String> dict = new HashSet<String>();
            Map<String,Boolean> map = new HashMap<String,Boolean>();
            for(int j = 0; j < cnt; j++){
                dict.add(sc.next());
            }
            String s = sc.next();
            boolean res = dfs(s,dict,"",map);
            if (!res){
                System.out.println("WRONG PASSWORD");
            }
        }
    }
    
    private static boolean dfs(String s, Set<String> dict, String path,Map<String,Boolean> map){
        
        if (s == null || s.length() == 0){
            System.out.println(path.trim());
            return true;
        }
        if (map.containsKey(s)){
            return map.get(s);
        }
        for(String word : dict){
            if (!s.startsWith(word)) continue;
            if (dfs(s.substring(word.length()),dict,path + word + " ",map)){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}
   
