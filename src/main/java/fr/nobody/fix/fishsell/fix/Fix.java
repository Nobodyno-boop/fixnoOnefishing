package fr.nobody.fix.fishsell.fix;

import com.google.common.collect.Lists;
import javassist.*;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.ArrayList;

public class Fix implements ClassFileTransformer {

    public static void premain(String args, Instrumentation instrumentation)
    {
        instrumentation.addTransformer(new Fix());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className == null) {
            return null;
        }
        className = className.replace("/", ".");
        if (className.equalsIgnoreCase("me.nooneboss.Utils.ColorUtils") || className.equalsIgnoreCase("nf.noonefishing.NooneFishing")) {
            System.out.println("BITE : "+ className);
            try {
                ClassPool pool = ClassPool.getDefault();
                pool.appendClassPath(new ByteArrayClassPath(className, classfileBuffer));
                // adding base source
                pool.importPackage("java.util.regex.Matcher");
                pool.importPackage("java.util.regex.Pattern");
                pool.importPackage("net.md_5.bungee.api.ChatColor");
                CtClass ct = pool.get(className);

                CtClass[] args = {pool.getCtClass("java.lang.String")};
                CtMethod tf = ct.getDeclaredMethod("hex", args);
                // the current method add condition to check if the server is on "1.16" and "1.17" but not higter...
                tf.setBody("            {for (Matcher match = Pattern.compile(\"(#\\\\w{6})\").matcher($1); match.find(); match = Pattern.compile(\"(#\\\\w{6})\").matcher($1)) {\n" +
                        "                final String color = $1.substring(match.start(), match.end());\n" +
                        "                $1 = $1.replace(color, ChatColor.of(color) + \"\");\n" +
                        "            }"+
                        "return ChatColor.translateAlternateColorCodes('&', $1);}");

                System.out.println("We fix the color on it!");
                return ct.toBytecode();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return null;
    }

}
