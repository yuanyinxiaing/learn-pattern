/**
 * Created by yinxia.yyx on 17/2/21.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class MyAnnotationAdvice  implements MethodInterceptor{
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
       Object[] args = methodInvocation.getArguments();
       Method method = methodInvocation.getMethod();
       String result = "";
        if(method.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            result = "the method is using annotation" + myAnnotation.operator();
        }
        result = "the method is not using annotation myAnnotation";
        System.out.print(result);
    }
}
