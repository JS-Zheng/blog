public class Main {
    public static void main(String[] args) {

        // 1. 實例 People 物件 -- 我
        People me = new People();

        // 2. 選擇一家早餐店
        BreakfastJoint breakfastJoint = new HaBoBoBreakfastJoint(); // 哈寶寶
//        BreakfastJoint breakfastJoint = new MWDBreakfastJoint(); // 麥味燈
//        BreakfastJoint breakfastJoint = new DeFangMiBreakfastJoint(); // 德方美
//        BreakfastJoint breakfastJoint = new XXBreakfastJoint(); // XX 美而美

        // 3. 選擇要吃的早餐 (兩種方式)
        Breakfast breakfast = breakfastJoint.makeBreakfast(HaBoBoBreakfastJoint.CA_LA_Chicken);
//        Breakfast breakfast2 = breakfastJoint.makeBreakfast(CaLaChickenBurger.class);


        // 4. 將早餐拿給我
        me.setBreakfast(breakfast);

        // 5. 開吃囉
        me.eatBreakfast();
    }
}


// Result:
// 咔拉雞腿滿福堡 好棒棒