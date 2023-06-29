package com.example.secondaryproject.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {
    public static Map<String, Object> beanMap(Object bean) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass(),Object.class);
        PropertyDescriptor[] list = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : list) {
            String key = pd.getName();
            Object value = pd.getReadMethod().invoke(bean);
            map.put(key, value);
        }
        return map;
    }

    public static <T> T mapBean(Map<String, Object> map,Class<T> classType) throws Exception {
        T obj = classType.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(classType,Object.class);
        PropertyDescriptor[] list = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : list) {
            String key = pd.getName();
            Object value=map.get(key);
            pd.getWriteMethod().invoke(obj, value);
        }
        return obj;
    }

}
