package cn.edu.cqut.base.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  @Annotation
  void run() {
    System.out.println("run");
  }

  public static void main(String[] args) {
    annotationSetting();
    new Main().run();
  }

  private static void annotationSetting() {
    // 所有方法，包含父类定义的方法（Object的方法）
    Method[] methods = Main.class.getMethods();
    // 本类中定义的方法
    Method[] declaredMethods = Main.class.getDeclaredMethods();
    System.out.println(Arrays.stream(methods).map(Method::getName).collect(Collectors.toList()));

    Arrays.stream(declaredMethods).forEach(method -> {
      System.out.printf("Method[%s] -> %s%n", method.getName(), method.isAnnotationPresent(Annotation.class));
    });
  }
}
