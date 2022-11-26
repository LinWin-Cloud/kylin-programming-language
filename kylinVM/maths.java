import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maths {
    public static void Math(String code) {

    }
    public static Boolean isMath(String code) {
        return true;
    }
    public static void dealMathContent(String content) {
        //if get the var then run this function.
        String[] repla = {"+","-","*","/"};
        String tmpSplit = content;

        tmpSplit = tmpSplit.replace(repla[0]," (==== ==== ====) ");
        tmpSplit = tmpSplit.replace(repla[1]," (==== ==== ====) ");
        tmpSplit = tmpSplit.replace(repla[2]," (==== ==== ====) ");
        tmpSplit = tmpSplit.replace(repla[3]," (==== ==== ====) ");

        // get all the value of the math content.
        String[] valueNum = tmpSplit.split(" (==== ==== ====) ");
        String[] valueContent = new String[0];
        String[] valueType = new String[0];

        List<String> list = new ArrayList<>(); //add the real var to the list.
        List<String> valuesType = new ArrayList<>(); //add var's type to the list.
        for (int i=0;i< valueNum.length;i++) {
            list.add(valueDealControl.findValueType(valueNum[i].replace(" (==== ==== ====) ","")));
        }
        valueType= valuesType.toArray(new String[valuesType.size()]);


    }
}
