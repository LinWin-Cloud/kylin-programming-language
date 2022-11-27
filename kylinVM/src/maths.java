import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class maths {
    public static void Math(String code) {

    }
    public static Boolean isMath(String code) {
        Boolean bool = false;
        String[] mathTo = {"+","-","*","/","**","%"};
        for (int i =0;i<mathTo.length;i++) {
            if (code.indexOf(mathTo[i])!=-1){
                bool = true;
                break;
            }
        }
        return bool;
    }
    public static String dealMathContent(String content) {
        //if get the var then run this function.
        String last = "";
        String[] repla = {"+","-","*","/"};
        String tmpSplit = content;

        tmpSplit = tmpSplit.replace(repla[0]," ==== ==== ==== ");
        tmpSplit = tmpSplit.replace(repla[1]," ==== ==== ==== ");
        tmpSplit = tmpSplit.replace(repla[2]," ==== ==== ==== ");
        tmpSplit = tmpSplit.replace(repla[3]," ==== ==== ==== ");

        String[] getNumber = tmpSplit.split(" ==== ==== ==== ");
        String getMathCharString = "";
        System.out.println(content+";");

        for (int i=0;i<content.length();i++) {
            for (int a=0;a<repla.length;a++) {
                if (content.substring(i,i+1).equals(repla[a])) {
                    getMathCharString = getMathCharString + " " + repla[a];
                }
            }
        }
        String[] getMathChar = getMathCharString.split(" ");

        int length = getNumber.length;
        for (int i=0;i<length-1;i++) {
            String value1 = getNumber[i];
            String value2 = getNumber[i+1];
            String getValue1Type = valueDealControl.getValueType(value1);
            String getValue2Type = valueDealControl.getValueType(value2);

            if (getValue1Type.equals(getValue2Type) && getValue1Type.equals("int")) {
                //is int to math.
                int valueInt1 = Integer.valueOf(value1);
                int valueInt2 = Integer.valueOf(value2);
                String mathChar = getMathChar[i];

                last = String.valueOf(valueInt1+valueInt2);

                if (mathChar.equals("+")) {
                    last = String.valueOf(valueInt1+valueInt2);
                    break;
                }
            }

        }

        return last;
    }
}
