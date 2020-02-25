package com.easy.util;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author rzq
 * @Desc 集合工具类
 * @Date 2020-02-20
 **/
public class ListUtil {


    /**
     * 返回list集合 如果list为null 返回一个空的list
     */
    public static <T> List<T> nullToEmpty(List<T> list) {
        return Optional.ofNullable(list).orElse(Collections.emptyList());
    }

    /**
     * 返回Set集合 如果Set为null 返回一个空的Set
     */
    public static <T> Set<T> nullToEmpty(Set<T> set) {
        return Optional.ofNullable(set).orElse(Collections.emptySet());
    }

    /**
     * 返回map 如果map为null 返回一个空的map
     */
    public static <K, V> Map<K, V> nullToEmpty(Map<K, V> map) {
        return Optional.ofNullable(map).orElse(Collections.emptyMap());
    }

    public static <T, R> List<R> collect(List<T> list, Function<? super T, ? extends R> mapper) {
        return nullToEmpty(list).stream().map(mapper).collect(Collectors.toList());
    }

    public static <T, R> Set<R> distinctCollect(List<T> list, Function<? super T, ? extends R> mapper) {
        return nullToEmpty(list).stream().map(mapper).collect(Collectors.toSet());
    }


    /**
     * 去重收集
     */
    public static <T, R> List<R> distinctList(List<T> list, Function<? super T, ? extends R> mapper) {
        return nullToEmpty(list).stream().map(mapper).distinct().collect(Collectors.toList());
    }

    /**
     * 过滤
     */
    public static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        return nullToEmpty(list).stream().filter(predicate).collect(Collectors.toList());
    }


    /**
     * 映射转换
     *
     * @param list
     * @param mapper
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E, R> List<R> mappingToList(List<E> list, Function<E, R> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * 抽取List中对象的某个字段组成Set
     *
     * @param list
     * @param mapper
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E, R> Set<R> mappingToSet(List<E> list, Function<E, R> mapper) {
        return list.stream().map(mapper).collect(Collectors.toSet());
    }

    /**
     * 按照classifier分组
     * @param list
     * @param classifier
     * @return
     */
    public static <T, K> Map<K, List<T>> grouping(List<T> list, Function<? super T, ? extends K> classifier) {
        if (CollectionUtils.isEmpty(list)) {
            return Maps.newHashMap();
        }
        return list.stream().collect(Collectors.groupingBy(classifier, Collectors.toList()));
    }

    /**
     * 按照classifier分组，然后将元素mapper操作
     * @param list
     * @param classifier
     * @param mapper
     * @return
     */
    public static <T, K, R> Map<K, List<R>> grouping(List<T> list, Function<? super T, ? extends K> classifier,
                                                     Function<T, R> mapper) {
        return list.stream()
                .collect(Collectors.groupingBy(classifier, Collectors.mapping(mapper, Collectors.toList())));
    }

    /**
     * 将List转换成value为list重的element的对象。
     *
     * @param keyGenerator key生成策略
     * @return
     */
    public static <K, E> Map<K, E> toMap(Collection<E> collection, Function<E, K> keyGenerator) {
        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }

        return collection.stream()
                .filter(distinctByKey(keyGenerator))
                .collect(Collectors.toMap(keyGenerator, Function.identity()));
    }

    public static <T, K, R> Map<K, R> toMap(Collection<T> collection, Function<T, K> keyMapper,
                                            Function<T, R> valueMapper) {

        if (CollectionUtils.isEmpty(collection)) {
            return Maps.newHashMap();
        }
        return collection.stream()
                .filter(distinctByKey(keyMapper))
                .collect(Collectors.toMap(keyMapper, valueMapper));
    }


    public static <T, R> List<R> flatMap(List<T> list, Function<? super T, ? extends Stream<? extends R>> mapper) {
        return nullToEmpty(list).stream().flatMap(mapper).collect(Collectors.toList());
    }

    /**
     * 深度拷贝list
     *
     * @param src
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);

        List<T> dest = (List<T>) in.readObject();

        return dest;
    }

    /**
     * 按size数分割List
     *
     * @param size
     * @param source
     * @param <E>
     * @return
     */
    public static <E> List<List<E>> split(final List<E> source, final int size) {
        List<List<E>> result = Lists.newArrayList();
        int scroll = 0;
        int total = source.size();
        while (size + scroll <= total) {
            result.add(source.subList(scroll, scroll += size));
        }
        if (scroll < total) {
            result.add(source.subList(scroll, total));
        }
        return result;
    }

    /**
     * 按指定List 的顺序排序
     *
     * @param list
     * @param orderBy
     * @param mapper
     * @param <T>
     * @param <B>
     * @return
     */
    public static <T, B> List<T> sortAs(List<T> list, List<B> orderBy, Function<T, B> mapper) {
        return list.stream()
                .sorted(Comparator.comparingInt(t -> orderBy.indexOf(mapper.apply(t))))
                .collect(Collectors.toList());
    }

    /**
     * 查找匹配的第一个元素, 未找到返回null
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> T findFirst(List<T> list, Predicate<? super T> predicate) {
        return nullToEmpty(list).stream().filter(predicate).findFirst().orElse(null);
    }

    /**
     * foreach循环执行函数
     *
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> forEach(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    /**
     * foreach循环执行函数，去重
     *
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> forEachThenDistinct(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
