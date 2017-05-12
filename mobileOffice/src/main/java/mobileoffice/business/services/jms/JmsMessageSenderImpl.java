package mobileoffice.business.services.jms;

import mobileoffice.business.contracts.jms.JmsMessageSender;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Service
public class JmsMessageSenderImpl implements JmsMessageSender {

    private final String QUEUE_NAME = "MOBILEOFFICE_QUEUE";

    private JmsTemplate jmsTemplate;

    public JmsMessageSenderImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    /**
     * send text to default queue.
     * @param text
     */
    @Override
    public void send(final String text) {
        this.jmsTemplate.send(session -> {
            Message message = session.createTextMessage(text);
            message.setJMSReplyTo(new ActiveMQQueue(QUEUE_NAME));
            return message;
        });
    }
}
