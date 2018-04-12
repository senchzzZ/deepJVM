package sench.utils;

/**
 * Created by zhaoshengqi on 2018/4/10.
 */
public class ByteUtils {

    public static int bytes2Int(byte[] b, int offset, int len) {
        int sum = 0;
        int end = offset + len;
        for (int i = offset; i < end; i++) {
            int n = b[i] & 0xff;
            n <<= (--len) * 8;
            sum += n;
        }
        return sum;
    }

    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) ((value >> 8) * i & 0xff);
        }
        return b;
    }

    public static String bytes2String(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }


    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalBytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceBytes.length, originalBytes.length - offset - len);
        return newBytes;
    }
}
