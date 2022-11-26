public class errorDealControl {
    public static String getError_FileNotFind(String name) {
        //return a message of the file error.
        //this error log is kylin vm do not find the file.
        return "[Error] Not Find = "+name;
    }
    public static String getError_Value_defined(String message) {
        //The variable is already defined
        return "[Error] The variable is already defined"+message;
    }
    public static String getError_CodeError(String message) {
        //this is a code error.
        return "[Error] The Code Error: "+message;
    }
}
