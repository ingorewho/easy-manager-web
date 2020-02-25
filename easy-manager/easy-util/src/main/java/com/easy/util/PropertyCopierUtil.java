package com.easy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author rzq
 * @Desc
 * @Date 2020-02-16
 **/
public class PropertyCopierUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertyCopierUtil.class);

    /**
     * 复制属性
     *
     * @param from
     * @param toCls
     * @param <T>
     * @param <F>
     * @return
     */
    public static <T, F> T copy(F from, Class<T> toCls) {
        if (from == null) {
            return null;
        } else {
            try {
                T to = toCls.newInstance();
                BeanCopier copier = BeanCopier.create(from.getClass(), toCls, false);
                copier.copy(from, to, (Converter) null);
                return to;
            } catch (Exception var4) {
                logger.error("copy property failed", var4);
                return null;
            }
        }
    }

    /**
     * 批量复制属性
     *
     * @param from
     * @param toCls
     * @param <T>
     * @param <F>
     * @return
     */
    public static <T, F> List<T> copy(List<F> from, Class<T> toCls) {
        return from == null ? null : (List) from.stream().map((e) -> {
            return copy(e, toCls);
        }).collect(Collectors.toList());
    }
}
