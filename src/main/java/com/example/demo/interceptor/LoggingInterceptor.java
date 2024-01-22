package com.example.demo.interceptor;

import com.example.demo.model.ChangeLog;
import com.example.demo.repository.ChangeLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    private ChangeLogRepository changeLogRepository;

    @Autowired
    public void setChangeLogRepository(ChangeLogRepository changeLogRepository) {
        this.changeLogRepository = changeLogRepository;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        ChangeLog changeLog = new ChangeLog();
        changeLog.setAction(request.getMethod());
        changeLog.setEndpoint(request.getRequestURI());
        changeLog.setAdministratorUsername("Default admin");
        changeLog.setTimestamp(LocalDateTime.now());

        changeLogRepository.save(changeLog);
    }
}
