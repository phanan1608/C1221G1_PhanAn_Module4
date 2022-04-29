package com.exercise2.service.impl;

import com.exercise2.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    static Map<String,String> stringMap = new HashMap<>();
    static {
        stringMap.put("luat","non lắm");
        stringMap.put("an","đẹp trai siêu cấp vip pro");
        stringMap.put("cat","con mèo");
        stringMap.put("dog","con chó");
        stringMap.put("book","quyển sách");

    }

    @Override
    public String search(String string) {
        Set<String> keySet = stringMap.keySet();
        String result = "";
        for (String key : keySet) {
            if (key.equals(string)){
                result = stringMap.get(key);
            }
        } if (result.equals("")){
            result = "Not Found";
        }
        return result;
    }
}
