package com.example.java8.Tree;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.rmi.AccessException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author qiuchang
 * @date 2020/8/22 22:54
 */
public class TreeComponent<T> {
    private Class entityClass;

    private Map<TreeField,Field> fieldMapping;

    private Map<Field,Class> clazzMapping;

    class TreeIndex{
        T parent;
        List<T> childs;
    }
    private Map<T,TreeIndex> indexMap;


    public T buildTree(List<T> nodes) {
        Map<Object, List<T>> sub = nodes.stream().filter(t -> getFieldValue(t,TreeField.ID) != null).collect(Collectors.groupingBy(t -> getFieldValue(t,TreeField.PID)));
        nodes.forEach(t -> t.setSub(sub.get(t.getId())));
        return nodes.stream().filter(T -> t.getPid() == 0).collect(Collectors.toList());
    }


    /**
     * 获取父类的泛型类
     */
    private Class<T> getEntityClass() {
        Class clazz = getClass(); //得到当前类
        Type genericType = clazz.getGenericSuperclass(); //返回当前类的父类的Type，包含泛型参数信息

        if(genericType instanceof ParameterizedType){
            Type[] params = ((ParameterizedType)genericType).getActualTypeArguments(); //得到父类的泛型参数信息
            if(params!=null && params.length>0){
                entityClass = (Class)params[0];
            }
        }

        return entityClass;
    }

    /**
     * 获取执行方法
     */
    private Object getFieldValue(T t,TreeField treeField) {
        Object value = null;
        try{
            Field field = fieldMapping.get(treeField);
            field.setAccessible(true);
            if(field.isAccessible()){
                Object o = field.get(t);
                value = o;
            }
        }catch (IllegalAccessException e){

        }

        return value;
    }

    private void initFieldMapping(T t){
        this.fieldMapping = new HashMap<>();
        Field[] declaredFields = t.getClass().getDeclaredFields();
        for (Field field:declaredFields){
            TreeInfo declaredAnnotation = field.getDeclaredAnnotation(TreeInfo.class);
            TreeField fieldAn = declaredAnnotation.field();
            Class clazz = declaredAnnotation.clazz();
            field.setAccessible(true);
            this.fieldMapping.put(fieldAn,field);
            this.clazzMapping.put(field,clazz);
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        TreeComponent<Node>  treeComponent= new TreeComponent<>();
        Node node = new Node(1,2);
        treeComponent.getMethod(node,TreeField.ID);
    }


}