package org.feichai.common.domain;

import java.util.HashMap;

public class ResponseBo extends HashMap<String, Object> {
    private static final long serialVersionUID = -8713837118340960775L;

    private static final Integer SUCCESS = 0;
    private static final Integer WARN = 1;
    private static final Integer FAIL = 500;

    public static ResponseBo resp(Integer code, String msg) {
        ResponseBo responseBo = new ResponseBo();
        responseBo.put("code", code);
        responseBo.put("msg", msg);
        return responseBo;
    }

    public static ResponseBo ok(String msg) {
        return ResponseBo.resp(SUCCESS, msg);
    }

    public static ResponseBo ok() {
        return ResponseBo.ok("success");
    }

    public static ResponseBo warn(String msg) {
        return ResponseBo.resp(WARN, msg);
    }

    public static ResponseBo error(String msg) {
        return ResponseBo.resp(FAIL, msg);
    }

    public static ResponseBo error() {
        return ResponseBo.error("failed");
    }

    public static ResponseBo failure(Integer code, String msg) {
        return ResponseBo.resp(code, msg);
    }


}
