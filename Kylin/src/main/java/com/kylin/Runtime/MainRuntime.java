package com.kylin.Runtime;

import com.kylin.Exception.RuntimeError;
import com.kylin.Exception.SyntaxError;
import com.kylin.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class MainRuntime {

    public static HashMap<String,Value> value = new HashMap<>();
    public static HashMap<String,String> function = new HashMap<>();

    public static void run() {
        int size = Main.code.size();
        for (int codeLine = 0 ; codeLine < size ; codeLine++) {
            String source_code = Main.code.get(codeLine);

            String[] words = source_code.split(" ");
            if (words[0].startsWith("//")) {
                continue;
            }
            if (words[0].startsWith("func")) {
                try {
                    String FunctionName = words[1];
                    String FunctionContent = source_code.substring(source_code.indexOf("(")+1,source_code.lastIndexOf(")")-1);
                    String[] InputValue = FunctionContent.split(",");

                    ArrayList<String> FunctionCode = new ArrayList<>();

                    //System.out.println("function start: "+codeLine);
                    for (int i = codeLine ; codeLine < size ; i++) {
                        String line = Main.code.get(i).trim();

                        if (line.startsWith("end")) {
                            codeLine = i;
                            //System.out.println("Function end:" + codeLine);
                            break;
                        }
                        FunctionCode.add(line);
                    }
                    Function func = new Function();
                    func.FunctionCode = FunctionCode;
                    func.FunctionName = FunctionName;
                    for (String i : InputValue){
                        func.FunctionValue.put(i.trim(),null);
                    }
                }catch (Exception exception){
                    sendSyntaxError("Defined function error.",codeLine+1);
                }
                continue;
            }
            if (words[0].startsWith("let")) {
                try {
                    String name = words[1];
                    String value = source_code.substring(source_code.indexOf("=")+1).trim();
                    Value NewValue = new Value();
                    NewValue.name = name;
                    NewValue.value = value;
                    //System.out.println(name+" "+value+";");

                    MainRuntime.value.put(name,NewValue);
                }
                catch (Exception exception){
                    sendSyntaxError("Defined variable error.",codeLine+1);
                }
                continue;
            }
            if (words[0].startsWith("try")){
                ArrayList<String> TryCode = new ArrayList<>();
                try {
                    String CatchValue = null;
                    for (int i = codeLine ; i < Main.code.size() ; i++) {
                        if (Main.code.get(i).startsWith("catch")) {

                        }
                    }
                }catch (Exception exception){
                    MainRuntime.sendRuntimeError("Syntax Error",codeLine);
                }
            }
            else {
                BaseRuntime.exec(source_code,codeLine+1);
                continue;
            }
        }
    }
    public static void sendSyntaxError(String message,int line) {
        SyntaxError syntaxError = new SyntaxError();
        syntaxError.setFile(Main.resource.getAbsolutePath());
        syntaxError.setMessage(message);
        syntaxError.setLine(line);
        syntaxError.setTime();
        System.out.println(syntaxError.getError());
        System.exit(0);
    }
    public static void sendRuntimeError(String message,int line) {
        RuntimeError runtimeError = new RuntimeError();
        runtimeError.setFile(Main.resource.getAbsolutePath());
        runtimeError.setLine(line);
        runtimeError.setTime();
        runtimeError.setMessage(message);
    }
}
