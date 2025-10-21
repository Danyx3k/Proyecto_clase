package co.edu.uco.nose.crosscuting.helper;

public final class TextHelper {
    private static final String EMPTY = "";
    private TextHelper(){
    }
    public static String getDefault(){
        return EMPTY;
    }
    public static String getDefault(final String value){
        return ObjectHelper.getDefault(value,getDefault());
    }
    public static String getDefaultwithTrim(final String value){
        return getDefault(value).trim();
    }
    public static boolean isEmptyWithTrim(final String value) {
        return EMPTY.equals(getDefault(value).trim());
    }
}
