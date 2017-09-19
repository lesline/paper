package keygen;

import java.util.List;

/**
 * key获取接口
 *
 * @author zhangshaolin
 */
public interface KeyGenerator {

    /**
     * 获取单个key值
     *
     * @return
     */
    Number generateKey();

    /**
     * 批量获取key值
     *
     * @return
     */
    List<Number> generateKeyByBatch();

}