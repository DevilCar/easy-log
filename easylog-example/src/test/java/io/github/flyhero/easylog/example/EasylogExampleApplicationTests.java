package io.github.flyhero.easylog.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EasylogExampleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void springElTest(){
        ExpressionParser parser =new SpelExpressionParser(); // 创建一个表达式解析器
        StandardEvaluationContext ex = new StandardEvaluationContext(); // 创建上下文
        Map<String, Object> map = new HashMap();
        map.put("name", "easylog");
        ex.setVariables(map); // 将自定义参数添加到上下文
        Expression exp = parser.parseExpression("'欢迎你！ '+ #name"); //模板解析
        String val = exp.getValue(ex,String.class); //获取值
        System.out.println(val);
    }

}
