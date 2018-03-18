class Chef {

    // 點一份 牛排
    void cook() {
        cook('A');
    }

    // 點一份 牛排 or 豬排
    void cook(char meal) {
        cook(meal, 1);
    }

    // 點很多份 牛排 or 豬排
    void cook(char meal, int quantity) {

        if (quantity < 1) return;

        switch (meal) {
            case 'A':
                System.out.println("準備 A 號餐: 牛排");
                break;
            case 'B':
                System.out.println("準備 B 號餐: 豬排");
                break;
            default:
                System.out.println("食屎吧你");
                break;
        }

        // 做好一份了，剩下 quantity - 1 份
        cook(meal, quantity - 1); // 遞迴呼叫
    }
}
