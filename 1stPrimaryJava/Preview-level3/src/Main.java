import java.util.Scanner;

public class Main {

    //程序入口
    public static void main(String args[]) throws InterruptedException {

        System.out.println("学生管理系统\nVersion: 1.0\nAuthor: zhangxinhui02\n\n");

        System.out.println("请设置数据库的最大容量：");
        int num = GetIntInput();
        Database db = new Database(num);
        System.out.println("容量为" + db.MaxNum + "的数据库已建立！\n");

        while(true){
            System.out.println("------------------------------------------");
            System.out.println("学生管理系统");
            System.out.println("数据库容量\t:" + db.MaxNum);
            System.out.println("目前的学生人数\t:" + db.Count());
            System.out.println("输入对应的数字来操作数据库：");
            System.out.println("\t1:添加学生");
            System.out.println("\t2:按学号移除学生");
            System.out.println("\t3:按姓名移除学生");
            System.out.println("\t4:按学号编辑学生");
            System.out.println("\t5:按姓名编辑学生");
            System.out.println("\t6:按学号查找学生");
            System.out.println("\t7:按姓名查找学生");
            System.out.println("\t8:查看学生列表");
            System.out.println("\t9:退出系统");
            System.out.println("------------------------------------------");

            switch (GetIntInput()){
                case 1:
                    System.out.println("输入学生数据（学号 姓名）:");
                    if (db.Add(GetIntInput(),GetStrInput()))
                        System.out.println("添加成功！");
                    else{
                        System.out.println("添加失败！");
                    }
                    break;
                case 2:
                    System.out.println("输入要移除的学生的学号:");
                    if (db.Remove(GetIntInput()))
                        System.out.println("移除成功！");
                    else{
                        System.out.println("移除失败！");
                    }
                    break;
                case 3:
                    System.out.println("输入要移除的学生的姓名:");
                    if (db.Remove(GetStrInput()))
                        System.out.println("移除成功！");
                    else{
                        System.out.println("移除失败！");
                    }
                    break;
                case 4:
                    System.out.println("输入要编辑的学生学号与要修改为什么姓名:");
                    if (db.Change(GetIntInput(),GetStrInput()))
                        System.out.println("编辑成功！");
                    else{
                        System.out.println("编辑失败！");
                    }
                    break;
                case 5:
                    System.out.println("输入要编辑的学生姓名与要修改为什么学号:");
                    if (db.Change(GetStrInput(),GetIntInput()))
                        System.out.println("编辑成功！");
                    else{
                        System.out.println("编辑失败！");
                    }
                    break;
                case 6:
                    System.out.println("输入要查找的学生的学号:");
                    String TempName = db.Search(GetIntInput());
                    if (TempName != null)
                        System.out.println(TempName);
                    else{
                        System.out.println("查找失败！");
                    }
                    break;
                case 7:
                    System.out.println("输入要查找的学生的姓名:");
                    int TempNumber = db.Search(GetStrInput());
                    if (TempNumber != -1)
                        System.out.println(TempNumber);
                    else{
                        System.out.println("查找失败！");
                    }
                    break;
                case 8:
                    String[][] s = db.GetSortList();
                    System.out.println("------------------------------------------\n\t学生列表:");
                    for (int i = 0;i < s.length;i++){
                        if (s[i][0] != null)
                            System.out.println("\t" + s[i][0] + " : " + s[i][1]);
                    }
                    System.out.println("------------------------------------------\n");
                    break;
                case 9:
                    System.out.println("\t谢谢使用！\n\n\t红岩网校第一次作业 2021.10.6\n");
                    System.exit(0);
                    while (true);
                default:
                    System.out.println("\t数据错误，请重新输入！\n");
                    break;
            }

            Thread.sleep(2000);
        }
    }

    //从终端获取正确的整型数据
    public static int GetIntInput(){
        int num;
        Scanner input = new Scanner(System.in);
        while(true){
            try {
                num = input.nextInt();
                if (num <= 0){
                    System.out.println("\t数据错误，请重新输入！\n");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("\t数据错误，请重新输入！\n");
                input = new Scanner(System.in);
            }
        }
        return num;
    }

    //从终端获取正确的字符串数据
    public static String GetStrInput(){
        String str;
        Scanner input = new Scanner(System.in);
        while(true){
            try {
                str = input.next();
                if (str.equals("")){
                    System.out.println("\t数据错误，请重新输入！\n");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("\t数据错误，请重新输入！\n");
                input = new Scanner(System.in);
            }
        }
        return str;
    }

}

