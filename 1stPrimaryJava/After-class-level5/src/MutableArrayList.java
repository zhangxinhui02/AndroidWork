public class MutableArrayList {
    private Object[] elementData;               //数组
    private int size = 0;                       //元素数量

    //构造函数初始化容器
    MutableArrayList(int listSize) {
        elementData = new Object[listSize];
    }

    //向容器末尾添加元素
    public void add(Object obj) {
        size = expand(size);
        elementData[size - 1] = obj;
    }

    //向容器中指定索引位置添加元素，注意，若指定索引大于已有最大索引，将在中间的空白位置补上null
    public void add(int index, Object obj) {
        size = expand(index);
        elementData[index] = obj;
    }

    //返回指定索引的元素
    public Object get(int index) {
        if (check(index))
            return elementData[index];
        System.out.println("申请的索引位置不存在！");
        return null;
    }

    //移除指定索引的元素，返回表示操作是否成功的状态
    public boolean remove(int index) {
        if (!check(index)) {
            System.out.println("申请的索引位置不存在！");
            return false;
        }
        for (int i = index; i < size - 1; i++)
            elementData[i] = elementData[i + 1];
        elementData[size - 1] = null;
        size--;
        return true;
    }

    //移除容器中与指定元素相同的第一个元素，返回表示操作是否成功的状态
    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == obj) {
                remove(i);
                return true;
            }
        }
        System.out.println("指定的元素不存在！");
        return false;
    }

    //返回容器内元素的数量
    public int size(){
        return size;
    }

    //在指定索引位置对数组扩容，返回扩容后的数组容量
    private int expand(int index) {
        //如果指定索引在已有索引范围+1内，将索引位置后的已有元素后移，在索引位置插入空值null
        if (index <= elementData.length) {
            Object[] temp = new Object[elementData.length + 1];             //临时数组，大小比原有数组多1
            for (int i = 0; i < index; i++)                                 //复制索引位置之前的元素
                temp[i] = elementData[i];
            temp[index] = null;                                             //在指定索引位置插入一个空值null
            for (int i = index + 1; i < elementData.length + 1; i++)        //依次复制之后的元素
                temp[i] = elementData[i - 1];
            elementData = temp;                                             //替换数组
            return size + 1;                                                //返回更新后的元素数量
        }
        //如果指定索引在已有索引范围+1之后，在已有的最大索引到指定索引之间插入null
        else {
            Object[] temp = new Object[index + 1];                          //临时数组，大小为指定索引加1
            for (int i = 0; i < elementData.length; i++)                    //复制原有数据
                temp[i] = elementData[i];
            for (int i = elementData.length; i <= index; i++)               //从原有数据最大索引加1处开始赋予空值null直至到达指定索引
                temp[i] = null;
            elementData = temp;                                             //替换数组
            return index;                                                   //返回更新后的元素数量
        }
    }

    //判断索引位置的元素是否存在
    private boolean check(int index) {
        if (index >= size && index < 0)
            return false;
        else return true;
    }
}
