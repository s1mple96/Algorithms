package find;

/**
 * @author s1mple
 * @create 2021/5/28-17:51
 */
public class SearchHash {

    public static void main(String[] args) {
        int arr[] = {2, 9, 3, 2, 3, 43, 32, 17};
        int hashLength = 30;
        int hash[] = new int[hashLength];
        for (int i = 0; i < arr.length; i++) {
            insertHash(hash, arr[i]);
        }
        for (int i = 0; i < 50; i++) {
            int index = searchHash(hash, hashLength, i);
            System.out.println("原数组中有" + i + "这个元素");
        }
    }

    public static int searchHash(int[] hash, int hashLength, int key) {
        int index = key % hashLength;
        while (hash[index] != 0 && hash[index] != key) {
            index = (++index) % hashLength;
        }
        if (hash[index] == 0) {
            return -1;
        }
        return index;
    }

    public static void insertHash(int[] hash, int data) {
        int index = data % hash.length;
        while (hash[index] != 0) {
            index = (++index) % hash.length;
        }
        hash[index] = data;
    }
}
