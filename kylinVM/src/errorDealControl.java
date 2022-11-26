public class errorDealControl {
    public static String getError_FileNotFind(String name) {
        //return a message of the file error.
        //this error log is kylin vm do not find the file.
        return "[Eraro] Kylin Eraro: Ne trovita = "+name;
    }
    public static String getError_Value_defined(String message) {
        //The variable is already defined
        return "[Eraro] Kylin Eraro: La variablo estas jam difinita"+message;
    }
}
