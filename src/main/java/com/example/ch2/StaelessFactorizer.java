package com.example.ch2;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 상태 없는 서블릿
 */
public class StaelessFactorizer implements Servlet {

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
    }
    // 상태 없는 객체에 접근하는 스레드가 어떤 일을 하든 다른 스레드가 수행하는 동작의 정확성에 영향을 끼칠 수 없기 때문에 상태 없는 객체는 항상 스레드가 안전하다.
}
