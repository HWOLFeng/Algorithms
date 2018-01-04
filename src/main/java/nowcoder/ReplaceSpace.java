package nowcoder;

import java.util.Iterator;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/4.
 */
public class ReplaceSpace {
    /**
     * 这题对java太简单了
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }
}
