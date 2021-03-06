package com.thebeastshop.aspectlog.enhance.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.thebeastshop.aspectlog.context.AspectLogContext;
import org.apache.commons.lang3.StringUtils;
/**
 * @author Bryan.Zhang
 * @Date 2020/1/19
 */
public class AspectLogbackConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String logValue = AspectLogContext.getLogValue();
        if(StringUtils.isBlank(logValue)){
            return event.getFormattedMessage();
        }else{
            return logValue + " " + event.getFormattedMessage();
        }
    }
}
