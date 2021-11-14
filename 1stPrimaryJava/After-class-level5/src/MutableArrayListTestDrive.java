import java.util.Scanner;

//测试MutableArrayList类
public class MutableArrayListTestDrive {
    public static void main(String[] args){
        System.out.println("MutableArrayList/可变数组测试\nAuthor: zhangxinhui02\n");
        Scanner input = new Scanner(System.in);
        System.out.println("输入可变数组的初始容量：");
        MutableArrayList list = new MutableArrayList(input.nextInt());
        String str1="CQUPT";
        String str2="Redrock";
        list.add(str1);
        list.add(1,str2);
        System.out.println(list.get(1)+" of "+list.get(0));
        list.remove(0);
        System.out.println("list内有"+list.size()+"个元素。");
        list.remove(str2);
        System.out.println("list内有"+list.size()+"个元素。");
    }
}
