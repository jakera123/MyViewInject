package com.zxp.myviewinject;

import android.app.Activity;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xiaoxin on 2017/7/26.
 */

public class ViewInjectParse {
    private static String TAG="ViewInjectParse";
    public static void Parse(Activity activity){
        try {
            Class<? extends Activity> object4inject=activity.getClass();
            Log.i(TAG,"before parse");
            for(Field field:(ViewInjectParse.class.getClassLoader().loadClass("com.zxp.myviewinject.MainActivity")).getDeclaredFields()){
               Log.i(TAG,field.toString());
                if(field.isAnnotationPresent(com.zxp.myviewinject.ViewInject.class)){
                    Log.i(TAG,"***********match success*************");
                    for(Annotation anno:field.getDeclaredAnnotations()){
                        Log.i("VIewInjectParse",anno+"");
                    }
                    ViewInject vi=field.getAnnotation(ViewInject.class);
                    int a=vi.ViewId();   //这里能够提取到注解
                    Method method=object4inject.getMethod("findViewById",int.class);
                    Object resView=method.invoke(activity,a);
                    field.setAccessible(true);
                    field.set(activity,resView);

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
