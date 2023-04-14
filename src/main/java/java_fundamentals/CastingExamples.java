package java_fundamentals;

public class CastingExamples {
    public static void main(String[] args) {

        //numberic types
        //manual casting means that we cast from bigger type to a smaller type
        //double(8 bytes), long(8 bytes) > float(4 bytes), int(4 bytes) > short(2 bytes), char(2 bytes) >  byte(1 byte)

        //boolean type
        //you cannot cast from other primitive types to boolean as it is not a numeric type,
        // nd you can't do bitwise operations on it as you must
        //us logical operations instead

        //prints -128(truncated 128 is more than maximum positive value of byte type so the next most negative is taken)
        System.out.println((byte)128.75d);
        //print 127(truncated 127 value fits the maximum value of byte type)
        System.out.println((byte)127.75d);
        // truncated value of 65 corresponds to character 'A' in ASCII
        System.out.println((char)65.75);
        // truncated value can be only in 1 to 128 range for char type to represent ASCII characters otherwise we get '?'
        // character
        System.out.println((char)128.75d);



        //automatic from smaller to bigger primitive type
        double a = 0.0d;
        byte b = 127;
        a = b;
        //prints 127.0
        System.out.println(a);


    }
}
