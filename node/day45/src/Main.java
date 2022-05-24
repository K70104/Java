
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * 输入描述:先输入字典中单词的个数n，再输入n个单词作为字典单词。再输入一个单词，查找其在字典中兄弟单词的个数m再输入数字k
     * 输出描述:根据输入，输出查找到的兄弟单词的个数m 然后输出查找到的兄弟单词的第k个单词。
     * 而且，数字和字符串各自占一行，还要判断边界条件，当没有指定序号的兄弟时，不输出字符串
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String[] str=new String[n];
            String result="";
            for(int i=0;i<n;i++){
                str[i]=sc.next();
            }
            Arrays.sort(str);
            String target=sc.next();
            int k=sc.nextInt();
            int count=0;//计数多少兄弟单词

            List<String> list = new ArrayList<>(); //

            for(int i=0;i<n;i++){

                if(isfriend(target,str[i])){
                    list.add(str[i]); //
                    count=count+1;
                    if(k==count){
                        result=str[i];
                    }
                }
            }
            System.out.println(Arrays.toString(list.toArray()));
            System.out.println("++++++++++++++++++++++");
            System.out.println(count+" ");
            if(count>=k){
                System.out.println(result);
            }


        }

    }
    static String sort(String str){
        char[] s=str.toCharArray();
        String result="";
        Arrays.sort(s);
        for(int i=0;i<str.length();i++){
            result=result+s[i];

        }
        return result;
    }
    static boolean isfriend(String s1,String s2){
        boolean b=false;
        if(s1.length()!=s2.length()){
            b=false;
        }
        if(s1.equals(s2)){
            b=false;
        }else{
            if(sort(s1).equals(sort(s2))){
                b=true;
            }

        }
        return b;
    }

}