package com.example.sign;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wgh  2018/8/21
 * @add v9.6.0
 * @description
 */
public class SignMain {

    public static void main(String[] args){
//        String params = "phone=13524721413&type=0&type=0&push_token=ea4f0d740db719c0a4a816702d45410ed6a35d12e363f41fc1bcb05a5e32df6a&udid=d265a41d54f97ffdbcc6e958246244113a7e4e3c&openid=d265a41d54f97ffdbcc6e958246244113a7e4e3c&v=9.5.6&devicetoken=7a9ed0f271519a311f215b24cca1e7cd&token=71bcb88688a6719da7193899e6fcc4f3&source=iphone&connectnet=wifi&lng=121.621705&lat=31.210660&os=iphone&his=1534326138.1534820679&device_model=iPhone&device_brand=iPhone7,1&wcctoken=&os_version=8.0&sign=9528a1498d3ab35c9fe9722949be713f";
//        String params = "newudid=05682ec8dc3c131b5c911c61cdbdffed&ectoken=3f94a2f23a2284cabeb0c642c7fe4e37&os=Android&device_model=ONEPLUS+A3010&lng=121.626458&os_version=8.0.0&sign=0dc13bd785a9e14eff5c19fecf4be91b&type=0&mac=94%3A65%3A2d%3A2b%3A41%3A25&varcode=&his=1532927688.1534830173&device_brand=OnePlus&phone=17521000828&v=9.5.7&connectnet=4g&wcctoken=&udid=864854033869293&lat=31.208406&push_token=Aqc7m5FAPh2tszUJsq43qIypx3s1orIs3cjmIvQC-7bq&city_id=1";
        String params = "phone=13524721413&type=0&type=0&push_token=ea4f0d740db719c0a4a816702d45410ed6a35d12e363f41fc1bcb05a5e32df6a&udid=d265a41d54f97ffdbcc6e958246244113a7e4e3c&openid=d265a41d54f97ffdbcc6e958246244113a7e4e3c&v=9.5.6&devicetoken=7a9ed0f271519a311f215b24cca1e7cd&token=71bcb88688a6719da7193899e6fcc4f3&source=iphone&connectnet=wifi&lng=121.621705&lat=31.210660&os=iphone&his=1534326138.1534820679&device_model=iPhone&device_brand=iPhone7,1&wcctoken=&os_version=8.0";
        if (params.contains("?")){
            params = params.substring(params.indexOf("?"), params.length());
        }
        final String signKey = "41907eed8d2948475d3cdf1f00579186";
        String[] strs = params.split("&");
        Map<String, String> nameValues = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            String[] ss = strs[i].split("=");
            if (ss.length > 1){
                nameValues.put(ss[0], ss[1]);
            } else {
                nameValues.put(ss[0], "");
            }
        }

        Object[] array = nameValues.keySet().toArray();
        String[] keys = new String[array.length];
        int i = 0;
        for (Object o : array) {
            keys[i++] = (String) o;
        }
        Arrays.sort(keys);

        StringBuffer sb = new StringBuffer(256);
        for (String key : keys) {
            if ("sign".equals(key)){
                continue;
            }
            String value = nameValues.get(key);
            if (value == null) {
                sb.append(key).append(value);
            } else {
                sb.append(key).append(DataConverter.urlDecode(value));
            }
        }
//        sb.append("connectnetwifidevice_brandiPhone7,1device_modeliPhonedevicetoken7a9ed0f271519a311f215b24cca1e7cdhis1534326138.1534820679lat31.210660lng121.621705openidd265a41d54f97ffdbcc6e958246244113a7e4e3cos_version8.0osiphonephone13524721413push_tokenea4f0d740db719c0a4a816702d45410ed6a35d12e363f41fc1bcb05a5e32df6asourceiphonetoken71bcb88688a6719da7193899e6fcc4f3type0udidd265a41d54f97ffdbcc6e958246244113a7e4e3cv9.5.6wcctoken");
        System.out.println("sb " + sb.toString());
        String s = signKey + DataConverter.getMD5(sb.toString().getBytes())
                + signKey;
        System.out.println("sign1 " + s);
        String md5 = DataConverter.getMD5(s.getBytes());
        System.out.println("sign = " + md5);
    }

}
