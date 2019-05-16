package com.example.RxJava.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.*;


public class ExecutorFactory {

    public static ExecutorService getExecutor() {
        return new SecuredThreadPoolExecutor(50, 50, 60, TimeUnit.SECONDS);
    }

    static class SecuredThreadPoolExecutor extends ThreadPoolExecutor {

        public SecuredThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new SynchronousQueue<>(), new CallerRunsPolicy());
        }

        @Override
        public void execute(Runnable command) {
            super.execute(new WrappedRunnable(
                    RequestContextHolder.getRequestAttributes(),
                    SecurityContextHolder.getContext(),
                    command));
        }
    }

    static class WrappedRunnable implements Runnable {

        final Runnable target;
        final RequestAttributes requestAttributes;
        final SecurityContext securityContext;

        WrappedRunnable(RequestAttributes requestAttributes,
                        SecurityContext securityContext,
                        Runnable target) {
            this.target = target;
            this.securityContext = securityContext;
            this.requestAttributes = requestAttributes;
        }

        public void run() {
            SecurityContextHolder.setContext(securityContext);
            RequestContextHolder.setRequestAttributes(requestAttributes);
            try {
                target.run();
            } finally {
                SecurityContextHolder.clearContext();
                RequestContextHolder.resetRequestAttributes();
            }
        }
    }
}
