package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.utils.AutowireHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 *
 * @author ssanchez
 * @param <T>
 */
public abstract class SupportSerDer<T extends Serializable> {

    @Autowired
    protected ObjectMapper objectMapper;

    private final Class<T> clazz;

    public SupportSerDer(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     *
     * @param model
     * @return
     */
    protected byte[] serialize(final T model) {
        Assert.notNull(model, "Model can not be null");
        AutowireHelper.autowire(this, this.objectMapper);
        byte[] retVal = null;
        try {
            retVal = objectMapper.writeValueAsString(model).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    /**
     *
     * @param bytes
     * @return
     */
    protected T deserialize(final byte[] bytes) {
        AutowireHelper.autowire(this, this.objectMapper);
        T modelDes = null;
        try {
            modelDes = objectMapper.readValue(bytes, clazz);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return modelDes;
    }

}
