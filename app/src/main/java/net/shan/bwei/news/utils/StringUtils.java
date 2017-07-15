package net.shan.bwei.news.utils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;

/**
 * 字符串相关的工具类。
 */
public class StringUtils {

    /**
     * 判断n个字符串均不为空
     *
     * @param args 要判断的字符串
     * @return 有任何一个字符串为空，会返回false。全部不为空则返回true。
     */
    public static boolean isNotEmpty(CharSequence... args) {
        if (args != null) {
            for (CharSequence text : args) {
                if (isEmpty(text)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 判断给定的字符串是否为空。
     *
     * @param text 要判断的字符串
     * @return 给定的字符串为空时返回true。否则返回false。
     */
    public static boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }

    /**
     * 判断一个字符串中是否含有可以阅读的字符。
     * 比如说如果一个字符串中只包含空格和回车等等，这个方法会返回false。
     *
     * @param text 要判断的字符串
     * @return 给定的字符串中有可以阅读的字符时返回true。否则返回false。
     */
    public static boolean hasReadableText(CharSequence text) {
        return text != null && isNotEmpty(text.toString().replaceAll("\\s", ""));
    }

    /**
     * 比较两个字符串是否相等，同时检查null字符串，保证不会崩溃
     *
     * @param text1
     * @param text2
     * @return
     */
    public static boolean equals(CharSequence text1, CharSequence text2) {
        if (text1 == null || text2 == null) {
            // text1 = null, text2 = "" 这种情况也认为是相同字符串。
            return isEmpty(text1) && isEmpty(text2);
        } else {
            return text1.toString().equals(text2.toString());
        }
    }

    /**
     * 比较两个字符串是否相等（忽略大小写），同时检查null字符串，保证不会崩溃
     *
     * @param text1
     * @param text2
     * @return
     */
    public static boolean equalsIgnoreCase(CharSequence text1, CharSequence text2) {
        if (text1 == null || text2 == null) {
            return text1 == null && text2 == null;
        } else {
            return text1.toString().equalsIgnoreCase(text2.toString());
        }
    }

    /**
     * 去掉字符串首尾的空白字符
     * 类似{@link String#trim()}，但是这个方法会同时过滤掉包括全角的空白字符等。
     *
     * @param str 要trim的字符串
     * @return trim后的字符串
     */
    public static CharSequence trimWhitespace(CharSequence str) {
        if (isEmpty(str)) {
            return "";
        }

        int start = 0;
        int end = str.length() - 1;

        while (start <= end && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        while (end >= start && Character.isWhitespace(str.charAt(end))) {
            end--;
        }

        // 这里 end 需要+1，因为 subSequence 的 end 参数是 exclusive 的。
        return str.subSequence(start, end + 1);
    }

    /**
     * 忽略大小写，包含关系
     * 如果存在null,默认返回false
     *
     * @param str
     * @param key
     * @return
     */
    public static boolean containsIgnoreCase(String str, String key) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(key)) {
            return false;
        }

        return str.toLowerCase().contains(key.toLowerCase());
    }

    /**
     * 判断某一个字符串里边是否含有换行符
     *
     * @param str 要判断的字符串
     * @return 如果含有换行符返回true。否则返回false。
     */
    public static boolean containsLineBreak(String str) {
        return isNotEmpty(str) && (str.contains("\n") || str.contains("\r"));
    }

    /**
     * 判断某一个字符串里边是否含有参数里边指明的所有子串
     *
     * @param findFrom
     * @param args
     * @return
     */
    public static boolean containsAll(String findFrom, CharSequence... args) {
        if (isEmpty(findFrom)) {
            return false;
        }

        if (args != null) {
            for (CharSequence arg : args) {
                if (!findFrom.contains(arg)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 将n个字符串合并到一起
     *
     * @param splitter 分隔符
     * @param args     要合并的数据。如果不是字符串会自动调用toString
     * @return 合并之后的字符串
     */
    public static CharSequence join(char splitter, Object... args) {
        if (args == null) {
            return "";
        }

        CharSequence csSplitter = String.valueOf(splitter);

        if (args.length == 1 && args[0] instanceof Iterable) {
            return join(csSplitter, args[0]);
        } else {
            return join(csSplitter, Arrays.asList(args));
        }
    }

    /**
     * 将n个字符串合并到一起
     *
     * @param splitter 分隔符
     * @param args     要合并的数据。如果不是字符串会自动调用toString
     * @return 合并之后的字符串
     */
    public static CharSequence join(CharSequence splitter, Object... args) {
        if (args == null) {
            return "";
        }

        if (args.length == 1 && args[0] instanceof Iterable) {
            return join(splitter, args[0]);
        } else {
            return join(splitter, Arrays.asList(args));
        }
    }

    /**
     * 将n个字符串合并到一起，忽略掉null对象。
     *
     * @param splitter 分隔符
     * @param args     要合并的数据。如果不是字符串会自动调用toString
     * @return 合并之后的字符串
     */
    public static CharSequence joinSkippingNull(CharSequence splitter, Object... args) {
        if (args == null) {
            return "";
        }

        if (args.length == 1 && args[0] instanceof Iterable) {
            return join(splitter, args[0], true);
        } else {
            return join(splitter, Arrays.asList(args), true);
        }
    }

    /**
     * 将n个字符串合并到一起
     *
     * @param splitter 分隔符
     * @param args     要合并的数据。如果不是字符串会自动调用toString
     * @return 合并之后的字符串
     */
    public static CharSequence join(CharSequence splitter, Iterable<?> args) {
        return join(splitter, args, false);
    }

    /**
     * 将n个字符串合并到一起，忽略掉null的对象。
     *
     * @param splitter 分隔符
     * @param args     要合并的数据。如果不是字符串会自动调用toString
     * @return 合并之后的字符串
     */
    public static CharSequence joinSkippingNull(CharSequence splitter, Iterable<?> args) {
        return join(splitter, args, true);
    }

    private static CharSequence join(CharSequence splitter, Iterable<?> args, boolean skippingNull) {
        if (args == null) {
            return "";
        }

        Iterator<?> iterator = args.iterator();
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next == null && skippingNull) {
                continue;
            }

            if (!first) {
                builder.append(splitter);
            }
            builder.append(next);
            first = false;
        }
        return builder.toString();
    }

    /**
     * 检查query是否在args中
     *
     * @param query 要查询的字符串
     * @param list  被查询的字符串列表
     * @return 如果query在list之中，返回true。否则返回false。
     * @see {@link #inListIgnoreCase(CharSequence, CharSequence...)}
     */
    public static boolean inList(CharSequence query, CharSequence... list) {
        for (CharSequence arg : list) {
            if (StringUtils.equals(query, arg)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 检查query是否在args中
     * 同{@link #inList(CharSequence, CharSequence...)}。但是这个会忽略大小写。
     *
     * @param query 要查询的字符串
     * @param list  被查询的字符串列表
     * @return 如果query在list之中，返回true。否则返回false。
     * @see {@link #inList(CharSequence, CharSequence...)}
     */
    public static boolean inListIgnoreCase(CharSequence query, CharSequence... list) {
        for (CharSequence arg : list) {
            if (StringUtils.equalsIgnoreCase(query, arg)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 从一个字符串开头截取指定长度
     *
     * @param str    要截取的字符串
     * @param length 要截取的长度
     * @return 如果字符串长于指定长度，则截取指定长度且加上省略号。反之直接返回字符串本身。
     */
    public static CharSequence truncate(CharSequence str, int length) {
        if (str == null) {
            return null;
        }

        if (str.length() <= length) {
            return str;
        }

        return str.subSequence(0, length - 1) + " ...";
    }

    /**
     * 将一个字符串转换成整数。如果字符串不能够顺利转换，返回0
     *
     * @param str 要转换的字符串
     * @return 转换成的整数
     */
    public static int toInt(CharSequence str) {
        try {
            return Integer.valueOf(String.valueOf(str));
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 将一个字符串转换成Float。如果字符串不能够顺利转换，返回0
     *
     * @param str 要转换的字符串
     * @return 转换成的Float
     */
    public static float toFloat(String str) {
        try {
            return Float.valueOf(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 判断一个字符串是不是一个数字。
     *
     * @param str 要判断的字符串
     * @return 如果是数字返回true，否则返回false。
     */
    public static boolean isNumber(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 将一个Object转换成String。
     * 如果Object为null，返回空字符串。
     *
     * @param object 要转换的Object
     * @return 转换成的String
     */
    public static String toStr(Object object) {
        if (object == null) {
            return "";
        }
        return String.valueOf(object);
    }

    /**
     * 从一个字符串里边过滤出一些子字符串。
     *
     * @param str     要处理的字符串
     * @param filters 要被 filter out 的字符串
     * @return 处理后的字符串
     */
    public static String filterOut(String str, CharSequence... filters) {
        if (isEmpty(str) || filters == null) {
            return str;
        }

        for (CharSequence filter : filters) {
            str = str.replace(filter, "");
        }

        return str;
    }

    /**
     * 从一段Path里边截取出最后一段。
     * 比如说输入 res/drawable-xhdpi-v4/ic_ark_author.png
     * 的时候会返回 ic_ark_author.png
     *
     * @param str 输入的文件路径或者uri路径的字符串。
     * @return 最后一个段。如果字符串中没有分隔符，返回原字符串。
     */
    public static String lastSegment(String str) {
        return lastSegment(str, '/');
    }

    /**
     * 从一个含有分隔符的字符串里边找出最后一段。
     * 比如说输入 ic_ark_author.png 时，会返回 png
     *
     * @param str     输入的文件路径或者uri路径的字符串。
     * @param divider 分割符
     * @return 最后一个段。如果字符串中没有分隔符，返回原字符串。
     */
    public static String lastSegment(String str, char divider) {
        int index = str.lastIndexOf(divider);
        if (index == str.length() - 1) {
            return "";
        }
        if (index >= 0) {
            return str.substring(index + 1);
        }

        return str;
    }

    /**
     * 从一个含有分隔符的字符串里边删除最后一段（包括分隔符）。
     * 比如说输入 ic_ark_author.png 时，会返回 ic_ark_author
     *
     * @param str     输入的文件路径或者uri路径的字符串。
     * @param divider 分割符
     * @return 最后一个段。如果字符串中没有分隔符，返回原字符串。
     */
    public static String removeLastSegment(String str, char divider) {
        int index = str.lastIndexOf(divider);
        if (index == str.length() - 1) {
            return str;
        }
        if (index >= 0) {
            return str.substring(0, index);
        }

        return "";
    }

    /**
     * 将一个字符串分开成n个部分，取出指定的某一个段落。
     *
     * 例：
     * getSegment("www.douban.com", '.', 0) -> "www"
     * getSegment("www.douban.com", '.', 1) -> "douban"
     * getSegment("www.douban.com", '.', 2) -> "com"
     * getSegment("www.douban.com", '.', 3) -> ""
     * getSegment("www.douban.com", '.', -1) -> "com"
     * getSegment("www.douban.com", '.', -2) -> "douban"
     * getSegment("www.douban.com", '.', -3) -> "www"
     * getSegment("www.douban.com", '.', -4) -> ""
     *
     * @param str     要拆分的字符串
     * @param index   要取得段的编号。如果是>=0，从左侧开始取，如果是<0，从右侧开始取。
     * @return 相应的段落。
     */
    public static String getSegment(String str, int index) {
        if (isEmpty(str)) {
            return "";
        }

        // 这里可以通过调整最后一个参数提升性能，只分割有用的部分。
        final String[] segments = str.split("\\.", 0);
        if (index >= 0 && index < segments.length) {
            return segments[index];
        } else if (index < 0 && index >= -segments.length) {
            return segments[segments.length + index];
        } else {
            return "";
        }
    }

    /**
     * 尝试将一个字符串转化为UUID。
     *
     * @param cs 输入的字符串。
     * @return 转化成的UUID。如果转化失败，返回null。
     */
    public static UUID toUUID(CharSequence cs) {
        try {
            return UUID.fromString(toStr(cs));
        } catch (Throwable e) {
            return null;
        }
    }
}
