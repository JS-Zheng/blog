public class Main {

    public static void main(String[] args) {

        int dec = 9487; // 十進制

        int binary = 0b10010100001111; // 二進制 前綴表示法 0b

        // (在 Java 7 後，可使用『底線』幫助閱讀，稱為 Underscores in Numeric Literals)
        int binary2 = 0b10_0101_0000_1111; // 二進制 前綴表示法二 0b

        int oct = 022417; // 八進制 前綴表示法 0 (不建議使用)

        int hex = 0x250F; // 十六進制 前綴表示法 0x

        System.out.println("十進制: " + dec);
        System.out.println("二進制 前綴表示法: " + binary);
        System.out.println("二進制 前綴表示法二: " + binary2);
        System.out.println("八進制 前綴表示法: " + oct);
        System.out.println("十六進制 前綴表示法: " + hex);
    }
}


/*
 * Result:
 *
 * 十進制: 9487
 * 二進制 前綴表示法: 9487
 * 二進制 前綴表示法二: 9487
 * 八進制 前綴表示法: 9487
 * 十六進制 前綴表示法: 9487
 *
 */