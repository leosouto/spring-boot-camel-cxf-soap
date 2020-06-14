package org.dev.application.cxf;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("encodingInterceptor")
public class EncodingInterceptor extends AbstractPhaseInterceptor<Message> {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CHARSET = "charset";
    private static final String ISO_8859_1 = "ISO-8859-1";

    public EncodingInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        if (!hasCharsetHeader(message)) {
            message.put(Message.ENCODING, ISO_8859_1);
        }
    }

    @SuppressWarnings("unchecked")
    private boolean hasCharsetHeader(Message message) {
        Map<String, List<String>> headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);

        List<String> contentType = headers.get(CONTENT_TYPE);

        for (String entry : contentType) {
            if (entry.contains(CHARSET)) {
                return true;
            }
        }

        return false;
    }
}
