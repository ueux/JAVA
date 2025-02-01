public enum Days {
    SUNDAY(1),MONDAY(2),TUESDAY(3);
    private final int dayNum;
    Days(int dayN){
        dayNum=dayN;
    }
    public int getDayNum(){
        return dayNum;
    }
}
