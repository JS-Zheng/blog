/**
 * 哈寶寶早餐店 繼承 BreakfastJoint
 * 為工廠的子類別
 */
public class HaBoBoBreakfastJoint extends BreakfastJoint {

    public static final int CA_LA_Chicken = 1;
    public static final int GARLIC_CHILI_SPAGHETTI = 2;
    public static final int MILK_TEA = 3;

    // 做早餐 並回傳
    // param: int
    @Override
    public Breakfast makeBreakfast(int type) {

        Breakfast breakfast = null;

        switch (type) {
            case CA_LA_Chicken:
                breakfast = new CaLaChickenBurger();
                break;
            case GARLIC_CHILI_SPAGHETTI:
                breakfast = new GarlicChiliSpaghetti();
                break;
            case MILK_TEA:
                breakfast = new MilkTea();
                break;
        }
        // 製作 咔拉雞腿滿福堡 並回傳
        return breakfast;
    }

}
