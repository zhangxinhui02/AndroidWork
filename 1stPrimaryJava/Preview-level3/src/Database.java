//数据库实例
public class Database {
    public int MaxNum;    //表示数据库可容纳的最大人数
    private String[][] Students;

    Database(int num){
        MaxNum = num;
        Students = new String[MaxNum][2];
    }

    //依据学号和姓名添加学生
    public boolean Add(int number,String name){
        for(int i = 0;i < Students.length;i++){
            if (Students[i][0] != null && Integer.parseInt(Students[i][0]) == number ){
                System.out.println("\t存在相同学号学生！");
                return false;
            }
        }
        try{
            for(int i = 0;i < Students.length;i++){
                if (Students[i][0] == null && Students[i][1] == null ){
                    Students[i][0] = Integer.toString(number);
                    Students[i][1] = name;
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println("\t在Add方法中发生了错误！");
            //System.out.println(e.toString());
        }
        System.out.println("\t无法添加数据！数据库已达到最大容量！！");
        return false;
    }

    //移除指定学号的学生
    public boolean Remove(int number){
        try {
            for(int i = 0;i < Students.length;i++){
                if (Students[i][0].equals(Integer.toString(number))){
                    Students[i][0] = null;
                    Students[i][1] = null;
                    return true;
                }
            }
        } catch(Exception e){
            System.out.println("\t在Remove方法中发生了错误！");
            //System.out.println(e.toString());
        }
        System.out.println("\t查无此人！");
        return false;
    }

    //移除指定姓名的学生
    public boolean Remove(String name){
        try {
            for(int i = 0;i < Students.length;i++){
                if (Students[i][1].equals(name)){
                    Students[i][0] = null;
                    Students[i][1] = null;
                    return true;
                }
            }
        } catch(Exception e){
            System.out.println("\t在Remove方法中发生了错误！");
            //System.out.println(e.toString());
        }
        System.out.println("\t查无此人！");
        return false;
    }

    //按学号修改姓名
    public boolean Change(int number,String name){
        try {
            for(int i = 0;i < Students.length;i++){
                if (Students[i][0].equals(Integer.toString(number))){
                    Students[i][1] = name;
                    return true;
                }
            }
        } catch(Exception e){
            System.out.println("\t在Change方法中发生了错误！");
            //System.out.println(e.toString());
        }
        System.out.println("\t查无此人！");
        return false;
    }

    //按姓名修改学号
    public boolean Change(String name,int number){
        try {
            for(int i = 0;i < Students.length;i++){
                if (Students[i][1].equals(name)){
                    Students[i][0] = Integer.toString(number);
                    return true;
                }
            }
        } catch(Exception e){
            System.out.println("\t在Change方法中发生了错误！");
            //System.out.println(e.toString());
        }
        System.out.println("\t查无此人！");
        return false;
    }

    //按姓名搜索
    public int Search(String name){
        try {
            for(int i = 0;i < Students.length;i++){
                if (Students[i][1].equals(name)){
                    return Integer.parseInt(Students[i][0]);
                }
            }
        } catch(Exception e){
            System.out.println("\t在Search方法中发生了错误！");
            //System.out.println(e.toString());
        }
        System.out.println("\t查无此人！");
        return -1;
    }

    //按学号搜索
    public String Search(int number){
        try {
            for(int i = 0;i < Students.length;i++){
                if (Students[i][0].equals(Integer.toString(number))){
                    return Students[i][1];
                }
            }
        } catch(Exception e){
            System.out.println("\t在Search方法中发生了错误！");
            //System.out.println(e.toString());
        }
        System.out.println("\t查无此人！");
        return null;
    }

    //返回学生数量
    public int Count(){
        int num = 0;
        for (int i = 0;i < Students.length;i++){
            if (Students[i][0] != null)
                num++;
        }
        return num;
    }

    //返回冒泡排序后的学生数据二维数组
    public String[][] GetSortList(){
        boolean state = false;          //是否完成了冒泡排序的标志
        String TempNumber = "";         //临时变量
        String TempName = "";           //临时变量

        while(!state){                  //如果上一次循环有排序行为排就再次运行冒泡排序算法
            state = true;
            for (int i = 0;i < Students.length - 1;i++){
                if (Students[i][0] != null ){                       //找出数组中从索引0开始的第i个非空数据
                    TempNumber = Students[i][0];                    //备份数据
                    TempName = Students[i][1];
                }
                for (int j = i + 1;j < Students.length;j++){        //找出数组中从索引i+1开始的第j个非空数据
                    if(Students[j][0] != null && Integer.parseInt(Students[j][0]) < Integer.parseInt(TempNumber)) {
                        Students[i][0] = Students[j][0];            //如果比第i个小就替换掉第i个（就是覆盖掉前一个比较大的）
                        Students[i][1] = Students[j][1];
                        Students[j][0] = TempNumber;                //向第j个位置赋予之前备份的较大的数据，完成一次冒泡算法
                        Students[j][1] = TempName;
                        state = false;                              //标识此次循环有冒泡算法行为
                        break;                                      //跳出寻找后一个较小数的内层循环
                    }
                }
            }
        }
        return Students;                 //返回排序后的数组（null值没有排序，因为在其他方法中会被筛选掉所以没必要）
    }
}
