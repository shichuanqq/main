package com.example.service.executors;

import ch.qos.logback.core.util.ExecutorServiceUtil;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;

public class ThreadQueueUtils<T, R> {
    @Getter
    private LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<>();
    @Setter
    private Function<T, R> function;
    private Callable<List<R>> callable = new Callable<List<R>>() {
        @Override
        public List<R> call() {
            List<R> list = Lists.newArrayList();
            for (; ; ) {
                T poll = queue.poll();
                if (poll == null) {
                    break;
                }
                R apply = function.apply(poll);
                if (apply != null) {
                    list.add(apply);
                }
            }
            return list;
        }
    };

    public static <T, R> ThreadQueueUtils create(List<T> list, Function<T, R> function) {
        ThreadQueueUtils<T, R> threadQueueUtils = new ThreadQueueUtils<>();
        threadQueueUtils.getQueue().addAll(list);
        threadQueueUtils.setFunction(function);
        return threadQueueUtils;
    }

    public List<Future<List<R>>> start(int threadNum) {
        List<Future<List<R>>> result = Lists.newArrayList();
        for (int i = 0; i < threadNum; i++) {
            Future<List<R>> submit = ExecutorServiceUtil.newExecutorService().submit(callable);
            result.add(submit);
        }
        return result;
    }

    public List<R> startAndGet(int threadNum) {
        try {
            List<R> list = Lists.newArrayList();
            List<Future<List<R>>> start = this.start(threadNum);
            for (Future<List<R>> future : start) {
                List<R> rs = future.get();
                list.addAll(rs);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
