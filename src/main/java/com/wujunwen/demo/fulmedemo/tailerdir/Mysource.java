//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wujunwen.demo.fulmedemo.tailerdir;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;
import org.apache.flume.Context;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;

public class Mysource extends AbstractSource implements Configurable, PollableSource {
    public Mysource() {
    }

    public Status process() throws EventDeliveryException {
        Random random = new Random();
        int randomNum = random.nextInt(100);
        String text = "Hello World:" + random.nextInt(100);
        HashMap<String, String> header = new HashMap();
        header.put("id", Integer.toString(randomNum));
        this.getChannelProcessor().processEvent(EventBuilder.withBody(text, Charset.forName("UTF-8"), header));
        return Status.READY;
    }

    public long getBackOffSleepIncrement() {
        return 0L;
    }

    public long getMaxBackOffSleepInterval() {
        return 0L;
    }

    public void configure(Context context) {
    }
}
