package ysoserial.test.hacker;

import org.junit.Test;
import ysoserial.payloads.Jdk7u21;

/**
 *
 *
 * @author cdliuhaibo
 * @date 2020/2/20
 */
public class Jdk7u21Test {
    @Test
    public void test() {
        HackerUtils.hack4Explorer(new Jdk7u21());

        System.out.println(127 * ("f5a5a608").hashCode() ^ 222);
    }
}
