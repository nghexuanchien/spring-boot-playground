package springwebfluxdemo.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author chiennghe
 */
public class Utils {

    private Utils (){}

    public static <T> T convertMapToObject(Map<String, String> map, Class<T> clazz) {
        try {
            T obj = clazz.getDeclaredConstructor(null).newInstance();
            for(Map.Entry<String, String> entry : map.entrySet()){
                String key = entry.getKey();
                if(key.indexOf("[") != -1){
                    String fieldName = key.substring(0, key.indexOf("["));
                    Field collections = clazz.getDeclaredField(fieldName);
                    collections.setAccessible(true);
                    Object fieldValue = collections.get(obj);
                    if(fieldValue == null){
                        fieldValue = new LinkedList<>();
                    }

                    if(fieldValue instanceof List){
                        ((List) fieldValue).add(entry.getValue());
                    }
                    collections.set(obj, fieldValue);
                }else{
                    Field field = clazz.getDeclaredField(key);
                    field.setAccessible(true);
                    field.set(obj, entry.getValue());
                }
            }

            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
