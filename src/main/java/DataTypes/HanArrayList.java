package DataTypes;

/**
 * Created by sven_ on 03/03/2016.
 * Only works for positive numbers currently
 */
public class HanArrayList {

    private int[] list;
    private int pointer;

    public HanArrayList(int size) {
        list = new int[size];
        pointer = 0;
        for (int i: list) {
            list[i] = -1;
        }
    }

    public HanArrayList() {
        list = new int[10];
        pointer = 0;
    }

    public void add(int value) {
        if(pointer == list.length){
            increaseArraySize();
        }
        list[pointer] = value;
        while(list[pointer] != -1 && pointer < list.length - 1) {
            pointer++;
        }
    }

    public int get(int index) {
        return list[index];
    }

    public void set(int index, int value) throws ArrayIndexOutOfBoundsException{
        if(pointer == list.length){
            increaseArraySize();
        }
        list[index] = value;
        if(index == pointer) {
            while(list[pointer] != -1 && pointer < list.length - 1) {
                pointer++;
            }
        }
    }

    private void increaseArraySize() {
        int[] tmpArray = new int[list.length];
        for (int i: list) {
            tmpArray[i] = list[i];
        }
        list = new int[tmpArray.length * 2 + 1];
        for (int i: list) {
            list[i] = -1;
        }
        for (int i: tmpArray) {
            list[i] = tmpArray[i];
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(int i = 0; i<list.length; i++) {
            if(i < list.length - 1)
                builder.append(list[i] + ", ");
            else
                builder.append(list[i] + "]");
        }

        return builder.toString();
    }
}
