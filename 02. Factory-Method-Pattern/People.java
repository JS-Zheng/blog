/**
 * 人
 * 負責吃早餐
 */
class People {

    private Breakfast breakfast;

    public People(Breakfast breakfast) {
        this.breakfast = breakfast;
    }

    public People() {

    }

    public void setBreakfast(Breakfast breakfast) {
        this.breakfast = breakfast;
    }

    // 吃早餐
    public void eatBreakfast() {

        if (breakfast != null) {
            breakfast.eaten();
        }
    }
}
