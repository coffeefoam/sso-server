/**
 * Copyright (c) 2011, yoomai.net. All rights reserved.
 * yoomai.cn. Use is subject to license terms.
 */
package net.yoomai.util;

/**
 * @(#)StringUtils.java 1.0 14/09/2012
 */

import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @author Ray
 * @version 1.0, 13/07/2011
 * @since 1.5
 */
public class StringUtils {
    private static char[] HEXCHAR = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final static SecureRandom sr;

    static {
        sr = new SecureRandom();
    }

    private StringUtils() {

    }

    /**
     * ͨ��MD5����
     *
     * @param s
     * @return
     */
    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ���ֽ�����ת����16�����ַ���
     *
     * @param b
     * @return
     */
    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEXCHAR[(b[i] & 0xf0) >>> 4]);
            sb.append(HEXCHAR[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    /**
     * ���ַ���ת����16�����ֽ�
     *
     * @param s
     * @return
     */
    public static byte[] toBytes(String s) {
        byte[] bytes;
        bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2),
                    16);
        }
        return bytes;
    }

    /**
     * �ַ�������ת��
     *
     * @param str  ��ת���ַ���
     * @param from �ַ���ת��֮ǰ�ı���
     * @param to   �ַ���ת��֮��ı���
     * @return ת�����ַ���
     */
    public static String iconv(String str, String from, String to) {
        String value;
        if (str == null || str.length() == 0) {
            return "";
        }

        try {
            value = new String(str.getBytes(from), to);
        } catch (Exception e) {
            return null;
        }
        return value;
    }

    /**
     * ��������λ������ַ���
     *
     * @param len �����λ��
     * @return �����
     */
    public static synchronized String getUniqueID(int len) {
        if (len < 1) return null;
        final char[] alphabet = ("12345abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ67890").toCharArray();
        byte[] b = new byte[len];
        sr.nextBytes(b);
        char[] out = new char[len];
        for (int i = 0; i < len; i++) {
            int index = b[i] % alphabet.length;
            if (index < 0) index += alphabet.length;
            out[i] = alphabet[index];
        }
        return new String(out);
    }

    /**
     * �ṩ��ȡ�ַ���������Ϣ
     *
     * @param original   ����ȡ���ַ���
     * @param split      ��ȡʱ�ķָ���
     * @param index      ��Ҫ��Ϣ����Ӧ������
     * @param nullString �ṩĬ��ֵ
     * @return ��ȡ�����Ϣ
     */
    public static String split(String original, String split, int index, String nullString) {
        String ret = nullString;

        String[] splited = original.split(split);
        if (index < splited.length) {
            ret = splited[index];
        }
        return ret;
    }

    /**
     * ���ַ���������Ӧλ��ʱ��߲�λ
     */
    public static String leftPadding(String orgStr, String addStr, int strLength) {
        if (orgStr.length() < strLength) {
            String padding = new String();
            int len = strLength - orgStr.length();
            for (int loop = 0; loop < len; loop++) {
                padding = padding + addStr;
            }
            padding = padding + orgStr;
            return padding;
        } else {
            return orgStr;
        }
    }
}
