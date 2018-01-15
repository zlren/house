package lab.zlren.house.common.result;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author zlren
 * @date 2018-01-15
 */
@Data
public class ResultMsg {

    public static final String ERROR_MSG_KEY = "errorMsg";

    public static final String SUCCESS_MSG_KEY = "successMsg";

    private String errorMsg;

    private String successMsg;

    public boolean isSuccess() {
        return errorMsg == null;
    }


    public static ResultMsg errorMsg(String msg) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setErrorMsg(msg);
        return resultMsg;
    }

    public static ResultMsg successMsg(String msg) {
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setSuccessMsg(msg);
        return resultMsg;
    }


    public Map<String, String> asMap() {
        Map<String, String> map = Maps.newHashMap();
        map.put(SUCCESS_MSG_KEY, successMsg);
        map.put(ERROR_MSG_KEY, errorMsg);
        return map;
    }

    public String asUrlParams() {
        Map<String, String> map = asMap();
        Map<String, String> newMap = Maps.newHashMap();
        map.forEach((k, v) -> {
            if (v != null) {
                try {
                    newMap.put(k, URLEncoder.encode(v, "utf-8"));
                } catch (UnsupportedEncodingException ignored) {

                }
            }
        });
        return Joiner.on("&").useForNull("").withKeyValueSeparator("=").join(newMap);
    }
}
