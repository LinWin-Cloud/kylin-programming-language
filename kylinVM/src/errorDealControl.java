public class errorDealControl {
    public static String getError_FileNotFind(String name) {
        //return a message of the file error.
        //this error log is kylin vm do not find the file.
        return "[Eraro] Ne trovi = "+name;
    }
    public static String getError_Value_defined(String message) {
        //The variable is already defined
        return "[Eraro] La variblo estas difinita"+message;
    }
    public static String getError_CodeError(String message) {
        //this is a code error.
        return "[Eraro] La koda eraro: "+message;
    }
}
