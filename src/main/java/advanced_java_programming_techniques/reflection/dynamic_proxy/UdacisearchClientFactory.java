package advanced_java_programming_techniques.reflection.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class UdacisearchClientFactory {

    public static UdacisearchClient fromPropertyMap(Map<String, Object> properties) {
        Object proxy =
                Proxy.newProxyInstance(
                        UdacisearchClientFactory.class.getClassLoader(),
                        new Class<?>[]{UdacisearchClient.class},
                        new Handler(properties));
        return (UdacisearchClient) proxy;
    }

    private UdacisearchClientFactory() {
        // UdacisearchClientFactory cannot be instantiated.
    }

    private static final class Handler implements InvocationHandler {

        private final Map<String, Object> properties;

        private Handler(Map<String, Object> properties) {
            this.properties = new HashMap<>(Objects.requireNonNull(properties));
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // TODO: Fill this method in!
            String methodName = method.getName();
            if (method.getDeclaringClass().equals(Object.class)) {
                // Invoke toString() and hashCode() directly on the property Map.
                try {
                    return method.invoke(properties, args);
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            String propertyName = getPropertyName(methodName);
            if(propertyName.contentEquals("")){
                throw new RuntimeException("Method is not a property getter: " + methodName);
            }
            if(!properties.containsKey(propertyName)){
                throw new RuntimeException("No property named \"" + propertyName + "\" found in map.");
            }
            return properties.get(propertyName);
        }
    }

    private static String getPropertyName(String methodName) {
        if (methodName.length() <= 3 || !methodName.startsWith("get")) {
            return "";
        }
        return methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
    }
}
