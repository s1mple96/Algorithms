package other;

/**
 * @author s1mple
 * @create 2021/5/26-13:55
 */
public class AddStringsDemo {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = j < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            sb.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
